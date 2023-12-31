package lpg.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * A JUnit4 test class that performs the following steps for each test grammar:
 * <ul>
 *   <li>runs the LPG generator on the grammar
 *   <li>compiles the resulting Java code
 *   <li>runs the parser on any test source input files in "parser-inputs" (see below)
 * </ul>
 * <b>Requires</b> that java and javac are in a directory listed on the PATH
 * environment variable.<br><br>
 * <b>Requires that the test is run with "lpg.test" or some sub-directory as the current directory.</b><br><br>
 * When that's true, the test harness should find everything else it needs, if all
 * of the projects below have been checked out as sibling directories:
 * <ul>
 *  <li>lpg.generator.cpp
 *  <li>lpg.generator (for the templates)
 *  <li>lpg.runtime.java (must have the .class files in "bin")
 *  <li>lpg.test
 * </ul>
 * <b>If the environment variable 'LPG' is defined</b>, it must point to the LPG
 * generator executable to be used.<br>
 * <b>If the environment variable 'LPG' is undefined</b>, the LPG generator
 * executable must be located at "lpg.generator.cpp/bin/lpg".<br><br>  
 * Scans "lpg.test/tests" for test directories, one per grammar.
 * Each directory has:
 * <ul>
 *   <li>a set of grammar files
 *   <li>a directory "GOLDEN" with the correct generated .java files for the
 *       parser, lexer, and so on. This directory may be empty, in which case
 *       the generated source is not 
 *   <li>a directory "parser-inputs" containing a set of source files in the
 *       language defined by the grammar
 *   <li>an optional directory "parser-bad-inputs" containing a set of syntactically
 *       malformed source files in the target language. If this directory exists,
 *       the Main driver program for the parser <b>must</b> take an "-e" flag that
 *       tells the driver that errors are expected. When this flag is not given, any
 *       failure to produce an AST results in Main producing a non-zero exit code,
 *       which the test harness interprets as a test failure.
 * </ul>
 * Also assumes that the name of each directory in "lpg.test/tests" is the
 * name of a top-level package containing any auxiliary Java source files.
 * 
 * @author rfuhrer@watson.ibm.com
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class GeneratorTest {
    private static final boolean DUMP_TOKENS= false;

    private static final boolean PRINT_TOKENS= false;

    private static final boolean DUMP_KEYWORDS= false;

	/**
	 * A File referring to the current working directory
	 */
	private static File sCWDFile;

	/**
	 * The location of the LPG generator executable
	 */
	private static File sGeneratorFile;

	/**
	 * The location of the "projects directory" that contains the projects
	 * "lpg.generator", "lpg.test", and so on, from an LPG source distribution.
	 */
	private static File sProjectsDir;

	/**
	 * The location of the "lpg.test/tests" directory
	 */
	private static File sTestsDir;

	/**
	 * The location of the "templates/java" directory
	 */
	private static File sTemplatesDir;

	/**
	 * The location of the "include/java" directory
	 */
	private static File sIncludeDir;

	/**
	 * The location of the "lpg.runtime.java" class folder
	 */
	private static File sJavaRuntimeDir;

	/**
	 * The location of the "java" executable
	 */
	private static File sJavaExecutable;

	/**
	 * The location of the "javac" executable
	 */
	private static File sJavacExecutable;

	private static boolean sIsWin32= false;

	@BeforeClass
	public static void findPrerequisites() {
		try {
			sCWDFile = new File(".").getCanonicalFile();

			System.out.println("Current working directory = " + sCWDFile);
		} catch (IOException e) {
			System.err.println("Exception encountered while determining cwd: " + e.getMessage());
		}
        sIsWin32 = System.getProperty("os.name").contains("indows");
		sJavaExecutable= findExecutableInPATH("java");
		sJavacExecutable= findExecutableInPATH("javac");
        findProjectsDir();
		findGenerator();
		findTemplates();
	}

    private static void findProjectsDir() {
        File dir = sCWDFile;

        while (dir != null && !dir.getName().equals("lpg.test")) {
            dir = dir.getParentFile();
        }
        if (dir == null) {
            System.err.println("Unable to locate project directory lpg.test starting at " + sCWDFile);
        }
        Assert.assertNotNull("Unable to locate project parent directory starting at " + sCWDFile, dir);
        sProjectsDir = dir.getParentFile();
    }

	private static File findExecutableInPATH(String executableName) {
		String path= System.getenv("PATH");
		String[] pathComponents= path.split(File.pathSeparator);

		if (sIsWin32) {
		    executableName = executableName + (sIsWin32 ? ".exe" : "");
		}

		for (String pathEntry : pathComponents) {
			File execFile= new File(pathEntry + File.separator + executableName);
			if (execFile.exists()) {
				System.out.println("Found " + executableName + " at: " + execFile.getAbsolutePath());
				return execFile;
			}
		}
		System.err.println("Unable to find executable in PATH: " + executableName);
		Assert.fail("Unable to find executable in PATH: " + executableName);
		return null;
	}

    private static void findGenerator() {
        String lpgEnv = System.getenv("LPG");
        File genFile;

        if (lpgEnv != null) {
            System.out.println("Using LPG generator location set in environment variable 'LPG': " + lpgEnv);
            genFile = new File(lpgEnv);
        } else {
            String generatorPath = "bin/lpg";
            File lpgGeneratorCppDir = new File(sProjectsDir, "lpg.generator.cpp");

            genFile = new File(lpgGeneratorCppDir, generatorPath).getAbsoluteFile();
        }

        boolean genFileExists = genFile.exists() && genFile.isFile();

        if (!genFileExists) {
            System.err.println("Generator executable not found at " + genFile);
            System.err.println("Note: Generator will be found if test is run within directory 'lpg.test'.");
            System.err.println("Note: You can also set the 'LPG' environment variable to point to the generator.");
        }
        Assert.assertTrue("Generator executable not found at " + genFile + " (cwd = " + new File(".").getAbsolutePath() + ")", genFileExists);

        boolean genFileExecutable = genFile.canExecute();

        if (!genFileExecutable) {
            System.err.println("Generator not executable: " + genFile);
        }
        Assert.assertTrue("Generator is not executable: " + genFile, genFileExecutable);
        sGeneratorFile = genFile;
    }

    private static void findTemplates() {
        File lpgTestDir = new File(sProjectsDir, "lpg.test");
        File lpgGeneratorDir = new File(sProjectsDir, "lpg.generator");
        File lpgRuntimeJavaDir = new File(sProjectsDir, "lpg.runtime.java");

        sTestsDir = new File(lpgTestDir, "tests");
        sTemplatesDir = new File(lpgGeneratorDir, "templates/java");
        sIncludeDir = new File(lpgGeneratorDir, "include/java");
        sJavaRuntimeDir = new File(lpgRuntimeJavaDir, "bin");

        if (!sTemplatesDir.exists()) {
            System.err.println("Folder 'templates/java' does not exist in " + lpgGeneratorDir.getAbsolutePath());
        }
        if (!sIncludeDir.exists()) {
            System.err.println("Folder 'include/java' does not exist in " + lpgGeneratorDir.getAbsolutePath());
        }
        if (!sJavaRuntimeDir.exists()) {
            System.err.println("Folder 'bin' does not exist in " + lpgRuntimeJavaDir.getAbsolutePath());
        }
        Assert.assertTrue("Folder 'templates/java' does not exist in " + lpgGeneratorDir.getAbsolutePath(), sTemplatesDir.exists());
        Assert.assertTrue("Folder 'include/java' does not exist in " + lpgGeneratorDir.getAbsolutePath(), sIncludeDir.exists());
        Assert.assertTrue("Folder 'bin' does not exist in " + lpgRuntimeJavaDir.getAbsolutePath(), sJavaRuntimeDir.exists());
    }

	@Test
	public void expr1() {
		runTest("expr1/ExprParser.g");
	}

	@Test
	public void expr2() {
		runTest("expr2/ExprParser.g");
	}

	@Test
	public void expr3() {
		runTest("expr3/ExprParser.g");
	}

	@Test
	public void expr4() {
		runTest("expr4/ExprParser.g");
	}

	@Test
	public void expr5() {
		runTest("expr5/ExprParser.g");
	}

	@Test
	public void expr6() {
		runTest("expr6/ExprParser.g");
	}

	@Test
	public void java() {
		runTest("javaparser/JavaParser.g");
	}

	@Test
	public void genericjava() {
		runTest("genericjavaparser/GJavaParser.g");
	}

	@Test
	public void expandedjava() {
		runTest("expandedjavaparser/JavaParser.g");
	}

	@Test
	public void softjava() {
		runTest("softjavaparser/SoftJavaParser.g");
	}

	// The following test doesn't use runTest(), since the LPG IDE grammar uses a "nested"
	// Java parser for the action blocks, which requires somewhat different build steps.
	@Test
	public void lpgGrammar() {
		String lpgGrammar = "lpg/LPGParser.g";
		String javaGrammar = "lpg/GJavaParser.g";
		File lpgGrammarFile = getInputFile(lpgGrammar);
		File grammarDir = lpgGrammarFile.getParentFile();
		File javaGrammarFile = getInputFile(javaGrammar);

		runGenerator(lpgGrammarFile);
		runGenerator(javaGrammarFile);
		compileParserFiles(grammarDir);
		runParserOnInputs(grammarDir, new IComputeExtraArgs() {
            public String[] argsFor(File f) {
                if (f.getName().endsWith("g")) {
                    // HACK Top-level files (*.g) all use automatic AST generation; included files (*.gi) don't
                    return new String[] { "-a" };
                }
                return null;
            }
        });
	}

	@Test
	public void xmlGrammar() {
		runTest("xmlparser/XmlParser.g");
	}

	private void runTest(String rootGrammarFile) {
	    System.out.println("*** Running test on grammar file " + rootGrammarFile);

		File grammarFile = getInputFile(rootGrammarFile);
		File grammarDir = grammarFile.getParentFile();

		runGenerator(grammarFile);
		compareGeneratedOutputs(grammarDir);
		compileParserFiles(grammarDir);
		runParserOnInputs(grammarDir);
		runParserOnBadInputs(grammarDir);
//		compareParserOutput(grammarFile);
	}

	/**
	 * Interface for classes that compute the necessary additional Main driver class
	 * cmd-line options for a given test input source file. This is mostly intended
	 * for the lpgGrammar() test, which invokes a Java parser on each action block:
	 * it needs to know which files use automatic AST generation so that it knows
	 * whether to parse the action blocks as class member lists or statement lists.
	 */
	interface IComputeExtraArgs {
	    String[] argsFor(File f);
	}


	private void runParserOnInputs(File grammarDir) {
        runParserOnInputs(grammarDir, null);
    }

    private void runParserOnInputs(File grammarDir, IComputeExtraArgs argComputer) {
		File inputsDir = new File(grammarDir, "parser-inputs");

		Assert.assertTrue("Missing inputs directory: " + inputsDir.getAbsolutePath(), inputsDir.exists());
		File[] inputs = inputsDir.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return !pathname.getName().equals("CVS");
			}
		});
		Assert.assertTrue("Empty inputs directory: " + inputsDir.getAbsolutePath(), inputs.length > 0);

		for (File srcFile : inputs) {
		    String[] extraArgs = (argComputer != null) ? argComputer.argsFor(srcFile) : null;
			runParserOn(grammarDir, srcFile, false, extraArgs);
		}
	}


    private void runParserOnBadInputs(File grammarDir) {
        File inputsDir = new File(grammarDir, "parser-bad-inputs");

        if (!inputsDir.exists()) {
            return;
        }

        File[] inputs = inputsDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return !pathname.getName().equals("CVS");
            }
        });
        Assert.assertTrue("Empty bad-inputs directory: " + inputsDir.getAbsolutePath(), inputs.length > 0);

        for (File srcFile : inputs) {
            runParserOn(grammarDir, srcFile, true);
        }
    }


    private void runParserOn(File grammarDir, File srcFile, boolean expectErrors) {
        runParserOn(grammarDir, srcFile, expectErrors, null);
    }

    private void runParserOn(File grammarDir, File srcFile, boolean expectErrors, String extraArgs[]) {
		File srcDir = srcFile.getParentFile();
		List<String> cmdArgList = new LinkedList<String>();
		cmdArgList.add("java");
		cmdArgList.add("-cp");
		cmdArgList.add("../bin:" + sJavaRuntimeDir.getAbsolutePath());
		cmdArgList.add(grammarDir.getName() + ".Main");
		if (expectErrors) {
		    cmdArgList.add("-e");
		}
		if (DUMP_TOKENS) {
		    cmdArgList.add("-d"); // dump tokens
		}
		if (DUMP_KEYWORDS) {
		    cmdArgList.add("-k"); // dump keywords
		}
		if (PRINT_TOKENS) {
		    cmdArgList.add("-p"); // print tokens
		}
		if (extraArgs != null) {
		    for(String arg: extraArgs) {
		        cmdArgList.add(arg);
		    }
		}
		cmdArgList.add(srcFile.getAbsolutePath());
		runCommand(sJavaExecutable, srcDir, cmdArgList.toArray(new String[cmdArgList.size()]));		
	}


	private void compileParserFiles(File grammarDir) {
		File[] grammarDirJavaFiles = grammarDir.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		});
		File binDir = new File(grammarDir, "bin");
		checkMakeDir(binDir);
		List<String> cmdArgList = buildJavacCmdArgs(grammarDirJavaFiles);
		runCommand(sJavacExecutable, grammarDir, cmdArgList.toArray(new String[cmdArgList.size()]));
		
	}


	private void checkMakeDir(File dir) {
		if (!dir.exists()) {
			boolean success = dir.mkdir();
			Assert.assertTrue("Failed to create directory: " + dir.getAbsolutePath(), success);
		}
	}


	private List<String> buildJavacCmdArgs(File[] grammarDirJavaFiles) {
		List<String> cmdArgList = new LinkedList<String>();
		cmdArgList.add("javac");
		cmdArgList.add("-cp");
		cmdArgList.add(".:..:" + sJavaRuntimeDir.getAbsolutePath());
		cmdArgList.add("-d");
		cmdArgList.add("bin");
		for (File javaFile : grammarDirJavaFiles) {
			cmdArgList.add(javaFile.getName());
		}
		return cmdArgList;
	}


	private void compareGeneratedOutputs(File grammarDir) {
		File goldenDir = new File(grammarDir, "GOLDEN");

		if (!goldenDir.exists()) {
			return;
		}
//		Assert.assertTrue("Folder 'GOLDEN' does not exist in " + grammarDir, goldenDir.exists());

		File[] goldenFiles= goldenDir.listFiles(new FileFilter() {
			public boolean accept(File path) {
				return !path.getName().equals("CVS") && path.getName().endsWith(".java");
			}
		});

		for (File goldenFile : goldenFiles) {
			String resultName = goldenFile.getName();
			File realFile = new File(grammarDir, resultName);
			Assert.assertTrue("Expected output file " + realFile + " does not exist.", realFile.exists());

			compareFile(goldenFile, realFile);
			System.out.println("Generated file " + realFile.getName() + " compared successfully with golden file " + goldenFile.getName());
		}
	}


	private boolean compareFile(File goldenFile, File realFile) {
		BufferedReader gbr = null;
		BufferedReader rbr = null;
		try {
			gbr = new BufferedReader(new FileReader(goldenFile));
			rbr = new BufferedReader(new FileReader(realFile));

			int lineNum = 0;
			String gline;
			do {
				lineNum++;
				gline = gbr.readLine();
				String rline = rbr.readLine();

				if (gline != null) {
					Assert.assertEquals("Miscompare at line " + lineNum + " of result file " + goldenFile.getName(), gline, rline);
				}
			} while (gline != null);
			String extraRealLine = rbr.readLine();
			Assert.assertNull("Result file has extra lines, starting at line " + lineNum + ": '" + extraRealLine + "'", extraRealLine);
			return true;
		} catch (IOException e) {
			Assert.fail("IOException caught while comparing result files " + goldenFile.getName());
			return false;
		} finally {
			if (rbr != null) {
				try {
					rbr.close();
				} catch (IOException e) {
				}
			}
			if (gbr != null) {
				try {
					gbr.close();
				} catch (IOException e) {
				}
			}
		}
	}


	private File getInputFile(String path) {
		File file = new File(sTestsDir, path);

		Assert.assertTrue("Resource doesn't exist: " + file, file.exists());
		return file;
	}


	private void runGenerator(File grammarFile) {
		File grammarDir = grammarFile.getParentFile();
		String[] cmdArgs= buildLPGCmdArgs(grammarFile.getAbsolutePath(), sGeneratorFile.getAbsolutePath());

        runCommand(sGeneratorFile, grammarDir, cmdArgs);
	}

	private String[] buildLPGCmdArgs(String fileName, String executablePath) {
        String includePathOption= "-include-directory=" + sTemplatesDir.getAbsolutePath() + ";" + sIncludeDir.getAbsolutePath() + "";
//      String directoryPrefixOption= "-directory-prefix='" + this.getProject().getLocation().toOSString() + "'";
        List<String> cmdArgs = new LinkedList<String>();

        cmdArgs.add(executablePath);
//        cmdArgs.add("-quiet");
        cmdArgs.add("-list");
        // In order for Windows to treat the following template path argument as
        // a single argument, despite any embedded spaces, it has to be completely
        // enclosed in double quotes. It does not suffice to quote only the path
        // part. However, for lpg to treat the path properly, the path itself
        // must also be quoted, since the outer quotes will be stripped by the
        // Windows shell (command/cmd.exe). As an added twist, if we used the same
        // kind of quote for both the inner and outer quoting, and the outer quotes
        // survived, the part that actually needed quoting would be "bare"! Hence
        // we use double quotes for the outer level and single quotes inside.
        cmdArgs.add(sIsWin32 ? "\"" + includePathOption + "\"" : includePathOption);
//      cmdArgs.add(sIsWin32 ? "\"" + directoryPrefixOption + "\"" : directoryPrefixOption);
        cmdArgs.add(fileName);

        return cmdArgs.toArray(new String[cmdArgs.size()]);
    }


	private void runCommand(File execFile, File processCWD, String[] cmdArgs) {
		try {
			System.out.print("Invoking command with arguments: ");
			for(String arg: cmdArgs) {
				System.out.print(arg);
				System.out.print(' ');
			}
			System.out.println();
			System.out.println("  Process working directory: " + processCWD);
			Process proc = Runtime.getRuntime().exec(cmdArgs, null, processCWD);

			processStandardOutput(proc);
			processStandardError(proc);

			int rc;
			do {
				try {
					rc = proc.waitFor();
				} catch (InterruptedException e) {
					continue;
				}
				Assert.assertEquals("Non-zero command return code for " + cmdArgs[0], 0, rc);
				break;
			} while (true);

		} catch (IOException e) {
			Assert.fail("IOException caught while running generator: " + e.getMessage());
			e.printStackTrace();
		}
	}


	private void processStandardError(Process process) throws IOException {
        InputStream is= process.getErrorStream();
        BufferedReader in= new BufferedReader(new InputStreamReader(is));
        String line= null;

        while ((line= in.readLine()) != null) {
        	System.out.println(line);
//        	Assert.fail("Error output: " + line);
        }
        is.close();
    }


	private void processStandardOutput(Process process) throws IOException {
        InputStream is= process.getInputStream();
        BufferedReader in= new BufferedReader(new InputStreamReader(is));
        String line= null;

        while ((line= in.readLine()) != null) {
        	System.out.println(line);
        }
        is.close();
    }
}

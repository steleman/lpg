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
 * JUnit4 test class that performs the following steps for each test grammar:
 * <ul>
 *   <li>runs the LPG generator on the grammar
 *   <li>compiles the resulting Java code
 *   <li>runs the parser on any test source input files in "parser-inputs" (see below)
 * </ul>
 * <b>Assumes the test is run with "lpg.test/tests" as the current directory.</b><br><br>
 * When that's true, it will find everything else it needs, if all of the relevant
 * projects have been checked out as sibling directories:
 * <ul>
 *  <li>lpg.generator.cpp
 *  <li>lpg.generator (for the templates)
 *  <li>lpg.runtime.java (must have the .class files in "bin")
 *  <li>lpg.test
 * </ul>
 * <b>Requires</b> that the lpg generator is located at "lpg.generator.cpp/bin/lpg".<br>  
 * <b>Requires</b> that java and javac are in a directory listed on the PATH environment
 * variable.<br>
 * Scans "lpg.test/tests" for test directories, one per grammar.
 * Each directory has:
 * <ul>
 *   <li>a set of grammar files
 *   <li>a directory "GOLDEN" with the correct generated .java files for the
 *       parser, lexer, and so on. This directory may be empty, in which case
 *       the generated source is not 
 *   <li>a directory "parser-inputs" containing a set of source files in the
 *       language defined by the grammar
 * </ul>
 * Also assumes that the name of each directory in "lpg.test/tests" is the
 * name of a top-level package containing any auxiliary Java source files.
 * 
 * @author rfuhrer@watson.ibm.com
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class GeneratorTest {
	/**
	 * The location of the LPG generator executable
	 */
	private static File sGeneratorFile;

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

	@BeforeClass
	public static void findPrerequisites() {
		sJavaExecutable= findExecutableInPATH("java");
		sJavacExecutable= findExecutableInPATH("javac");
		findGeneratorAndTemplates();
	}

	private static File findExecutableInPATH(String executableName) {
		String path= System.getenv("PATH");
		String[] pathComponents= path.split(File.pathSeparator);
		boolean isWin32 = System.getProperty("os.name").contains("indows");

		for (String pathEntry : pathComponents) {
			File execFile= new File(pathEntry + File.separator + executableName + (isWin32 ? ".exe" : ""));
			if (execFile.exists()) {
				System.out.println("Found " + executableName + " at: " + execFile.getAbsolutePath());
				return execFile;
			}
		}
		System.err.println("Unable to find executable in PATH: " + executableName);
		Assert.fail("Unable to find executable in PATH: " + executableName);
		return null;
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

	// Following test is disabled for now, since the LPG IDE grammar uses a "nested"
	// Java parser for the action blocks, which requires different build steps.
//	@Test
//	public void lpgGrammar() {
//		runTest("lpg/LPGParser.g");
//	}

	@Test
	public void xmlGrammar() {
		runTest("xmlparser/XmlParser.g");
	}

	private void runTest(String rootGrammarFile) {
		File grammarFile = getInputFile(rootGrammarFile);
		File grammarDir = grammarFile.getParentFile();

		runGenerator(grammarFile);
		compareGeneratedOutputs(grammarDir);
		compileParserFiles(grammarDir);
		runParserOnInputs(grammarDir);
//		compareParserOutput(grammarFile);
	}

	private void runParserOnInputs(File grammarDir) {
		File inputsDir = new File(grammarDir, "parser-inputs");

		Assert.assertTrue("Missing inputs directory: " + inputsDir.getAbsolutePath(), inputsDir.exists());
		File[] inputs = inputsDir.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return !pathname.getName().equals("CVS");
			}
		});
		Assert.assertTrue("Empty inputs directory: " + inputsDir.getAbsolutePath(), inputs.length > 0);

		for (File srcFile : inputs) {
			runParserOn(grammarDir, srcFile);
		}
	}

	private void runParserOn(File grammarDir, File srcFile) {
		File srcDir = srcFile.getParentFile();
		List<String> cmdArgList = new LinkedList<String>();
		cmdArgList.add("java");
		cmdArgList.add("-cp");
		cmdArgList.add("../bin:" + sJavaRuntimeDir.getAbsolutePath());
		cmdArgList.add(grammarDir.getName() + ".Main");
		cmdArgList.add("-d");
		cmdArgList.add("-k");
		cmdArgList.add("-p");
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
		List<String> cmdArgList = buildJavaCmdArgs(grammarDirJavaFiles);
		runCommand(sJavacExecutable, grammarDir, cmdArgList.toArray(new String[cmdArgList.size()]));
		
	}

	private void checkMakeDir(File dir) {
		if (!dir.exists()) {
			boolean success = dir.mkdir();
			Assert.assertTrue("Failed to create directory: " + dir.getAbsolutePath(), success);
		}
	}

	private List<String> buildJavaCmdArgs(File[] grammarDirJavaFiles) {
		List<String> cmdArgList = new LinkedList<String>();
		cmdArgList.add("javac");
		cmdArgList.add("-cp");
		cmdArgList.add("..:" + sJavaRuntimeDir.getAbsolutePath());
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
			public boolean accept(File pathname) {
				return !pathname.getName().equals("CVS");
			}
		});

		for (File goldenFile : goldenFiles) {
			if (!goldenFile.getName().endsWith(".java")) {
				System.out.println("Ignoring non-Java golden file: " + goldenFile.getAbsolutePath());
			}
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

	private static void findGeneratorAndTemplates() {
		findGenerator();

		File parentDir = sGeneratorFile.getParentFile().getParentFile().getParentFile();
		File lpgTestDir = new File(parentDir, "lpg.test");
		File lpgGeneratorDir = new File(parentDir, "lpg.generator");
		File lpgRuntimeJavaDir = new File(parentDir, "lpg.runtime.java");

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

	private static void findGenerator() {
		String generatorPath = "bin/lpg";
		File cwdFile = new File(".").getAbsoluteFile().getParentFile();
		File lpgGeneratorCppDir = new File(cwdFile.getParentFile(), "lpg.generator.cpp");
		File genFile = new File(lpgGeneratorCppDir, generatorPath).getAbsoluteFile();

		if (!genFile.exists() || !genFile.isFile()) {
			System.err.println("Generator executable not found at " + genFile + " (cwd = " + new File(".").getAbsolutePath() + ")");
			System.err.println("Test should be run from within directory 'lpg.test'");
		}
		Assert.assertTrue("Generator executable not found at " + genFile + " (cwd = " + new File(".").getAbsolutePath() + ")", genFile.exists() && genFile.isFile());
		sGeneratorFile = genFile;
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

	private boolean fIsWin32 = false;

	private String[] buildLPGCmdArgs(String fileName, String executablePath) {
        String includeSearchPath= "-include-directory='" + sTemplatesDir.getAbsolutePath() + ";" + sIncludeDir.getAbsolutePath() + "'";
//      String directoryPrefixPath= "-directory-prefix='" + this.getProject().getLocation().toOSString() + "'";

        String cmd[]= new String[] {
                executablePath,
                "-quiet",
                "-list",
                // In order for Windows to treat the following template path argument as
                // a single argument, despite any embedded spaces, it has to be completely
                // enclosed in double quotes. It does not suffice to quote only the path
                // part. However, for lpg to treat the path properly, the path itself
                // must also be quoted, since the outer quotes will be stripped by the
                // Windows shell (command/cmd.exe). As an added twist, if we used the same
                // kind of quote for both the inner and outer quoting, and the outer quotes
                // survived, the part that actually needed quoting would be "bare"! Hence
                // we use double quotes for the outer level and single quotes inside.
                (fIsWin32 ? "\"" + includeSearchPath + "\"" : includeSearchPath),
//              (fIsWin32 ? "\"" + directoryPrefixPath + "\"" : directoryPrefixPath),
                fileName};
        return cmd;
    }

	private void runCommand(File execFile, File processCWD, String[] cmdArgs) {
		try {
			System.out.print("Invoking command with arguments: ");
			for(String arg: cmdArgs) {
				System.out.print(arg);
				System.out.print(' ');
			}
			System.out.println();
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

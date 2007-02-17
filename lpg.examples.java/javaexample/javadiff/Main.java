package javadiff;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import genericjavaparser.JavaLexer;
import lpg.javaruntime.Differ;
import lpg.javaruntime.DifferLines;
import lpg.javaruntime.DifferTokens;
import lpg.javaruntime.LexStream;
import lpg.javaruntime.PrsStream;

public class Main
{
    private static boolean differ_tokens = false;
    private static int changeCount = 0,
                       insertCount = 0,
                       deleteCount = 0,
                       replaceCount = 0,
                       moveCount = 0;

    private static void compareFiles(String old_file, String new_file)
    {
        try
        {
            JavaLexer old_lexer = new JavaLexer(old_file),
                      new_lexer = new JavaLexer(new_file);

            PrsStream old_stream = new PrsStream(old_lexer);
            old_lexer.lexer(old_stream);

            PrsStream new_stream = new PrsStream(new_lexer);
            new_lexer.lexer(new_stream);

            Differ diff = (differ_tokens ? (Differ) new DifferTokens(old_stream, new_stream)
                                         : (Differ) new DifferLines(old_stream, new_stream));
            diff.compare();

            if (diff.getChangeCount() > 0)
            {
                diff.outputChanges();

                changeCount += diff.getChangeCount();
                insertCount += diff.getInsertCount();
                deleteCount += diff.getDeleteCount();
                moveCount += diff.getMoveCount();
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void compareDirectories(java.io.File old_dir, java.io.File new_dir)
    {
        try
        {
            java.io.File old_file[] = old_dir.listFiles(),
                         new_file[] = new_dir.listFiles();
            HashMap old_map = new HashMap();
            for (int i = 0; i < old_file.length; i++)
                old_map.put(old_file[i].getName(), old_file[i]);

            for (int i = 0; i < new_file.length; i++)
            {
                java.io.File file = (java.io.File) old_map.get(new_file[i].getName());
                if (file != null)
                {
                    old_map.remove(new_file[i].getName());

                    if (file.isDirectory() && new_file[i].isDirectory())
                         compareDirectories(file, new_file[i]);
                    else compareFiles(file.getPath(), new_file[i].getPath());
                }
                else ; /* TODO: file is a new file */ 
            }

            for (Iterator i = old_map.entrySet().iterator(); i.hasNext(); )
            {
                Map.Entry e = (Map.Entry) i.next();
                java.io.File file = (java.io.File) e.getValue();
                // TODO: file was deleted
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        String new_file = "new file",
               old_file = "old file";

        int i;
        for (i = 0; i < args.length; i++)
        {
            if (args[i].charAt(0) == '-')
            {
                if (args[i].equals("-t"))
                    differ_tokens = true;
                else if (args[i].equals("-l"))
                    differ_tokens = false;
            }
            else break;
        }
        if (i < args.length) 
            new_file = args[i++];
        if (i < args.length) 
            old_file = args[i++];
        for (; i < args.length; i++)
            System.err.println("Invalid argument: " + args[i]);

        java.io.File old_dir = new java.io.File(old_file),
             new_dir = new java.io.File(new_file);
        if (old_dir.isDirectory() && new_dir.isDirectory())
             compareDirectories(old_dir, new_dir);
        else compareFiles(old_file, new_file);

        if (changeCount == 0)
            System.out.println("***** No difference *****");
        else
        {
            System.out.println("***** " +
                               changeCount +
                               " different " +
                               (changeCount == 1 ? "section" : "sections") + " *****");
            System.out.println("" + insertCount  + (differ_tokens ? " tokens" : " lines") + " inserted");
            System.out.println("" + deleteCount  + (differ_tokens ? " tokens" : " lines") + " deleted");
            System.out.println("" + replaceCount + (differ_tokens ? " tokens" : " lines") + " replaced");
            System.out.println("" + moveCount    + (differ_tokens ? " tokens" : " lines") + " moved");
        }

        return;
    }
}

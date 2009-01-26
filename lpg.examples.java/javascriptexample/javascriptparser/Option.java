package javascriptparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Option
{
    String fileName = "input";
    boolean dumpTokens = false;
    boolean incremental = false;
    boolean dumpKeywords = false;
    boolean print  = false;
    byte[] inputChars;


    public Option(String [] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            if (args[i].charAt(0) == '-')
            {
                if (args[i].equals("-d"))
                    dumpTokens = true;
                else if (args[i].equals("-i"))
                    incremental = true;
                else if (args[i].equals("-k"))
                    dumpKeywords = true;
                else if (args[i].equals("-p"))
                    print = true;
            }
            else
            {
                fileName = args[i];
                break;
            }
        }
    }

    public String getFileName() { return fileName; }

    public boolean dumpTokens() { return dumpTokens; }

    public boolean incremental() { return incremental; }

    public boolean dumpKeywords() { return dumpKeywords; }

    public boolean printTokens() { return print; }

    public byte[] getInputChars() { return inputChars; }

    public int readInputChars() throws IOException
    {
        try
        {
            File f = new File(fileName);
            FileInputStream in = new FileInputStream(f);

            inputChars = new byte[(int) f.length()];

            in.read(inputChars, 0, inputChars.length);
        }
        catch (Exception e)
        {
            IOException io = new IOException();
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw(io);
        }

        return (inputChars == null ? 0 : inputChars.length);
    }
}

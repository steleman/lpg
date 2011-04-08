package genericjavaparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Option
{
    String fileName = "input";
    boolean dump = false;
    boolean print  = false;
    char[] inputChars;


    Option(String [] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            if (args[i].charAt(0) == '-')
            {
                if (args[i].equals("-d"))
                    dump = true;
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

    String getFileName() { return fileName; }

    boolean dumpTokens() { return dump; }

    boolean printTokens() { return print; }

    char[] getInputChars() { return inputChars; }

    int readInputChars() throws IOException
    {
        int rlen = 0;
        try
        {
            // Create a reader for the input stream and read the input file into a char array.
            File f = new File(fileName);
            int len = (int) f.length();
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            inputChars = new char[len];

            rlen = in.read(inputChars, 0, len);

        }
        catch (Exception e)
        {
            IOException io = new IOException();
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw(io);
        }
        return rlen;
    }

}

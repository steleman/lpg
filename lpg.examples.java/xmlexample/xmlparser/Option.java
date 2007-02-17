package xmlparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import lpg.javaruntime.IntSegmentedTuple;

public class Option
{
    String fileName = "input";
    boolean dump = false;
    boolean print  = false;
    char[] inputChars;
    boolean isUTF8;
    IntSegmentedTuple lineOffsets;

    public Option(String [] args)
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

    public boolean isUtf8() { return isUTF8; }

    public String getFileName() { return fileName; }

    public boolean dumpTokens() { return dump; }

    public boolean printTokens() { return print; }

    public char[] getInputChars() { return inputChars; }

    public int getInputCharsLength() { return (inputChars == null ? 0 : inputChars.length); }

    public IntSegmentedTuple getLineOffsets() { return lineOffsets; }

    public int readInputChars() throws IOException
    {
        try
        {
            File f = new File(fileName);
            int length = (int) f.length();
            FileInputStream in = new FileInputStream(f);

            int BLKSIZE = 65536;
            byte[] buffer = new byte[BLKSIZE];
            int num_read = in.read(buffer, 0, BLKSIZE);

            this.isUTF8 = (length >= 3 &&
                           (((int) buffer[0]) & 0x000000FF) == 0x00EF &&
                           (((int) buffer[1]) & 0x000000FF) == 0x00BB &&
                           (((int) buffer[2]) & 0x000000FF) == 0x00BF);
            this.inputChars = new char[(isUTF8 ? length : length + 1) + 1];
            this.lineOffsets = new IntSegmentedTuple(15);
            this.lineOffsets.add(-1);

            int k = 0;
            this.inputChars[k++] = (char) 0x00; // the 0th column should not be used
            for (int i = (isUTF8 ? 3 : 0); i < num_read; i++)
            {
                if (buffer[i] == 0x0A) this.lineOffsets.add(k);
                this.inputChars[k++] = (char) (buffer[i] & 0xFF);
            }
            for (int j = BLKSIZE; j < length; j += BLKSIZE)
            {
                num_read = in.read(buffer, 0, BLKSIZE);
                for (int i = 0; i < num_read; i++)
                {
                    if (buffer[i] == 0x0A) this.lineOffsets.add(k);
                    this.inputChars[k++] = (char) (buffer[i] & 0xFF);
                }
            }

            //
            // We are at the end of the file. If the file is UTF8-encoded,
            // we add the UTF8 sequence for Unicode 0xFFFF.Otherwise, we
            // add the Unicode characted 0xFFFF.
            //
            if (this.isUTF8)
            {
                 this.inputChars[k++] = 0xEF;
                 this.inputChars[k++] = 0xBF;
                 this.inputChars[k++] = 0xBF;
                 //assert(k == length + 1);
            }
            else this.inputChars[length + 1] = 0xFFFF;
        }
        catch (Exception e)
        {
            IOException io = new IOException();
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw(io);
        }

        return this.inputChars.length;
    }
}

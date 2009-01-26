package xmlparser;

public class Main
{
    public static void main(String[] args)
    {
        Option option;
        XmlParser xml_parser;
        Ast ast;

        Runtime r = Runtime.getRuntime();
        long r1, r2, r3,
             f1, f2, f3,
             t1, t2, t3;

        try
        {
            System.gc();

            r1 = r.totalMemory();
            f1 = r.freeMemory();

            option = new Option(args);

            t1 = System.currentTimeMillis();

            xml_parser = new XmlParser(option.getFileName());

            t2 = System.currentTimeMillis();

            System.out.println("****Begin parser: ");
            ast = xml_parser.parser(); // Parse the token stream to produce an AST

            t3 = System.currentTimeMillis();

            r2 = r.totalMemory();
            f2 = r.freeMemory();

            System.gc();

            r3 = r.totalMemory();
            f3 = r.freeMemory();

            if (ast == null) System.out.println("****Failure");
            else System.out.println("****Success");

            System.out.println("\n****Parsing statistics: \n");
            System.out.println("****File length = " + xml_parser.getStreamLength());
            System.out.println("****Number of Lines = " + xml_parser.getLineCount());
            System.out.println("****Class Construction and input time: " + (t2 - t1));           
            System.out.println("****Parsing time: " + (t3 - t2));
            System.out.println("****Total time: " + (t3 - t1));
            System.out.println("****Initial Max Memory:    \t " + r1 + ", used: " + (r1 - f1));
            System.out.println("****After Parse Max Memory:\t " + r2 + ", used: " + (r2 - f2));
            System.out.println("****After GC Max Memory:\t " + r3 + ", used: " + (r3 - f3));
            System.out.println();

            return;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}

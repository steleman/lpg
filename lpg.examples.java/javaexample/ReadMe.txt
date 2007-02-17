ReadMe for javaexample

This example consists of an LPG specified lexer and parser for three variations
of the Java language.  The "src" subdirectory contains the grammar
files and packages specifying "genericjava" (the next version of the Java
language), "javaparser" (the current Java language) and "softjavaparser" (a Java
with a no reserved keywords extension).  In addition, there is a subdirectory
"test" containing several Java files that may be run as test cases.

We assume lpgjavaruntime.zip has been extracted to "c:\" and the environment
variables for LPG_INCLUDE and LPG_TEMPLATE have been set to
"c:\lpgjavaruntime\lpgjava\com.ibm.lpg\include;.;" and
"c:\lpgjavaruntime\lpgjava\com.ibm.lpg\templates", respectively.

This example may be installed as an eclipse project, or it may be run directly
from the command line. To run any of the three java examples in an eclipse
project create a Run configuration for one (or each package) and make sure that
the user entries include lpg.jar and the folder lpgjavaruntime/tables. Compile
the parser grammar file only (JavaParser.g, for example, other ".g" files will
be compiled automatically) with lpg.exe (using the command line or an eclipse
External Tool). Then run any of the examples in examples/javaexample/test.

To compile and run from the command line (using javaparser to illustrate) do the
following:

(1) Run lpg on the grammar file.  Since templates are used you only need to run
lpg on the JavaParser.g file.  The command and its output are:

    C:\lpgjavaruntime\examples\javaexample\src\javaparser>\lpgjavaruntime\lpg
    -list JavaParser.g

    Options in effect for JavaKWLexer.g:

    ACTION-BLOCK=("JavaKWLexer.java","/.","./")

    NOATTRIBUTES  NOBACKTRACK  BYTE  CONFLICTS  DAT-DIRECTORY="./"
    DAT-FILE="JavaKWLexerdcl.data"  DCL-FILE="JavaKWLexerdcl.java"  NODEBUG
    DEF-FILE="JavaKWLexerdef.java"  NOEDIT  NOERROR-MAPS  ESCAPE='$'
    EXPORT-TERMINALS=("JavaParsersym.java","TK_","")  FILE-PREFIX="JavaKWLexer"
    NOFIRST  NOFOLLOW  NOGOTO-DEFAULT  GRM-FILE="JavaKWLexer.g"
    IMP-FILE="JavaKWLexerimp.java"
    INCLUDE-DIRECTORY="c:\lpgjavaruntime\lpgjava\com.ibm.lpg\include;.;"  NOLIST
    MARGIN=4  NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'  PACKAGE="javaparser"
    PARSE-TABLE="com.ibm.lpg.*"  PREFIX="Char_"  NOPRIORITY
    PRS-FILE="JavaKWLexerprs.java"  NOQUIET  READ-REDUCE  NOSCOPES  NOSERIALIZE
    NOSOFT-KEYWORDS  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  SLR  NOSTATES
    SUFFIX=""  SYM-FILE="JavaKWLexersym.java"  TAB-FILE="JavaKWLexer.t"
    TABLE=JAVA  TEMPLATE="KeyWordTemplateB.g"  TRACE=CONFLICTS  NOVARIABLES
    NOVERBOSE  WARNINGS  NOXREF

    *** The following Terminals are useless:
            j  q

    JavaKWLexer.g is SLR(1).


    Number of Terminals: 27
    Number of Nonterminals: 1
    Number of Productions: 52
    Number of Items: 345
    Number of States: 189
    Number of Shift actions: 187
    Number of Goto actions: 1
    Number of Shift/Reduce actions: 47
    Number of Goto/Reduce actions: 0
    Number of Reduce actions: 5
    Number of Shift-Reduce conflicts: 0
    Number of Reduce-Reduce conflicts: 0

    Number of entries in base Action Table: 190
    Additional space required for compaction of Action Table: 0.5%

    Number of unique terminal states: 189
    Number of Shift actions saved by merging: 0
    Number of Conflict points saved by merging: 0
    Number of Reduce actions saved by merging: 0
    Number of Reduce saved by default: 4

    Number of entries in Terminal Action Table: 424
    Additional space required for compaction of Terminal Table: 4.2%

    Actions in Compressed Tables:
         Number of Shifts: 187
         Number of Shift/Reduces: 47
         Number of Gotos: 1
         Number of Goto/Reduces: 0
         Number of Reduces: 1
         Number of Defaults: 4

    Parsing Tables storage:
        Storage required for BASE_CHECK: 52 Bytes
        Storage required for BASE_ACTION: 488 Bytes
        Storage required for TERM_CHECK: 454 Bytes
        Storage required for TERM_ACTION: 886 Bytes

    Options in effect for JavaLexer.g:

    ACTION-BLOCK=("JavaLexer.java","/.","./")

    NOATTRIBUTES  NOBACKTRACK  BYTE  CONFLICTS  DAT-DIRECTORY="./"
    DAT-FILE="JavaLexerdcl.data"  DCL-FILE="JavaLexerdcl.java"  NODEBUG
    DEF-FILE="JavaLexerdef.java"  NOEDIT  NOERROR-MAPS  ESCAPE='$'
    EXPORT-TERMINALS=("JavaParsersym.java","TK_","")  FILE-PREFIX="JavaLexer"
    FILTER="JavaKWLexer.g"  NOFIRST  NOFOLLOW  NOGOTO-DEFAULT
    GRM-FILE="JavaLexer.g"  IMP-FILE="JavaLexerimp.java"
    INCLUDE-DIRECTORY="c:\lpgjavaruntime\lpgjava\com.ibm.lpg\include;.;"  LALR=2
    NOLIST  MARGIN=4  NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'
    PACKAGE="javaparser"  PARSE-TABLE="com.ibm.lpg.*"  PREFIX="Char_"
    NOPRIORITY  PRS-FILE="JavaLexerprs.java"  NOQUIET  READ-REDUCE  NOSCOPES
    NOSERIALIZE  NOSOFT-KEYWORDS  NOSHIFT-DEFAULT  SINGLE-PRODUCTIONS  NOSTATES
    SUFFIX=""  SYM-FILE="JavaLexersym.java"  TAB-FILE="JavaLexer.t"  TABLE=JAVA
    TEMPLATE="LexerTemplateB.g"  TRACE=CONFLICTS  NOVARIABLES  NOVERBOSE
    WARNINGS  NOXREF


    JavaLexer.g is LALR(1).


    Number of Terminals: 102
    Number of Nonterminals: 36
    Number of Productions: 349
    Number of Single Productions: 248
    Number of Items: 789
    Number of States: 65
    Number of Shift actions: 350
    Number of Goto actions: 51
    Number of Shift/Reduce actions: 652
    Number of Goto/Reduce actions: 56
    Number of Reduce actions: 492
    Number of Shift-Reduce conflicts: 0
    Number of Reduce-Reduce conflicts: 0

    Number of entries in base Action Table: 172
    Additional space required for compaction of Action Table: 0.5%

    Number of unique terminal states: 65
    Number of Shift actions saved by merging: 0
    Number of Conflict points saved by merging: 0
    Number of Reduce actions saved by merging: 0
    Number of Reduce saved by default: 477

    Number of entries in Terminal Action Table: 1082
    Additional space required for compaction of Terminal Table: 8.9%

    Actions in Compressed Tables:
         Number of Shifts: 350
         Number of Shift/Reduces: 652
         Number of Gotos: 51
         Number of Goto/Reduces: 56
         Number of Reduces: 15
         Number of Defaults: 51

    Parsing Tables storage:
        Storage required for BASE_CHECK: 349 Bytes
        Storage required for BASE_ACTION: 1046 Bytes
        Storage required for TERM_CHECK: 1211 Bytes
        Storage required for TERM_ACTION: 2360 Bytes

    Options in effect for JavaParser.g:

    ACTION-BLOCK=("JavaParser.java","/.","./")

    NOATTRIBUTES  NOBACKTRACK  BYTE  CONFLICTS  DAT-DIRECTORY="./"
    DAT-FILE="JavaParserdcl.data"  DCL-FILE="JavaParserdcl.java"  NODEBUG
    DEF-FILE="JavaParserdef.java"  NOEDIT  ERROR-MAPS  ESCAPE='$'
    EXPORT-TERMINALS=("JavaParserexp.java","","")  FILE-PREFIX="JavaParser"
    NOFIRST  NOFOLLOW  NOGOTO-DEFAULT  GRM-FILE="JavaParser.g"
    IMP-FILE="JavaParserimp.java"  IMPORT-TERMINALS="JavaLexer.g"
    INCLUDE-DIRECTORY="c:\lpgjavaruntime\lpgjava\com.ibm.lpg\include;.;"  LALR=2
    LIST  MARGIN=4  NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'
    PACKAGE="javaparser"  PARSE-TABLE="com.ibm.lpg.*"  PREFIX="TK_"  NOPRIORITY
    PRS-FILE="JavaParserprs.java"  NOQUIET  READ-REDUCE  SCOPES  NOSERIALIZE
    NOSOFT-KEYWORDS  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  NOSTATES  SUFFIX=""
    SYM-FILE="JavaParsersym.java"  TAB-FILE="JavaParser.t"  TABLE=JAVA
    TEMPLATE="dtParserTemplateB.g"  TRACE=CONFLICTS  NOVARIABLES  NOVERBOSE
    WARNINGS  NOXREF

    *** The following Terminals are useless:
            const  goto

    JavaParser.g is LALR(2).


    Number of Terminals: 106
    Number of Nonterminals: 157
    Number of Productions: 355
    Number of Items: 1046
    Number of Scopes: 57
    Number of States: 334
    Number of look-ahead states: 5
    Number of Shift actions: 1275
    Number of Goto actions: 1462
    Number of Shift/Reduce actions: 2100
    Number of Goto/Reduce actions: 2422
    Number of Reduce actions: 1576
    Number of Shift-Reduce conflicts: 0
    Number of Reduce-Reduce conflicts: 0

    Number of entries in base Action Table: 4218
    Additional space required for compaction of Action Table: 16.7%

    Number of unique terminal states: 243
    Number of Shift actions saved by merging: 2194
    Number of Conflict points saved by merging: 0
    Number of Reduce actions saved by merging: 116
    Number of Reduce saved by default: 1383

    Number of entries in Terminal Action Table: 1506
    Additional space required for compaction of Terminal Table: 5.9%

    Actions in Compressed Tables:
         Number of Shifts: 493
         Number of Shift/Reduces: 688
         Number of Look-Ahead Shifts: 5
         Number of Gotos: 1462
         Number of Goto/Reduces: 2422
         Number of Reduces: 77
         Number of Defaults: 108

    Parsing Tables storage:
        Storage required for BASE_CHECK: 10556 Bytes
        Storage required for BASE_ACTION: 10558 Bytes
        Storage required for TERM_CHECK: 1628 Bytes
        Storage required for TERM_ACTION: 3194 Bytes

    Error maps storage:
        Storage required for ACTION_SYMBOLS_BASE map: 670 Bytes
        Storage required for ACTION_SYMBOLS_RANGE map: 655 Bytes
        Storage required for NACTION_SYMBOLS_BASE map: 670 Bytes
        Storage required for NACTION_SYMBOLS_RANGE map: 342 Bytes
        Storage required for TERMINAL_INDEX map: 214 Bytes
        Storage required for NON_TERMINAL_INDEX map: 318 Bytes

        Storage required for SCOPE_PREFIX map: 114 Bytes
        Storage required for SCOPE_SUFFIX map: 114 Bytes
        Storage required for SCOPE_LHS_SYMBOL map: 114 Bytes
        Storage required for SCOPE_LOOK_AHEAD map: 57 Bytes
        Storage required for SCOPE_STATE_SET map: 114 Bytes
        Storage required for SCOPE_RIGHT_SIDE map: 582 Bytes
        Storage required for SCOPE_STATE map: 422 Bytes
        Storage required for IN_SYMB map: 670 Bytes

        Number of names: 194
        Number of characters in name: 1849

(2) Next compile the Java source. You may use the following command:

    C:\lpgjavaruntime\examples\javaexample\src\javaparser>javac -d
    /lpgjavaruntime/bin -classpath /lpgjavaruntime/lpg.jar *.java

(3) Execute one of the test cases in the test directory.  For example:

    C:\lpgjavaruntime\examples\javaexample\src\javaparser>java -cp
    /lpgjavaruntime/bin;/lpgjavaruntime/tables;/lpgjavaruntime/lpg.jar
    javaparser.Main /lpgjavaruntime/examples/javaexample/test/TsqlParser.java

    ****Begin lexer: ****Begin Parser: ****Success

    ****Parsing statistics:

    ****File length = 999749
    ****Number of Lines = 40290
    ****Read input time :200
    ****Class Construction time :220
    ****Lexing time :421
    ****Parsing time :140
    ****Total time :981
    ****Number of tokens : 204808
    ****Initial Max Memory:          4323840, used: 1120184
    ****After Parse Max Memory:      11205120, used: 10490960
    ****After GC Max Memory:         13564416, used: 9511552

This should let you know the example installed ok.

Here are a few words to help you better understand the Java examples. The
"javaparser" package (illustrated above) is the primary example.  The lpg parser
is specified in JavaParser.g and the lpg lexer in JavaLexer.g.  This lexer uses
a separate lpg lexer for the keywords, specified in the grammar file
JavaKWLexer.g.

Here is how it works: the JavaLexer "exports" the terminal symbols used by the
parser.  These symbols are listed in the $Export section.  However, there are no
keywords included in this list -- only IDENTIFIER.  The action taken when an
IDENTIFIER is recognized is to call the checkForKeyWord() method which invokes
the JavaKWLexer on the IDENTIFIER text to determine whether the scanned
identifier is a java keyword.  Thus, the JavaKWLexer acts as a "filter" on
identifiers.  Two options are needed to make this happen:

%options filter=JavaKWLexer.g
%options export_terminals=("JavaParsersym.java", "TK_")

The filter option specifies the grammar file defining the filter, and the
export_terminals option specifies the file that will enumerate the terminal
symbols names and assigned integer values for the parser (and optionally a
prefix to ensure that the token names are legal java identifiers).  When lpg.exe
compiles "JavaLexer.g" the "filter" option forces the inclusion and processing
of "JavaKWLexer.g".

The java lexer is actually an "action" class that creates the array list of
tokens to be parsed.  To get in all the code that is necessary to do this
(without making the grammar file more difficult to read), we use the "template"
option specifying LexerTemplateB.g.  This template is located in the
lpgjavaruntime/lpgjava/com.ibm.lpg/templates directory (which should be the
value of the environment variable LPG_TEMPLATE).

Finally note that the JavaLexer.g contains an $Include section that includes the
grammar file LexerBasicMap.g.  This file specifies various methods needed to
perform actions, including the checkForKeyWord() method mentioned above.
Another method defined in this file is getKind(int i) that classifies the
character at the ith location of the input stream.  This method is required by
the lexer and the one given here should sufice for most scanners.  This file is
located in the lpgjavaruntime/lpgjava/com.ibm.lpg/include directory (which
should be the value of the environment variable LPG_INCLUDE).

The java parser, "JavaParser.g", uses the template "dtParserTemplateB.g"
(located in the lpgjava/com.ibm.lpg/templates directory) and "imports" its
terminals from "JavaLexer.g".  When lpg.exe compiles "JavaParser.g" the "import"
option forces the inclusion and processing of the imported lexer.  Since the
lexer has a "filter" option, the JavaKWLexer is also included and processed.
This is why it is only necessary to run lpg.exe on the parser file.  You can, of
course, compile each grammar file separately.

In the java language examples no AST is produced although there is a class "Ast"
which only tells us whether the parse was successful.  Only when the "Goal"
symbol is reached is an Ast object generated.  You might want to try the test
case "tab.java" which has syntax errors.

The "genericjavaparser" package has a lexer and parser for the latest version of
the java language.  The generated parse tables are "serialized" into a file
which is placed in the data directory "lpgjavaruntime/tables".  This example
also uses "soft-keyword" recognition and "backtracking".  Backtracking forces
the parser to try alternative parses where there are conflicts.  The soft-
keyword feature tries first to parse a keyword as a keyword and, if that fails,
then as an identifier.  There is an option to specify soft-keywords (which
forces backtracking and sets the lookahead to 1).  Note that a backtracking
parser template, "btParserTemplateA.g", is used.

The "softjavaparser" package has the same java grammar as the javaparser but
uses soft keywords (that is, keywords are not reserved).  Looking at the
directory you will see only parser files and a main program.  This is because
the lexer and Ast are imported from the javaparser package.  The only files
generated by lpg from "SoftJavaParser.g" are "SoftJavaParser.java",
"SoftJavaParserprs.java" and "SoftJavaParsersym.java".  The first of these
consists of the action class and can be thought of as the parser itself.  The
second file is the parse table file, a java class containing the parse tables as
java arrays.  The third file is the symbol file, a java interface defining
values (used by the parser) for the terminal symbols.

The three java language examples essentially have the same driver, Main.java.
Three objects are used: an options object, a lexer object and a parser object.
The options object reads an input file into an array of characters.  The lexer
object is created by passing the options object to its constructor.  The parser
object is created using the lexer object.  The lexical analysis of the input
character array is performed by the "lexer" method, which is passed the parser
object.  Finally, the "parser" method of the parser object is called to parse
the tokens scanned by the lexer and to produce the Ast.

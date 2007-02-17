
Options in effect for C:/eclipse/workspace/lpg.javaruntime.examples/exprexample/expr6/ExprParser.g:

    ACTION-BLOCK=("C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParser.java","/.","./")

    AST-DIRECTORY="./ExprAst"  AST-TYPE="Ast"  NOATTRIBUTES  
    AUTOMATIC-AST=TOPLEVEL  NOBACKTRACK  BYTE  CONFLICTS  
    DAT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\"
    DAT-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParserdcl.data"
    DAT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\"
    DCL-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParserdcl.java"
    DAT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\"
    NODEBUG  
    DEF-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParserdef.java"
    NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  
    EXPORT-TERMINALS=("C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParserexp.java","","")
    NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  EXTENDS-PARSETABLE  FACTORY="new "
    FILE-PREFIX="ExprParser"  NOFIRST  NOFOLLOW  NOGLR  NOGOTO-DEFAULT  
    GRM-FILE="C:/eclipse/workspace/lpg.javaruntime.examples/exprexample/expr6/ExprParser.g"
    FILE-PREFIX="ExprParser"  NOFIRST  NOFOLLOW  NOGLR  NOGOTO-DEFAULT  
    IMP-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParserimp.java"
    FILE-PREFIX="ExprParser"  NOFIRST  NOFOLLOW  NOGLR  NOGOTO-DEFAULT  
    IMPORT-TERMINALS="ExprLexer.g"  
    INCLUDE-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\;.;C:\eclipse\workspace\lpg.javaruntime.v2\include;C:\eclipse\workspace;C:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003;C:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003\lexer;C:\eclipse\workspace\com.ibm.db.parsers.sql.common.db2.lexer\src\com\ibm\db\parsers\sql\common\db2\lexer;C:\eclipse\workspace\com.ibm.db.parsers.sql.routines.db2.common\src\com\ibm\db\parsers\sql\routines\db2\common;"
    IMPORT-TERMINALS="ExprLexer.g"  LALR=1  LIST  MARGIN=4  MAX-CASES=1024  
    NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'  
    OUT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\"
    PACKAGE="expr6"  NOPARENT-SAVE  
    PARSETABLE-INTERFACES="lpg.javaruntime.ParseTable"  PREFIX="TK_"  PRIORITY
    PROGRAMMING_LANGUAGE=JAVA  
    PRS-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParserprs.java"
    PROGRAMMING_LANGUAGE=JAVA  NOQUIET  READ-REDUCE  REMAP-TERMINALS  SCOPES  
    NOSERIALIZE  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  NOSOFT-KEYWORDS  
    NOSTATES  SUFFIX=""  
    SYM-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr6\ExprParsersym.java"
    NOSTATES  SUFFIX=""  TAB-FILE="ExprParser.t"  TABLE  
    TEMPLATE="dtParserTemplateD.g"  TRACE=CONFLICTS  VARIABLES=NONTERMINALS  
    NOVERBOSE  VISITOR=PREORDER  VISITOR-TYPE="Visitor"  WARNINGS  NOXREF  


Predefined Macros:

    $rule_number
    $rule_text
    $rule_size
    $input_file
    $current_line
    $next_line
    $#identifier
    $symbol_declarations
    $num_rules
    $num_terminals
    $num_nonterminals
    $num_non_terminals
    $num_symbols
    $template
    $file_prefix
    $package
    $ast_package
    $ast_type
    $exp_type
    $prs_type
    $sym_type
    $action_type
    $visitor_type



Defined Symbols:



    $Header
    /.    
                    //    
                    // Rule $rule_number:  $rule_text    
                    //./


    $BeginAction
    /. $Header    
                    case $rule_number: {./


    $EndAction
    /.          break;    
                    }./


    $BeginJava
    /.$BeginAction    
                        $symbol_declarations./


    $EndJava
    /.$EndAction./


    $NoAction
    /. $Header    
                    case $rule_number:    
                        break;./


    $BadAction
    /. $Header    
                    case $rule_number:    
                        throw new Error("No action specified for rule " + $rule_number);./


    $NullAction
    /. $Header    
                    case $rule_number:    
                        setResult(null);    
                        break;./


    $BeginActions
    /.    
            public void ruleAction(int ruleNumber)    
            {    
                switch (ruleNumber)    
                {./


    $SplitActions
    /.    
    	            default:    
    	                ruleAction$rule_number(ruleNumber);    
    	                break;    
    	        }    
    	        return;    
    	    }    
    	    
    	    public void ruleAction$rule_number(int ruleNumber)    
    	    {    
    	        switch (ruleNumber)    
    	        {./


    $EndActions
    /.    
                    default:    
                        break;    
                }    
                return;    
            }./


    $additional_interfaces
    /../


    $ast_class
    /.$ast_type./


    $unimplemented_symbols_warning
    /.false./


    $setSym1
    /. // macro setSym1 is deprecated. Use function setResult    
                    getParser().setSym1./


    $setResult
    /. // macro setResult is deprecated. Use function setResult    
                     getParser().setSym1./


    $getSym
    /. // macro getSym is deprecated. Use function getRhsSym    
                  getParser().getSym./


    $getToken
    /. // macro getToken is deprecated. Use function getRhsTokenIndex    
                    getParser().getToken./


    $getIToken
    /. // macro getIToken is deprecated. Use function getRhsIToken    
                     super.getIToken./


    $getLeftSpan
    /. // macro getLeftSpan is deprecated. Use function getLeftSpan    
                       getParser().getFirstToken./


    $getRightSpan
    /. // macro getRightSpan is deprecated. Use function getRightSpan    
                        getParser().getLastToken./


Aliases:

    + ::= PLUS
    * ::= MULTIPLY
    ( ::= LPAREN
    ) ::= RPAREN
    , ::= COMMA


Eof:

    EOF_TOKEN

Error:

    ERROR_TOKEN

Terminals:

    PLUS
    MULTIPLY
    LPAREN
    RPAREN
    COMMA
    EOF_TOKEN
    IntegerLiteral
    ERROR_TOKEN


Soft Keywords:



Rules:

1      EL$$E ::= E
2           | EL , E
3      E ::= E + T
4          | T
5      T ::= T * F
6          | F
7      F ::= IntegerLiteral
8      F$ParenExpr ::= ( E )


 IBM LALR Parser Generator              1.00 (Feb 14 2007)


Name map:

'$empty' ::= '$empty'
PLUS ::= +
MULTIPLY ::= *
LPAREN ::= (
RPAREN ::= )
COMMA ::= ,
EOF_TOKEN ::= EOF_TOKEN
IntegerLiteral ::= IntegerLiteral
ERROR_TOKEN ::= ERROR_TOKEN
EL ::= EL
E ::= E
T ::= T
F ::= F

 IBM LALR Parser Generator              1.00 (Feb 14 2007)


Scopes:

F ::= LPAREN E  .RPAREN 


C:/eclipse/workspace/lpg.javaruntime.examples/exprexample/expr6/ExprParser.g is LALR(1).


Number of Terminals: 8
Number of Nonterminals: 4
Number of Productions: 9
Number of Items: 26
Number of Scopes: 1
Number of States: 11
Number of Shift actions: 11
Number of Goto actions: 8
Number of Shift/Reduce actions: 6
Number of Goto/Reduce actions: 5
Number of Reduce actions: 13
Number of Shift-Reduce conflicts: 0
Number of Reduce-Reduce conflicts: 0

Number of entries in base Action Table: 24
Additional space required for compaction of Action Table: 4.1%

Number of unique terminal states: 7
Number of Shift actions saved by merging: 8
Number of Conflict points saved by merging: 0
Number of Reduce actions saved by merging: 0
Number of Reduce saved by default: 12

Number of entries in Terminal Action Table: 17
Additional space required for compaction of Terminal Table: 5.8%

Actions in Compressed Tables:
     Number of Shifts: 7
     Number of Shift/Reduces: 2
     Number of Gotos: 8
     Number of Goto/Reduces: 5
     Number of Reduces: 1
     Number of Defaults: 4

Parsing Tables storage:
    Storage required for BASE_CHECK: 34 Bytes
    Storage required for BASE_ACTION: 35 Bytes
    Storage required for TERM_CHECK: 25 Bytes
    Storage required for TERM_ACTION: 19 Bytes

Error maps storage:
    Storage required for ACTION_SYMBOLS_BASE map: 12 Bytes
    Storage required for ACTION_SYMBOLS_RANGE map: 13 Bytes
    Storage required for NACTION_SYMBOLS_BASE map: 12 Bytes
    Storage required for NACTION_SYMBOLS_RANGE map: 5 Bytes
    Storage required for TERMINAL_INDEX map: 9 Bytes
    Storage required for NON_TERMINAL_INDEX map: 6 Bytes

    Storage required for SCOPE_PREFIX map: 1 Bytes
    Storage required for SCOPE_SUFFIX map: 1 Bytes
    Storage required for SCOPE_LHS_SYMBOL map: 1 Bytes
    Storage required for SCOPE_LOOK_AHEAD map: 1 Bytes
    Storage required for SCOPE_STATE_SET map: 1 Bytes
    Storage required for SCOPE_RIGHT_SIDE map: 6 Bytes
    Storage required for SCOPE_STATE map: 7 Bytes
    Storage required for IN_SYMB map: 12 Bytes

    Number of names: 15
    Number of characters in name: 50

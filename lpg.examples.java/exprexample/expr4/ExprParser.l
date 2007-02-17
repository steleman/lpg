
Options in effect for C:/eclipse/workspace/lpg.javaruntime.examples/exprexample/expr4/ExprParser.g:

    ACTION-BLOCK=("C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParser.java","/.","./")
    HEADERS=("C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParser.java","/:",":/")

    AST-DIRECTORY=""  AST-TYPE="Integer"  NOATTRIBUTES  NOAUTOMATIC-AST  
    NOBACKTRACK  BYTE  CONFLICTS  
    DAT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\"
    DAT-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParserdcl.data"
    DAT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\"
    DCL-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParserdcl.java"
    DAT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\"
    NODEBUG  
    DEF-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParserdef.java"
    NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  
    EXPORT-TERMINALS=("C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParserexp.java","","")
    NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  EXTENDS-PARSETABLE  FACTORY="new "
    FILE-PREFIX="ExprParser"  NOFIRST  NOFOLLOW  NOGLR  NOGOTO-DEFAULT  
    GRM-FILE="C:/eclipse/workspace/lpg.javaruntime.examples/exprexample/expr4/ExprParser.g"
    FILE-PREFIX="ExprParser"  NOFIRST  NOFOLLOW  NOGLR  NOGOTO-DEFAULT  
    IMP-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParserimp.java"
    FILE-PREFIX="ExprParser"  NOFIRST  NOFOLLOW  NOGLR  NOGOTO-DEFAULT  
    IMPORT-TERMINALS="ExprLexer.g"  
    INCLUDE-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\;.;C:\eclipse\workspace\lpg.javaruntime.v2\include;C:\eclipse\workspace;C:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003;C:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003\lexer;C:\eclipse\workspace\com.ibm.db.parsers.sql.common.db2.lexer\src\com\ibm\db\parsers\sql\common\db2\lexer;C:\eclipse\workspace\com.ibm.db.parsers.sql.routines.db2.common\src\com\ibm\db\parsers\sql\routines\db2\common;"
    IMPORT-TERMINALS="ExprLexer.g"  LALR=1  LIST  MARGIN=8  MAX-CASES=1024  
    NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'  
    OUT-DIRECTORY="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\"
    PACKAGE="expr4"  NOPARENT-SAVE  
    PARSETABLE-INTERFACES="lpg.javaruntime.ParseTable"  PREFIX="TK_"  PRIORITY
    PROGRAMMING_LANGUAGE=JAVA  
    PRS-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParserprs.java"
    PROGRAMMING_LANGUAGE=JAVA  NOQUIET  READ-REDUCE  REMAP-TERMINALS  SCOPES  
    NOSERIALIZE  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  NOSOFT-KEYWORDS  
    NOSTATES  SUFFIX=""  
    SYM-FILE="C:\eclipse\workspace\lpg.javaruntime.examples\exprexample\expr4\ExprParsersym.java"
    NOSTATES  SUFFIX=""  TAB-FILE="ExprParser.t"  TABLE  
    TEMPLATE="dtParserTemplateE.g"  TRACE=CONFLICTS  VARIABLES=NONTERMINALS  
    NOVERBOSE  NOVISITOR  VISITOR-TYPE="Visitor"  WARNINGS  NOXREF  


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



    $DefaultAllocation
    /:    
                    ruleAction[$rule_number] = new act$rule_number$();:/


    $NoAllocation
    /:    
                    ruleAction[$rule_number] = new NoAction();:/


    $NullAllocation
    /:    
                    ruleAction[$rule_number] = new NullAction();:/


    $BadAllocation
    /:    
                    ruleAction[$rule_number] = new BadAction();:/


    $Header
    /.    
                //    
                // Rule $rule_number:  $rule_text    
                //./


    $DefaultAction
    /.$DefaultAllocation $Header    
                final class act$rule_number extends Action./


    $NullAction
    /. $NullAllocation $Header    
                //    
                // final class NullAction extends Action    
                //    
            ./


    $NoAction
    /. $NoAllocation $Header    
                //    
                // final class NullAction extends Action    
                //    
            ./


    $BadAction
    /. $BadAllocation $Header    
                //    
                // final class NullAction extends Action    
                //    
            ./


    $BeginAction
    /.$DefaultAllocation $Header    
                final class act$rule_number extends Action    
                {    
                    public void action()    
                    {./


    $EndAction
    /.          return;    
                    }    
                }./


    $BeginJava
    /.$BeginAction    
                        $symbol_declarations./


    $EndJava
    /.$EndAction./


    $SplitActions
    /../


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


Eof:

    EOF_TOKEN

Error:

    ERROR_TOKEN

Terminals:

    PLUS
    MULTIPLY
    LPAREN
    RPAREN
    EOF_TOKEN
    IntegerLiteral
    ERROR_TOKEN


Soft Keywords:



Rules:

1      E ::= E + T
2          | T
3      T ::= T * F
4          | F
5      F ::= IntegerLiteral $number
6      F$ParenExpr ::= ( E )


Types:

    Integer ::= E
              | T
              | F



 IBM LALR Parser Generator              1.00 (Feb 14 2007)


Name map:

'$empty' ::= '$empty'
PLUS ::= +
MULTIPLY ::= *
LPAREN ::= (
RPAREN ::= )
EOF_TOKEN ::= EOF_TOKEN
IntegerLiteral ::= IntegerLiteral
ERROR_TOKEN ::= ERROR_TOKEN
E ::= E
T ::= T
F ::= F

 IBM LALR Parser Generator              1.00 (Feb 14 2007)


Scopes:

F ::= LPAREN E  .RPAREN 


C:/eclipse/workspace/lpg.javaruntime.examples/exprexample/expr4/ExprParser.g is LALR(1).


Number of Terminals: 7
Number of Nonterminals: 3
Number of Productions: 7
Number of Items: 20
Number of Scopes: 1
Number of States: 8
Number of Shift actions: 8
Number of Goto actions: 5
Number of Shift/Reduce actions: 5
Number of Goto/Reduce actions: 4
Number of Reduce actions: 7
Number of Shift-Reduce conflicts: 0
Number of Reduce-Reduce conflicts: 0

Number of entries in base Action Table: 17
Additional space required for compaction of Action Table: 5.8%

Number of unique terminal states: 5
Number of Shift actions saved by merging: 6
Number of Conflict points saved by merging: 0
Number of Reduce actions saved by merging: 0
Number of Reduce saved by default: 6

Number of entries in Terminal Action Table: 13
Additional space required for compaction of Terminal Table: 23.0%

Actions in Compressed Tables:
     Number of Shifts: 5
     Number of Shift/Reduces: 2
     Number of Gotos: 5
     Number of Goto/Reduces: 4
     Number of Reduces: 1
     Number of Defaults: 2

Parsing Tables storage:
    Storage required for BASE_CHECK: 25 Bytes
    Storage required for BASE_ACTION: 26 Bytes
    Storage required for TERM_CHECK: 22 Bytes
    Storage required for TERM_ACTION: 17 Bytes

Error maps storage:
    Storage required for ACTION_SYMBOLS_BASE map: 9 Bytes
    Storage required for ACTION_SYMBOLS_RANGE map: 12 Bytes
    Storage required for NACTION_SYMBOLS_BASE map: 9 Bytes
    Storage required for NACTION_SYMBOLS_RANGE map: 5 Bytes
    Storage required for TERMINAL_INDEX map: 8 Bytes
    Storage required for NON_TERMINAL_INDEX map: 5 Bytes

    Storage required for SCOPE_PREFIX map: 1 Bytes
    Storage required for SCOPE_SUFFIX map: 1 Bytes
    Storage required for SCOPE_LHS_SYMBOL map: 1 Bytes
    Storage required for SCOPE_LOOK_AHEAD map: 1 Bytes
    Storage required for SCOPE_STATE_SET map: 1 Bytes
    Storage required for SCOPE_RIGHT_SIDE map: 6 Bytes
    Storage required for SCOPE_STATE map: 6 Bytes
    Storage required for IN_SYMB map: 9 Bytes

    Number of names: 13
    Number of characters in name: 47

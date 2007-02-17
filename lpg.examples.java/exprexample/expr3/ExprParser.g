%options ast_directory=./ExprAst
%options automatic_ast=toplevel
%options variables=nt
%options package=expr3
%options template=dtParserTemplateD.g
%options import_terminals=ExprLexer.g

$Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
    
$end

$Ast
    /.
        int value;
        public int getValue() { return value; }
        protected void setValue(int value) { this.value = value; }
    ./
$End

$Rules
    E ::= E + T
    /.
        void initialize()
        {
            setValue(((Ast) getE()).getValue() + ((Ast) getT()).getValue());
        }
    ./
        | T
    T ::= T * F
    /.
        void initialize()
        {
            setValue(((Ast) getT()).getValue() * ((Ast) getF()).getValue());
        }
    ./
        | F
    F ::= IntegerLiteral$Number
    /.
        void initialize()
        {
            setValue(new Integer(getNumber().toString()).intValue());
        }
    ./
    F$ParenExpr ::= ( E )
    /.
        void initialize()
        {
            setValue(((Ast) getE()).getValue());
        }
    ./
$End

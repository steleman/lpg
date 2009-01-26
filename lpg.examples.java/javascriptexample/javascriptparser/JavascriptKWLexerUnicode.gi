%Options fp=JavascriptKWLexer
%options package=javascriptparser
%options template=KeywordTemplateF.gi

%Include
    KWLexerLowerCaseMapF.gi
%End

%Export

    -- The following are reserved words and may not be used as variables, functions,
    -- methods, or object identifiers. The following are reserved as existing
    -- keywords by the ECMAScript specification:

    AS
    BREAK
    CASE
    CATCH
    CLASS
    CONST
    CONTINUE
    DEFAULT
    DELETE
    DO
    ELSE
    EXPORT
    EXTENDS
    FALSE
    FINAL
    FINALLY
    FOR
    FUNCTION
    IF
    IMPORT
    IN
    INSTANCEOF
    IS
    NAMESPACE
    NEW
    NULL
    PACKAGE
    PRIVATE
    PUBLIC    
    RETURN
    STATIC
    SUPER    
    SWITCH
    THIS
    THROW
    TRUE    
    TRY
    TYPEOF
    USE    
    VAR
    VOID
    WHILE
    WITH 

    -- The following are reserved as future keywords by the ECMAScript specification:

    ABSTRACT
    DEBUGGER
    ENUM
    GOTO
    IMPLEMENTS
    INTERFACE
    LONG
    NATIVE
    PROTECTED
    SYNCHRONIZED
    THROWS
    TRANSIENT
    VOLATILE 
    
    -- Non-reserved keywords

    EXCLUDE
    GET
    INCLUDE
    SET

%End

%Terminals
    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
%End

%Start
    KeyWord
%End


--
-- Regular Reserved keywords
--
%Rules

    -- The Goal for the parser is a single Keyword

    KeyWord ::= a s                  /.$setResult($_AS);./
              | b r e a k            /.$setResult($_BREAK);./
              | c a s e              /.$setResult($_CASE);./
              | c a t c h            /.$setResult($_CATCH);./
              | c l a s s            /.$setResult($_CLASS);./
              | c o n s t            /.$setResult($_CONST);./
              | c o n t i n u e      /.$setResult($_CONTINUE);./
              | d e f a u l t        /.$setResult($_DEFAULT);./
              | d e l e t e          /.$setResult($_DELETE);./
              | d o                  /.$setResult($_DO);./
              | e l s e              /.$setResult($_ELSE);./
              | e x p o r t          /.$setResult($_EXPORT);./
              | e x t e n d s        /.$setResult($_EXTENDS);./
              | f a l s e            /.$setResult($_FALSE);./
              | f i n a l            /.$setResult($_FINAL);./
              | f i n a l l y        /.$setResult($_FINALLY);./
              | f o r                /.$setResult($_FOR);./
              | f u n c t i o n      /.$setResult($_FUNCTION);./
              | i f                  /.$setResult($_IF);./
              | i m p o r t          /.$setResult($_IMPORT);./
              | i n                  /.$setResult($_IN);./
              | i n s t a n c e o f  /.$setResult($_INSTANCEOF);./
              | i s                  /.$setResult($_IS);./
              | n a m e s p a c e    /.$setResult($_NAMESPACE);./
              | n e w                /.$setResult($_NEW);./
              | n u l l              /.$setResult($_NULL);./
              | p a c k a g e        /.$setResult($_PACKAGE);./
              | p r i v a t e        /.$setResult($_PRIVATE);./
              | p u b l i c          /.$setResult($_PUBLIC    );./    
              | r e t u r n          /.$setResult($_RETURN);./
              | s t a t i c          /.$setResult($_STATIC);./
              | s u p e r            /.$setResult($_SUPER    );./    
              | s w i t c h          /.$setResult($_SWITCH);./
              | t h i s              /.$setResult($_THIS);./
              | t h r o w            /.$setResult($_THROW);./
              | t r u e              /.$setResult($_TRUE    );./    
              | t r y                /.$setResult($_TRY);./
              | t y p e o f          /.$setResult($_TYPEOF);./
              | u s e                /.$setResult($_USE);./
              | v a r                /.$setResult($_VAR);./
              | v o i d              /.$setResult($_VOID);./
              | w h i l e            /.$setResult($_WHILE);./
              | w i t h              /.$setResult($_WITH );./ 
%End

--
-- Future ECMA reserved words
--
%Rules
    KeyWord ::= a b s t r a c t /.$setResult($_ABSTRACT);./
    | d e b u g g e r           /.$setResult($_DEBUGGER);./
    | e n u m                   /.$setResult($_ENUM);./
    | g o t o                   /.$setResult($_GOTO);./
    | i m p l e m e n t s       /.$setResult($_IMPLEMENTS);./
    | i n t e r f a c e         /.$setResult($_INTERFACE);./
    | l o n g                   /.$setResult($_LONG);./
    | n a t i v e               /.$setResult($_NATIVE);./
    | p r o t e c t e d         /.$setResult($_PROTECTED);./
    | s y n c h r o n i z e d   /.$setResult($_SYNCHRONIZED);./
    | t h r o w s               /.$setResult($_THROWS);./
    | t r a n s i e n t         /.$setResult($_TRANSIENT);./
    | v o l a t i l e           /.$setResult($_VOLATILE );./ 
%End

--
-- Non-Reserved keywords
--
%Rules
    KeyWord ::= e x c l u d e /.$setResult($_EXCLUDE);./
              | g e t         /.$setResult($_GET);./
              | i n c l u d e /.$setResult($_INCLUDE);./
              | s e t         /.$setResult($_SET);./
%End

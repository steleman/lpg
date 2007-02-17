%Options fp=JavascriptKWLexer
%options package=javascriptparser
%options template=KeywordTemplateD.g

$Include
    KWLexerLowerCaseMap.g
$End

$Export

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

$End

$Terminals
    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
$End

$Start
    KeyWord
$End


--
-- Regular Reserved keywords
--
$Rules

    -- The Goal for the parser is a single Keyword
    KeyWord ::= a s
        /.$BeginAction
            $setResult($_AS);
          $EndAction
        ./
    | b r e a k
        /.$BeginAction
            $setResult($_BREAK);
          $EndAction
        ./
    | c a s e
       /.$BeginAction
           $setResult($_CASE);
         $EndAction
       ./
    | c a t c h
       /.$BeginAction
           $setResult($_CATCH);
         $EndAction
       ./
    | c l a s s
       /.$BeginAction
           $setResult($_CLASS);
         $EndAction
       ./
    | c o n s t
       /.$BeginAction
           $setResult($_CONST);
         $EndAction
       ./
    | c o n t i n u e
       /.$BeginAction
           $setResult($_CONTINUE);
         $EndAction
       ./
    | d e f a u l t
       /.$BeginAction
           $setResult($_DEFAULT);
         $EndAction
       ./
    | d e l e t e
       /.$BeginAction
           $setResult($_DELETE);
         $EndAction
       ./
    | d o
       /.$BeginAction
           $setResult($_DO);
         $EndAction
       ./
    | e l s e
       /.$BeginAction
           $setResult($_ELSE);
         $EndAction
       ./
    | e x p o r t
       /.$BeginAction
           $setResult($_EXPORT);
         $EndAction
       ./
    | e x t e n d s
       /.$BeginAction
           $setResult($_EXTENDS);
         $EndAction
       ./
    | f a l s e
       /.$BeginAction
           $setResult($_FALSE);
         $EndAction
       ./
    | f i n a l
       /.$BeginAction
           $setResult($_FINAL);
         $EndAction
       ./
    | f i n a l l y
       /.$BeginAction
           $setResult($_FINALLY);
         $EndAction
       ./
    | f o r
       /.$BeginAction
           $setResult($_FOR);
         $EndAction
       ./
    | f u n c t i o n
       /.$BeginAction
           $setResult($_FUNCTION);
         $EndAction
       ./
    | i f
       /.$BeginAction
           $setResult($_IF);
         $EndAction
       ./
    | i m p o r t
       /.$BeginAction
           $setResult($_IMPORT);
         $EndAction
       ./
    | i n
       /.$BeginAction
           $setResult($_IN);
         $EndAction
       ./
    | i n s t a n c e o f
       /.$BeginAction
           $setResult($_INSTANCEOF);
         $EndAction
       ./
    | i s
       /.$BeginAction
           $setResult($_IS);
         $EndAction
       ./
    | n a m e s p a c e
       /.$BeginAction
           $setResult($_NAMESPACE);
         $EndAction
       ./
    | n e w
       /.$BeginAction
           $setResult($_NEW);
         $EndAction
       ./
    | n u l l
       /.$BeginAction
           $setResult($_NULL);
         $EndAction
       ./
    | p a c k a g e
       /.$BeginAction
           $setResult($_PACKAGE);
         $EndAction
       ./
    | p r i v a t e
       /.$BeginAction
           $setResult($_PRIVATE);
         $EndAction
       ./
    | p u b l i c
       /.$BeginAction
           $setResult($_PUBLIC    );
         $EndAction
       ./    
    | r e t u r n
       /.$BeginAction
           $setResult($_RETURN);
         $EndAction
       ./
    | s t a t i c
       /.$BeginAction
           $setResult($_STATIC);
         $EndAction
       ./
    | s u p e r
       /.$BeginAction
           $setResult($_SUPER    );
         $EndAction
       ./    
    | s w i t c h
       /.$BeginAction
           $setResult($_SWITCH);
         $EndAction
       ./
    | t h i s
       /.$BeginAction
           $setResult($_THIS);
         $EndAction
       ./
    | t h r o w
       /.$BeginAction
           $setResult($_THROW);
         $EndAction
       ./
    | t r u e
       /.$BeginAction
           $setResult($_TRUE    );
         $EndAction
       ./    
    | t r y
       /.$BeginAction
           $setResult($_TRY);
         $EndAction
       ./
    | t y p e o f
       /.$BeginAction
           $setResult($_TYPEOF);
         $EndAction
       ./
    | u s e    
       /.$BeginAction
           $setResult($_USE);
         $EndAction
       ./
    | v a r
       /.$BeginAction
           $setResult($_VAR);
         $EndAction
       ./
    | v o i d
       /.$BeginAction
           $setResult($_VOID);
         $EndAction
       ./
    | w h i l e
       /.$BeginAction
           $setResult($_WHILE);
         $EndAction
       ./
    | w i t h
       /.$BeginAction
           $setResult($_WITH );
         $EndAction
       ./ 
$End

--
-- Future ECMA reserved words
--
$Rules
    KeyWord ::= a b s t r a c t
       /.$BeginAction
           $setResult($_ABSTRACT);
         $EndAction
       ./
    | d e b u g g e r
       /.$BeginAction
           $setResult($_DEBUGGER);
         $EndAction
       ./
    | e n u m
       /.$BeginAction
           $setResult($_ENUM);
         $EndAction
       ./
    | g o t o
       /.$BeginAction
           $setResult($_GOTO);
         $EndAction
       ./
    | i m p l e m e n t s
       /.$BeginAction
           $setResult($_IMPLEMENTS);
         $EndAction
       ./
    | i n t e r f a c e
       /.$BeginAction
           $setResult($_INTERFACE);
         $EndAction
       ./
    | l o n g
       /.$BeginAction
           $setResult($_LONG);
         $EndAction
       ./
    | n a t i v e
       /.$BeginAction
           $setResult($_NATIVE);
         $EndAction
       ./
    | p r o t e c t e d
       /.$BeginAction
           $setResult($_PROTECTED);
         $EndAction
       ./
    | s y n c h r o n i z e d
       /.$BeginAction
           $setResult($_SYNCHRONIZED);
         $EndAction
       ./
    | t h r o w s
       /.$BeginAction
           $setResult($_THROWS);
         $EndAction
       ./
    | t r a n s i e n t
       /.$BeginAction
           $setResult($_TRANSIENT);
         $EndAction
       ./
    | v o l a t i l e
       /.$BeginAction
           $setResult($_VOLATILE );
         $EndAction
       ./ 
$End

--
-- Non-Reserved keywords
--
$Rules
    KeyWord ::= e x c l u d e
       /.$BeginAction
           $setResult($_EXCLUDE);
         $EndAction
       ./
    | g e t
       /.$BeginAction
           $setResult($_GET);
         $EndAction
       ./
    | i n c l u d e
       /.$BeginAction
           $setResult($_INCLUDE);
         $EndAction
       ./
    | s e t
       /.$BeginAction
           $setResult($_SET);
         $EndAction
       ./
$End

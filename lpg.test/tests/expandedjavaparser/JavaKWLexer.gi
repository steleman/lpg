--
-- The Java KeyWord Lexer
--
%Options fp=JavaKWLexer
%options package=expandedjavaparser
%options template=KeywordTemplateF.gi

%Include
    KWLexerLowerCaseMapF.gi
%End

%Export

    abstract
    boolean
    break
    byte
    case
    catch
    char
    class
    const
    continue
    default
    do
    double
    else
    extends
    false
    final
    finally
    float
    for
    goto
    if
    implements
    import
    instanceof
    int
    interface
    long
    native
    new
    null
    package
    private
    protected
    public
    return
    short
    static
    strictfp
    super
    switch
    synchronized
    this
    throw
    throws
    transient
    true
    try
    void
    volatile
    while

%End

%Terminals
    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
%End

%Start
    KeyWord
%End

%Rules

-- The Goal for the parser is a single Keyword

    KeyWord ::= a b s t r a c t          /.$setResult($_abstract);./
              | b o o l e a n            /.$setResult($_boolean);./
              | b r e a k                /.$setResult($_break);./
              | b y t e                  /.$setResult($_byte);./
              | c a s e                  /.$setResult($_case);./
              | c a t c h                /.$setResult($_catch);./
              | c h a r                  /.$setResult($_char);./
              | c l a s s                /.$setResult($_class);./
              | c o n s t                /.$setResult($_const);./
              | c o n t i n u e          /.$setResult($_continue);./
              | d e f a u l t            /.$setResult($_default);./
              | d o                      /.$setResult($_do);./
              | d o u b l e              /.$setResult($_double);./
              | e l s e                  /.$setResult($_else);./
              | e x t e n d s            /.$setResult($_extends);./
              | f a l s e                /.$setResult($_false);./
              | f i n a l                /.$setResult($_final);./
              | f i n a l l y            /.$setResult($_finally);./
              | f l o a t                /.$setResult($_float);./
              | f o r                    /.$setResult($_for);./
              | g o t o                  /.$setResult($_goto);./
              | i f                      /.$setResult($_if);./
              | i m p l e m e n t s      /.$setResult($_implements);./
              | i m p o r t              /.$setResult($_import);./
              | i n s t a n c e o f      /.$setResult($_instanceof);./
              | i n t                    /.$setResult($_int);./
              | i n t e r f a c e        /.$setResult($_interface);./
              | l o n g                  /.$setResult($_long);./
              | n a t i v e              /.$setResult($_native);./
              | n e w                    /.$setResult($_new);./
              | n u l l                  /.$setResult($_null);./
              | p a c k a g e            /.$setResult($_package);./
              | p r i v a t e            /.$setResult($_private);./
              | p r o t e c t e d        /.$setResult($_protected);./
              | p u b l i c              /.$setResult($_public);./
              | r e t u r n              /.$setResult($_return);./
              | s h o r t                /.$setResult($_short);./
              | s t a t i c              /.$setResult($_static);./
              | s t r i c t f p          /.$setResult($_strictfp);./
              | s u p e r                /.$setResult($_super);./
              | s w i t c h              /.$setResult($_switch);./
              | s y n c h r o n i z e d  /.$setResult($_synchronized);./
              | t h i s                  /.$setResult($_this);./
              | t h r o w                /.$setResult($_throw);./
              | t h r o w s              /.$setResult($_throws);./
              | t r a n s i e n t        /.$setResult($_transient);./
              | t r u e                  /.$setResult($_true);./
              | t r y                    /.$setResult($_try);./
              | v o i d                  /.$setResult($_void);./
              | v o l a t i l e          /.$setResult($_volatile);./
              | w h i l e                /.$setResult($_while);./
%End

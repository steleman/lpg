package lpg.examples.java.expr3.ExprAst;

import lpg.examples.java.expr3.*;
import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 5:  F ::= IntegerLiteral$Number
 *</b>
 */
public class F extends AstToken implements IF
{
    private ExprParser environment;
    public ExprParser getEnvironment() { return environment; }

    public IToken getNumber() { return leftIToken; }

    public F(ExprParser environment, IToken token)    {
        super(token);
        this.environment = environment;
        initialize();
    }

    void initialize()
    {
        setValue(new Integer(getNumber().toString()).intValue());
    }
}



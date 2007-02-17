package expr6.ExprAst;

import lpg.javaruntime.*;

/**
 * is implemented by <b>EList</b>
 */
public interface IEL
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}



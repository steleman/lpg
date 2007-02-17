package expr6.ExprAst;

import lpg.javaruntime.*;

public abstract class Ast implements IAst
{
    public IAst getNextAst() { return null; }
    protected IToken leftIToken,
                     rightIToken;
    public IAst getParent()
    {
        throw new UnsupportedOperationException("noparent-saved option in effect");
    }

    public IToken getLeftIToken() { return leftIToken; }
    public IToken getRightIToken() { return rightIToken; }
    public IToken[] getPrecedingAdjuncts() { return leftIToken.getPrecedingAdjuncts(); }
    public IToken[] getFollowingAdjuncts() { return rightIToken.getFollowingAdjuncts(); }

    public String toString()
    {
        return leftIToken.getPrsStream().toString(leftIToken, rightIToken);
    }

    public Ast(IToken token) { this.leftIToken = this.rightIToken = token; }
    public Ast(IToken leftIToken, IToken rightIToken)
    {
        this.leftIToken = leftIToken;
        this.rightIToken = rightIToken;
    }

    void initialize() {}

    public java.util.ArrayList getChildren()
    {
        throw new UnsupportedOperationException("noparent-saved option in effect");
    }
    public java.util.ArrayList getAllChildren() { return getChildren(); }

    /**
     * Since the Ast type has no children, any two instances of it are equal.
     */
    public boolean equals(Object o) { return o instanceof Ast; }
    public abstract int hashCode();
    public abstract void accept(Visitor v);
}



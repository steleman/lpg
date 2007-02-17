package expr6.ExprAst;

import lpg.javaruntime.*;

public class AstToken extends Ast implements IAstToken
{
    public AstToken(IToken token) { super(token); }
    public IToken getIToken() { return leftIToken; }
    public String toString() { return leftIToken.toString(); }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof AstToken)) return false;
        AstToken other = (AstToken) o;
        return toString().equals(other.toString());
    }

    public int hashCode()
    {
        return toString().hashCode();
    }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        v.visit(this);
        v.endVisit(this);
    }
}



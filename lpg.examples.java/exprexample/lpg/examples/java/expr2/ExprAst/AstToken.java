package lpg.examples.java.expr2.ExprAst;

import lpg.runtime.java.*;

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

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}



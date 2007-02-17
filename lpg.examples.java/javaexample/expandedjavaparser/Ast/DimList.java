//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 222:  Dims ::= Dim
 *<li>Rule 223:  Dims ::= Dims Dim
 *<li>Rule 326:  Dimsopt ::= $Empty
 *<li>Rule 327:  Dimsopt ::= Dims
 *</b>
 */
public class DimList extends AstList implements IDims, IDimsopt
{
    public Dim getDimAt(int i) { return (Dim) getElementAt(i); }

    public DimList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public DimList(Dim _Dim, boolean leftRecursive)
    {
        super((Ast) _Dim, leftRecursive);
        ((Ast) _Dim).setParent(this);
        initialize();
    }

    public void add(Dim _Dim)
    {
        super.add((Ast) _Dim);
        ((Ast) _Dim).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getDimAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getDimAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getDimAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getDimAt(i), o));
        return result;
    }
}



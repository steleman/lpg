//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 90:  FormalParameterList ::= FormalParameter
 *<li>Rule 91:  FormalParameterList ::= FormalParameterList , FormalParameter
 *<li>Rule 332:  FormalParameterListopt ::= $Empty
 *<li>Rule 333:  FormalParameterListopt ::= FormalParameterList
 *</b>
 */
public class FormalParameterList extends AstList implements IFormalParameterList, IFormalParameterListopt
{
    public FormalParameter getFormalParameterAt(int i) { return (FormalParameter) getElementAt(i); }

    public FormalParameterList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public FormalParameterList(FormalParameter _FormalParameter, boolean leftRecursive)
    {
        super((Ast) _FormalParameter, leftRecursive);
        ((Ast) _FormalParameter).setParent(this);
        initialize();
    }

    public void add(FormalParameter _FormalParameter)
    {
        super.add((Ast) _FormalParameter);
        ((Ast) _FormalParameter).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getFormalParameterAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getFormalParameterAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getFormalParameterAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getFormalParameterAt(i), o));
        return result;
    }
}



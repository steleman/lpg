//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 79:  VariableDeclarators ::= VariableDeclarator
 *<li>Rule 80:  VariableDeclarators ::= VariableDeclarators , VariableDeclarator
 *</b>
 */
public class VariableDeclaratorList extends AstList implements IVariableDeclarators
{
    public IVariableDeclarator getVariableDeclaratorAt(int i) { return (IVariableDeclarator) getElementAt(i); }

    public VariableDeclaratorList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public VariableDeclaratorList(IVariableDeclarator _VariableDeclarator, boolean leftRecursive)
    {
        super((Ast) _VariableDeclarator, leftRecursive);
        ((Ast) _VariableDeclarator).setParent(this);
        initialize();
    }

    public void add(IVariableDeclarator _VariableDeclarator)
    {
        super.add((Ast) _VariableDeclarator);
        ((Ast) _VariableDeclarator).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getVariableDeclaratorAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getVariableDeclaratorAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getVariableDeclaratorAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getVariableDeclaratorAt(i).accept(v, o));
        return result;
    }
}



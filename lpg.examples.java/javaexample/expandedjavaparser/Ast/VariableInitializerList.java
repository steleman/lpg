//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 121:  VariableInitializers ::= VariableInitializer
 *<li>Rule 122:  VariableInitializers ::= VariableInitializers , VariableInitializer
 *<li>Rule 346:  VariableInitializersopt ::= $Empty
 *<li>Rule 347:  VariableInitializersopt ::= VariableInitializers
 *</b>
 */
public class VariableInitializerList extends AstList implements IVariableInitializers, IVariableInitializersopt
{
    public IVariableInitializer getVariableInitializerAt(int i) { return (IVariableInitializer) getElementAt(i); }

    public VariableInitializerList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public VariableInitializerList(IVariableInitializer _VariableInitializer, boolean leftRecursive)
    {
        super((Ast) _VariableInitializer, leftRecursive);
        ((Ast) _VariableInitializer).setParent(this);
        initialize();
    }

    public void add(IVariableInitializer _VariableInitializer)
    {
        super.add((Ast) _VariableInitializer);
        ((Ast) _VariableInitializer).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getVariableInitializerAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getVariableInitializerAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getVariableInitializerAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getVariableInitializerAt(i).accept(v, o));
        return result;
    }
}



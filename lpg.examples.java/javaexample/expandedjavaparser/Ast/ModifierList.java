//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 48:  Modifiers ::= Modifier
 *<li>Rule 49:  Modifiers ::= Modifiers Modifier
 *<li>Rule 320:  Modifiersopt ::= $Empty
 *<li>Rule 321:  Modifiersopt ::= Modifiers
 *</b>
 */
public class ModifierList extends AstList implements IModifiers, IModifiersopt
{
    public IModifier getModifierAt(int i) { return (IModifier) getElementAt(i); }

    public ModifierList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public ModifierList(IModifier _Modifier, boolean leftRecursive)
    {
        super((Ast) _Modifier, leftRecursive);
        ((Ast) _Modifier).setParent(this);
        initialize();
    }

    public void add(IModifier _Modifier)
    {
        super.add((Ast) _Modifier);
        ((Ast) _Modifier).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getModifierAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getModifierAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getModifierAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getModifierAt(i).accept(v, o));
        return result;
    }
}



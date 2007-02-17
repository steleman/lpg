package expr6.ExprAst;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 1:  EL ::= E
 *<li>Rule 2:  EL ::= EL , E
 *</b>
 */
public class EList extends AstList implements IEL
{
    public IE getEAt(int i) { return (IE) getElementAt(i); }

    public EList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public EList(IE _E, boolean leftRecursive)
    {
        super((Ast) _E, leftRecursive);
        initialize();
    }

    public void add(IE _E)
    {
        super.add((Ast) _E);
    }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }
    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            for (int i = 0; i < size(); i++)
            {
                IE element = getEAt(i);
                element.accept(v);
            }
        }
        v.endVisit(this);
    }
}



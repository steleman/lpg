//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 93:  Throws ::= throws ClassTypeList
 *<li>Rule 94:  ClassTypeList ::= ClassType
 *<li>Rule 95:  ClassTypeList ::= ClassTypeList , ClassType
 *<li>Rule 330:  Throwsopt ::= $Empty
 *<li>Rule 331:  Throwsopt ::= Throws
 *</b>
 */
public class ClassTypeList extends AstList implements IThrows, IClassTypeList, IThrowsopt
{
    public IClassType getClassTypeAt(int i) { return (IClassType) getElementAt(i); }

    public ClassTypeList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public ClassTypeList(IClassType _ClassType, boolean leftRecursive)
    {
        super((Ast) _ClassType, leftRecursive);
        ((Ast) _ClassType).setParent(this);
        initialize();
    }

    public void add(IClassType _ClassType)
    {
        super.add((Ast) _ClassType);
        ((Ast) _ClassType).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getClassTypeAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getClassTypeAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getClassTypeAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getClassTypeAt(i).accept(v, o));
        return result;
    }
}



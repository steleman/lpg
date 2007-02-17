//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 63:  Interfaces ::= implements InterfaceTypeList
 *<li>Rule 64:  InterfaceTypeList ::= InterfaceType
 *<li>Rule 65:  InterfaceTypeList ::= InterfaceTypeList , InterfaceType
 *<li>Rule 109:  ExtendsInterfaces ::= extends InterfaceTypeList
 *<li>Rule 334:  Interfacesopt ::= $Empty
 *<li>Rule 335:  Interfacesopt ::= Interfaces
 *<li>Rule 342:  ExtendsInterfacesopt ::= $Empty
 *<li>Rule 343:  ExtendsInterfacesopt ::= ExtendsInterfaces
 *</b>
 */
public class InterfaceTypeList extends AstList implements IInterfaces, IInterfaceTypeList, IExtendsInterfaces, IInterfacesopt, IExtendsInterfacesopt
{
    public IInterfaceType getInterfaceTypeAt(int i) { return (IInterfaceType) getElementAt(i); }

    public InterfaceTypeList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public InterfaceTypeList(IInterfaceType _InterfaceType, boolean leftRecursive)
    {
        super((Ast) _InterfaceType, leftRecursive);
        ((Ast) _InterfaceType).setParent(this);
        initialize();
    }

    public void add(IInterfaceType _InterfaceType)
    {
        super.add((Ast) _InterfaceType);
        ((Ast) _InterfaceType).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getInterfaceTypeAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getInterfaceTypeAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getInterfaceTypeAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getInterfaceTypeAt(i).accept(v, o));
        return result;
    }
}



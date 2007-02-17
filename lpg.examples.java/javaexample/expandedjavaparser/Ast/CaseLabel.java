//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 176:  SwitchLabel ::= case ConstantExpression :
 *</b>
 */
public class CaseLabel extends Ast implements ISwitchLabel
{
    private AstToken _case;
    private IConstantExpression _ConstantExpression;
    private AstToken _COLON;

    public AstToken getcase() { return _case; }
    public IConstantExpression getConstantExpression() { return _ConstantExpression; }
    public AstToken getCOLON() { return _COLON; }

    public CaseLabel(IToken leftIToken, IToken rightIToken,
                     AstToken _case,
                     IConstantExpression _ConstantExpression,
                     AstToken _COLON)
    {
        super(leftIToken, rightIToken);

        this._case = _case;
        ((Ast) _case).setParent(this);
        this._ConstantExpression = _ConstantExpression;
        ((Ast) _ConstantExpression).setParent(this);
        this._COLON = _COLON;
        ((Ast) _COLON).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_case);
        list.add(_ConstantExpression);
        list.add(_COLON);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        //
        // The super call test is not required for now because an Ast node
        // can only extend the root Ast, AstToken and AstList and none of
        // these nodes contain additional children.
        //
        // if (! super.equals(o)) return false;
        //
        if (! (o instanceof CaseLabel)) return false;
        CaseLabel other = (CaseLabel) o;
        if (! _case.equals(other._case)) return false;
        if (! _ConstantExpression.equals(other._ConstantExpression)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_case.hashCode());
        hash = hash * 31 + (_ConstantExpression.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}



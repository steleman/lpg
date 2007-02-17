//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 190:  ReturnStatement ::= return Expressionopt ;
 *</b>
 */
public class ReturnStatement extends Ast implements IReturnStatement
{
    private AstToken _return;
    private IExpressionopt _Expressionopt;
    private AstToken _SEMICOLON;

    public AstToken getreturn() { return _return; }
    /**
     * The value returned by <b>getExpressionopt</b> may be <b>null</b>
     */
    public IExpressionopt getExpressionopt() { return _Expressionopt; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public ReturnStatement(IToken leftIToken, IToken rightIToken,
                           AstToken _return,
                           IExpressionopt _Expressionopt,
                           AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._return = _return;
        ((Ast) _return).setParent(this);
        this._Expressionopt = _Expressionopt;
        if (_Expressionopt != null) ((Ast) _Expressionopt).setParent(this);
        this._SEMICOLON = _SEMICOLON;
        ((Ast) _SEMICOLON).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_return);
        list.add(_Expressionopt);
        list.add(_SEMICOLON);
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
        if (! (o instanceof ReturnStatement)) return false;
        ReturnStatement other = (ReturnStatement) o;
        if (! _return.equals(other._return)) return false;
        if (_Expressionopt == null)
            if (other._Expressionopt != null) return false;
            else; // continue
        else if (! _Expressionopt.equals(other._Expressionopt)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_return.hashCode());
        hash = hash * 31 + (_Expressionopt == null ? 0 : _Expressionopt.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}



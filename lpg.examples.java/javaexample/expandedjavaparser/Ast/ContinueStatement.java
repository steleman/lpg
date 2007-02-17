//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 189:  ContinueStatement ::= continue IDENTIFIERopt ;
 *</b>
 */
public class ContinueStatement extends Ast implements IContinueStatement
{
    private AstToken _continue;
    private IDENTIFIERopt _IDENTIFIERopt;
    private AstToken _SEMICOLON;

    public AstToken getcontinue() { return _continue; }
    /**
     * The value returned by <b>getIDENTIFIERopt</b> may be <b>null</b>
     */
    public IDENTIFIERopt getIDENTIFIERopt() { return _IDENTIFIERopt; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public ContinueStatement(IToken leftIToken, IToken rightIToken,
                             AstToken _continue,
                             IDENTIFIERopt _IDENTIFIERopt,
                             AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._continue = _continue;
        ((Ast) _continue).setParent(this);
        this._IDENTIFIERopt = _IDENTIFIERopt;
        if (_IDENTIFIERopt != null) ((Ast) _IDENTIFIERopt).setParent(this);
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
        list.add(_continue);
        list.add(_IDENTIFIERopt);
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
        if (! (o instanceof ContinueStatement)) return false;
        ContinueStatement other = (ContinueStatement) o;
        if (! _continue.equals(other._continue)) return false;
        if (_IDENTIFIERopt == null)
            if (other._IDENTIFIERopt != null) return false;
            else; // continue
        else if (! _IDENTIFIERopt.equals(other._IDENTIFIERopt)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_continue.hashCode());
        hash = hash * 31 + (_IDENTIFIERopt == null ? 0 : _IDENTIFIERopt.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}



//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 188:  BreakStatement ::= break IDENTIFIERopt ;
 *</b>
 */
public class BreakStatement extends Ast implements IBreakStatement
{
    private AstToken _break;
    private IDENTIFIERopt _IDENTIFIERopt;
    private AstToken _SEMICOLON;

    public AstToken getbreak() { return _break; }
    /**
     * The value returned by <b>getIDENTIFIERopt</b> may be <b>null</b>
     */
    public IDENTIFIERopt getIDENTIFIERopt() { return _IDENTIFIERopt; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public BreakStatement(IToken leftIToken, IToken rightIToken,
                          AstToken _break,
                          IDENTIFIERopt _IDENTIFIERopt,
                          AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._break = _break;
        ((Ast) _break).setParent(this);
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
        list.add(_break);
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
        if (! (o instanceof BreakStatement)) return false;
        BreakStatement other = (BreakStatement) o;
        if (! _break.equals(other._break)) return false;
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
        hash = hash * 31 + (_break.hashCode());
        hash = hash * 31 + (_IDENTIFIERopt == null ? 0 : _IDENTIFIERopt.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}



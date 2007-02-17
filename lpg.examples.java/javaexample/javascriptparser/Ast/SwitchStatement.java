package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 272:  SwitchStatement ::= SWITCH ParenListExpression { CaseElements }
 *</b>
 */
public class SwitchStatement extends Ast implements ISwitchStatement
{
    private AstToken _SWITCH;
    private IParenListExpression _ParenListExpression;
    private AstToken _LBRACE;
    private ICaseElements _CaseElements;
    private AstToken _RBRACE;

    public AstToken getSWITCH() { return _SWITCH; }
    public IParenListExpression getParenListExpression() { return _ParenListExpression; }
    public AstToken getLBRACE() { return _LBRACE; }
    /**
     * The value returned by <b>getCaseElements</b> may be <b>null</b>
     */
    public ICaseElements getCaseElements() { return _CaseElements; }
    public AstToken getRBRACE() { return _RBRACE; }

    public SwitchStatement(IToken leftIToken, IToken rightIToken,
                           AstToken _SWITCH,
                           IParenListExpression _ParenListExpression,
                           AstToken _LBRACE,
                           ICaseElements _CaseElements,
                           AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._SWITCH = _SWITCH;
        this._ParenListExpression = _ParenListExpression;
        this._LBRACE = _LBRACE;
        this._CaseElements = _CaseElements;
        this._RBRACE = _RBRACE;
        initialize();
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
        if (! (o instanceof SwitchStatement)) return false;
        SwitchStatement other = (SwitchStatement) o;
        if (! _SWITCH.equals(other._SWITCH)) return false;
        if (! _ParenListExpression.equals(other._ParenListExpression)) return false;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (_CaseElements == null)
            if (other._CaseElements != null) return false;
            else; // continue
        else if (! _CaseElements.equals(other._CaseElements)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SWITCH.hashCode());
        hash = hash * 31 + (_ParenListExpression.hashCode());
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_CaseElements == null ? 0 : _CaseElements.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
        return hash;
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
            _SWITCH.accept(v);
            _ParenListExpression.accept(v);
            _LBRACE.accept(v);
            if (_CaseElements != null) _CaseElements.accept(v);
            _RBRACE.accept(v);
        }
        v.endVisit(this);
    }
}



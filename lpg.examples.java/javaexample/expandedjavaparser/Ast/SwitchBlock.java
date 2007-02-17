//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import expandedjavaparser.*;
import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 169:  SwitchBlock ::= { SwitchLabelsopt }
 *<li>Rule 170:  SwitchBlock ::= { SwitchBlockStatements SwitchLabelsopt }
 *</b>
 */
public class SwitchBlock extends Ast implements ISwitchBlock
{
    private JavaParser environment;
    public JavaParser getEnvironment() { return environment; }

    private AstToken _LBRACE;
    private SwitchLabelList _SwitchLabelsopt;
    private AstToken _RBRACE;
    private SwitchBlockStatementList _SwitchBlockStatements;

    public AstToken getLBRACE() { return _LBRACE; }
    public SwitchLabelList getSwitchLabelsopt() { return _SwitchLabelsopt; }
    public AstToken getRBRACE() { return _RBRACE; }
    /**
     * The value returned by <b>getSwitchBlockStatements</b> may be <b>null</b>
     */
    public SwitchBlockStatementList getSwitchBlockStatements() { return _SwitchBlockStatements; }

    public SwitchBlock(JavaParser environment, IToken leftIToken, IToken rightIToken,
                       AstToken _LBRACE,
                       SwitchLabelList _SwitchLabelsopt,
                       AstToken _RBRACE,
                       SwitchBlockStatementList _SwitchBlockStatements)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
        this._LBRACE = _LBRACE;
        ((Ast) _LBRACE).setParent(this);
        this._SwitchLabelsopt = _SwitchLabelsopt;
        ((Ast) _SwitchLabelsopt).setParent(this);
        this._RBRACE = _RBRACE;
        ((Ast) _RBRACE).setParent(this);
        this._SwitchBlockStatements = _SwitchBlockStatements;
        if (_SwitchBlockStatements != null) ((Ast) _SwitchBlockStatements).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LBRACE);
        list.add(_SwitchLabelsopt);
        list.add(_RBRACE);
        list.add(_SwitchBlockStatements);
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
        if (! (o instanceof SwitchBlock)) return false;
        SwitchBlock other = (SwitchBlock) o;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (! _SwitchLabelsopt.equals(other._SwitchLabelsopt)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        if (_SwitchBlockStatements == null)
            if (other._SwitchBlockStatements != null) return false;
            else; // continue
        else if (! _SwitchBlockStatements.equals(other._SwitchBlockStatements)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_SwitchLabelsopt.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
        hash = hash * 31 + (_SwitchBlockStatements == null ? 0 : _SwitchBlockStatements.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }

    public void initialize()
    {
        if (_SwitchBlockStatements == null)
        {
            IToken left = environment.getLeftIToken(),
                   right = environment.getPrevious(left);
            _SwitchBlockStatements = new SwitchBlockStatementList(left, right, true);
        }
    }
}



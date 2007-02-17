//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 174:  SwitchLabels ::= SwitchLabel
 *<li>Rule 175:  SwitchLabels ::= SwitchLabels SwitchLabel
 *<li>Rule 350:  SwitchLabelsopt ::= $Empty
 *<li>Rule 351:  SwitchLabelsopt ::= SwitchLabels
 *</b>
 */
public class SwitchLabelList extends AstList implements ISwitchLabels, ISwitchLabelsopt
{
    public ISwitchLabel getSwitchLabelAt(int i) { return (ISwitchLabel) getElementAt(i); }

    public SwitchLabelList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public SwitchLabelList(ISwitchLabel _SwitchLabel, boolean leftRecursive)
    {
        super((Ast) _SwitchLabel, leftRecursive);
        ((Ast) _SwitchLabel).setParent(this);
        initialize();
    }

    public void add(ISwitchLabel _SwitchLabel)
    {
        super.add((Ast) _SwitchLabel);
        ((Ast) _SwitchLabel).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getSwitchLabelAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getSwitchLabelAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getSwitchLabelAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getSwitchLabelAt(i).accept(v, o));
        return result;
    }
}



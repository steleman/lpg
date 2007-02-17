package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 442:  PackageName ::= PackageIdentifiers
 *</em>
 *<p>
 *<b>
 *<li>Rule 441:  PackageName ::= String
 *</b>
 */
public class PackageName extends AstToken implements IPackageName
{
    public IToken getString() { return leftIToken; }

    public PackageName(IToken token) { super(token); initialize(); }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        v.visit(this);
        v.endVisit(this);
    }
}



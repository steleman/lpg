package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 430:  ClassDefinition ::= CLASS Identifier Inheritance Block
 *</b>
 */
public class ClassDefinition extends Ast implements IClassDefinition
{
    private AstToken _CLASS;
    private IIdentifier _Identifier;
    private Inheritance _Inheritance;
    private Block _Block;

    public AstToken getCLASS() { return _CLASS; }
    public IIdentifier getIdentifier() { return _Identifier; }
    /**
     * The value returned by <b>getInheritance</b> may be <b>null</b>
     */
    public Inheritance getInheritance() { return _Inheritance; }
    public Block getBlock() { return _Block; }

    public ClassDefinition(IToken leftIToken, IToken rightIToken,
                           AstToken _CLASS,
                           IIdentifier _Identifier,
                           Inheritance _Inheritance,
                           Block _Block)
    {
        super(leftIToken, rightIToken);

        this._CLASS = _CLASS;
        this._Identifier = _Identifier;
        this._Inheritance = _Inheritance;
        this._Block = _Block;
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
        if (! (o instanceof ClassDefinition)) return false;
        ClassDefinition other = (ClassDefinition) o;
        if (! _CLASS.equals(other._CLASS)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (_Inheritance == null)
            if (other._Inheritance != null) return false;
            else; // continue
        else if (! _Inheritance.equals(other._Inheritance)) return false;
        if (! _Block.equals(other._Block)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_CLASS.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_Inheritance == null ? 0 : _Inheritance.hashCode());
        hash = hash * 31 + (_Block.hashCode());
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
            _CLASS.accept(v);
            _Identifier.accept(v);
            if (_Inheritance != null) _Inheritance.accept(v);
            _Block.accept(v);
        }
        v.endVisit(this);
    }
}



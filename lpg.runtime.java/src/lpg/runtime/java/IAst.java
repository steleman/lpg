package lpg.runtime.java;

public interface IAst
{
    public IAst getNextAst();
    public IAst getParent();
    public IToken getLeftIToken();
    public IToken getRightIToken();
    public IToken[] getPrecedingAdjuncts();
    public IToken[] getFollowingAdjuncts();
    public java.util.ArrayList getChildren();
    public java.util.ArrayList getAllChildren();
}



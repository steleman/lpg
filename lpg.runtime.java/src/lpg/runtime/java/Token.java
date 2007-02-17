package lpg.runtime.java;

public class Token extends AbstractToken
{
    public Token() {}
    public Token(int startOffset, int endOffset, int kind)
    {
        super(null, startOffset, endOffset, kind);
    }
    public Token(IPrsStream prsStream, int startOffset, int endOffset, int kind)
    {
        super(prsStream, startOffset, endOffset, kind);
    }

    //
    // Return an iterator for the adjuncts that follow token i.
    //
    public IToken[] getFollowingAdjuncts()
    {
        return getPrsStream().getFollowingAdjuncts(getTokenIndex());
    }

    public IToken[] getPrecedingAdjuncts()
    {
        return getPrsStream().getPrecedingAdjuncts(getTokenIndex());
    }

}

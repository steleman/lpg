package lpg.runtime.java;

public abstract class AbstractToken implements IToken
{
    private int kind = 0,
                startOffset = 0,
                endOffset = 0,
                tokenIndex = 0,
                adjunctIndex;
    private IPrsStream prsStream;

    public AbstractToken() {}
    public AbstractToken(IPrsStream prsStream, int startOffset, int endOffset, int kind)
    {
        this.prsStream = prsStream;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.kind = kind;
    }

    public int getKind() { return kind; }
    public void setKind(int kind) { this.kind = kind; }

    public int getStartOffset() { return startOffset; }
    public void setStartOffset(int startOffset)
    {
        this.startOffset = startOffset;
    }

    public int getEndOffset() { return endOffset; }
    public void setEndOffset(int endOffset)
    {
        this.endOffset = endOffset;
    }

    public int getTokenIndex() { return tokenIndex; }
    public void setTokenIndex(int tokenIndex) { this.tokenIndex = tokenIndex; }

    public void setAdjunctIndex(int adjunctIndex) { this.adjunctIndex = adjunctIndex; }
    public int getAdjunctIndex() { return adjunctIndex; }
    
    public IPrsStream getPrsStream() { return prsStream; }
    public int getLine() { return (prsStream == null ? 0 : prsStream.getLexStream().getLineNumberOfCharAt(startOffset)); }
    public int getColumn() { return (prsStream == null ? 0 : prsStream.getLexStream().getColumnOfCharAt(startOffset)); }
    public int getEndLine() { return (prsStream == null ? 0 : prsStream.getLexStream().getLineNumberOfCharAt(endOffset)); }
    public int getEndColumn() { return (prsStream == null ? 0 : prsStream.getLexStream().getColumnOfCharAt(endOffset)); }

    /**
     * @deprecated replaced by {@link #toString()}
     */
    public String getValue(char[] inputChars)
    {
        if (prsStream != null)
            return toString();
        if (prsStream.getLexStream() instanceof LexStream)
        {
            LexStream lex_stream = (LexStream) prsStream.getLexStream();
            if (inputChars != lex_stream.getInputChars())
                throw new MismatchedInputCharsException();
            return toString();
        }
        throw new UnknownStreamType("Unknown stream type " +
                                    prsStream.getLexStream().getClass().toString());
    }

    public String toString()
    {
        return (prsStream == null
                           ? "<toString>"
                           : prsStream.toString(this, this));
    }
}
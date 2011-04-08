package instal;

import com.ibm.db2.tools.mtk.translation.source.common.*;
import com.ibm.db2.tools.mtk.translation.util.*;

import java.util.*;
import java.io.*;
import com.ibm.lpg.*;

class junk {}

interface goop extends muck {}

;

//
// LexStream contains an array of characters as the input stream to be parsed.
// There are methods to retrieve and classify characters.
// The lexparser "token" is implemented simply as the index of the next character in the array.
//
public class LexStream extends com.ibm.lpg.LexStream implements SybaseLexersym
{

	private static final int LEX_ERROR_CODE = MessageConstants.LPG_LEX_ERROR;
	private static final int INVALID_TOKEN_CODE = MessageConstants.LPG_INVALID_TOKEN_CODE;
	
	FileInfo fileInfo;
    TransEnv transEnv;
    PrintWriter rptFile;
    DebugOptions debugOptions;
    GlobalOptions globalOptions;

    char[] inputChars;
    String fileName;
    int len = 0;
    int prevOffset = -1;
    boolean eofSeen = false;

    public LexStream(InputFileInfo fileInfo, TransEnv transEnv)
    {
    	super(fileInfo.getInputBuffer(), fileInfo.getFilename());
    	this.transEnv = transEnv;
    	this.fileInfo = fileInfo;
    	inputChars = fileInfo.getInputBuffer();
    	len = inputChars.length;
    	fileName = fileInfo.getFilename();
    	this.rptFile = transEnv.getRptFile();
    	this.debugOptions = transEnv.getDebugOpts();
    	this.globalOptions = transEnv.getGlobalOpts();
    }

    public final static int tokenKind[] =
    {
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_NL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_CtlCharNotNL,
      Char_Blank,
      Char_Exclaimation,
      Char_DoubleQuote,
      Char_Sharp,
      Char_DollarSign,
      Char_Percent,
      Char_Ampersand,
      Char_SingleQuote,
      Char_LeftParen,
      Char_RightParen,
      Char_Star,
      Char_Plus,
      Char_Comma,
      Char_Minus,
      Char_Dot,
      Char_Slash,
      Char_0,
      Char_1,
      Char_2,
      Char_3,
      Char_4,
      Char_5,
      Char_6,
      Char_7,
      Char_8,
      Char_9,
      Char_Colon,
      Char_SemiColon,
      Char_LessThan,
      Char_Equal,
      Char_GreaterThan,
      Char_QuestionMark,
      Char_AtSign,
      Char_a,
      Char_b,
      Char_c,
      Char_d,
      Char_e,
      Char_f,
      Char_g,
      Char_h,
      Char_i,
      Char_j,
      Char_k,
      Char_l,
      Char_m,
      Char_n,
      Char_o,
      Char_p,
      Char_q,
      Char_r,
      Char_s,
      Char_t,
      Char_u,
      Char_v,
      Char_w,
      Char_x,
      Char_y,
      Char_z,
      Char_LeftBracket,
      Char_BackSlash,
      Char_RightBracket,
      Char_Caret,
      Char__,
      Char_BackQuote,
      Char_a,
      Char_b,
      Char_c,
      Char_d,
      Char_e,
      Char_f,
      Char_g,
      Char_h,
      Char_i,
      Char_j,
      Char_k,
      Char_l,
      Char_m,
      Char_n,
      Char_o,
      Char_p,
      Char_q,
      Char_r,
      Char_s,
      Char_t,
      Char_u,
      Char_v,
      Char_w,
      Char_x,
      Char_y,
      Char_z,
      Char_LeftBrace,
      Char_VerticalBar,
      Char_RightBrace,
      Char_Tilde,
      Char_AfterASCII
    };

    public int getToken()
    {
    	int index = getToken(len);
    	if (index >= len) return len;

    	char c = inputChars[index];
        if (c == 10) 
        { 
        	fileInfo.updateLinestart(index - prevOffset);
        	prevOffset = index;
        }	// a line feed '\n'

        return index;
    }

    public int getKind( int i )  // Classify character at ith location
    {
        if (i >= len) return Char_EOF;
        char c = inputChars[i];

        if (c < 128)	// ASCII Character
        {
    	    	return tokenKind[c];
        }
        else if (c == '\uffff')
        {
        	return Char_EOF;
        }
        else
        {
        	return Char_AfterASCII;
        }
    }

	public FileInfo getFileInfo() { return fileInfo; }

	public TransEnv getTransEnv() { return transEnv; }

	public PrintWriter getRptFile() { return rptFile; }

	public DebugOptions getDebugOptions() { return debugOptions; }

	public GlobalOptions getGlobalOptions() { return globalOptions; }

    public void reportError(int left_loc, int right_loc)
    {
    	String tokenText = "\"" + getCharValue(left_loc) + "\" ";
    	SpanInfo span = new SpanInfo(fileInfo, left_loc, right_loc + 1);
    	MessageDescriptor msg = new MessageDescriptor(LEX_ERROR_CODE, span, tokenText);
    	msg.outputErrorMessage(rptFile, debugOptions.getErrorsOut());
    }

}

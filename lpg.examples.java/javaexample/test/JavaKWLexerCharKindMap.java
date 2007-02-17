package javaparser;

public class JavaKWLexerCharKindMap implements JavaKWLexersym
{
    public final static int tokenKind[] =
    {
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
      0,
      0,
      0,
      0,
      0
    };

    public static final int EOF = Char_EOF;

    public static int getKind(char c) {
        if (96 < c && c < 128)	// Lower case letter
        {
    	    	return tokenKind[c - 97];
        }
        else if (c == '\uffff')
        {
        	return Char_EOF;
	}
        else
        {
        	return 0;
        }
    }
}

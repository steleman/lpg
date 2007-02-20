package genericjavaparser;

import lpg.runtime.java.*;

public class JavaKWLexer extends JavaKWLexerprs implements JavaParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[53 + 1];

    public int[] getKeywordKinds() { return keywordKind; }

    public int lexer(int curtok, int lasttok)
    {
        int current_kind = getKind(inputChars[curtok]),
            act;

        for (act = tAction(START_STATE, current_kind);
             act > NUM_RULES && act < ACCEPT_ACTION;
             act = tAction(act, current_kind))
        {
            curtok++;
            current_kind = (curtok > lasttok
                                   ? Char_EOF
                                   : getKind(inputChars[curtok]));
        }

        if (act > ERROR_ACTION)
        {
            curtok++;
            act -= ERROR_ACTION;
        }

        return keywordKind[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
    }

    public void setInputChars(char[] inputChars) { this.inputChars = inputChars; }


    //
    // Each upper case letter is mapped into is corresponding
    // lower case counterpart. For example, if an 'A' appears
    // in the input, it is mapped into Char_a just like 'a'.
    //
    final static int tokenKind[] = new int[128];
    static
    {
        tokenKind['$'] = Char_DollarSign;
        tokenKind['_'] = Char__;

        tokenKind['a'] = Char_a;
        tokenKind['b'] = Char_b;
        tokenKind['c'] = Char_c;
        tokenKind['d'] = Char_d;
        tokenKind['e'] = Char_e;
        tokenKind['f'] = Char_f;
        tokenKind['g'] = Char_g;
        tokenKind['h'] = Char_h;
        tokenKind['i'] = Char_i;
        tokenKind['j'] = Char_j;
        tokenKind['k'] = Char_k;
        tokenKind['l'] = Char_l;
        tokenKind['m'] = Char_m;
        tokenKind['n'] = Char_n;
        tokenKind['o'] = Char_o;
        tokenKind['p'] = Char_p;
        tokenKind['q'] = Char_q;
        tokenKind['r'] = Char_r;
        tokenKind['s'] = Char_s;
        tokenKind['t'] = Char_t;
        tokenKind['u'] = Char_u;
        tokenKind['v'] = Char_v;
        tokenKind['w'] = Char_w;
        tokenKind['x'] = Char_x;
        tokenKind['y'] = Char_y;
        tokenKind['z'] = Char_z;
    };

    final int getKind(int c)
    {
        return ((c & 0xFFFFFF80) == 0 /* 0 <= c < 128? */ ? tokenKind[c] : 0);
    }


    public JavaKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= a b s t r a c t
        //
        keywordKind[1] = (TK_abstract);
      
    
        //
        // Rule 2:  KeyWord ::= a s s e r t
        //
        keywordKind[2] = (TK_assert);
      
    
        //
        // Rule 3:  KeyWord ::= b o o l e a n
        //
        keywordKind[3] = (TK_boolean);
      
    
        //
        // Rule 4:  KeyWord ::= b r e a k
        //
        keywordKind[4] = (TK_break);
      
    
        //
        // Rule 5:  KeyWord ::= b y t e
        //
        keywordKind[5] = (TK_byte);
      
    
        //
        // Rule 6:  KeyWord ::= c a s e
        //
        keywordKind[6] = (TK_case);
      
    
        //
        // Rule 7:  KeyWord ::= c a t c h
        //
        keywordKind[7] = (TK_catch);
      
    
        //
        // Rule 8:  KeyWord ::= c h a r
        //
        keywordKind[8] = (TK_char);
      
    
        //
        // Rule 9:  KeyWord ::= c l a s s
        //
        keywordKind[9] = (TK_class);
      
    
        //
        // Rule 10:  KeyWord ::= c o n s t
        //
        keywordKind[10] = (TK_const);
      
    
        //
        // Rule 11:  KeyWord ::= c o n t i n u e
        //
        keywordKind[11] = (TK_continue);
      
    
        //
        // Rule 12:  KeyWord ::= d e f a u l t
        //
        keywordKind[12] = (TK_default);
      
    
        //
        // Rule 13:  KeyWord ::= d o
        //
        keywordKind[13] = (TK_do);
      
    
        //
        // Rule 14:  KeyWord ::= d o u b l e
        //
        keywordKind[14] = (TK_double);
      
    
        //
        // Rule 15:  KeyWord ::= e l s e
        //
        keywordKind[15] = (TK_else);
      
    
        //
        // Rule 16:  KeyWord ::= e n u m
        //
        keywordKind[16] = (TK_enum);
      
    
        //
        // Rule 17:  KeyWord ::= e x t e n d s
        //
        keywordKind[17] = (TK_extends);
      
    
        //
        // Rule 18:  KeyWord ::= f a l s e
        //
        keywordKind[18] = (TK_false);
      
    
        //
        // Rule 19:  KeyWord ::= f i n a l
        //
        keywordKind[19] = (TK_final);
      
    
        //
        // Rule 20:  KeyWord ::= f i n a l l y
        //
        keywordKind[20] = (TK_finally);
      
    
        //
        // Rule 21:  KeyWord ::= f l o a t
        //
        keywordKind[21] = (TK_float);
      
    
        //
        // Rule 22:  KeyWord ::= f o r
        //
        keywordKind[22] = (TK_for);
      
    
        //
        // Rule 23:  KeyWord ::= g o t o
        //
        keywordKind[23] = (TK_goto);
      
    
        //
        // Rule 24:  KeyWord ::= i f
        //
        keywordKind[24] = (TK_if);
      
    
        //
        // Rule 25:  KeyWord ::= i m p l e m e n t s
        //
        keywordKind[25] = (TK_implements);
      
    
        //
        // Rule 26:  KeyWord ::= i m p o r t
        //
        keywordKind[26] = (TK_import);
      
    
        //
        // Rule 27:  KeyWord ::= i n s t a n c e o f
        //
        keywordKind[27] = (TK_instanceof);
      
    
        //
        // Rule 28:  KeyWord ::= i n t
        //
        keywordKind[28] = (TK_int);
      
    
        //
        // Rule 29:  KeyWord ::= i n t e r f a c e
        //
        keywordKind[29] = (TK_interface);
      
    
        //
        // Rule 30:  KeyWord ::= l o n g
        //
        keywordKind[30] = (TK_long);
      
    
        //
        // Rule 31:  KeyWord ::= n a t i v e
        //
        keywordKind[31] = (TK_native);
      
    
        //
        // Rule 32:  KeyWord ::= n e w
        //
        keywordKind[32] = (TK_new);
      
    
        //
        // Rule 33:  KeyWord ::= n u l l
        //
        keywordKind[33] = (TK_null);
      
    
        //
        // Rule 34:  KeyWord ::= p a c k a g e
        //
        keywordKind[34] = (TK_package);
      
    
        //
        // Rule 35:  KeyWord ::= p r i v a t e
        //
        keywordKind[35] = (TK_private);
      
    
        //
        // Rule 36:  KeyWord ::= p r o t e c t e d
        //
        keywordKind[36] = (TK_protected);
      
    
        //
        // Rule 37:  KeyWord ::= p u b l i c
        //
        keywordKind[37] = (TK_public);
      
    
        //
        // Rule 38:  KeyWord ::= r e t u r n
        //
        keywordKind[38] = (TK_return);
      
    
        //
        // Rule 39:  KeyWord ::= s h o r t
        //
        keywordKind[39] = (TK_short);
      
    
        //
        // Rule 40:  KeyWord ::= s t a t i c
        //
        keywordKind[40] = (TK_static);
      
    
        //
        // Rule 41:  KeyWord ::= s t r i c t f p
        //
        keywordKind[41] = (TK_strictfp);
      
    
        //
        // Rule 42:  KeyWord ::= s u p e r
        //
        keywordKind[42] = (TK_super);
      
    
        //
        // Rule 43:  KeyWord ::= s w i t c h
        //
        keywordKind[43] = (TK_switch);
      
    
        //
        // Rule 44:  KeyWord ::= s y n c h r o n i z e d
        //
        keywordKind[44] = (TK_synchronized);
      
    
        //
        // Rule 45:  KeyWord ::= t h i s
        //
        keywordKind[45] = (TK_this);
      
    
        //
        // Rule 46:  KeyWord ::= t h r o w
        //
        keywordKind[46] = (TK_throw);
      
    
        //
        // Rule 47:  KeyWord ::= t h r o w s
        //
        keywordKind[47] = (TK_throws);
      
    
        //
        // Rule 48:  KeyWord ::= t r a n s i e n t
        //
        keywordKind[48] = (TK_transient);
      
    
        //
        // Rule 49:  KeyWord ::= t r u e
        //
        keywordKind[49] = (TK_true);
      
    
        //
        // Rule 50:  KeyWord ::= t r y
        //
        keywordKind[50] = (TK_try);
      
    
        //
        // Rule 51:  KeyWord ::= v o i d
        //
        keywordKind[51] = (TK_void);
      
    
        //
        // Rule 52:  KeyWord ::= v o l a t i l e
        //
        keywordKind[52] = (TK_volatile);
      
    
        //
        // Rule 53:  KeyWord ::= w h i l e
        //
        keywordKind[53] = (TK_while);
      
    

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

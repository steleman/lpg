package expandedjavaparser;

import lpg.javaruntime.*;

public class JavaKWLexer extends JavaKWLexerprs implements JavaParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[51 + 1];

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
        // Rule 2:  KeyWord ::= b o o l e a n
        //
        keywordKind[2] = (TK_boolean);
      
    
        //
        // Rule 3:  KeyWord ::= b r e a k
        //
        keywordKind[3] = (TK_break);
      
    
        //
        // Rule 4:  KeyWord ::= b y t e
        //
        keywordKind[4] = (TK_byte);
      
    
        //
        // Rule 5:  KeyWord ::= c a s e
        //
        keywordKind[5] = (TK_case);
      
    
        //
        // Rule 6:  KeyWord ::= c a t c h
        //
        keywordKind[6] = (TK_catch);
      
    
        //
        // Rule 7:  KeyWord ::= c h a r
        //
        keywordKind[7] = (TK_char);
      
    
        //
        // Rule 8:  KeyWord ::= c l a s s
        //
        keywordKind[8] = (TK_class);
      
    
        //
        // Rule 9:  KeyWord ::= c o n s t
        //
        keywordKind[9] = (TK_const);
      
    
        //
        // Rule 10:  KeyWord ::= c o n t i n u e
        //
        keywordKind[10] = (TK_continue);
      
    
        //
        // Rule 11:  KeyWord ::= d e f a u l t
        //
        keywordKind[11] = (TK_default);
      
    
        //
        // Rule 12:  KeyWord ::= d o
        //
        keywordKind[12] = (TK_do);
      
    
        //
        // Rule 13:  KeyWord ::= d o u b l e
        //
        keywordKind[13] = (TK_double);
      
    
        //
        // Rule 14:  KeyWord ::= e l s e
        //
        keywordKind[14] = (TK_else);
      
    
        //
        // Rule 15:  KeyWord ::= e x t e n d s
        //
        keywordKind[15] = (TK_extends);
      
    
        //
        // Rule 16:  KeyWord ::= f a l s e
        //
        keywordKind[16] = (TK_false);
      
    
        //
        // Rule 17:  KeyWord ::= f i n a l
        //
        keywordKind[17] = (TK_final);
      
    
        //
        // Rule 18:  KeyWord ::= f i n a l l y
        //
        keywordKind[18] = (TK_finally);
      
    
        //
        // Rule 19:  KeyWord ::= f l o a t
        //
        keywordKind[19] = (TK_float);
      
    
        //
        // Rule 20:  KeyWord ::= f o r
        //
        keywordKind[20] = (TK_for);
      
    
        //
        // Rule 21:  KeyWord ::= g o t o
        //
        keywordKind[21] = (TK_goto);
      
    
        //
        // Rule 22:  KeyWord ::= i f
        //
        keywordKind[22] = (TK_if);
      
    
        //
        // Rule 23:  KeyWord ::= i m p l e m e n t s
        //
        keywordKind[23] = (TK_implements);
      
    
        //
        // Rule 24:  KeyWord ::= i m p o r t
        //
        keywordKind[24] = (TK_import);
      
    
        //
        // Rule 25:  KeyWord ::= i n s t a n c e o f
        //
        keywordKind[25] = (TK_instanceof);
      
    
        //
        // Rule 26:  KeyWord ::= i n t
        //
        keywordKind[26] = (TK_int);
      
    
        //
        // Rule 27:  KeyWord ::= i n t e r f a c e
        //
        keywordKind[27] = (TK_interface);
      
    
        //
        // Rule 28:  KeyWord ::= l o n g
        //
        keywordKind[28] = (TK_long);
      
    
        //
        // Rule 29:  KeyWord ::= n a t i v e
        //
        keywordKind[29] = (TK_native);
      
    
        //
        // Rule 30:  KeyWord ::= n e w
        //
        keywordKind[30] = (TK_new);
      
    
        //
        // Rule 31:  KeyWord ::= n u l l
        //
        keywordKind[31] = (TK_null);
      
    
        //
        // Rule 32:  KeyWord ::= p a c k a g e
        //
        keywordKind[32] = (TK_package);
      
    
        //
        // Rule 33:  KeyWord ::= p r i v a t e
        //
        keywordKind[33] = (TK_private);
      
    
        //
        // Rule 34:  KeyWord ::= p r o t e c t e d
        //
        keywordKind[34] = (TK_protected);
      
    
        //
        // Rule 35:  KeyWord ::= p u b l i c
        //
        keywordKind[35] = (TK_public);
      
    
        //
        // Rule 36:  KeyWord ::= r e t u r n
        //
        keywordKind[36] = (TK_return);
      
    
        //
        // Rule 37:  KeyWord ::= s h o r t
        //
        keywordKind[37] = (TK_short);
      
    
        //
        // Rule 38:  KeyWord ::= s t a t i c
        //
        keywordKind[38] = (TK_static);
      
    
        //
        // Rule 39:  KeyWord ::= s t r i c t f p
        //
        keywordKind[39] = (TK_strictfp);
      
    
        //
        // Rule 40:  KeyWord ::= s u p e r
        //
        keywordKind[40] = (TK_super);
      
    
        //
        // Rule 41:  KeyWord ::= s w i t c h
        //
        keywordKind[41] = (TK_switch);
      
    
        //
        // Rule 42:  KeyWord ::= s y n c h r o n i z e d
        //
        keywordKind[42] = (TK_synchronized);
      
    
        //
        // Rule 43:  KeyWord ::= t h i s
        //
        keywordKind[43] = (TK_this);
      
    
        //
        // Rule 44:  KeyWord ::= t h r o w
        //
        keywordKind[44] = (TK_throw);
      
    
        //
        // Rule 45:  KeyWord ::= t h r o w s
        //
        keywordKind[45] = (TK_throws);
      
    
        //
        // Rule 46:  KeyWord ::= t r a n s i e n t
        //
        keywordKind[46] = (TK_transient);
      
    
        //
        // Rule 47:  KeyWord ::= t r u e
        //
        keywordKind[47] = (TK_true);
      
    
        //
        // Rule 48:  KeyWord ::= t r y
        //
        keywordKind[48] = (TK_try);
      
    
        //
        // Rule 49:  KeyWord ::= v o i d
        //
        keywordKind[49] = (TK_void);
      
    
        //
        // Rule 50:  KeyWord ::= v o l a t i l e
        //
        keywordKind[50] = (TK_volatile);
      
    
        //
        // Rule 51:  KeyWord ::= w h i l e
        //
        keywordKind[51] = (TK_while);
      
    

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}


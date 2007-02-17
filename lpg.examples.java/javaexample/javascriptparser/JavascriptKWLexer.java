package javascriptparser;

import lpg.javaruntime.*;

public class JavascriptKWLexer extends JavascriptKWLexerprs implements JavascriptParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[60 + 1];

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


    public JavascriptKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= a s
        //
        keywordKind[1] = (TK_AS);
      
    
        //
        // Rule 2:  KeyWord ::= b r e a k
        //
        keywordKind[2] = (TK_BREAK);
      
    
        //
        // Rule 3:  KeyWord ::= c a s e
        //
       keywordKind[3] = (TK_CASE);
     
   
        //
        // Rule 4:  KeyWord ::= c a t c h
        //
       keywordKind[4] = (TK_CATCH);
     
   
        //
        // Rule 5:  KeyWord ::= c l a s s
        //
       keywordKind[5] = (TK_CLASS);
     
   
        //
        // Rule 6:  KeyWord ::= c o n s t
        //
       keywordKind[6] = (TK_CONST);
     
   
        //
        // Rule 7:  KeyWord ::= c o n t i n u e
        //
       keywordKind[7] = (TK_CONTINUE);
     
   
        //
        // Rule 8:  KeyWord ::= d e f a u l t
        //
       keywordKind[8] = (TK_DEFAULT);
     
   
        //
        // Rule 9:  KeyWord ::= d e l e t e
        //
       keywordKind[9] = (TK_DELETE);
     
   
        //
        // Rule 10:  KeyWord ::= d o
        //
       keywordKind[10] = (TK_DO);
     
   
        //
        // Rule 11:  KeyWord ::= e l s e
        //
       keywordKind[11] = (TK_ELSE);
     
   
        //
        // Rule 12:  KeyWord ::= e x p o r t
        //
       keywordKind[12] = (TK_EXPORT);
     
   
        //
        // Rule 13:  KeyWord ::= e x t e n d s
        //
       keywordKind[13] = (TK_EXTENDS);
     
   
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
       keywordKind[14] = (TK_FALSE);
     
   
        //
        // Rule 15:  KeyWord ::= f i n a l
        //
       keywordKind[15] = (TK_FINAL);
     
   
        //
        // Rule 16:  KeyWord ::= f i n a l l y
        //
       keywordKind[16] = (TK_FINALLY);
     
   
        //
        // Rule 17:  KeyWord ::= f o r
        //
       keywordKind[17] = (TK_FOR);
     
   
        //
        // Rule 18:  KeyWord ::= f u n c t i o n
        //
       keywordKind[18] = (TK_FUNCTION);
     
   
        //
        // Rule 19:  KeyWord ::= i f
        //
       keywordKind[19] = (TK_IF);
     
   
        //
        // Rule 20:  KeyWord ::= i m p o r t
        //
       keywordKind[20] = (TK_IMPORT);
     
   
        //
        // Rule 21:  KeyWord ::= i n
        //
       keywordKind[21] = (TK_IN);
     
   
        //
        // Rule 22:  KeyWord ::= i n s t a n c e o f
        //
       keywordKind[22] = (TK_INSTANCEOF);
     
   
        //
        // Rule 23:  KeyWord ::= i s
        //
       keywordKind[23] = (TK_IS);
     
   
        //
        // Rule 24:  KeyWord ::= n a m e s p a c e
        //
       keywordKind[24] = (TK_NAMESPACE);
     
   
        //
        // Rule 25:  KeyWord ::= n e w
        //
       keywordKind[25] = (TK_NEW);
     
   
        //
        // Rule 26:  KeyWord ::= n u l l
        //
       keywordKind[26] = (TK_NULL);
     
   
        //
        // Rule 27:  KeyWord ::= p a c k a g e
        //
       keywordKind[27] = (TK_PACKAGE);
     
   
        //
        // Rule 28:  KeyWord ::= p r i v a t e
        //
       keywordKind[28] = (TK_PRIVATE);
     
   
        //
        // Rule 29:  KeyWord ::= p u b l i c
        //
       keywordKind[29] = (TK_PUBLIC    );
     
   
        //
        // Rule 30:  KeyWord ::= r e t u r n
        //
       keywordKind[30] = (TK_RETURN);
     
   
        //
        // Rule 31:  KeyWord ::= s t a t i c
        //
       keywordKind[31] = (TK_STATIC);
     
   
        //
        // Rule 32:  KeyWord ::= s u p e r
        //
       keywordKind[32] = (TK_SUPER    );
     
   
        //
        // Rule 33:  KeyWord ::= s w i t c h
        //
       keywordKind[33] = (TK_SWITCH);
     
   
        //
        // Rule 34:  KeyWord ::= t h i s
        //
       keywordKind[34] = (TK_THIS);
     
   
        //
        // Rule 35:  KeyWord ::= t h r o w
        //
       keywordKind[35] = (TK_THROW);
     
   
        //
        // Rule 36:  KeyWord ::= t r u e
        //
       keywordKind[36] = (TK_TRUE    );
     
   
        //
        // Rule 37:  KeyWord ::= t r y
        //
       keywordKind[37] = (TK_TRY);
     
   
        //
        // Rule 38:  KeyWord ::= t y p e o f
        //
       keywordKind[38] = (TK_TYPEOF);
     
   
        //
        // Rule 39:  KeyWord ::= u s e
        //
       keywordKind[39] = (TK_USE);
     
   
        //
        // Rule 40:  KeyWord ::= v a r
        //
       keywordKind[40] = (TK_VAR);
     
   
        //
        // Rule 41:  KeyWord ::= v o i d
        //
       keywordKind[41] = (TK_VOID);
     
   
        //
        // Rule 42:  KeyWord ::= w h i l e
        //
       keywordKind[42] = (TK_WHILE);
     
   
        //
        // Rule 43:  KeyWord ::= w i t h
        //
       keywordKind[43] = (TK_WITH );
     
   
        //
        // Rule 44:  KeyWord ::= a b s t r a c t
        //
       keywordKind[44] = (TK_ABSTRACT);
     
   
        //
        // Rule 45:  KeyWord ::= d e b u g g e r
        //
       keywordKind[45] = (TK_DEBUGGER);
     
   
        //
        // Rule 46:  KeyWord ::= e n u m
        //
       keywordKind[46] = (TK_ENUM);
     
   
        //
        // Rule 47:  KeyWord ::= g o t o
        //
       keywordKind[47] = (TK_GOTO);
     
   
        //
        // Rule 48:  KeyWord ::= i m p l e m e n t s
        //
       keywordKind[48] = (TK_IMPLEMENTS);
     
   
        //
        // Rule 49:  KeyWord ::= i n t e r f a c e
        //
       keywordKind[49] = (TK_INTERFACE);
     
   
        //
        // Rule 50:  KeyWord ::= l o n g
        //
       keywordKind[50] = (TK_LONG);
     
   
        //
        // Rule 51:  KeyWord ::= n a t i v e
        //
       keywordKind[51] = (TK_NATIVE);
     
   
        //
        // Rule 52:  KeyWord ::= p r o t e c t e d
        //
       keywordKind[52] = (TK_PROTECTED);
     
   
        //
        // Rule 53:  KeyWord ::= s y n c h r o n i z e d
        //
       keywordKind[53] = (TK_SYNCHRONIZED);
     
   
        //
        // Rule 54:  KeyWord ::= t h r o w s
        //
       keywordKind[54] = (TK_THROWS);
     
   
        //
        // Rule 55:  KeyWord ::= t r a n s i e n t
        //
       keywordKind[55] = (TK_TRANSIENT);
     
   
        //
        // Rule 56:  KeyWord ::= v o l a t i l e
        //
       keywordKind[56] = (TK_VOLATILE );
     
   
        //
        // Rule 57:  KeyWord ::= e x c l u d e
        //
       keywordKind[57] = (TK_EXCLUDE);
     
   
        //
        // Rule 58:  KeyWord ::= g e t
        //
       keywordKind[58] = (TK_GET);
     
   
        //
        // Rule 59:  KeyWord ::= i n c l u d e
        //
       keywordKind[59] = (TK_INCLUDE);
     
   
        //
        // Rule 60:  KeyWord ::= s e t
        //
       keywordKind[60] = (TK_SET);
     
   

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}


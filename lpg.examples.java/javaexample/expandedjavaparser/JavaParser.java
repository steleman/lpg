//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser;

import expandedjavaparser.Ast.*;
import lpg.javaruntime.*;

public class JavaParser extends PrsStream implements RuleAction
{
    private boolean unimplementedSymbolsWarning = false;
        
    private static ParseTable prs = new JavaParserprs();
    public ParseTable getParseTable() { return prs; }

    private DeterministicParser dtParser = null;
    public DeterministicParser getParser() { return dtParser; }

    private void setResult(Object object) { dtParser.setSym1(object); }
    public Object getRhsSym(int i) { return dtParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public IToken getRhsIToken(int i) { return super.getIToken(getRhsTokenIndex(i)); }

    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public IToken getRhsFirstIToken(int i) { return super.getIToken(getRhsFirstTokenIndex(i)); }

    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }
    public IToken getRhsLastIToken(int i) { return super.getIToken(getRhsLastTokenIndex(i)); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public IToken getLeftIToken()  { return super.getIToken(getLeftSpan()); }

    public int getRightSpan() { return dtParser.getLastToken(); }
    public IToken getRightIToken() { return super.getIToken(getRightSpan()); }

    public int getRhsErrorTokenIndex(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    public ErrorToken getRhsErrorIToken(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

    public JavaParser(ILexStream lexStream)
    {
        super(lexStream);

        try
        {
            super.remapTerminalSymbols(orderedTerminalSymbols(), JavaParserprs.EOFT_SYMBOL);
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e)
        {
            if (unimplementedSymbolsWarning) {
                java.util.ArrayList unimplemented_symbols = e.getSymbols();
                System.out.println("The Lexer will not scan the following token(s):");
                for (int i = 0; i < unimplemented_symbols.size(); i++)
                {
                    Integer id = (Integer) unimplemented_symbols.get(i);
                    System.out.println("    " + JavaParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();                        
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 JavaParsersym.orderedTerminalSymbols[JavaParserprs.EOFT_SYMBOL]));
        } 

        try
        {
            dtParser = new DeterministicParser(this, prs, this);
        }
        catch (NotDeterministicParseTableException e)
        {
            throw new Error(new NotDeterministicParseTableException
                                 ("Regenerate JavaParserprs.java with -NOBACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- JavaParsersym.java. Regenerate JavaParserprs.java"));
        }
    }

    public String[] orderedTerminalSymbols() { return JavaParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return JavaParsersym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return JavaParserprs.EOFT_SYMBOL; }
    public PrsStream getParseStream() { return (PrsStream) this; }

    public Ast parser()
    {
        return parser(null, 0);
    }
    
    public Ast parser(Monitor monitor)
    {
        return parser(monitor, 0);
    }
    
    public Ast parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }
    
    public Ast parser(Monitor monitor, int error_repair_count)
    {
        dtParser.setMonitor(monitor);
        
        try
        {
            return (Ast) dtParser.parse();
        }
        catch (BadParseException e)
        {
            reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }

    public class BadActionException extends Exception
    {
        private static final long serialVersionUID = 1L;
    }

    public final void ruleAction(int rule_number)
    {
        try
        {
            ruleAction[rule_number].action();
        }
        catch (Error e)
        {
            if (e.getCause() instanceof BadActionException)
                throw new Error("No action specified for rule " + rule_number);
        }
    }

    abstract class Action
    {
        public abstract void action();
    }

    final class NoAction extends Action
    {
        public void action() {}
    }

    final class BadAction extends Action
    {
        public void action()
        {
            throw new Error(new BadActionException());
        }
    }

    //
    // Action for a null rule
    //
    final class NullAction extends Action
    {
        public void action() { dtParser.setSym1(null); }
    }

public IToken getPrevious(IToken tok)
{
    return getIToken(getPrevious(tok.getTokenIndex()));
}

public IToken getDocComment(IToken token)
{
    int token_index = token.getTokenIndex();
    IToken[] adjuncts = getPrecedingAdjuncts(token_index);
    int i = adjuncts.length - 1;
    IToken comment = (i >= 0 && adjuncts[i].getKind() == JavaParsersym.TK_DocComment
                              ? adjuncts[i]
                              : null);
    return comment;
}



    //
    // Declare and initialize ruleAction array.
    //
    Action ruleAction[] = new Action[355 + 1];
    {
        ruleAction[0] = null;

        ruleAction[1] = new act1();
        ruleAction[2] = new act2();
        ruleAction[3] = new act3();
        ruleAction[4] = new act4();
        ruleAction[5] = new act5();
        ruleAction[6] = new act6();
        ruleAction[7] = new act7();
        ruleAction[8] = new act8();
        ruleAction[9] = new act9();
        ruleAction[10] = new act10();
        ruleAction[11] = new NoAction();
        ruleAction[12] = new NoAction();
        ruleAction[13] = new NoAction();
        ruleAction[14] = new act14();
        ruleAction[15] = new NoAction();
        ruleAction[16] = new NoAction();
        ruleAction[17] = new act17();
        ruleAction[18] = new act18();
        ruleAction[19] = new act19();
        ruleAction[20] = new act20();
        ruleAction[21] = new act21();
        ruleAction[22] = new act22();
        ruleAction[23] = new act23();
        ruleAction[24] = new NoAction();
        ruleAction[25] = new NoAction();
        ruleAction[26] = new NoAction();
        ruleAction[27] = new act27();
        ruleAction[28] = new act28();
        ruleAction[29] = new NoAction();
        ruleAction[30] = new NoAction();
        ruleAction[31] = new NoAction();
        ruleAction[32] = new NoAction();
        ruleAction[33] = new act33();
        ruleAction[34] = new act34();
        ruleAction[35] = new act35();
        ruleAction[36] = new act36();
        ruleAction[37] = new act37();
        ruleAction[38] = new act38();
        ruleAction[39] = new act39();
        ruleAction[40] = new act40();
        ruleAction[41] = new NoAction();
        ruleAction[42] = new NoAction();
        ruleAction[43] = new act43();
        ruleAction[44] = new act44();
        ruleAction[45] = new NoAction();
        ruleAction[46] = new NoAction();
        ruleAction[47] = new act47();
        ruleAction[48] = new act48();
        ruleAction[49] = new act49();
        ruleAction[50] = new act50();
        ruleAction[51] = new act51();
        ruleAction[52] = new act52();
        ruleAction[53] = new act53();
        ruleAction[54] = new act54();
        ruleAction[55] = new act55();
        ruleAction[56] = new act56();
        ruleAction[57] = new act57();
        ruleAction[58] = new act58();
        ruleAction[59] = new act59();
        ruleAction[60] = new act60();
        ruleAction[61] = new act61();
        ruleAction[62] = new act62();
        ruleAction[63] = new act63();
        ruleAction[64] = new act64();
        ruleAction[65] = new act65();
        ruleAction[66] = new act66();
        ruleAction[67] = new act67();
        ruleAction[68] = new act68();
        ruleAction[69] = new NoAction();
        ruleAction[70] = new NoAction();
        ruleAction[71] = new NoAction();
        ruleAction[72] = new NoAction();
        ruleAction[73] = new NoAction();
        ruleAction[74] = new NoAction();
        ruleAction[75] = new NoAction();
        ruleAction[76] = new NoAction();
        ruleAction[77] = new act77();
        ruleAction[78] = new act78();
        ruleAction[79] = new act79();
        ruleAction[80] = new act80();
        ruleAction[81] = new NoAction();
        ruleAction[82] = new act82();
        ruleAction[83] = new act83();
        ruleAction[84] = new NoAction();
        ruleAction[85] = new NoAction();
        ruleAction[86] = new act86();
        ruleAction[87] = new act87();
        ruleAction[88] = new act88();
        ruleAction[89] = new act89();
        ruleAction[90] = new act90();
        ruleAction[91] = new act91();
        ruleAction[92] = new act92();
        ruleAction[93] = new act93();
        ruleAction[94] = new act94();
        ruleAction[95] = new act95();
        ruleAction[96] = new NoAction();
        ruleAction[97] = new act97();
        ruleAction[98] = new act98();
        ruleAction[99] = new act99();
        ruleAction[100] = new act100();
        ruleAction[101] = new NoAction();
        ruleAction[102] = new act102();
        ruleAction[103] = new act103();
        ruleAction[104] = new act104();
        ruleAction[105] = new act105();
        ruleAction[106] = new act106();
        ruleAction[107] = new act107();
        ruleAction[108] = new act108();
        ruleAction[109] = new act109();
        ruleAction[110] = new act110();
        ruleAction[111] = new act111();
        ruleAction[112] = new act112();
        ruleAction[113] = new NoAction();
        ruleAction[114] = new NoAction();
        ruleAction[115] = new NoAction();
        ruleAction[116] = new NoAction();
        ruleAction[117] = new act117();
        ruleAction[118] = new NoAction();
        ruleAction[119] = new act119();
        ruleAction[120] = new act120();
        ruleAction[121] = new act121();
        ruleAction[122] = new act122();
        ruleAction[123] = new act123();
        ruleAction[124] = new act124();
        ruleAction[125] = new act125();
        ruleAction[126] = new NoAction();
        ruleAction[127] = new NoAction();
        ruleAction[128] = new NoAction();
        ruleAction[129] = new act129();
        ruleAction[130] = new act130();
        ruleAction[131] = new act131();
        ruleAction[132] = new NoAction();
        ruleAction[133] = new NoAction();
        ruleAction[134] = new NoAction();
        ruleAction[135] = new NoAction();
        ruleAction[136] = new NoAction();
        ruleAction[137] = new NoAction();
        ruleAction[138] = new NoAction();
        ruleAction[139] = new NoAction();
        ruleAction[140] = new NoAction();
        ruleAction[141] = new NoAction();
        ruleAction[142] = new NoAction();
        ruleAction[143] = new NoAction();
        ruleAction[144] = new NoAction();
        ruleAction[145] = new NoAction();
        ruleAction[146] = new NoAction();
        ruleAction[147] = new NoAction();
        ruleAction[148] = new NoAction();
        ruleAction[149] = new NoAction();
        ruleAction[150] = new NoAction();
        ruleAction[151] = new NoAction();
        ruleAction[152] = new NoAction();
        ruleAction[153] = new NoAction();
        ruleAction[154] = new act154();
        ruleAction[155] = new act155();
        ruleAction[156] = new act156();
        ruleAction[157] = new act157();
        ruleAction[158] = new NoAction();
        ruleAction[159] = new NoAction();
        ruleAction[160] = new NoAction();
        ruleAction[161] = new NoAction();
        ruleAction[162] = new NoAction();
        ruleAction[163] = new NoAction();
        ruleAction[164] = new NoAction();
        ruleAction[165] = new act165();
        ruleAction[166] = new act166();
        ruleAction[167] = new act167();
        ruleAction[168] = new act168();
        ruleAction[169] = new act169();
        ruleAction[170] = new act170();
        ruleAction[171] = new act171();
        ruleAction[172] = new act172();
        ruleAction[173] = new act173();
        ruleAction[174] = new act174();
        ruleAction[175] = new act175();
        ruleAction[176] = new act176();
        ruleAction[177] = new act177();
        ruleAction[178] = new act178();
        ruleAction[179] = new act179();
        ruleAction[180] = new act180();
        ruleAction[181] = new act181();
        ruleAction[182] = new act182();
        ruleAction[183] = new NoAction();
        ruleAction[184] = new NoAction();
        ruleAction[185] = new NoAction();
        ruleAction[186] = new act186();
        ruleAction[187] = new act187();
        ruleAction[188] = new act188();
        ruleAction[189] = new act189();
        ruleAction[190] = new act190();
        ruleAction[191] = new act191();
        ruleAction[192] = new act192();
        ruleAction[193] = new act193();
        ruleAction[194] = new act194();
        ruleAction[195] = new act195();
        ruleAction[196] = new act196();
        ruleAction[197] = new act197();
        ruleAction[198] = new act198();
        ruleAction[199] = new NoAction();
        ruleAction[200] = new NoAction();
        ruleAction[201] = new NoAction();
        ruleAction[202] = new NoAction();
        ruleAction[203] = new NoAction();
        ruleAction[204] = new NoAction();
        ruleAction[205] = new NoAction();
        ruleAction[206] = new act206();
        ruleAction[207] = new act207();
        ruleAction[208] = new act208();
        ruleAction[209] = new act209();
        ruleAction[210] = new act210();
        ruleAction[211] = new act211();
        ruleAction[212] = new act212();
        ruleAction[213] = new act213();
        ruleAction[214] = new act214();
        ruleAction[215] = new act215();
        ruleAction[216] = new act216();
        ruleAction[217] = new act217();
        ruleAction[218] = new act218();
        ruleAction[219] = new act219();
        ruleAction[220] = new act220();
        ruleAction[221] = new act221();
        ruleAction[222] = new act222();
        ruleAction[223] = new act223();
        ruleAction[224] = new act224();
        ruleAction[225] = new act225();
        ruleAction[226] = new act226();
        ruleAction[227] = new act227();
        ruleAction[228] = new act228();
        ruleAction[229] = new act229();
        ruleAction[230] = new act230();
        ruleAction[231] = new act231();
        ruleAction[232] = new act232();
        ruleAction[233] = new act233();
        ruleAction[234] = new NoAction();
        ruleAction[235] = new NoAction();
        ruleAction[236] = new NoAction();
        ruleAction[237] = new NoAction();
        ruleAction[238] = new act238();
        ruleAction[239] = new act239();
        ruleAction[240] = new NoAction();
        ruleAction[241] = new NoAction();
        ruleAction[242] = new NoAction();
        ruleAction[243] = new act243();
        ruleAction[244] = new act244();
        ruleAction[245] = new act245();
        ruleAction[246] = new act246();
        ruleAction[247] = new NoAction();
        ruleAction[248] = new NoAction();
        ruleAction[249] = new act249();
        ruleAction[250] = new act250();
        ruleAction[251] = new act251();
        ruleAction[252] = new act252();
        ruleAction[253] = new act253();
        ruleAction[254] = new NoAction();
        ruleAction[255] = new act255();
        ruleAction[256] = new act256();
        ruleAction[257] = new act257();
        ruleAction[258] = new NoAction();
        ruleAction[259] = new act259();
        ruleAction[260] = new act260();
        ruleAction[261] = new NoAction();
        ruleAction[262] = new act262();
        ruleAction[263] = new act263();
        ruleAction[264] = new act264();
        ruleAction[265] = new NoAction();
        ruleAction[266] = new act266();
        ruleAction[267] = new act267();
        ruleAction[268] = new act268();
        ruleAction[269] = new act269();
        ruleAction[270] = new act270();
        ruleAction[271] = new NoAction();
        ruleAction[272] = new act272();
        ruleAction[273] = new act273();
        ruleAction[274] = new NoAction();
        ruleAction[275] = new act275();
        ruleAction[276] = new NoAction();
        ruleAction[277] = new act277();
        ruleAction[278] = new NoAction();
        ruleAction[279] = new act279();
        ruleAction[280] = new NoAction();
        ruleAction[281] = new act281();
        ruleAction[282] = new NoAction();
        ruleAction[283] = new act283();
        ruleAction[284] = new NoAction();
        ruleAction[285] = new act285();
        ruleAction[286] = new NoAction();
        ruleAction[287] = new NoAction();
        ruleAction[288] = new act288();
        ruleAction[289] = new NoAction();
        ruleAction[290] = new NoAction();
        ruleAction[291] = new NoAction();
        ruleAction[292] = new act292();
        ruleAction[293] = new act293();
        ruleAction[294] = new act294();
        ruleAction[295] = new act295();
        ruleAction[296] = new act296();
        ruleAction[297] = new act297();
        ruleAction[298] = new act298();
        ruleAction[299] = new act299();
        ruleAction[300] = new act300();
        ruleAction[301] = new act301();
        ruleAction[302] = new act302();
        ruleAction[303] = new act303();
        ruleAction[304] = new NoAction();
        ruleAction[305] = new NoAction();
        ruleAction[306] = new act306();
        ruleAction[307] = new NoAction();
        ruleAction[308] = new act308();
        ruleAction[309] = new NoAction();
        ruleAction[310] = new act310();
        ruleAction[311] = new NoAction();
        ruleAction[312] = new act312();
        ruleAction[313] = new NoAction();
        ruleAction[314] = new act314();
        ruleAction[315] = new NoAction();
        ruleAction[316] = new act316();
        ruleAction[317] = new NoAction();
        ruleAction[318] = new act318();
        ruleAction[319] = new NoAction();
        ruleAction[320] = new act320();
        ruleAction[321] = new NoAction();
        ruleAction[322] = new act322();
        ruleAction[323] = new NoAction();
        ruleAction[324] = new act324();
        ruleAction[325] = new NoAction();
        ruleAction[326] = new act326();
        ruleAction[327] = new NoAction();
        ruleAction[328] = new act328();
        ruleAction[329] = new NoAction();
        ruleAction[330] = new act330();
        ruleAction[331] = new NoAction();
        ruleAction[332] = new act332();
        ruleAction[333] = new NoAction();
        ruleAction[334] = new act334();
        ruleAction[335] = new NoAction();
        ruleAction[336] = new act336();
        ruleAction[337] = new NoAction();
        ruleAction[338] = new act338();
        ruleAction[339] = new NoAction();
        ruleAction[340] = new act340();
        ruleAction[341] = new NoAction();
        ruleAction[342] = new act342();
        ruleAction[343] = new NoAction();
        ruleAction[344] = new act344();
        ruleAction[345] = new NoAction();
        ruleAction[346] = new act346();
        ruleAction[347] = new NoAction();
        ruleAction[348] = new act348();
        ruleAction[349] = new NoAction();
        ruleAction[350] = new act350();
        ruleAction[351] = new NoAction();
        ruleAction[352] = new act352();
        ruleAction[353] = new act353();
        ruleAction[354] = new act354();
        ruleAction[355] = new act355();


        //
        // Make sure that all elements of ruleAction are properly initialized
        //
        for (int i = 0; i < ruleAction.length; i++)
        {
            if (ruleAction[i] == null)
                 ruleAction[i] = new NoAction();
        }
    };
 
    //
    // Rule 1:  Literal ::= IntegerLiteral
    //
    final class act1 extends Action
    {
        public void action()
        {
            setResult(
                new IntegerLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 2:  Literal ::= LongLiteral
    //
    final class act2 extends Action
    {
        public void action()
        {
            setResult(
                new LongLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 3:  Literal ::= FloatingPointLiteral
    //
    final class act3 extends Action
    {
        public void action()
        {
            setResult(
                new FloatLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 4:  Literal ::= DoubleLiteral
    //
    final class act4 extends Action
    {
        public void action()
        {
            setResult(
                new DoubleLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 5:  Literal ::= BooleanLiteral
    //
    final class act5 extends Action
    {
        public void action()
        {
            //
            // When garbage collection is not available, delete getRhsSym(1)
            //
            setResult(
                new BooleanLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 6:  Literal ::= CharacterLiteral
    //
    final class act6 extends Action
    {
        public void action()
        {
            setResult(
                new CharacterLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 7:  Literal ::= StringLiteral
    //
    final class act7 extends Action
    {
        public void action()
        {
            setResult(
                new StringLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 8:  Literal ::= null
    //
    final class act8 extends Action
    {
        public void action()
        {
            setResult(
                new NullLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 9:  BooleanLiteral ::= true
    //
    final class act9 extends Action
    {
        public void action()
        {
            setResult(
                new TrueLiteral(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 10:  BooleanLiteral ::= false
    //
    final class act10 extends Action
    {
        public void action()
        {
            setResult(
                new FalseLiteral(getRhsIToken(1))
            );
            return;
        }
    }  
    //
    // Rule 11:  Type ::= PrimitiveType
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 12:  Type ::= ReferenceType
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 13:  PrimitiveType ::= NumericType
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 14:  PrimitiveType ::= boolean
    //
    final class act14 extends Action
    {
        public void action()
        {
            setResult(
                new BooleanType(getRhsIToken(1))
            );
            return;
        }
    }  
    //
    // Rule 15:  NumericType ::= IntegralType
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 16:  NumericType ::= FloatingPointType
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 17:  IntegralType ::= byte
    //
    final class act17 extends Action
    {
        public void action()
        {
            setResult(
                new ByteType(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 18:  IntegralType ::= short
    //
    final class act18 extends Action
    {
        public void action()
        {
            setResult(
                new ShortType(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 19:  IntegralType ::= int
    //
    final class act19 extends Action
    {
        public void action()
        {
            setResult(
                new IntType(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 20:  IntegralType ::= long
    //
    final class act20 extends Action
    {
        public void action()
        {
            setResult(
                new LongType(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 21:  IntegralType ::= char
    //
    final class act21 extends Action
    {
        public void action()
        {
            setResult(
                new CharType(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 22:  FloatingPointType ::= float
    //
    final class act22 extends Action
    {
        public void action()
        {
            setResult(
                new FloatType(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 23:  FloatingPointType ::= double
    //
    final class act23 extends Action
    {
        public void action()
        {
            setResult(
                new DoubleType(getRhsIToken(1))
            );
            return;
        }
    }  
    //
    // Rule 24:  ReferenceType ::= ClassOrInterfaceType
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 25:  ReferenceType ::= ArrayType
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 26:  ClassOrInterfaceType ::= Name
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 27:  ArrayType ::= PrimitiveType Dims
    //
    final class act27 extends Action
    {
        public void action()
        {
            setResult(
                new PrimitiveArrayType(getLeftIToken(), getRightIToken(),
                                       (IPrimitiveType)getRhsSym(1),
                                       (DimList)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 28:  ArrayType ::= Name Dims
    //
    final class act28 extends Action
    {
        public void action()
        {
            setResult(
                new ClassOrInterfaceArrayType(getLeftIToken(), getRightIToken(),
                                              (IName)getRhsSym(1),
                                              (DimList)getRhsSym(2))
            );
            return;
        }
    }  
    //
    // Rule 29:  ClassType ::= ClassOrInterfaceType
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 30:  InterfaceType ::= ClassOrInterfaceType
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 31:  Name ::= SimpleName
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 32:  Name ::= QualifiedName
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 33:  SimpleName ::= IDENTIFIER
    //
    final class act33 extends Action
    {
        public void action()
        {
            setResult(
                new SimpleName(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 34:  QualifiedName ::= Name . IDENTIFIER
    //
    final class act34 extends Action
    {
        public void action()
        {
            setResult(
                new QualifiedName(getLeftIToken(), getRightIToken(),
                                  (IName)getRhsSym(1),
                                  new AstToken(getRhsIToken(2)),
                                  new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 35:  CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
    //
    final class act35 extends Action
    {
        public void action()
        {
            setResult(
                new CompilationUnit(getLeftIToken(), getRightIToken(),
                                    (PackageDeclaration)getRhsSym(1),
                                    (ImportDeclarationList)getRhsSym(2),
                                    (TypeDeclarationList)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 36:  ImportDeclarations ::= ImportDeclaration
    //
    final class act36 extends Action
    {
        public void action()
        {
            setResult(
                new ImportDeclarationList((IImportDeclaration)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 37:  ImportDeclarations ::= ImportDeclarations ImportDeclaration
    //
    final class act37 extends Action
    {
        public void action()
        {
            ((ImportDeclarationList)getRhsSym(1)).add((IImportDeclaration)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 38:  TypeDeclarations ::= TypeDeclaration
    //
    final class act38 extends Action
    {
        public void action()
        {
            setResult(
                new TypeDeclarationList((ITypeDeclaration)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 39:  TypeDeclarations ::= TypeDeclarations TypeDeclaration
    //
    final class act39 extends Action
    {
        public void action()
        {
            ((TypeDeclarationList)getRhsSym(1)).add((ITypeDeclaration)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 40:  PackageDeclaration ::= package Name ;
    //
    final class act40 extends Action
    {
        public void action()
        {
            setResult(
                new PackageDeclaration(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(1)),
                                       (IName)getRhsSym(2),
                                       new AstToken(getRhsIToken(3)))
            );
            return;
        }
    }  
    //
    // Rule 41:  ImportDeclaration ::= SingleTypeImportDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 42:  ImportDeclaration ::= TypeImportOnDemandDeclaration
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 43:  SingleTypeImportDeclaration ::= import Name ;
    //
    final class act43 extends Action
    {
        public void action()
        {
            setResult(
                new SingleTypeImportDeclaration(getLeftIToken(), getRightIToken(),
                                                new AstToken(getRhsIToken(1)),
                                                (IName)getRhsSym(2),
                                                new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 44:  TypeImportOnDemandDeclaration ::= import Name . * ;
    //
    final class act44 extends Action
    {
        public void action()
        {
            setResult(
                new TypeImportOnDemandDeclaration(getLeftIToken(), getRightIToken(),
                                                  new AstToken(getRhsIToken(1)),
                                                  (IName)getRhsSym(2),
                                                  new AstToken(getRhsIToken(3)),
                                                  new AstToken(getRhsIToken(4)),
                                                  new AstToken(getRhsIToken(5)))
            );
            return;
        }
    }  
    //
    // Rule 45:  TypeDeclaration ::= ClassDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 46:  TypeDeclaration ::= InterfaceDeclaration
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 47:  TypeDeclaration ::= ;
    //
    final class act47 extends Action
    {
        public void action()
        {
            setResult(
                new EmptyDeclaration(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 48:  Modifiers ::= Modifier
    //
    final class act48 extends Action
    {
        public void action()
        {
            setResult(
                new ModifierList((IModifier)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 49:  Modifiers ::= Modifiers Modifier
    //
    final class act49 extends Action
    {
        public void action()
        {
            ((ModifierList)getRhsSym(1)).add((IModifier)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 50:  Modifier ::= public
    //
    final class act50 extends Action
    {
        public void action()
        {
            setResult(
                new PublicModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 51:  Modifier ::= protected
    //
    final class act51 extends Action
    {
        public void action()
        {
            setResult(
                new ProtectedModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 52:  Modifier ::= private
    //
    final class act52 extends Action
    {
        public void action()
        {
            setResult(
                new PrivateModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 53:  Modifier ::= static
    //
    final class act53 extends Action
    {
        public void action()
        {
            setResult(
                new StaticModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 54:  Modifier ::= abstract
    //
    final class act54 extends Action
    {
        public void action()
        {
            setResult(
                new AbstractModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 55:  Modifier ::= final
    //
    final class act55 extends Action
    {
        public void action()
        {
            setResult(
                new FinalModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 56:  Modifier ::= native
    //
    final class act56 extends Action
    {
        public void action()
        {
            setResult(
                new NativeModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 57:  Modifier ::= strictfp
    //
    final class act57 extends Action
    {
        public void action()
        {
            setResult(
                new StrictfpModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 58:  Modifier ::= synchronized
    //
    final class act58 extends Action
    {
        public void action()
        {
            setResult(
                new SynchronizedModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 59:  Modifier ::= transient
    //
    final class act59 extends Action
    {
        public void action()
        {
            setResult(
                new TransientModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 60:  Modifier ::= volatile
    //
    final class act60 extends Action
    {
        public void action()
        {
            setResult(
                new VolatileModifier(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 61:  ClassDeclaration ::= Modifiersopt class IDENTIFIER$Name Superopt Interfacesopt ClassBody
    //
    final class act61 extends Action
    {
        public void action()
        {
            setResult(
                new ClassDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                     (ModifierList)getRhsSym(1),
                                     new AstToken(getRhsIToken(2)),
                                     new AstToken(getRhsIToken(3)),
                                     (Super)getRhsSym(4),
                                     (InterfaceTypeList)getRhsSym(5),
                                     (ClassBody)getRhsSym(6))
            );
            return;
        }
    } 
    //
    // Rule 62:  Super ::= extends ClassType
    //
    final class act62 extends Action
    {
        public void action()
        {
            setResult(
                new Super(getLeftIToken(), getRightIToken(),
                          new AstToken(getRhsIToken(1)),
                          (IClassType)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 63:  Interfaces ::= implements InterfaceTypeList
    //
    final class act63 extends Action
    {
        public void action()
        {
            setResult((InterfaceTypeList)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 64:  InterfaceTypeList ::= InterfaceType
    //
    final class act64 extends Action
    {
        public void action()
        {
            setResult(
                new InterfaceTypeList((IInterfaceType)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 65:  InterfaceTypeList ::= InterfaceTypeList , InterfaceType
    //
    final class act65 extends Action
    {
        public void action()
        {
            ((InterfaceTypeList)getRhsSym(1)).add((IInterfaceType)getRhsSym(3));
            return;
        }
    } 
    //
    // Rule 66:  ClassBody ::= { ClassBodyDeclarationsopt }
    //
    final class act66 extends Action
    {
        public void action()
        {
            setResult(
                new ClassBody(getLeftIToken(), getRightIToken(),
                              new AstToken(getRhsIToken(1)),
                              (ClassBodyDeclarationList)getRhsSym(2),
                              new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 67:  ClassBodyDeclarations ::= ClassBodyDeclaration
    //
    final class act67 extends Action
    {
        public void action()
        {
            setResult(
                new ClassBodyDeclarationList((IClassBodyDeclaration)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 68:  ClassBodyDeclarations ::= ClassBodyDeclarations ClassBodyDeclaration
    //
    final class act68 extends Action
    {
        public void action()
        {
            ((ClassBodyDeclarationList)getRhsSym(1)).add((IClassBodyDeclaration)getRhsSym(2));
            return;
        }
    }  
    //
    // Rule 69:  ClassBodyDeclaration ::= ClassMemberDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 70:  ClassBodyDeclaration ::= StaticInitializer
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 71:  ClassBodyDeclaration ::= ConstructorDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 72:  ClassBodyDeclaration ::= Block
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 73:  ClassMemberDeclaration ::= FieldDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 74:  ClassMemberDeclaration ::= MethodDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 75:  ClassMemberDeclaration ::= ClassDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 76:  ClassMemberDeclaration ::= InterfaceDeclaration
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 77:  ClassMemberDeclaration ::= ;
    //
    final class act77 extends Action
    {
        public void action()
        {
            setResult(
                new EmptyDeclaration(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 78:  FieldDeclaration ::= Modifiersopt Type VariableDeclarators ;
    //
    final class act78 extends Action
    {
        public void action()
        {
            setResult(
                new FieldDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                     (ModifierList)getRhsSym(1),
                                     (IType)getRhsSym(2),
                                     (VariableDeclaratorList)getRhsSym(3),
                                     new AstToken(getRhsIToken(4)))
            );
            return;
        }
    } 
    //
    // Rule 79:  VariableDeclarators ::= VariableDeclarator
    //
    final class act79 extends Action
    {
        public void action()
        {
            setResult(
                new VariableDeclaratorList((IVariableDeclarator)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 80:  VariableDeclarators ::= VariableDeclarators , VariableDeclarator
    //
    final class act80 extends Action
    {
        public void action()
        {
            ((VariableDeclaratorList)getRhsSym(1)).add((IVariableDeclarator)getRhsSym(3));
            return;
        }
    }  
    //
    // Rule 81:  VariableDeclarator ::= VariableDeclaratorId
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 82:  VariableDeclarator ::= VariableDeclaratorId = VariableInitializer
    //
    final class act82 extends Action
    {
        public void action()
        {
            setResult(
                new VariableDeclarator(getLeftIToken(), getRightIToken(),
                                       (VariableDeclaratorId)getRhsSym(1),
                                       new AstToken(getRhsIToken(2)),
                                       (IVariableInitializer)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 83:  VariableDeclaratorId ::= IDENTIFIER Dimsopt
    //
    final class act83 extends Action
    {
        public void action()
        {
            setResult(
                new VariableDeclaratorId(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (DimList)getRhsSym(2))
            );
            return;
        }
    }  
    //
    // Rule 84:  VariableInitializer ::= Expression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 85:  VariableInitializer ::= ArrayInitializer
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 86:  MethodDeclaration ::= MethodHeader MethodBody
    //
    final class act86 extends Action
    {
        public void action()
        {
            setResult(
                new MethodDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                      (IMethodHeader)getRhsSym(1),
                                      (IMethodBody)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 87:  MethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt
    //
    final class act87 extends Action
    {
        public void action()
        {
            setResult(
                new TypedMethodHeader(getLeftIToken(), getRightIToken(),
                                      (ModifierList)getRhsSym(1),
                                      (IType)getRhsSym(2),
                                      (MethodDeclarator)getRhsSym(3),
                                      (ClassTypeList)getRhsSym(4))
            );
            return;
        }
    } 
    //
    // Rule 88:  MethodHeader ::= Modifiersopt void MethodDeclarator Throwsopt
    //
    final class act88 extends Action
    {
        public void action()
        {
            setResult(
                new VoidMethodHeader(getLeftIToken(), getRightIToken(),
                                     (ModifierList)getRhsSym(1),
                                     new AstToken(getRhsIToken(2)),
                                     (MethodDeclarator)getRhsSym(3),
                                     (ClassTypeList)getRhsSym(4))
            );
            return;
        }
    } 
    //
    // Rule 89:  MethodDeclarator ::= IDENTIFIER ( FormalParameterListopt ) Dimsopt
    //
    final class act89 extends Action
    {
        public void action()
        {
            setResult(
                new MethodDeclarator(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     new AstToken(getRhsIToken(2)),
                                     (FormalParameterList)getRhsSym(3),
                                     new AstToken(getRhsIToken(4)),
                                     (DimList)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 90:  FormalParameterList ::= FormalParameter
    //
    final class act90 extends Action
    {
        public void action()
        {
            setResult(
                new FormalParameterList((FormalParameter)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 91:  FormalParameterList ::= FormalParameterList , FormalParameter
    //
    final class act91 extends Action
    {
        public void action()
        {
            ((FormalParameterList)getRhsSym(1)).add((FormalParameter)getRhsSym(3));
            return;
        }
    } 
    //
    // Rule 92:  FormalParameter ::= Modifiersopt Type VariableDeclaratorId
    //
    final class act92 extends Action
    {
        public void action()
        {
            setResult(
                new FormalParameter(getLeftIToken(), getRightIToken(),
                                    (ModifierList)getRhsSym(1),
                                    (IType)getRhsSym(2),
                                    (VariableDeclaratorId)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 93:  Throws ::= throws ClassTypeList
    //
    final class act93 extends Action
    {
        public void action()
        {
            setResult((ClassTypeList)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 94:  ClassTypeList ::= ClassType
    //
    final class act94 extends Action
    {
        public void action()
        {
            setResult(
                new ClassTypeList((IClassType)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 95:  ClassTypeList ::= ClassTypeList , ClassType
    //
    final class act95 extends Action
    {
        public void action()
        {
            ((ClassTypeList)getRhsSym(1)).add((IClassType)getRhsSym(3));
            return;
        }
    }  
    //
    // Rule 96:  MethodBody ::= Block
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 97:  MethodBody ::= ;
    //
    final class act97 extends Action
    {
        public void action()
        {
            setResult(
                new EmptyMethodBody(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 98:  StaticInitializer ::= static Block
    //
    final class act98 extends Action
    {
        public void action()
        {
            setResult(
                new StaticInitializer(getLeftIToken(), getRightIToken(),
                                      new AstToken(getRhsIToken(1)),
                                      (Block)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 99:  ConstructorDeclaration ::= Modifiersopt ConstructorDeclarator Throwsopt ConstructorBody
    //
    final class act99 extends Action
    {
        public void action()
        {
            setResult(
                new ConstructorDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                           (ModifierList)getRhsSym(1),
                                           (ConstructorDeclarator)getRhsSym(2),
                                           (ClassTypeList)getRhsSym(3),
                                           (IConstructorBody)getRhsSym(4))
            );
            return;
        }
    } 
    //
    // Rule 100:  ConstructorDeclarator ::= IDENTIFIER ( FormalParameterListopt )
    //
    final class act100 extends Action
    {
        public void action()
        {
            setResult(
                new ConstructorDeclarator(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(1)),
                                          new AstToken(getRhsIToken(2)),
                                          (FormalParameterList)getRhsSym(3),
                                          new AstToken(getRhsIToken(4)))
            );
            return;
        }
    }  
    //
    // Rule 101:  ConstructorBody ::= Block
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 102:  ConstructorBody ::= { ExplicitConstructorInvocation BlockStatementsopt }
    //
    final class act102 extends Action
    {
        public void action()
        {
            setResult(
                new ConstructorBody(getLeftIToken(), getRightIToken(),
                                    new AstToken(getRhsIToken(1)),
                                    (IExplicitConstructorInvocation)getRhsSym(2),
                                    (BlockStatementList)getRhsSym(3),
                                    new AstToken(getRhsIToken(4)))
            );
            return;
        }
    } 
    //
    // Rule 103:  ExplicitConstructorInvocation ::= this ( ArgumentListopt ) ;
    //
    final class act103 extends Action
    {
        public void action()
        {
            setResult(
                new ThisCall(getLeftIToken(), getRightIToken(),
                             new AstToken(getRhsIToken(1)),
                             new AstToken(getRhsIToken(2)),
                             (ExpressionList)getRhsSym(3),
                             new AstToken(getRhsIToken(4)),
                             new AstToken(getRhsIToken(5)),
                             (IPrimary)null,
                             (AstToken)null)
            );
            return;
        }
    } 
    //
    // Rule 104:  ExplicitConstructorInvocation ::= Primary . this ( ArgumentListopt ) ;
    //
    final class act104 extends Action
    {
        public void action()
        {
            setResult(
                new ThisCall(getLeftIToken(), getRightIToken(),
                             new AstToken(getRhsIToken(3)),
                             new AstToken(getRhsIToken(4)),
                             (ExpressionList)getRhsSym(5),
                             new AstToken(getRhsIToken(6)),
                             new AstToken(getRhsIToken(7)),
                             (IPrimary)getRhsSym(1),
                             new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 105:  ExplicitConstructorInvocation ::= super ( ArgumentListopt ) ;
    //
    final class act105 extends Action
    {
        public void action()
        {
            setResult(
                new SuperCall(getLeftIToken(), getRightIToken(),
                              new AstToken(getRhsIToken(1)),
                              new AstToken(getRhsIToken(2)),
                              (ExpressionList)getRhsSym(3),
                              new AstToken(getRhsIToken(4)),
                              new AstToken(getRhsIToken(5)),
                              (IPostfixExpression)null,
                              (AstToken)null)
            );
            return;
        }
    } 
    //
    // Rule 106:  ExplicitConstructorInvocation ::= Primary$expression . super ( ArgumentListopt ) ;
    //
    final class act106 extends Action
    {
        public void action()
        {
            setResult(
                new SuperCall(getLeftIToken(), getRightIToken(),
                              new AstToken(getRhsIToken(3)),
                              new AstToken(getRhsIToken(4)),
                              (ExpressionList)getRhsSym(5),
                              new AstToken(getRhsIToken(6)),
                              new AstToken(getRhsIToken(7)),
                              (IPostfixExpression)getRhsSym(1),
                              new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 107:  ExplicitConstructorInvocation ::= Name$expression . super ( ArgumentListopt ) ;
    //
    final class act107 extends Action
    {
        public void action()
        {
            setResult(
                new SuperCall(getLeftIToken(), getRightIToken(),
                              new AstToken(getRhsIToken(3)),
                              new AstToken(getRhsIToken(4)),
                              (ExpressionList)getRhsSym(5),
                              new AstToken(getRhsIToken(6)),
                              new AstToken(getRhsIToken(7)),
                              (IPostfixExpression)getRhsSym(1),
                              new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 108:  InterfaceDeclaration ::= Modifiersopt interface IDENTIFIER$Name ExtendsInterfacesopt InterfaceBody
    //
    final class act108 extends Action
    {
        public void action()
        {
            setResult(
                new InterfaceDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                         (ModifierList)getRhsSym(1),
                                         new AstToken(getRhsIToken(2)),
                                         new AstToken(getRhsIToken(3)),
                                         (InterfaceTypeList)getRhsSym(4),
                                         (InterfaceBody)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 109:  ExtendsInterfaces ::= extends InterfaceTypeList
    //
    final class act109 extends Action
    {
        public void action()
        {
            setResult((InterfaceTypeList)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 110:  InterfaceBody ::= { InterfaceMemberDeclarationsopt }
    //
    final class act110 extends Action
    {
        public void action()
        {
            setResult(
                new InterfaceBody(getLeftIToken(), getRightIToken(),
                                  new AstToken(getRhsIToken(1)),
                                  (InterfaceMemberDeclarationList)getRhsSym(2),
                                  new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 111:  InterfaceMemberDeclarations ::= InterfaceMemberDeclaration
    //
    final class act111 extends Action
    {
        public void action()
        {
            setResult(
                new InterfaceMemberDeclarationList((IInterfaceMemberDeclaration)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 112:  InterfaceMemberDeclarations ::= InterfaceMemberDeclarations InterfaceMemberDeclaration
    //
    final class act112 extends Action
    {
        public void action()
        {
            ((InterfaceMemberDeclarationList)getRhsSym(1)).add((IInterfaceMemberDeclaration)getRhsSym(2));
            return;
        }
    }  
    //
    // Rule 113:  InterfaceMemberDeclaration ::= ConstantDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 114:  InterfaceMemberDeclaration ::= AbstractMethodDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 115:  InterfaceMemberDeclaration ::= ClassDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 116:  InterfaceMemberDeclaration ::= InterfaceDeclaration
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 117:  InterfaceMemberDeclaration ::= ;
    //
    final class act117 extends Action
    {
        public void action()
        {
            setResult(
                new EmptyDeclaration(getRhsIToken(1))
            );
            return;
        }
    }  
    //
    // Rule 118:  ConstantDeclaration ::= FieldDeclaration
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 119:  AbstractMethodDeclaration ::= MethodHeader ;
    //
    final class act119 extends Action
    {
        public void action()
        {
            setResult(
                new AbstractMethodDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                              (IMethodHeader)getRhsSym(1),
                                              new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 120:  ArrayInitializer ::= { VariableInitializersopt Commaopt }
    //
    final class act120 extends Action
    {
        public void action()
        {
            setResult(
                new ArrayInitializer(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     (VariableInitializerList)getRhsSym(2),
                                     (Commaopt)getRhsSym(3),
                                     new AstToken(getRhsIToken(4)))
            );
            return;
        }
    } 
    //
    // Rule 121:  VariableInitializers ::= VariableInitializer
    //
    final class act121 extends Action
    {
        public void action()
        {
            setResult(
                new VariableInitializerList((IVariableInitializer)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 122:  VariableInitializers ::= VariableInitializers , VariableInitializer
    //
    final class act122 extends Action
    {
        public void action()
        {
            ((VariableInitializerList)getRhsSym(1)).add((IVariableInitializer)getRhsSym(3));
            return;
        }
    } 
    //
    // Rule 123:  Block ::= { BlockStatementsopt }
    //
    final class act123 extends Action
    {
        public void action()
        {
            setResult(
                new Block(getLeftIToken(), getRightIToken(),
                          new AstToken(getRhsIToken(1)),
                          (BlockStatementList)getRhsSym(2),
                          new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 124:  BlockStatements ::= BlockStatement
    //
    final class act124 extends Action
    {
        public void action()
        {
            setResult(
                new BlockStatementList((IBlockStatement)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 125:  BlockStatements ::= BlockStatements BlockStatement
    //
    final class act125 extends Action
    {
        public void action()
        {
            ((BlockStatementList)getRhsSym(1)).add((IBlockStatement)getRhsSym(2));
            return;
        }
    }  
    //
    // Rule 126:  BlockStatement ::= LocalVariableDeclarationStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 127:  BlockStatement ::= Statement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 128:  BlockStatement ::= ClassDeclaration
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 129:  LocalVariableDeclarationStatement ::= LocalVariableDeclaration ;
    //
    final class act129 extends Action
    {
        public void action()
        {
            setResult(
                new LocalVariableDeclarationStatement(getLeftIToken(), getRightIToken(),
                                                      (LocalVariableDeclaration)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 130:  LocalVariableDeclaration ::= Modifiers Type VariableDeclarators
    //
    final class act130 extends Action
    {
        public void action()
        {
            setResult(
                new LocalVariableDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                             (ModifierList)getRhsSym(1),
                                             (IType)getRhsSym(2),
                                             (VariableDeclaratorList)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 131:  LocalVariableDeclaration ::= Type VariableDeclarators
    //
    final class act131 extends Action
    {
        public void action()
        {
            setResult(
                new LocalVariableDeclaration(JavaParser.this, getLeftIToken(), getRightIToken(),
                                             (ModifierList)null,
                                             (IType)getRhsSym(1),
                                             (VariableDeclaratorList)getRhsSym(2))
            );
            return;
        }
    }  
    //
    // Rule 132:  Statement ::= StatementWithoutTrailingSubstatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 133:  Statement ::= LabeledStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 134:  Statement ::= IfThenStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 135:  Statement ::= IfThenElseStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 136:  Statement ::= WhileStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 137:  Statement ::= ForStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 138:  StatementNoShortIf ::= StatementWithoutTrailingSubstatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 139:  StatementNoShortIf ::= LabeledStatementNoShortIf
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 140:  StatementNoShortIf ::= IfThenElseStatementNoShortIf
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 141:  StatementNoShortIf ::= WhileStatementNoShortIf
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 142:  StatementNoShortIf ::= ForStatementNoShortIf
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 143:  StatementWithoutTrailingSubstatement ::= Block
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 144:  StatementWithoutTrailingSubstatement ::= EmptyStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 145:  StatementWithoutTrailingSubstatement ::= ExpressionStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 146:  StatementWithoutTrailingSubstatement ::= SwitchStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 147:  StatementWithoutTrailingSubstatement ::= DoStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 148:  StatementWithoutTrailingSubstatement ::= BreakStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 149:  StatementWithoutTrailingSubstatement ::= ContinueStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 150:  StatementWithoutTrailingSubstatement ::= ReturnStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 151:  StatementWithoutTrailingSubstatement ::= SynchronizedStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 152:  StatementWithoutTrailingSubstatement ::= ThrowStatement
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 153:  StatementWithoutTrailingSubstatement ::= TryStatement
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 154:  EmptyStatement ::= ;
    //
    final class act154 extends Action
    {
        public void action()
        {
            setResult(
                new EmptyStatement(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 155:  LabeledStatement ::= IDENTIFIER : Statement
    //
    final class act155 extends Action
    {
        public void action()
        {
            setResult(
                new LabeledStatement(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     new AstToken(getRhsIToken(2)),
                                     (Ast)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 156:  LabeledStatementNoShortIf ::= IDENTIFIER : StatementNoShortIf$Statement
    //
    final class act156 extends Action
    {
        public void action()
        {
            setResult(
                new LabeledStatement(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     new AstToken(getRhsIToken(2)),
                                     (Ast)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 157:  ExpressionStatement ::= StatementExpression ;
    //
    final class act157 extends Action
    {
        public void action()
        {
            setResult(
                new ExpressionStatement(getLeftIToken(), getRightIToken(),
                                        (IStatementExpression)getRhsSym(1),
                                        new AstToken(getRhsIToken(2)))
            );
            return;
        }
    }  
    //
    // Rule 158:  StatementExpression ::= Assignment
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 159:  StatementExpression ::= PreIncrementExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 160:  StatementExpression ::= PreDecrementExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 161:  StatementExpression ::= PostIncrementExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 162:  StatementExpression ::= PostDecrementExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 163:  StatementExpression ::= MethodInvocation
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 164:  StatementExpression ::= ClassInstanceCreationExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 165:  IfThenStatement ::= if ( Expression ) Statement$thenStmt
    //
    final class act165 extends Action
    {
        public void action()
        {
            setResult(
                new IfStatement(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                new AstToken(getRhsIToken(2)),
                                (IExpression)getRhsSym(3),
                                new AstToken(getRhsIToken(4)),
                                (Ast)getRhsSym(5),
                                (AstToken)null,
                                (Ast)null)
            );
            return;
        }
    } 
    //
    // Rule 166:  IfThenElseStatement ::= if ( Expression ) StatementNoShortIf$thenStmt else Statement$elseStmt
    //
    final class act166 extends Action
    {
        public void action()
        {
            setResult(
                new IfStatement(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                new AstToken(getRhsIToken(2)),
                                (IExpression)getRhsSym(3),
                                new AstToken(getRhsIToken(4)),
                                (Ast)getRhsSym(5),
                                new AstToken(getRhsIToken(6)),
                                (Ast)getRhsSym(7))
            );
            return;
        }
    } 
    //
    // Rule 167:  IfThenElseStatementNoShortIf ::= if ( Expression ) StatementNoShortIf$thenStmt else StatementNoShortIf$elseStmt
    //
    final class act167 extends Action
    {
        public void action()
        {
            setResult(
                new IfStatement(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                new AstToken(getRhsIToken(2)),
                                (IExpression)getRhsSym(3),
                                new AstToken(getRhsIToken(4)),
                                (Ast)getRhsSym(5),
                                new AstToken(getRhsIToken(6)),
                                (Ast)getRhsSym(7))
            );
            return;
        }
    } 
    //
    // Rule 168:  SwitchStatement ::= switch ( Expression ) SwitchBlock
    //
    final class act168 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchStatement(getLeftIToken(), getRightIToken(),
                                    new AstToken(getRhsIToken(1)),
                                    new AstToken(getRhsIToken(2)),
                                    (IExpression)getRhsSym(3),
                                    new AstToken(getRhsIToken(4)),
                                    (SwitchBlock)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 169:  SwitchBlock ::= { SwitchLabelsopt }
    //
    final class act169 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchBlock(JavaParser.this, getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                (SwitchLabelList)getRhsSym(2),
                                new AstToken(getRhsIToken(3)),
                                (SwitchBlockStatementList)null)
            );
            return;
        }
    } 
    //
    // Rule 170:  SwitchBlock ::= { SwitchBlockStatements SwitchLabelsopt }
    //
    final class act170 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchBlock(JavaParser.this, getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                (SwitchLabelList)getRhsSym(3),
                                new AstToken(getRhsIToken(4)),
                                (SwitchBlockStatementList)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 171:  SwitchBlockStatements ::= SwitchBlockStatement
    //
    final class act171 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchBlockStatementList((SwitchBlockStatement)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 172:  SwitchBlockStatements ::= SwitchBlockStatements SwitchBlockStatement
    //
    final class act172 extends Action
    {
        public void action()
        {
            ((SwitchBlockStatementList)getRhsSym(1)).add((SwitchBlockStatement)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 173:  SwitchBlockStatement ::= SwitchLabels BlockStatements
    //
    final class act173 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchBlockStatement(getLeftIToken(), getRightIToken(),
                                         (SwitchLabelList)getRhsSym(1),
                                         (BlockStatementList)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 174:  SwitchLabels ::= SwitchLabel
    //
    final class act174 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchLabelList((ISwitchLabel)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 175:  SwitchLabels ::= SwitchLabels SwitchLabel
    //
    final class act175 extends Action
    {
        public void action()
        {
            ((SwitchLabelList)getRhsSym(1)).add((ISwitchLabel)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 176:  SwitchLabel ::= case ConstantExpression :
    //
    final class act176 extends Action
    {
        public void action()
        {
            setResult(
                new CaseLabel(getLeftIToken(), getRightIToken(),
                              new AstToken(getRhsIToken(1)),
                              (IConstantExpression)getRhsSym(2),
                              new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 177:  SwitchLabel ::= default :
    //
    final class act177 extends Action
    {
        public void action()
        {
            setResult(
                new DefaultLabel(getLeftIToken(), getRightIToken(),
                                 new AstToken(getRhsIToken(1)),
                                 new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 178:  WhileStatement ::= while ( Expression ) Statement
    //
    final class act178 extends Action
    {
        public void action()
        {
            setResult(
                new WhileStatement(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   new AstToken(getRhsIToken(2)),
                                   (IExpression)getRhsSym(3),
                                   new AstToken(getRhsIToken(4)),
                                   (Ast)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 179:  WhileStatementNoShortIf ::= while ( Expression ) StatementNoShortIf$Statement
    //
    final class act179 extends Action
    {
        public void action()
        {
            setResult(
                new WhileStatement(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   new AstToken(getRhsIToken(2)),
                                   (IExpression)getRhsSym(3),
                                   new AstToken(getRhsIToken(4)),
                                   (Ast)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 180:  DoStatement ::= do Statement while ( Expression ) ;
    //
    final class act180 extends Action
    {
        public void action()
        {
            setResult(
                new DoStatement(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                (IStatement)getRhsSym(2),
                                new AstToken(getRhsIToken(3)),
                                new AstToken(getRhsIToken(4)),
                                (IExpression)getRhsSym(5),
                                new AstToken(getRhsIToken(6)),
                                new AstToken(getRhsIToken(7)))
            );
            return;
        }
    } 
    //
    // Rule 181:  ForStatement ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement
    //
    final class act181 extends Action
    {
        public void action()
        {
            setResult(
                new ForStatement(getLeftIToken(), getRightIToken(),
                                 new AstToken(getRhsIToken(1)),
                                 new AstToken(getRhsIToken(2)),
                                 (IForInitopt)getRhsSym(3),
                                 new AstToken(getRhsIToken(4)),
                                 (IExpressionopt)getRhsSym(5),
                                 new AstToken(getRhsIToken(6)),
                                 (StatementExpressionList)getRhsSym(7),
                                 new AstToken(getRhsIToken(8)),
                                 (Ast)getRhsSym(9))
            );
            return;
        }
    } 
    //
    // Rule 182:  ForStatementNoShortIf ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) StatementNoShortIf$Statement
    //
    final class act182 extends Action
    {
        public void action()
        {
            setResult(
                new ForStatement(getLeftIToken(), getRightIToken(),
                                 new AstToken(getRhsIToken(1)),
                                 new AstToken(getRhsIToken(2)),
                                 (IForInitopt)getRhsSym(3),
                                 new AstToken(getRhsIToken(4)),
                                 (IExpressionopt)getRhsSym(5),
                                 new AstToken(getRhsIToken(6)),
                                 (StatementExpressionList)getRhsSym(7),
                                 new AstToken(getRhsIToken(8)),
                                 (Ast)getRhsSym(9))
            );
            return;
        }
    }  
    //
    // Rule 183:  ForInit ::= StatementExpressionList
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 184:  ForInit ::= LocalVariableDeclaration
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 185:  ForUpdate ::= StatementExpressionList
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 186:  StatementExpressionList ::= StatementExpression
    //
    final class act186 extends Action
    {
        public void action()
        {
            setResult(
                new StatementExpressionList((IStatementExpression)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 187:  StatementExpressionList ::= StatementExpressionList , StatementExpression
    //
    final class act187 extends Action
    {
        public void action()
        {
            ((StatementExpressionList)getRhsSym(1)).add((IStatementExpression)getRhsSym(3));
            return;
        }
    } 
    //
    // Rule 188:  BreakStatement ::= break IDENTIFIERopt ;
    //
    final class act188 extends Action
    {
        public void action()
        {
            setResult(
                new BreakStatement(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   (IDENTIFIERopt)getRhsSym(2),
                                   new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 189:  ContinueStatement ::= continue IDENTIFIERopt ;
    //
    final class act189 extends Action
    {
        public void action()
        {
            setResult(
                new ContinueStatement(getLeftIToken(), getRightIToken(),
                                      new AstToken(getRhsIToken(1)),
                                      (IDENTIFIERopt)getRhsSym(2),
                                      new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 190:  ReturnStatement ::= return Expressionopt ;
    //
    final class act190 extends Action
    {
        public void action()
        {
            setResult(
                new ReturnStatement(getLeftIToken(), getRightIToken(),
                                    new AstToken(getRhsIToken(1)),
                                    (IExpressionopt)getRhsSym(2),
                                    new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 191:  ThrowStatement ::= throw Expression ;
    //
    final class act191 extends Action
    {
        public void action()
        {
            setResult(
                new ThrowStatement(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   (IExpression)getRhsSym(2),
                                   new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 192:  SynchronizedStatement ::= synchronized ( Expression ) Block
    //
    final class act192 extends Action
    {
        public void action()
        {
            setResult(
                new SynchronizedStatement(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(1)),
                                          new AstToken(getRhsIToken(2)),
                                          (IExpression)getRhsSym(3),
                                          new AstToken(getRhsIToken(4)),
                                          (Block)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 193:  TryStatement ::= try Block Catches$Catchesopt
    //
    final class act193 extends Action
    {
        public void action()
        {
            setResult(
                new TryStatement(getLeftIToken(), getRightIToken(),
                                 new AstToken(getRhsIToken(1)),
                                 (Block)getRhsSym(2),
                                 (Ast)getRhsSym(3),
                                 (Finally)null)
            );
            return;
        }
    } 
    //
    // Rule 194:  TryStatement ::= try Block Catchesopt Finally
    //
    final class act194 extends Action
    {
        public void action()
        {
            setResult(
                new TryStatement(getLeftIToken(), getRightIToken(),
                                 new AstToken(getRhsIToken(1)),
                                 (Block)getRhsSym(2),
                                 (Ast)getRhsSym(3),
                                 (Finally)getRhsSym(4))
            );
            return;
        }
    } 
    //
    // Rule 195:  Catches ::= CatchClause
    //
    final class act195 extends Action
    {
        public void action()
        {
            setResult(
                new CatchClauseList((CatchClause)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 196:  Catches ::= Catches CatchClause
    //
    final class act196 extends Action
    {
        public void action()
        {
            ((CatchClauseList)getRhsSym(1)).add((CatchClause)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 197:  CatchClause ::= catch ( FormalParameter ) Block
    //
    final class act197 extends Action
    {
        public void action()
        {
            setResult(
                new CatchClause(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                new AstToken(getRhsIToken(2)),
                                (FormalParameter)getRhsSym(3),
                                new AstToken(getRhsIToken(4)),
                                (Block)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 198:  Finally ::= finally Block
    //
    final class act198 extends Action
    {
        public void action()
        {
            setResult(
                new Finally(getLeftIToken(), getRightIToken(),
                            new AstToken(getRhsIToken(1)),
                            (Block)getRhsSym(2))
            );
            return;
        }
    }  
    //
    // Rule 199:  Primary ::= PrimaryNoNewArray
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 200:  Primary ::= ArrayCreationExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 201:  PrimaryNoNewArray ::= Literal
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 202:  PrimaryNoNewArray ::= MethodInvocation
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 203:  PrimaryNoNewArray ::= ArrayAccess
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 204:  PrimaryNoNewArray ::= ClassInstanceCreationExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 205:  PrimaryNoNewArray ::= FieldAccess
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 206:  PrimaryNoNewArray ::= ( Expression )
    //
    final class act206 extends Action
    {
        public void action()
        {
            setResult(
                new ParenthesizedExpression(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IExpression)getRhsSym(2),
                                            new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 207:  PrimaryNoNewArray ::= this
    //
    final class act207 extends Action
    {
        public void action()
        {
            setResult(
                new PrimaryThis(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                (IName)null,
                                (AstToken)null)
            );
            return;
        }
    } 
    //
    // Rule 208:  PrimaryNoNewArray ::= Name . this
    //
    final class act208 extends Action
    {
        public void action()
        {
            setResult(
                new PrimaryThis(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(3)),
                                (IName)getRhsSym(1),
                                new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 209:  PrimaryNoNewArray ::= Type . class
    //
    final class act209 extends Action
    {
        public void action()
        {
            setResult(
                new PrimaryClassLiteral(getLeftIToken(), getRightIToken(),
                                        (IType)getRhsSym(1),
                                        new AstToken(getRhsIToken(2)),
                                        new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 210:  PrimaryNoNewArray ::= void . class
    //
    final class act210 extends Action
    {
        public void action()
        {
            setResult(
                new PrimaryVoidClassLiteral(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            new AstToken(getRhsIToken(2)),
                                            new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 211:  ClassInstanceCreationExpression ::= new ClassType ( ArgumentListopt ) ClassBodyopt
    //
    final class act211 extends Action
    {
        public void action()
        {
            setResult(
                new ClassInstanceCreationExpression(getLeftIToken(), getRightIToken(),
                                                    new AstToken(getRhsIToken(1)),
                                                    (IClassType)getRhsSym(2),
                                                    new AstToken(getRhsIToken(3)),
                                                    (ExpressionList)getRhsSym(4),
                                                    new AstToken(getRhsIToken(5)),
                                                    (ClassBody)getRhsSym(6),
                                                    (IPostfixExpression)null,
                                                    (AstToken)null)
            );
            return;
        }
    } 
    //
    // Rule 212:  ClassInstanceCreationExpression ::= Primary$expression . new SimpleName$ClassType ( ArgumentListopt ) ClassBodyopt
    //
    final class act212 extends Action
    {
        public void action()
        {
            setResult(
                new ClassInstanceCreationExpression(getLeftIToken(), getRightIToken(),
                                                    new AstToken(getRhsIToken(3)),
                                                    (IClassType)getRhsSym(4),
                                                    new AstToken(getRhsIToken(5)),
                                                    (ExpressionList)getRhsSym(6),
                                                    new AstToken(getRhsIToken(7)),
                                                    (ClassBody)getRhsSym(8),
                                                    (IPostfixExpression)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 213:  ClassInstanceCreationExpression ::= Name$expression . new SimpleName$ClassType ( ArgumentListopt ) ClassBodyopt
    //
    final class act213 extends Action
    {
        public void action()
        {
            setResult(
                new ClassInstanceCreationExpression(getLeftIToken(), getRightIToken(),
                                                    new AstToken(getRhsIToken(3)),
                                                    (IClassType)getRhsSym(4),
                                                    new AstToken(getRhsIToken(5)),
                                                    (ExpressionList)getRhsSym(6),
                                                    new AstToken(getRhsIToken(7)),
                                                    (ClassBody)getRhsSym(8),
                                                    (IPostfixExpression)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 214:  ArgumentList ::= Expression
    //
    final class act214 extends Action
    {
        public void action()
        {
            setResult(
                new ExpressionList((IExpression)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 215:  ArgumentList ::= ArgumentList , Expression
    //
    final class act215 extends Action
    {
        public void action()
        {
            ((ExpressionList)getRhsSym(1)).add((IExpression)getRhsSym(3));
            return;
        }
    } 
    //
    // Rule 216:  ArrayCreationExpression ::= new PrimitiveType$Type DimExprs Dimsopt
    //
    final class act216 extends Action
    {
        public void action()
        {
            setResult(
                new ArrayCreationExpression(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IType)getRhsSym(2),
                                            (DimExprList)getRhsSym(3),
                                            (DimList)getRhsSym(4),
                                            (ArrayInitializer)null)
            );
            return;
        }
    } 
    //
    // Rule 217:  ArrayCreationExpression ::= new ClassOrInterfaceType$Type DimExprs Dimsopt
    //
    final class act217 extends Action
    {
        public void action()
        {
            setResult(
                new ArrayCreationExpression(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IType)getRhsSym(2),
                                            (DimExprList)getRhsSym(3),
                                            (DimList)getRhsSym(4),
                                            (ArrayInitializer)null)
            );
            return;
        }
    } 
    //
    // Rule 218:  ArrayCreationExpression ::= new ArrayType$Type ArrayInitializer
    //
    final class act218 extends Action
    {
        public void action()
        {
            setResult(
                new ArrayCreationExpression(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IType)getRhsSym(2),
                                            (DimExprList)null,
                                            (DimList)null,
                                            (ArrayInitializer)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 219:  DimExprs ::= DimExpr
    //
    final class act219 extends Action
    {
        public void action()
        {
            setResult(
                new DimExprList((DimExpr)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 220:  DimExprs ::= DimExprs DimExpr
    //
    final class act220 extends Action
    {
        public void action()
        {
            ((DimExprList)getRhsSym(1)).add((DimExpr)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 221:  DimExpr ::= [ Expression ]
    //
    final class act221 extends Action
    {
        public void action()
        {
            setResult(
                new DimExpr(getLeftIToken(), getRightIToken(),
                            new AstToken(getRhsIToken(1)),
                            (IExpression)getRhsSym(2),
                            new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 222:  Dims ::= Dim
    //
    final class act222 extends Action
    {
        public void action()
        {
            setResult(
                new DimList((Dim)getRhsSym(1), true /* left recursive */)
            );
            return;
        }
    } 
    //
    // Rule 223:  Dims ::= Dims Dim
    //
    final class act223 extends Action
    {
        public void action()
        {
            ((DimList)getRhsSym(1)).add((Dim)getRhsSym(2));
            return;
        }
    } 
    //
    // Rule 224:  Dim ::= [ ]
    //
    final class act224 extends Action
    {
        public void action()
        {
            setResult(
                new Dim(getLeftIToken(), getRightIToken(),
                        new AstToken(getRhsIToken(1)),
                        new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 225:  FieldAccess ::= Primary . IDENTIFIER
    //
    final class act225 extends Action
    {
        public void action()
        {
            setResult(
                new FieldAccess(getLeftIToken(), getRightIToken(),
                                (IPrimary)getRhsSym(1),
                                new AstToken(getRhsIToken(2)),
                                new AstToken(getRhsIToken(3)))
            );
            return;
        }
    } 
    //
    // Rule 226:  FieldAccess ::= super . IDENTIFIER
    //
    final class act226 extends Action
    {
        public void action()
        {
            setResult(
                new SuperFieldAccess(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     new AstToken(getRhsIToken(2)),
                                     new AstToken(getRhsIToken(3)),
                                     (IName)null,
                                     (AstToken)null)
            );
            return;
        }
    } 
    //
    // Rule 227:  FieldAccess ::= Name . super . IDENTIFIER
    //
    final class act227 extends Action
    {
        public void action()
        {
            setResult(
                new SuperFieldAccess(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(3)),
                                     new AstToken(getRhsIToken(2)),
                                     new AstToken(getRhsIToken(5)),
                                     (IName)getRhsSym(1),
                                     new AstToken(getRhsIToken(4)))
            );
            return;
        }
    } 
    //
    // Rule 228:  MethodInvocation ::= Name ( ArgumentListopt )
    //
    final class act228 extends Action
    {
        public void action()
        {
            setResult(
                new MethodInvocation(getLeftIToken(), getRightIToken(),
                                     (IName)getRhsSym(1),
                                     new AstToken(getRhsIToken(2)),
                                     (ExpressionList)getRhsSym(3),
                                     new AstToken(getRhsIToken(4)))
            );
            return;
        }
    } 
    //
    // Rule 229:  MethodInvocation ::= Primary . IDENTIFIER ( ArgumentListopt )
    //
    final class act229 extends Action
    {
        public void action()
        {
            setResult(
                new PrimaryMethodInvocation(getLeftIToken(), getRightIToken(),
                                            (IPrimary)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            new AstToken(getRhsIToken(3)),
                                            new AstToken(getRhsIToken(4)),
                                            (ExpressionList)getRhsSym(5),
                                            new AstToken(getRhsIToken(6)))
            );
            return;
        }
    } 
    //
    // Rule 230:  MethodInvocation ::= super . IDENTIFIER ( ArgumentListopt )
    //
    final class act230 extends Action
    {
        public void action()
        {
            setResult(
                new SuperMethodInvocation(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(1)),
                                          new AstToken(getRhsIToken(2)),
                                          new AstToken(getRhsIToken(3)),
                                          new AstToken(getRhsIToken(4)),
                                          (ExpressionList)getRhsSym(5),
                                          new AstToken(getRhsIToken(6)),
                                          (IName)null,
                                          (AstToken)null)
            );
            return;
        }
    } 
    //
    // Rule 231:  MethodInvocation ::= Name . super . IDENTIFIER ( ArgumentListopt )
    //
    final class act231 extends Action
    {
        public void action()
        {
            setResult(
                new SuperMethodInvocation(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(3)),
                                          new AstToken(getRhsIToken(2)),
                                          new AstToken(getRhsIToken(5)),
                                          new AstToken(getRhsIToken(6)),
                                          (ExpressionList)getRhsSym(7),
                                          new AstToken(getRhsIToken(8)),
                                          (IName)getRhsSym(1),
                                          new AstToken(getRhsIToken(4)))
            );
            return;
        }
    } 
    //
    // Rule 232:  ArrayAccess ::= Name$Base [ Expression ]
    //
    final class act232 extends Action
    {
        public void action()
        {
            setResult(
                new ArrayAccess(getLeftIToken(), getRightIToken(),
                                (IPostfixExpression)getRhsSym(1),
                                new AstToken(getRhsIToken(2)),
                                (IExpression)getRhsSym(3),
                                new AstToken(getRhsIToken(4)))
            );
            return;
        }
    } 
    //
    // Rule 233:  ArrayAccess ::= PrimaryNoNewArray$Base [ Expression ]
    //
    final class act233 extends Action
    {
        public void action()
        {
            setResult(
                new ArrayAccess(getLeftIToken(), getRightIToken(),
                                (IPostfixExpression)getRhsSym(1),
                                new AstToken(getRhsIToken(2)),
                                (IExpression)getRhsSym(3),
                                new AstToken(getRhsIToken(4)))
            );
            return;
        }
    }  
    //
    // Rule 234:  PostfixExpression ::= Primary
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 235:  PostfixExpression ::= Name
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 236:  PostfixExpression ::= PostIncrementExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 237:  PostfixExpression ::= PostDecrementExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 238:  PostIncrementExpression ::= PostfixExpression ++
    //
    final class act238 extends Action
    {
        public void action()
        {
            setResult(
                new PostIncrementExpression(getLeftIToken(), getRightIToken(),
                                            (IPostfixExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)))
            );
            return;
        }
    } 
    //
    // Rule 239:  PostDecrementExpression ::= PostfixExpression --
    //
    final class act239 extends Action
    {
        public void action()
        {
            setResult(
                new PostDecrementExpression(getLeftIToken(), getRightIToken(),
                                            (IPostfixExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)))
            );
            return;
        }
    }  
    //
    // Rule 240:  UnaryExpression ::= PreIncrementExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 241:  UnaryExpression ::= PreDecrementExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 242:  UnaryExpression ::= UnaryExpressionNotPlusMinus
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 243:  UnaryExpression ::= + UnaryExpression
    //
    final class act243 extends Action
    {
        public void action()
        {
            setResult(
                new PlusUnaryExpression(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (IUnaryExpression)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 244:  UnaryExpression ::= - UnaryExpression
    //
    final class act244 extends Action
    {
        public void action()
        {
            setResult(
                new MinusUnaryExpression(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IUnaryExpression)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 245:  PreIncrementExpression ::= ++ UnaryExpression
    //
    final class act245 extends Action
    {
        public void action()
        {
            setResult(
                new PreIncrementExpression(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           (IUnaryExpression)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 246:  PreDecrementExpression ::= -- UnaryExpression
    //
    final class act246 extends Action
    {
        public void action()
        {
            setResult(
                new PreDecrementExpression(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           (IUnaryExpression)getRhsSym(2))
            );
            return;
        }
    }  
    //
    // Rule 247:  UnaryExpressionNotPlusMinus ::= PostfixExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 248:  UnaryExpressionNotPlusMinus ::= CastExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 249:  UnaryExpressionNotPlusMinus ::= ~ UnaryExpression
    //
    final class act249 extends Action
    {
        public void action()
        {
            setResult(
                new UnaryComplementExpression(getLeftIToken(), getRightIToken(),
                                              new AstToken(getRhsIToken(1)),
                                              (IUnaryExpression)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 250:  UnaryExpressionNotPlusMinus ::= ! UnaryExpression
    //
    final class act250 extends Action
    {
        public void action()
        {
            setResult(
                new UnaryNotExpression(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(1)),
                                       (IUnaryExpression)getRhsSym(2))
            );
            return;
        }
    } 
    //
    // Rule 251:  CastExpression ::= ( PrimitiveType Dimsopt ) UnaryExpression
    //
    final class act251 extends Action
    {
        public void action()
        {
            setResult(
                new PrimitiveCastExpression(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IPrimitiveType)getRhsSym(2),
                                            (DimList)getRhsSym(3),
                                            new AstToken(getRhsIToken(4)),
                                            (IUnaryExpression)getRhsSym(5))
            );
            return;
        }
    } 
    //
    // Rule 252:  CastExpression ::= ( Expression$Name ) UnaryExpressionNotPlusMinus
    //
    final class act252 extends Action
    {
        public void action()
        {
            setResult(
                new ClassCastExpression(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (IExpression)getRhsSym(2),
                                        new AstToken(getRhsIToken(3)),
                                        (IUnaryExpressionNotPlusMinus)getRhsSym(4),
                                        (DimList)null)
            );
            return;
        }
    } 
    //
    // Rule 253:  CastExpression ::= ( Name$Name Dims ) UnaryExpressionNotPlusMinus
    //
    final class act253 extends Action
    {
        public void action()
        {
            setResult(
                new ClassCastExpression(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (IExpression)getRhsSym(2),
                                        new AstToken(getRhsIToken(4)),
                                        (IUnaryExpressionNotPlusMinus)getRhsSym(5),
                                        (DimList)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 254:  MultiplicativeExpression ::= UnaryExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 255:  MultiplicativeExpression ::= MultiplicativeExpression * UnaryExpression
    //
    final class act255 extends Action
    {
        public void action()
        {
            setResult(
                new MultiplyExpression(getLeftIToken(), getRightIToken(),
                                       (IMultiplicativeExpression)getRhsSym(1),
                                       new AstToken(getRhsIToken(2)),
                                       (IUnaryExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 256:  MultiplicativeExpression ::= MultiplicativeExpression / UnaryExpression
    //
    final class act256 extends Action
    {
        public void action()
        {
            setResult(
                new DivideExpression(getLeftIToken(), getRightIToken(),
                                     (IMultiplicativeExpression)getRhsSym(1),
                                     new AstToken(getRhsIToken(2)),
                                     (IUnaryExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 257:  MultiplicativeExpression ::= MultiplicativeExpression % UnaryExpression
    //
    final class act257 extends Action
    {
        public void action()
        {
            setResult(
                new ModExpression(getLeftIToken(), getRightIToken(),
                                  (IMultiplicativeExpression)getRhsSym(1),
                                  new AstToken(getRhsIToken(2)),
                                  (IUnaryExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 258:  AdditiveExpression ::= MultiplicativeExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 259:  AdditiveExpression ::= AdditiveExpression + MultiplicativeExpression
    //
    final class act259 extends Action
    {
        public void action()
        {
            setResult(
                new AddExpression(getLeftIToken(), getRightIToken(),
                                  (IAdditiveExpression)getRhsSym(1),
                                  new AstToken(getRhsIToken(2)),
                                  (IMultiplicativeExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 260:  AdditiveExpression ::= AdditiveExpression - MultiplicativeExpression
    //
    final class act260 extends Action
    {
        public void action()
        {
            setResult(
                new SubtractExpression(getLeftIToken(), getRightIToken(),
                                       (IAdditiveExpression)getRhsSym(1),
                                       new AstToken(getRhsIToken(2)),
                                       (IMultiplicativeExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 261:  ShiftExpression ::= AdditiveExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 262:  ShiftExpression ::= ShiftExpression << AdditiveExpression
    //
    final class act262 extends Action
    {
        public void action()
        {
            setResult(
                new LeftShiftExpression(getLeftIToken(), getRightIToken(),
                                        (IShiftExpression)getRhsSym(1),
                                        new AstToken(getRhsIToken(2)),
                                        (IAdditiveExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 263:  ShiftExpression ::= ShiftExpression >> AdditiveExpression
    //
    final class act263 extends Action
    {
        public void action()
        {
            setResult(
                new RightShiftExpression(getLeftIToken(), getRightIToken(),
                                         (IShiftExpression)getRhsSym(1),
                                         new AstToken(getRhsIToken(2)),
                                         (IAdditiveExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 264:  ShiftExpression ::= ShiftExpression >>> AdditiveExpression
    //
    final class act264 extends Action
    {
        public void action()
        {
            setResult(
                new UnsignedRightShiftExpression(getLeftIToken(), getRightIToken(),
                                                 (IShiftExpression)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (IAdditiveExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 265:  RelationalExpression ::= ShiftExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 266:  RelationalExpression ::= RelationalExpression < ShiftExpression
    //
    final class act266 extends Action
    {
        public void action()
        {
            setResult(
                new LessExpression(getLeftIToken(), getRightIToken(),
                                   (IRelationalExpression)getRhsSym(1),
                                   new AstToken(getRhsIToken(2)),
                                   (IShiftExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 267:  RelationalExpression ::= RelationalExpression > ShiftExpression
    //
    final class act267 extends Action
    {
        public void action()
        {
            setResult(
                new GreaterExpression(getLeftIToken(), getRightIToken(),
                                      (IRelationalExpression)getRhsSym(1),
                                      new AstToken(getRhsIToken(2)),
                                      (IShiftExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 268:  RelationalExpression ::= RelationalExpression <= ShiftExpression
    //
    final class act268 extends Action
    {
        public void action()
        {
            setResult(
                new LessEqualExpression(getLeftIToken(), getRightIToken(),
                                        (IRelationalExpression)getRhsSym(1),
                                        new AstToken(getRhsIToken(2)),
                                        (IShiftExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 269:  RelationalExpression ::= RelationalExpression >= ShiftExpression
    //
    final class act269 extends Action
    {
        public void action()
        {
            setResult(
                new GreaterEqualExpression(getLeftIToken(), getRightIToken(),
                                           (IRelationalExpression)getRhsSym(1),
                                           new AstToken(getRhsIToken(2)),
                                           (IShiftExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 270:  RelationalExpression ::= RelationalExpression instanceof ReferenceType
    //
    final class act270 extends Action
    {
        public void action()
        {
            setResult(
                new InstanceofExpression(getLeftIToken(), getRightIToken(),
                                         (IRelationalExpression)getRhsSym(1),
                                         new AstToken(getRhsIToken(2)),
                                         (IReferenceType)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 271:  EqualityExpression ::= RelationalExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 272:  EqualityExpression ::= EqualityExpression == RelationalExpression
    //
    final class act272 extends Action
    {
        public void action()
        {
            setResult(
                new EqualExpression(getLeftIToken(), getRightIToken(),
                                    (IEqualityExpression)getRhsSym(1),
                                    new AstToken(getRhsIToken(2)),
                                    (IRelationalExpression)getRhsSym(3))
            );
            return;
        }
    } 
    //
    // Rule 273:  EqualityExpression ::= EqualityExpression != RelationalExpression
    //
    final class act273 extends Action
    {
        public void action()
        {
            setResult(
                new NotEqualExpression(getLeftIToken(), getRightIToken(),
                                       (IEqualityExpression)getRhsSym(1),
                                       new AstToken(getRhsIToken(2)),
                                       (IRelationalExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 274:  AndExpression ::= EqualityExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 275:  AndExpression ::= AndExpression & EqualityExpression
    //
    final class act275 extends Action
    {
        public void action()
        {
            setResult(
                new AndExpression(getLeftIToken(), getRightIToken(),
                                  (IAndExpression)getRhsSym(1),
                                  new AstToken(getRhsIToken(2)),
                                  (IEqualityExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 276:  ExclusiveOrExpression ::= AndExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 277:  ExclusiveOrExpression ::= ExclusiveOrExpression ^ AndExpression
    //
    final class act277 extends Action
    {
        public void action()
        {
            setResult(
                new ExclusiveOrExpression(getLeftIToken(), getRightIToken(),
                                          (IExclusiveOrExpression)getRhsSym(1),
                                          new AstToken(getRhsIToken(2)),
                                          (IAndExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 278:  InclusiveOrExpression ::= ExclusiveOrExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 279:  InclusiveOrExpression ::= InclusiveOrExpression | ExclusiveOrExpression
    //
    final class act279 extends Action
    {
        public void action()
        {
            setResult(
                new InclusiveOrExpression(getLeftIToken(), getRightIToken(),
                                          (IInclusiveOrExpression)getRhsSym(1),
                                          new AstToken(getRhsIToken(2)),
                                          (IExclusiveOrExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 280:  ConditionalAndExpression ::= InclusiveOrExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 281:  ConditionalAndExpression ::= ConditionalAndExpression && InclusiveOrExpression
    //
    final class act281 extends Action
    {
        public void action()
        {
            setResult(
                new ConditionalAndExpression(getLeftIToken(), getRightIToken(),
                                             (IConditionalAndExpression)getRhsSym(1),
                                             new AstToken(getRhsIToken(2)),
                                             (IInclusiveOrExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 282:  ConditionalOrExpression ::= ConditionalAndExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 283:  ConditionalOrExpression ::= ConditionalOrExpression || ConditionalAndExpression
    //
    final class act283 extends Action
    {
        public void action()
        {
            setResult(
                new ConditionalOrExpression(getLeftIToken(), getRightIToken(),
                                            (IConditionalOrExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IConditionalAndExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 284:  ConditionalExpression ::= ConditionalOrExpression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 285:  ConditionalExpression ::= ConditionalOrExpression ? Expression : ConditionalExpression
    //
    final class act285 extends Action
    {
        public void action()
        {
            setResult(
                new ConditionalExpression(getLeftIToken(), getRightIToken(),
                                          (IConditionalOrExpression)getRhsSym(1),
                                          new AstToken(getRhsIToken(2)),
                                          (IExpression)getRhsSym(3),
                                          new AstToken(getRhsIToken(4)),
                                          (IConditionalExpression)getRhsSym(5))
            );
            return;
        }
    }  
    //
    // Rule 286:  AssignmentExpression ::= ConditionalExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 287:  AssignmentExpression ::= Assignment
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 288:  Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
    //
    final class act288 extends Action
    {
        public void action()
        {
            setResult(
                new Assignment(getLeftIToken(), getRightIToken(),
                               (ILeftHandSide)getRhsSym(1),
                               (IAssignmentOperator)getRhsSym(2),
                               (IAssignmentExpression)getRhsSym(3))
            );
            return;
        }
    }  
    //
    // Rule 289:  LeftHandSide ::= Name
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 290:  LeftHandSide ::= FieldAccess
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 291:  LeftHandSide ::= ArrayAccess
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 292:  AssignmentOperator ::= =
    //
    final class act292 extends Action
    {
        public void action()
        {
            setResult(
                new EqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 293:  AssignmentOperator ::= *=
    //
    final class act293 extends Action
    {
        public void action()
        {
            setResult(
                new MultiplyEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 294:  AssignmentOperator ::= /=
    //
    final class act294 extends Action
    {
        public void action()
        {
            setResult(
                new DivideEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 295:  AssignmentOperator ::= %=
    //
    final class act295 extends Action
    {
        public void action()
        {
            setResult(
                new ModEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 296:  AssignmentOperator ::= +=
    //
    final class act296 extends Action
    {
        public void action()
        {
            setResult(
                new PlusEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 297:  AssignmentOperator ::= -=
    //
    final class act297 extends Action
    {
        public void action()
        {
            setResult(
                new MinusEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 298:  AssignmentOperator ::= <<=
    //
    final class act298 extends Action
    {
        public void action()
        {
            setResult(
                new LeftShiftEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 299:  AssignmentOperator ::= >>=
    //
    final class act299 extends Action
    {
        public void action()
        {
            setResult(
                new RightShiftEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 300:  AssignmentOperator ::= >>>=
    //
    final class act300 extends Action
    {
        public void action()
        {
            setResult(
                new UnsignedRightShiftEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 301:  AssignmentOperator ::= &=
    //
    final class act301 extends Action
    {
        public void action()
        {
            setResult(
                new AndEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 302:  AssignmentOperator ::= ^=
    //
    final class act302 extends Action
    {
        public void action()
        {
            setResult(
                new ExclusiveOrEqualOperator(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 303:  AssignmentOperator ::= |=
    //
    final class act303 extends Action
    {
        public void action()
        {
            setResult(
                new OrEqualOperator(getRhsIToken(1))
            );
            return;
        }
    }  
    //
    // Rule 304:  Expression ::= AssignmentExpression
    //
    //
    // final class NullAction extends Action
    //
  
    //
    // Rule 305:  ConstantExpression ::= Expression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 306:  PackageDeclarationopt ::= $Empty
    //
    final class act306 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    }  
    //
    // Rule 307:  PackageDeclarationopt ::= PackageDeclaration
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 308:  Superopt ::= $Empty
    //
    final class act308 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    }  
    //
    // Rule 309:  Superopt ::= Super
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 310:  Expressionopt ::= $Empty
    //
    final class act310 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    }  
    //
    // Rule 311:  Expressionopt ::= Expression
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 312:  ClassBodyopt ::= $Empty
    //
    final class act312 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    }  
    //
    // Rule 313:  ClassBodyopt ::= ClassBody
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 314:  ImportDeclarationsopt ::= $Empty
    //
    final class act314 extends Action
    {
        public void action()
        {
            setResult(
                new ImportDeclarationList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 315:  ImportDeclarationsopt ::= ImportDeclarations
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 316:  TypeDeclarationsopt ::= $Empty
    //
    final class act316 extends Action
    {
        public void action()
        {
            setResult(
                new TypeDeclarationList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 317:  TypeDeclarationsopt ::= TypeDeclarations
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 318:  ClassBodyDeclarationsopt ::= $Empty
    //
    final class act318 extends Action
    {
        public void action()
        {
            setResult(
                new ClassBodyDeclarationList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 319:  ClassBodyDeclarationsopt ::= ClassBodyDeclarations
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 320:  Modifiersopt ::= $Empty
    //
    final class act320 extends Action
    {
        public void action()
        {
            setResult(
                new ModifierList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 321:  Modifiersopt ::= Modifiers
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 322:  ExplicitConstructorInvocationopt ::= $Empty
    //
    final class act322 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    }  
    //
    // Rule 323:  ExplicitConstructorInvocationopt ::= ExplicitConstructorInvocation
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 324:  BlockStatementsopt ::= $Empty
    //
    final class act324 extends Action
    {
        public void action()
        {
            setResult(
                new BlockStatementList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 325:  BlockStatementsopt ::= BlockStatements
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 326:  Dimsopt ::= $Empty
    //
    final class act326 extends Action
    {
        public void action()
        {
            setResult(
                new DimList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 327:  Dimsopt ::= Dims
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 328:  ArgumentListopt ::= $Empty
    //
    final class act328 extends Action
    {
        public void action()
        {
            setResult(
                new ExpressionList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 329:  ArgumentListopt ::= ArgumentList
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 330:  Throwsopt ::= $Empty
    //
    final class act330 extends Action
    {
        public void action()
        {
            setResult(
                new ClassTypeList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 331:  Throwsopt ::= Throws
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 332:  FormalParameterListopt ::= $Empty
    //
    final class act332 extends Action
    {
        public void action()
        {
            setResult(
                new FormalParameterList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 333:  FormalParameterListopt ::= FormalParameterList
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 334:  Interfacesopt ::= $Empty
    //
    final class act334 extends Action
    {
        public void action()
        {
            setResult(
                new InterfaceTypeList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 335:  Interfacesopt ::= Interfaces
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 336:  InterfaceMemberDeclarationsopt ::= $Empty
    //
    final class act336 extends Action
    {
        public void action()
        {
            setResult(
                new InterfaceMemberDeclarationList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 337:  InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 338:  ForInitopt ::= $Empty
    //
    final class act338 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    }  
    //
    // Rule 339:  ForInitopt ::= ForInit
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 340:  ForUpdateopt ::= $Empty
    //
    final class act340 extends Action
    {
        public void action()
        {
            setResult(
                new StatementExpressionList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 341:  ForUpdateopt ::= ForUpdate
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 342:  ExtendsInterfacesopt ::= $Empty
    //
    final class act342 extends Action
    {
        public void action()
        {
            setResult(
                new InterfaceTypeList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 343:  ExtendsInterfacesopt ::= ExtendsInterfaces
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 344:  Catchesopt ::= $Empty
    //
    final class act344 extends Action
    {
        public void action()
        {
            setResult(
                new CatchClauseList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 345:  Catchesopt ::= Catches
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 346:  VariableInitializersopt ::= $Empty
    //
    final class act346 extends Action
    {
        public void action()
        {
            setResult(
                new VariableInitializerList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 347:  VariableInitializersopt ::= VariableInitializers
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 348:  SwitchBlockStatementsopt ::= $Empty
    //
    final class act348 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchBlockStatementList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 349:  SwitchBlockStatementsopt ::= SwitchBlockStatements
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 350:  SwitchLabelsopt ::= $Empty
    //
    final class act350 extends Action
    {
        public void action()
        {
            setResult(
                new SwitchLabelList(getLeftIToken(), getRightIToken(), true /* left recursive */)
            );
            return;
        }
    }  
    //
    // Rule 351:  SwitchLabelsopt ::= SwitchLabels
    //
    //
    // final class NullAction extends Action
    //
 
    //
    // Rule 352:  Commaopt ::= $Empty
    //
    final class act352 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    } 
    //
    // Rule 353:  Commaopt ::= ,
    //
    final class act353 extends Action
    {
        public void action()
        {
            setResult(
                new Commaopt(getRhsIToken(1))
            );
            return;
        }
    } 
    //
    // Rule 354:  IDENTIFIERopt ::= $Empty
    //
    final class act354 extends Action
    {
        public void action()
        {
            setResult(null);
            return;
        }
    } 
    //
    // Rule 355:  IDENTIFIERopt ::= IDENTIFIER
    //
    final class act355 extends Action
    {
        public void action()
        {
            setResult(
                new IDENTIFIERopt(getRhsIToken(1))
            );
            return;
        }
    }
}


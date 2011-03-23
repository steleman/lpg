%Terminals
    DollarSign ::= '$'
    _
    
    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
%End

%Headers
    /!
        #line $next_line "$input_file$"
        private:
            static const int tokenKind[];
            static int getKind(int _c);
    !/
    /.
        #line $next_line "$input_file$"
        int $action_type::getKind(int _c)
        {
            unsigned char c = (unsigned char) _c;
            return (c < 128 ? tokenKind[c] : 0);
        }
        //
        // Each upper case letter is mapped into its corresponding
        // lower case counterpart. For example, if an 'A' appears
        // in the input, it is mapped into Char_a just like 'a'.
        //
        const int $action_type::tokenKind[] =
        {
            0,    // 000    0x00
            0,    // 001    0x01
            0,    // 002    0x02
            0,    // 003    0x03
            0,    // 004    0x04
            0,    // 005    0x05
            0,    // 006    0x06
            0,    // 007    0x07
            0,    // 008    0x08
            0,              // 009    0x09
            0,              // 010    0x0A
            0,    // 011    0x0B
            0,              // 012    0x0C
            0,              // 013    0x0D
            0,    // 014    0x0E
            0,    // 015    0x0F
            0,    // 016    0x10
            0,    // 017    0x11
            0,    // 018    0x12
            0,    // 019    0x13
            0,    // 020    0x14
            0,    // 021    0x15
            0,    // 022    0x16
            0,    // 023    0x17
            0,    // 024    0x18
            0,    // 025    0x19
            0,    // 026    0x1A
            0,    // 027    0x1B
            0,    // 028    0x1C
            0,    // 029    0x1D
            0,    // 030    0x1E
            0,    // 031    0x1F
            0,           // 032    0x20
            0,     // 033    0x21
            0,     // 034    0x22
            0,           // 035    0x23
            Char_DollarSign,      // 036    0x24
            0,         // 037    0x25
            0,       // 038    0x26
            0,     // 039    0x27
            0,       // 040    0x28
            0,      // 041    0x29
            0,            // 042    0x2A
            0,            // 043    0x2B
            0,           // 044    0x2C
            0,           // 045    0x2D
            0,             // 046    0x2E
            0,           // 047    0x2F
            0,               // 048    0x30
            0,               // 049    0x31
            0,               // 050    0x32
            0,               // 051    0x33
            0,               // 052    0x34
            0,               // 053    0x35
            0,               // 054    0x36
            0,               // 055    0x37
            0,               // 056    0x38
            0,               // 057    0x39
            0,           // 058    0x3A
            0,       // 059    0x3B
            0,        // 060    0x3C
            0,           // 061    0x3D
            0,     // 062    0x3E
            0,    // 063    0x3F
            0,          // 064    0x40
            0,               // 065    0x41
            0,               // 066    0x42
            0,               // 067    0x43
            0,               // 068    0x44
            0,               // 069    0x45
            0,               // 070    0x46
            0,               // 071    0x47
            0,               // 072    0x48
            0,               // 073    0x49
            0,               // 074    0x4A
            0,               // 075    0x4B
            0,               // 076    0x4C
            0,               // 077    0x4D
            0,               // 078    0x4E
            0,               // 079    0x4F
            0,               // 080    0x50
            0,               // 081    0x51
            0,               // 082    0x52
            0,               // 083    0x53
            0,               // 084    0x54
            0,               // 085    0x55
            0,               // 086    0x56
            0,               // 087    0x57
            0,               // 088    0x58
            0,               // 089    0x59
            0,               // 090    0x5A
            0,     // 091    0x5B
            0,       // 092    0x5C
            0,    // 093    0x5D
            0,           // 094    0x5E
            Char__,               // 095    0x5F
            0,       // 096    0x60
            Char_a,               // 097    0x61
            Char_b,               // 098    0x62
            Char_c,               // 099    0x63
            Char_d,               // 100    0x64
            Char_e,               // 101    0x65
            Char_f,               // 102    0x66
            Char_g,               // 103    0x67
            Char_h,               // 104    0x68
            Char_i,               // 105    0x69
            Char_j,               // 106    0x6A
            Char_k,               // 107    0x6B
            Char_l,               // 108    0x6C
            Char_m,               // 109    0x6D
            Char_n,               // 110    0x6E
            Char_o,               // 111    0x6F
            Char_p,               // 112    0x70
            Char_q,               // 113    0x71
            Char_r,               // 114    0x72
            Char_s,               // 115    0x73
            Char_t,               // 116    0x74
            Char_u,               // 117    0x75
            Char_v,               // 118    0x76
            Char_w,               // 119    0x77
            Char_x,               // 120    0x78
            Char_y,               // 121    0x79
            Char_z,               // 122    0x7A
            0,       // 123    0x7B
            0,     // 124    0x7C
            0,      // 125    0x7D
            0,           // 126    0x7E

            0,      // for all chars in range 128..65534
            0              // for '\uffff' or 65535 
        };
    ./
%End

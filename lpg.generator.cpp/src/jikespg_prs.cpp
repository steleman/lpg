#include "jikespg_prs.h"


const char jikespg_prs::is_nullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,1,0,0,
            0,1,0,0,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,1,
            0,0,0,0,0,0,1,0,0,0,
            0
        };

const unsigned char jikespg_prs::prostheses_index[] = {0,
            4,30,26,29,37,38,31,2,3,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            27,28,32,33,34,35,36,39,40,41,
            42,43,44,1
        };

const char jikespg_prs::is_keyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0
        };

const signed char jikespg_prs::base_check[] = {0,
            0,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,1,2,1,2,1,3,1,
            1,1,1,2,4,1,2,1,3,1,
            1,1,1,2,1,2,3,4,3,0,
            2,1,2,4,1,2,1,2,1,2,
            1,2,1,2,1,1,1,4,4,4,
            4,4,4,1,1,1,1,1,1,1,
            1,2,1,2,1,2,1,2,1,2,
            1,1,2,2,3,4,5,3,1,1,
            1,1,0,2,3,2,2,1,1,2,
            1,2,3,3,1,3,1,4,1,1,
            1,1,1,1,0,1,0,2,-2,-32,
            0,-52,-12,0,-11,0,-34,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-13,
            0,-24,0,-30,0,0,0,0,0,-14,
            0,0,0,0,-15,0,-17,0,0,-18,
            0,-21,0,0,-1,0,-25,0,-26,0,
            0,0,0,0,-28,0,-23,0,-19,0,
            -29,0,0,0,0,-3,0,-4,0,-5,
            0,-6,0,-7,0,-8,0,-9,0,-10,
            0,-20,-22,-31,-27,0,0,0,-33,0,
            -35,-36,0,-16,-37,0,0,-38,-39,0,
            0,-40,-41,0,0,-42,-43,0,0,-44,
            -46,0,0,-47,-51,-49,0,0,-53,-66,
            -54,0,-55,0,0,0,0,-56,0,-57,
            -58,-59,-60,0,-45,0,0,0,-61,0,
            -62,-63,0,0,-68,-48,0,0,-69,-70,
            0,-73,-71,0,0,0,0,-75,-76,-77,
            -50,0,0,-78,0,0,-79,-80,-82,-81,
            0,0,0,0,-83,-84,-64,0,0,-65,
            -67,-72,-74,0
        };

const signed char *jikespg_prs::rhs = base_check;

const unsigned short jikespg_prs::base_action[] = {
            8,8,8,8,8,8,8,8,8,8,
            8,8,8,8,8,8,8,8,8,8,
            8,8,8,8,9,9,10,10,11,11,
            31,31,32,12,12,12,13,13,14,14,
            34,34,34,35,35,36,36,37,37,37,
            33,33,15,15,15,18,18,19,19,20,
            20,17,17,16,16,4,4,22,22,22,
            22,22,22,22,38,6,6,6,6,6,
            6,6,21,24,24,25,25,26,26,27,
            27,39,39,28,28,41,41,41,41,2,
            2,2,2,5,5,5,5,5,3,29,
            29,42,42,43,43,30,30,23,23,7,
            7,7,7,7,7,1,1,40,40,463,
            659,22,34,595,3,31,27,587,220,133,
            160,170,175,218,177,216,214,212,182,210,
            208,162,187,189,206,195,201,164,130,229,
            534,4,493,15,654,21,51,321,260,29,
            549,5,110,286,231,549,6,549,8,37,
            636,235,549,12,64,33,58,503,16,595,
            17,137,84,129,250,595,19,652,88,638,
            238,595,20,62,90,275,551,18,551,14,
            551,13,551,11,551,10,551,9,551,7,
            551,2,644,646,71,575,56,60,86,661,
            23,514,117,255,495,540,82,259,548,548,
            261,263,548,548,268,270,548,548,271,272,
            548,526,273,282,601,522,548,128,320,522,
            668,512,35,512,254,132,54,73,512,72,
            512,512,512,522,71,533,70,69,68,154,
            118,532,154,290,285,105,640,293,107,548,
            154,298,536,142,307,299,107,322,154,179,
            154,620,107,308,548,310,309,154,216,154,
            464,107,315,107,316,608,612,622,107,107,
            666,670,664,468,326,326
        };

const unsigned short *jikespg_prs::lhs = base_action;

const unsigned char jikespg_prs::term_check[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            0,1,0,0,34,35,36,0,1,2,
            3,4,5,6,7,8,9,10,11,12,
            13,14,15,16,17,18,19,20,21,22,
            23,24,25,26,27,28,29,34,35,36,
            0,34,35,36,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,0,1,2,3,34,35,
            36,0,1,2,3,4,0,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,0,1,2,3,34,35,36,0,1,
            2,3,4,0,6,7,8,9,10,11,
            12,13,14,15,16,17,18,19,20,21,
            22,23,24,25,26,27,28,29,0,1,
            2,3,34,35,36,0,1,2,3,4,
            0,6,7,8,9,10,11,12,13,14,
            15,16,17,18,19,20,21,22,23,24,
            25,26,27,28,29,0,1,2,3,34,
            35,36,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,2,3,4,0,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,2,3,4,0,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,2,3,4,0,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,2,3,4,0,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,0,1,2,3,0,6,7,
            8,9,5,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,0,1,0,1,4,5,6,7,
            8,9,0,1,0,3,4,5,6,7,
            8,0,1,0,3,0,5,6,7,8,
            9,0,1,0,3,0,5,6,7,8,
            5,0,0,0,1,0,5,4,5,0,
            5,0,10,30,31,32,33,0,0,1,
            0,0,4,5,4,30,31,32,33,0,
            0,30,31,32,33,30,31,32,33,30,
            31,32,33,0,0,0,2,30,31,32,
            33,30,31,32,33,0,0,0,2,30,
            31,32,33,0,0,0,2,0,4,0,
            0,0,2,30,31,32,33,0,1,2,
            3,0,1,2,3,30,31,32,33,0,
            1,0,1,30,31,32,33,30,31,32,
            33,30,31,32,33,0,1,0,1,0,
            5,2,5,0,1,0,1,0,5,10,
            5,0,1,0,1,0,5,4,0,1,
            0,1,4,0,4,0,1,0,1,0,
            1,0,0,10,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0
        };

const unsigned short jikespg_prs::term_action[] = {0,
            49,323,323,323,323,566,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            24,351,1,39,323,323,323,47,323,323,
            323,323,603,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,369,368,371,
            127,323,323,323,48,323,323,323,323,640,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,98,677,434,432,323,323,
            323,49,323,323,323,323,50,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,95,707,434,432,323,323,323,47,323,
            323,323,323,103,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,96,737,
            434,432,323,323,323,48,323,323,323,323,
            326,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,97,767,434,432,323,
            323,323,98,323,323,323,323,797,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,95,323,323,323,323,827,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,96,323,323,323,323,857,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,97,323,323,323,323,887,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,98,323,323,323,323,326,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,95,323,323,323,323,326,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,96,323,323,323,323,326,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,97,323,323,323,323,326,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,323,323,323,323,323,323,323,323,
            323,323,326,49,455,434,432,104,199,222,
            223,180,431,352,225,413,354,359,378,393,
            197,435,224,443,409,415,362,234,135,383,
            441,325,125,239,38,232,452,400,1028,1040,
            1006,1014,125,445,326,447,452,446,1052,1056,
            1048,326,401,34,406,326,402,404,403,407,
            405,326,445,326,447,326,446,449,448,450,
            281,326,94,125,357,326,289,452,356,53,
            304,326,279,425,426,427,428,326,125,391,
            125,125,452,392,452,425,426,427,428,125,
            326,425,426,427,428,425,426,427,428,425,
            426,427,428,125,85,326,434,425,426,427,
            428,242,242,242,242,125,326,326,358,243,
            243,243,243,125,125,326,434,125,452,326,
            93,125,434,246,246,246,246,47,492,434,
            432,48,529,434,432,247,247,247,247,326,
            442,326,440,450,450,450,450,449,449,449,
            449,448,448,448,448,63,391,61,391,111,
            392,438,392,55,391,59,391,326,392,317,
            392,326,417,125,251,326,418,452,125,256,
            125,301,452,46,452,326,439,41,292,40,
            370,326,326,300
        };

const unsigned char jikespg_prs::asb[] = {0,
            131,131,130,130,130,130,130,130,130,130,
            61,30,60,60,60,61,60,60,60,60,
            60,60,26,60,1,30,30,30,30,61,
            29,61,61,54,56,127,56,88,88,88,
            88,88,88,88,95,87,29,94,88,85,
            22,127,22,21,21,21,21,21,21,22,
            93,87,93,85,85,126,126,93,88,93,
            93,125,87,122,93,93,123,88,123,93,
            123,123,123,123
        };

const unsigned char jikespg_prs::asr[] = {0,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,4,
            9,3,7,6,8,1,5,0,1,11,
            12,13,14,15,16,6,9,7,8,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,4,2,0,30,31,32,33,5,
            11,12,13,14,15,16,6,9,7,8,
            17,18,19,20,21,4,22,23,24,25,
            26,27,28,29,1,0,5,30,31,32,
            33,0,3,2,11,12,13,14,15,16,
            6,9,7,8,17,18,19,20,21,4,
            22,23,24,25,26,27,28,1,29,10,
            0,5,3,2,10,1,34,35,36,4,
            11,12,13,14,15,16,6,9,7,8,
            17,18,19,20,21,22,23,24,25,26,
            27,28,29,0
        };

const unsigned char jikespg_prs::nasb[] = {0,
            47,1,25,25,25,25,25,25,25,25,
            23,30,35,44,44,23,44,45,45,45,
            44,45,52,38,49,30,31,30,30,41,
            54,24,25,33,56,58,56,56,56,56,
            56,56,56,56,23,56,31,23,56,23,
            50,27,50,62,62,62,62,62,62,50,
            64,56,64,23,23,60,23,31,56,64,
            31,23,56,23,64,31,64,56,64,31,
            31,64,31,31
        };

const unsigned char jikespg_prs::nasr[] = {0,
            30,29,28,27,26,24,23,22,19,15,
            13,12,11,10,9,14,16,17,18,20,
            21,25,0,43,1,0,35,36,0,1,
            3,0,32,0,1,31,0,1,38,0,
            41,1,0,1,4,0,8,0,1,7,
            0,39,0,40,0,2,0,33,0,37,
            0,6,0,5,0
        };

const unsigned char jikespg_prs::terminal_index[] = {0,
            35,36,15,20,34,10,12,13,11,32,
            4,5,6,7,8,9,14,16,17,18,
            19,21,22,23,24,25,26,27,37,28,
            29,30,31,1,2,3,38
        };

const unsigned char jikespg_prs::non_terminal_index[] = {0,
            0,65,61,64,0,71,66,0,39,40,
            41,42,43,44,45,46,47,48,49,50,
            51,52,53,54,55,56,57,58,59,60,
            62,63,0,67,68,69,70,72,73,0,
            74,75,76,0
        };

const unsigned char jikespg_prs::scope_prefix[] = {0};
const unsigned char jikespg_prs::scope_suffix[] = {0};
const unsigned char jikespg_prs::scope_lhs[] = {0};
const unsigned char jikespg_prs::scope_la[] = {0};
const unsigned char jikespg_prs::scope_state_set[] = {0};
const unsigned char jikespg_prs::scope_rhs[] = {0};
const unsigned char jikespg_prs::scope_state[] = {0};
const unsigned char jikespg_prs::in_symb[] = {0};

const char jikespg_prs::string_buffer[] = {0,
            '%','D','r','o','p','S','y','m','b','o',
            'l','s','%','D','r','o','p','A','c','t',
            'i','o','n','s','%','D','r','o','p','R',
            'u','l','e','s','%','N','o','t','i','c',
            'e','%','A','s','t','%','G','l','o','b',
            'a','l','s','%','D','e','f','i','n','e',
            '%','T','e','r','m','i','n','a','l','s',
            '%','S','o','f','t','K','e','y','w','o',
            'r','d','s','%','E','o','l','%','E','o',
            'f','%','E','r','r','o','r','%','I','d',
            'e','n','t','i','f','i','e','r','%','A',
            'l','i','a','s','%','E','m','p','t','y',
            '%','S','t','a','r','t','%','T','y','p',
            'e','s','%','R','u','l','e','s','%','N',
            'a','m','e','s','%','E','n','d','%','H',
            'e','a','d','e','r','s','%','T','r','a',
            'i','l','e','r','s','%','E','x','p','o',
            'r','t','%','I','m','p','o','r','t','%',
            'I','n','c','l','u','d','e','%','R','e',
            'c','o','v','e','r','%','D','i','s','j',
            'o','i','n','t','P','r','e','d','e','c',
            'e','s','s','o','r','S','e','t','s',':',
            ':','=',':',':','=','?','-','>','-','>',
            '?','|','$','e','m','p','t','y','M','A',
            'C','R','O','_','N','A','M','E','S','Y',
            'M','B','O','L','B','L','O','C','K','E',
            'O','F','E','R','R','O','R','_','S','Y',
            'M','B','O','L','i','n','c','l','u','d',
            'e','_','s','e','g','m','e','n','t','n',
            'o','t','i','c','e','_','s','e','g','m',
            'e','n','t','d','e','f','i','n','e','_',
            's','e','g','m','e','n','t','t','e','r',
            'm','i','n','a','l','s','_','s','e','g',
            'm','e','n','t','e','x','p','o','r','t',
            '_','s','e','g','m','e','n','t','i','m',
            'p','o','r','t','_','s','e','g','m','e',
            'n','t','s','o','f','t','k','e','y','w',
            'o','r','d','s','_','s','e','g','m','e',
            'n','t','e','o','f','_','s','e','g','m',
            'e','n','t','e','o','l','_','s','e','g',
            'm','e','n','t','e','r','r','o','r','_',
            's','e','g','m','e','n','t','r','e','c',
            'o','v','e','r','_','s','e','g','m','e',
            'n','t','i','d','e','n','t','i','f','i',
            'e','r','_','s','e','g','m','e','n','t',
            's','t','a','r','t','_','s','e','g','m',
            'e','n','t','a','l','i','a','s','_','s',
            'e','g','m','e','n','t','n','a','m','e',
            's','_','s','e','g','m','e','n','t','h',
            'e','a','d','e','r','s','_','s','e','g',
            'm','e','n','t','a','s','t','_','s','e',
            'g','m','e','n','t','g','l','o','b','a',
            'l','s','_','s','e','g','m','e','n','t',
            't','r','a','i','l','e','r','s','_','s',
            'e','g','m','e','n','t','r','u','l','e',
            's','_','s','e','g','m','e','n','t','t',
            'y','p','e','s','_','s','e','g','m','e',
            'n','t','d','p','s','_','s','e','g','m',
            'e','n','t','a','c','t','i','o','n','_',
            's','e','g','m','e','n','t','m','a','c',
            'r','o','_','n','a','m','e','_','s','y',
            'm','b','o','l','m','a','c','r','o','_',
            's','e','g','m','e','n','t','t','e','r',
            'm','i','n','a','l','_','s','y','m','b',
            'o','l','p','r','o','d','u','c','e','s',
            'n','a','m','e','d','r','o','p','_','c',
            'o','m','m','a','n','d','d','r','o','p',
            '_','s','y','m','b','o','l','s','d','r',
            'o','p','_','r','u','l','e','s','d','r',
            'o','p','_','r','u','l','e','a','l','i',
            'a','s','_','r','h','s','a','l','i','a',
            's','_','l','h','s','_','m','a','c','r',
            'o','_','n','a','m','e','s','t','a','r',
            't','_','s','y','m','b','o','l','r','u',
            'l','e','s','t','y','p','e','_','d','e',
            'c','l','a','r','a','t','i','o','n','l',
            'i','s','t','t','y','p','e','_','d','e',
            'c','l','a','r','a','t','i','o','n','s'
        };

const unsigned short jikespg_prs::name_start[] = {
            1,1,13,25,35,42,46,54,61,71,
            84,88,92,98,109,115,121,127,133,139,
            145,149,157,166,173,180,188,196,220,223,
            227,229,232,233,239,249,255,260,263,275,
            290,304,318,335,349,363,383,394,405,418,
            433,451,464,477,490,505,516,531,547,560,
            573,584,598,615,628,643,651,655,667,679,
            689,698,707,727,739,744,764,781
        };

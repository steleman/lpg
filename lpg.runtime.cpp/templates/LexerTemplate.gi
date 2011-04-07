%Options programming_language=c++,table=c++, margin=8
%Options prefix=Char_
%Options table=cpp
%Options action=("*.cpp", "/.", "./")
%Options action=("*.h","/!","!/")
-- %Options esc=$,em,scopes

%Eof
    EOF
%End

%Export
    EOF_TOKEN
%End

%Define
    $eof_token /.$_EOF_TOKEN./
    $action_class /.$action_type./
    $exp_class /.ENUM_$exp_type./

    $Header
    /.
            //
            // Rule $rule_number:  $rule_text
            //
            #line $next_line "$input_file$"./
    

    $BeginActions
    /.  #line $next_line "$input_file$"
        void $action_class::ruleAction(int ruleNumber)
        {
            using namespace $exp_class;
            switch(ruleNumber)
            {./

    $BeginAction
    /.$Header
                case $rule_number: {
     ./

    $EndAction
    /.
          break;
                }./

    $NoAction
    /. $Header
                case $rule_number:
                break; ./

    $EndActions
    /.
                default:
                    break;
            }
            return;
        }./
%End

%Headers

    /!  #ifndef $action_class$_INCLUDED
        #define $action_class$_INCLUDED
        #line $next_line "$input_file$"

        #include "lpg/runtime/tuple.h"
        #include "lpg/runtime/LexStream.h"
        #include "lpg/runtime/LexParser.h"
        #include "$prs_type.h"

        class PrsStream;

        class $action_class : public LexStream
        {
            LexParser<$prs_type, $action_class> lp_;
            $action_class();
            $action_class($action_class&);

        public:
            virtual ~$action_class();

            virtual void ruleAction(int ruleNumber);

            virtual int lexer(PrsStream* prsStream);

            inline int getLeftSpan()
            { return lp_.getToken(1); }

            inline int getRightSpan()
            { return lp_.getLastToken(); }

            inline void makeToken(int startOffset, int endOffset, int kind)
            {
                prsStream_->makeToken(inputChars_, startOffset, endOffset, kind);
            }

            inline void makeComment(int kind)
            {
                prsStream_->makeAdjunct(inputChars_, getLeftSpan(), getRightSpan(), kind);
            }

            inline int getRhsFirstTokenIndex(int i) {
                return lp_.getFirstToken(i);
            }

            inline int getRhsLastTokenIndex(int i) {
                return lp_.getLastToken(i);
            }
    !/

    /.  #line $next_line "$input_file$"
        #include <limits.h>

        using namespace std;

        #include "$sym_type.h"
        #include "$kw_lexer_class.h"
        #include "$action_class.h"

        namespace $exp_class
        {
          #include "$exp_type.h"
        };

        $action_class::~$action_class() { }

        int $action_class::lexer(PrsStream* prsStream)
        {
            prsStream_ = prsStream;
            makeToken(0, -1, 0);
            lp_.parseCharacters();
            prsStream_->makeToken(inputChars_, getStreamIndex(), getStreamIndex(), ENUM_LPGLexerexp::EOF_TOKEN);
            return 0;
        }        
    ./
%End

%Rules
    /.$BeginActions./
%End

%Trailers
    /!  #line $next_line "$input_file"
        };
        #endif
    !/

    /.  #line $next_line "$input_file"
        $EndActions
    ./
%End

%Options action=("*.cpp", "/.", "./")
%Options action=("*.h","/!","!/")
%Options programming_language=c++,nobacktrack
%Options table=c++,margin=8,error_maps
%Options esc=$,em,scopes

$Eof
    EOF_TOKEN
$End

$Error
    ERROR_TOKEN
$End

$Define
    $action_class /.$action_type./
    $Header
    /.
            //
            // Rule $rule_number:  $rule_text
            //
            #line $next_line "$input_file$"./
    

    $BeginActions
    /.
        void $action_class::ruleAction(int ruleNumber)
        {
            switch(ruleNumber)
            {./

    $BeginAction
    /.$Header
                case $rule_number: {
                  $symbol_declarations./

    $EndAction
    /.          break;
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
$End

$Headers

    /!  #ifndef $action_class$_INCLUDED
        #define $action_class$_INCLUDED
        #line $next_line "$input_file$"
        #include "lpg/runtime/tuple.h"
        #include "lpg/runtime/Stacks.h"
        #include "$prs_type.h"

        struct Ast;
        struct LexStream;

        class $action_class : public PrsStream
        {
            LexStream *lexStream_;
            DeterministicParser<$action_class, $prs_type, $action_class> dtParser_;
        public:
            $action_class(LexStream* lexStream);
            virtual ~$action_class();
            virtual void* parser();
            void ruleAction(int ruleNumber);

            inline void setResult(void* sym) { dtParser_.setSym(sym); }
            inline void* getRhsSym(int i) { return dtParser_.getSym(i); }
            inline const char* getTokenText(int i)
            {
                int t = dtParser_.getToken(i);
                return tokens_[t].getValue();
            }

            inline int getRhsTokenIndex(int i)
              { return dtParser_.getToken(i); }
            inline Token* getRhsIToken(int i)
              { return PrsStream::getIToken(getRhsTokenIndex(i)); }
            inline int getRhsFirstTokenIndex(int i)
              { return dtParser_.getFirstToken(i); }
            inline Token* getRhsFirstIToken(int i)
              { return PrsStream::getIToken(getRhsFirstTokenIndex(i)); }
            inline int getRhsLastTokenIndex(int i)
              { return dtParser_.getLastToken(i); }
            inline Token* getRhsLastIToken(int i)
              { return PrsStream::getIToken(getRhsLastTokenIndex(i)); }

            inline int getLeftSpan()
              { return dtParser_.getFirstToken(); }
            inline Token* getLeftIToken()
              { return PrsStream::getIToken(getLeftSpan()); }
            inline int getRightSpan()
              { return dtParser_.getLastToken(); }
            inline Token* getRightIToken()
              { return PrsStream::getIToken(getRightSpan()); }

    !/

    /.  #line $next_line "$input_file$"
        #include <limits.h>
        using namespace std;

        #include "$action_class.h"
        #include "lpg/runtime/LexStream.h"
        #include "$ast_directory/AstNodes.h"

        $action_class::$action_class(LexStream *lexStream)
           : lexStream_(lexStream), dtParser_(this, this) {}

        $action_class::~$action_class() {}

        void* $action_class::parser()
        {
            return dtParser_.parse(0);
        }
    ./
$End


$Rules
    /.$BeginActions./
$End

$Trailers
    /!
        #line $next_line "$input_file"
        };
        #endif
    !/

    /.
        #line $next_line "$input_file"
        $EndActions
    ./
$End
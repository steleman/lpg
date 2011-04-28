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

        struct CharStream;
        class $action_class : public PrsStream
        {
            CharStream *charStream_;
            DeterministicParser<$action_class, $prs_type, $action_class> dtParser_;
        public:
            $action_class(CharStream* charStream);
            virtual ~$action_class();
            virtual void* parser();
            void ruleAction(int ruleNumber);

            template<typename T>
            inline void setResult(T sym) { dtParser_.setSym((void*)sym); }
            inline void* getRhsSym(int i) { return dtParser_.getSym(i); }
            inline const char* getTokenText(int i)
            {
                int t = dtParser_.getToken(i);
                return tokens_[t].getValue();
            }
    !/

    /.  #line $next_line "$input_file$"
        #include <limits.h>
        using namespace std;

        #include "$action_class.h"
        #include "lpg/runtime/CharStream.h"

        $action_class::$action_class(CharStream *charStream)
           : charStream_(charStream), dtParser_(this, this) {}

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

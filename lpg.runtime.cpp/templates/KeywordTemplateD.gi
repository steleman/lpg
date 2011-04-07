%Options programming_language=c++,margin=8
%Options prefix=Char_
%Options table=cpp
%Options action=("*.cpp", "/.", "./")
%Options action=("*.h","/!","!/")
%Options esc=$,em,scopes

%Eof
    EOF
%End

%Error
    EOF
%End

%Define
    $eof_char /.Char_EOF./
    $setResult /.keywordKind_[$rule_number] = ./
    $Header
    /.
            //
            // Rule $rule_number:  $rule_text
            //./
    $BeginAction /.$Header./
    $EndAction /../
%End

%Headers
    /!  #ifndef $action_type$_INCLUDED
        #define $action_type$_INCLUDED
        #line $next_line "$input_file$"

        class $action_type
        {
            const char* inputChars_;
            static int* keywordKind_;
        public:
            $action_type(const char* inputChars, int identifierKind);
            int lexer(int curtok, int lasttok);
            const int* getKeywordKinds() { return keywordKind_; }
            void setInputChars(const char* inputChars) { inputChars_ = inputChars; }
    !/
    /.  #line $next_line "$input_file$"
        #include "$action_type.h"
        #include "$prs_type.h"
        #include "$sym_type.h"

        int* $action_type::keywordKind_ = NULL;

        int $action_type::lexer(int curtok, int lasttok)
        {
            enum {
                START_STATE   = $prs_type::START_STATE,
                NUM_RULES     = $prs_type::NUM_RULES,
                ACCEPT_ACTION = $prs_type::ACCEPT_ACTION,
                ERROR_ACTION  = $prs_type::ERROR_ACTION
            };

            int current_kind = getKind(inputChars_[curtok]);
            int act;

            for (act = $prs_type::t_action(START_STATE, current_kind);
                 act > NUM_RULES && act < ACCEPT_ACTION;
                 act = $prs_type::t_action(act, current_kind))
            {
                curtok++;
                current_kind = (curtok > lasttok
                                       ? $eof_char
                                       : getKind(inputChars_[curtok]));
            }

            if (act > ERROR_ACTION)
            {
                curtok++;
                act -= ERROR_ACTION;
            }

            return keywordKind_[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
        }
    ./
%End

%Rules
    /.
        #line $next_line "$input_file$"
        $action_type::$action_type(const char* inputChars, int identifierKind)
        {
            #include "$exp_type.h"
            inputChars_ = inputChars;
            if (! keywordKind_) 
            {
                int length = $num_rules;
                keywordKind_ = new int[length + 1];
                keywordKind_[0] = identifierKind;
    ./
%End

%Trailers
    /!
        #line $next_line "$input_file$"
        };
        #endif
    !/
    /.
        #line $next_line "$input_file$"
                for (int i = 0; i < length; i++)
                {
                    if (keywordKind_[i] == 0)
                        keywordKind_[i] = identifierKind;
                }
            }
        }
    ./
%End

--
-- E N D   O F   T E M P L A T E
--

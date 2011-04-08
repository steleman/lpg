%Rules
    U0009 -> HT
    U000A -> LF
    U000D -> CR
    U0020 -> Space

    Aa -> A | a
    Bb -> B | b
    Cc -> C | c
    Dd -> D | d
    Ee -> E | e
    Ff -> F | f
    Gg -> G | g
    Hh -> H | h
    Ii -> I | i
    Jj -> J | j
    Kk -> K | k
    Ll -> L | l
    Mm -> M | m
    Nn -> N | n
    Oo -> O | o
    Pp -> P | p
    Qq -> Q | q
    Rr -> R | r
    Ss -> S | s
    Tt -> T | t
    Uu -> U | u
    Vv -> V | v
    Ww -> W | w
    Xx -> X | x
    Yy -> Y | y
    Zz -> Z | z

    AsciiLetter -> Aa 
                 | Bb 
                 | Cc 
                 | Dd 
                 | Ee 
                 | Ff 
                 | Gg 
                 | Hh 
                 | Ii 
                 | Jj 
                 | Kk 
                 | Ll 
                 | Mm 
                 | Nn 
                 | Oo 
                 | Pp 
                 | Qq 
                 | Rr 
                 | Ss 
                 | Tt 
                 | Uu 
                 | Vv 
                 | Ww 
                 | Xx 
                 | Yy 
                 | Zz

    AsciiDigit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 

    NonSpaceChar ->
             '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'
    
    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z
    
           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'
    
    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z
    
           | '{'
           | '|'
           | '}'
           | '~'
    
           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    NonSpaceChar[^?>] ->
             '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
    --     | '>'
    --     | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    SpaceChar -> U0009
               | U000D 
               | U0020
               | U000A

    Char[^-] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
    --     | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^%&"] -> SpaceChar
           | '!'
    --     | '"'
           | #
           | '$'
    --     | '%'
    --     | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^%&'] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
    --     | '%'
    --     | '&'
    --     | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^<&"] -> SpaceChar
           | '!'
    --     | '"'
           | #
           | '$'
           | '%'
    --     | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
    --     | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^<&'] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
    --     | '&'
    --     | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
    --     | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^"] -> SpaceChar
           | '!'
    --     | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^']  -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
    --     | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^<&]] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
    --     | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
    --     | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
    --     | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^<&]>] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
    --     | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
    --     | '<'
           | '='
    --     | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
    --     | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^]>] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
    --     | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
    --     | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^>] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
    --     | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^?>] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
    --     | '>'
    --     | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^]] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
    --     | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^!] -> SpaceChar
    --     | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^<]] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
    --     | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

           | '['
           | '\'
    --     | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Char[^[] -> SpaceChar
           | '!'
           | '"'
           | #
           | '$'
           | '%'
           | '&'
           | "'"
           | '('
           | ')'
           | '*'
           | '+'
           | ','
           | '-'
           | '.'
           | '/'

    --
    -- The following are subsumed by the class Digit
    --
    -- | 0
    -- | 1
    -- | 2
    -- | 3
    -- | 4
    -- | 5
    -- | 6
    -- | 7
    -- | 8
    -- | 9

           | ':'
           | ';'
           | '<'
           | '='
           | '>'
           | '?'
           | '@'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | A
    -- | B
    -- | C
    -- | D
    -- | E
    -- | F
    -- | G
    -- | H
    -- | I
    -- | J
    -- | K
    -- | L
    -- | M
    -- | N
    -- | O
    -- | P
    -- | Q
    -- | R
    -- | S
    -- | T
    -- | U
    -- | V
    -- | W
    -- | X
    -- | Y
    -- | Z

    --     | '['
           | '\'
           | ']'
           | '^'
           | '_'
           | '`'

    --
    -- The following are subsumed by the class BaseChar
    --
    -- | a
    -- | b
    -- | c
    -- | d
    -- | e
    -- | f
    -- | g
    -- | h
    -- | i
    -- | j
    -- | k
    -- | l
    -- | m
    -- | n
    -- | o
    -- | p
    -- | q
    -- | r
    -- | s
    -- | t
    -- | u
    -- | v
    -- | w
    -- | x
    -- | y
    -- | z

           | '{'
           | '|'
           | '}'
           | '~'

           | BaseChar
           | Ideographic
           | CombiningChar
           | Extender
           | Digit
           | OtherValidChar
    
    Letter[^Xx] ->
             Aa
           | Bb
           | Cc
           | Dd
           | Ee
           | Ff
           | Gg
           | Hh
           | Ii
           | Jj
           | Kk
           | Ll
           | Mm
           | Nn
           | Oo
           | Pp
           | Qq
           | Rr
           | Ss
           | Tt
           | Uu
           | Vv
           | Ww
    --     | Xx
           | Yy
           | Zz

           | NonAsciiBaseChar
           | Ideographic

    NameChar[^Mm] ->    
             Aa
           | Bb
           | Cc
           | Dd
           | Ee
           | Ff
           | Gg
           | Hh
           | Ii
           | Jj
           | Kk
           | Ll
    --     | Mm
           | Nn
           | Oo
           | Pp
           | Qq
           | Rr
           | Ss
           | Tt
           | Uu
           | Vv
           | Ww
           | Xx
           | Yy
           | Zz

           | NonAsciiBaseChar
           | Ideographic
           | Digit
           | '.'
           | '-'
           | '_'
           | ':'
           | CombiningChar
           | Extender 

    NameChar[^Ll] ->    
             Aa
           | Bb
           | Cc
           | Dd
           | Ee
           | Ff
           | Gg
           | Hh
           | Ii
           | Jj
           | Kk
    --     | Ll
           | Mm
           | Nn
           | Oo
           | Pp
           | Qq
           | Rr
           | Ss
           | Tt
           | Uu
           | Vv
           | Ww
           | Xx
           | Yy
           | Zz

           | NonAsciiBaseChar
           | Ideographic
           | Digit
           | '.'
           | '-'
           | '_'
           | ':'
           | CombiningChar
           | Extender 

    PubidChar[^'] -> U0020
                   | U000D
                   | U000A
                   | AsciiLetter
                   | AsciiDigit
                   | '-'
                   | '('
                   | ')'
                   | '+'
                   | ','
                   | '.'
                   | '/'
                   | ':'
                   | '='
                   | '?'
                   | ';'
                   | '!'
                   | '*'
                   | '#'
                   | '@'
                   | '$'
                   | '_'
                   | '%'
%End




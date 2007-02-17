
'Single-quoted string (should be recognized)'

"Double-quoted string (should be recognized)"

"Inconsistently-quoted string (should not be recognized)'

'Inconsistently-quoted string (should not be recognized)"

'String with starting quote only (should not be recognized)

String with ending quote only (should not be recognized)"

"Double-quoted string containing 'single-quoted' string (should be recognized)"

'Single-quoted string containing "doube-quoted" string (should be recognized)'

"Double-quoted string containing "double-quoted" string (bad!)"


"String with a
line break in it (bad!"



/*
 * Hex escapes
 * Incorrect forms may be treated in various ways:
 * - Incorrect forms that have too few characters may simply be unrecognized;
 *   this seems appropriate
 * - Incorrect forms that have too many characters may be recognized as
 *   strings or identifiers, depending on whether they're quoted or not;
  *  this may be appropriate if the form has a prefix that matches
 *   a legal escape and that, combined with the remainder, leads to a
 *   recognizable element; such cases should be checked individually
 * - Other results from incorrect forms should be regarded with a high
 *   level of suspicion
 *
 */

/* x-escapes--take two digits */
 
// '\xAA'		single-quoted x-escaped two-digit form (correct)
'\xAA'

// "\x12"		double-quoted x-escaped two-digit form (crorrect)
"\x12"

// "\xA"		quoted one-digit form (incorrect)
"\xA"

// "\xABC"		quoted three-digit form (incorrect)
"\xABC"

// \x12			unquoted x-escaped two-digit form (incorrect)
\x12

/* u-escapes--take four digits */

// "\uABCD"		double-quoted u-escaped four-digit form (correct)
"\uABCD"

// '\uABCD'		single-quoted u-escaped four-digit form (correct)
"\uABCD"

// "\u12"		quoted two-digit form (incorrect)
"\u12"

// "\u123456"		quoted six-digit form (incorrect)
"\u123456"

// \uABCD		unquoted u-escaped four-digit form (incorrect)
\uABCD

/* U-escapes--take eight digits */

// "\U12345678"		double-quoted U-escaped eight-digit form (correct)
"\U12345678"

// '\U12345678'		single-quoted U-escaped eight-digit form (correct)
'\U12345678'

// "\U12"		quoted two-digit form (incorrect)
"\U12"

// "\U1234567890"	quoted ten-digit form (incorrect)
"\U1234567890"

// \U12345DEF		unquoted, U-escaped wrong form--eight digits (incorrect)
\U12345DEF


/*
 * 0 escapes
 * Caution:  Not sure what purpose these serve
 * Presumably should be recognized as strings (if correct)
 */

// "\0a123"		should be correct
"\0a123"

// '\0a123'		should be correct
'\0a123'

// "\0abcd"		should be correct
"\0abcd"

// "\0123"		should be incorrect (digit follows initial 0)
"\0123"

// \0a123		should be incorrect (not quoted)
\0a123


/*
 * Control escapes
 */

// "\b"
"\b"

// "\f"
"\f"

// "\n"
"\n"

// '\r'
'\r'

// '\t'
'\t'

// '\v'
'\v'

/*
 * A selection of identity escapes
 * (could include most, if not all, punctuation charactes and more)
 *
 */

// "\ "
"\ "

// "\	"
"\	"

// "\$"
"\$"

// "\!"
"\!"


// "\\"
"\\"


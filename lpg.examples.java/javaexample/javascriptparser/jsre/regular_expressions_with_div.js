
/*
 * The following should all be recoginzed as REGULAREXPRESSION:
 */

// /\d{2,4}/
/\d{2,4}/

// /\w{3}\d?/
/\w{3}\d?/

// /\s+java\s+/
/\s+java\s+/

// /[^]/
/[^]/

// /[a-z]+(\d)/
/[a-z]+(\d)/

// /java(script)?/
/java(script)?/

// /(ab | cd)+ | ef/
/(ab | cd)+ | ef/

// /([Jj]ava([Ss]cript)?)\sis\s(fun\w*)/
/([Jj]ava([Ss]cript)?)\sis\s(fun\w*)/

// /['"][^'*]*['"]/
/['"][^'*]*['"]/

// /(['"])[^'"]*\1/
/(['"])[^'"]*\1/

// / 123 /
/ 123 /


// Can you have an empty regular expression???

/*
 * The following lines should NOT be recoginzed as REGULAREXPRESSION,
 * although they may contain legal regular expressions and may also
 * contain properly unrecognizable constructs
 */
 
// /=/		/* Comment after dangling slash */
// Note:  trailing '/' in "/=/" can be interpreted as start of RE;
// won't (and shouldn't) recognize a following comment as such
/=/		/* Comment after dangling slash */

// /=	/* SLASHASSIGN operator */
/=		/* SLASHASSIGN operator */

// \/d{2,4}/
\/d{2,4}/

// /(ab-cd) | ef
/(ab-cd) | ef

// /(/\/
/(/\/


/*
 * The following are written to look like DIVISION examples but contain
 * typographical arrangements that can look like REGULAREXPRESSION.  Depending
 * on what you're looking for, that's what you should find (although some of
 * the formulations may appear a bit odd).  You may need to read each case
 * closely to assure that it is correct ... (Note:  Under the RE interpretation,
 * '/' will not be recognized as a division operator--may be an unknown token type)
 */
 
// var div0 = 2/34;
var div0 = 2/34;

// var div1 = 100 / 2 / 4;
var div1 = 100 / 2 / 4;

// var div1a = 101/3/5;
var div1a = 101/3/5;

// Note the effect of LineComments on lines with REs:

// var mixed2 = 100 / 8 * 2
var mixed2 = 100 / 8 * 2

// var mixed2 = 100 / 8 * 2		// No ';'
var mixed2 = 100 / 8 * 2		// No ';'

// var div2 = 200 / i;
var div2 = 200 / i;
//

// var div3 = 300 / i / 8
// Note:  No ';' and identifier, but putting a comment
// after the test case on the same line gives rise to
// 		"... / 8 // Note: ..."
// in which the "/ 8 /" gets recognized as an RE
var div3 = 300 / i  / 8	

// var mixed1 = 101 / 9 * 3;
var mixed1 = 101 / 9 * 3;

// var multi = a / b / c / d
var multi = a / b / c / d


/*
 * A couple of expressions that include REGULAREXPRESSION
 * (in whole or in part)
 */
 
// var s2 = 3/4 + /{abc}/
var s2 = 3/4 + /{abc}/

// /{def}/
/{def}/		/* conclude with a legal RE to see if recognized after all */

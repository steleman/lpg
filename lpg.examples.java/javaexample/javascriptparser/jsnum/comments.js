

'Single quote string'

"Double quote string"

// LineComment alone on line

/* SingleLineBlockComment alone on line */

/*
MultilineBlockComment
over four lines
*/


/*
 * Note:  the NextInputElementNum rule requires (in effect) that whitespace
 * precede any identifier or keyword (as well as any numeric literal).  So
 * keywords at the start of a line will be seen as "unexpected" characters
 * and keyword tokens will not be recognized.
 *     For this reason, the following lines that begin with "var" have
 * all be indented
 */


	var a 	// LineComment at end of line

	var b	/* SingleLineBlockComment at end of line */

	var c	/* MultilineBlockComment
			   starting at end of line
			*/

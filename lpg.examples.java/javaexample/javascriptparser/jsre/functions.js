/*
 * Note:  This example is based on a real loan-calculator function,
 * but it has been edited to include some arbitrary language features
 * and is no longer sensible.
 * 
 * Almost everything here should be recognized in both the RE and DIV
 * lexing modes.  The two notable exceptions are as follows:
 * - The RE lexer should not recognize the division operator at line 8
 *   in the function; it should be reported as an unknown token kind
 * - The DIV lexer should not recognize the regular expression at
 *   line 25 in the function; it should be reported as nonsensical
 *   string of tokens, some of which may be of unknown kinds
 * Comments may also be unrecognized, but comments are not intended
 * to be exported by the lexers--particular versions of the RE and DIV
 * lexers may export comments in case they may be useful in SAFARI.
 */

function loanCalculator() {

  var tmpValue = "tmp" + "value";
  var principal = document.loandata.principal.value;
  var interest = 8.5f;
 
  // should not be recognized as division in RE mode
  var n = interest / 12;

  var x = Math.pow(1 + interest, payments);
  var monthly = (principal * x * interest) - (x+1);
  
  	if (!isNaN(monthly) &&
	   (monthly != Number.POSITIVE_INFINITY) &&
	   (monthly != Number.NEGATIVE_INFINITY))
	{
	  	document.loandata.payment.value = round(monthly);
	} else {
	  	document.loandata.payment.value = "Couldn't compute";
	}
	
	while (today == "tuesday") {}

	/* should not be recognized as regular expression in DIV mode */
	var re = /([Jj]ava([Ss]cript)?)\sis\s(fun\w*)/;
}

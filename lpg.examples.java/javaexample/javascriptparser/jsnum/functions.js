/*
 * Nothing special, just several lines of typical syntax
 *
 * Note:  the NextInputElementNum rule requires (in effect) that whitespace
 * precede any identifier or keyword (as well as any numeric literal).  So
 * keywords at the start of a line will be seen as "unexpected" characters
 * and keyword tokens will not be recognized.  Likewise, identifiers that
 * begin immediately following a punctuation mark (such as a dot or comma)
 * will likewise be unrecognized.
 *     Several of the lines in the function below use keywords and identifiers
 * in situations in which they are not preceded by whitespace.  As a result,
 * they will not be recognized by JSNUMLexer.  This behavior may seem strange,
 * but it seems to be correct, and the elements that go unrecognized by
 * this lexer may instead by recognized alternative lexers that, it seems,
 * should come into play in these circumstances.
 */

function foo() {
  var tmp = "tmp value";
  var principal = document . loandata . principal . value;
  var interest = document.loandata.interest.value / 100 / 12;
  var interest = document.loandata.interest.value / 100;
  var interest /= 12;
  var payments = document.loandata.years.value * 12;
  
  var x = Math.pow(1 + interest, payments);
  var monthly = (principal * x * interest)/(x-1);
  
  	if (!isNaN(monthly) &&
	   (monthly != Number.POSITIVE_INFINITY) &&
	   (monthly != Number.NEGATIVE_INFINITY))
	{
	  document.loandata.payment.value = round(monthly);
	  document.loandata.total.value = round(monthly * payments);
	  document.loandata.totalinterest.value = round(monthly * payments - principal);
	  
/*	  alert("Is a number!");	*/
	  

	} else {
	
	  document.loandata.payment.value = "Couldn't compute";
	  document.loandata.total.value = "Couldn't compute";
	  document.loandata.totalinterest.value = "Couldn't compute";

//	  alert("Is not a number!");
	}
 
}

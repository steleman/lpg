/*
 * Nothing special, just several lines of typical syntax
 */

function foo() {
  var tmp = "tmp value";
  var principal = document.loandata.principal.value;
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

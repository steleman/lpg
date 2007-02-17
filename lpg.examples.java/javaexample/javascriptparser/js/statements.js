
// Expression statements

s = "Hello " + name;

i *= e;

delete o.x;


// Compound (block) statements

{
	x = Math.PI;
	cx = Math.cos(x);
	alert("cos(" + x + ") = " + cx);
}


// If statements

if (username == null)
	username = "John Doe";

if (!username) username = "John Doe";

if ((address == null) || (address == "")) {
	address = "undefined";
	alert("Please specify a mailing address");
}

if (username != null)
	alert("Hello " + username);
else {
	username = prompt("Welcome!\n What is your name?");
	alert("Hello " + username);
}


i = j = 1;
k = 2;
if (i == j)
	if (k == j) {
		document.write("i == j == k");
	} else {
		docment.write("i == j != k");
	} 
else {
	document.write("i != j");
}


if (n == 1) {
	alert("n == 1");
} else if (n == 2) {
	alert("n == 2");
} else if (n == 3) {
	alert("n == 3");
} else {
	alert("I don't know what n equals");
}


// Switch statements

switch(typeof x) {
	case 'number':		// do number thing
		return x.toString(16);
	case 'string':		// do string thing
		return '=' + x + '"';
	case 'boolean':		// do boolean thing
		return x.tString().toUpperCase();
	default:
		return x.toString()
}

switch(whatever) {
	case 60*60*24:
		return 60*60*24;
	case Math.PI:
		return Math.PI;
	case n+1:
		n++;
		return Math.PI;
	default: {
		return false;
	}
}


// While statement

var count = 0;
while (count < 10) {
	document.write(count + "<br>");
	count++;
}


// Do/while statement

var i = 0;
do {
	document.write(a[i] + "<br>");
} while (++i < a.length);



// For statement

for (var count = 0; count <= 9; count++)
	document.write(count + "<br>");

for (i = 0, j = 10; i < 10; i++, j--)
	sum += i * j;


// For/in statement

for (var prop in my_object) {
	document.write("name:  " + prop + "; value:  " + my_object[prop], "<br>");
}

var o = {x:1, y:2, z:3};
var a = new Array();
var i = o;
for(a[i++] in o) /* empty loop body */;

// 22 Mar 2006:  Note on parser behavior:
// With the comment in the preceding statement, it seems that following
// comments are not noted (not even as unexpected tokens).  Although the
// semicolon is noted, perhaps it and all of the surrounding comments are
// considered to be one unexpected region


// Labels

parser:
	while(token != null) {
		alert(token);
		token = lexer.nextToken();
	}


// Break statement

	while(true) {
		token = lexer.nextToken();
		if (token == null) break;
		alert(token);
	}

var i = 0;
outer:
while (i < 1000) {
	inner:
	while(true) {
		token = lexer.nextToken();
		if (token == null) break outer;
		alert(token);
		i++;
	}
}


outer:
for (var i = 0; i < 10; i++) {
	inner:
	for (var j = 0; j > 10; j++) {
		if (j > 3) break;			// quit inner loop
		if (i == 2) break inner;	// quit inner loop
		if (i == 4) break outer;	// quit outer loop
		document.write("i = " + i + " j = " + j + "<br>");
	}
}


// Continue statement

continue;

continue outer;

for(i = 0; i < data.length; i++) {
	if (datat[i] == null)
		continue;	// can't do anything
	total += data[i];
}


// Var statement

var i;

var j = 0;

var p, q;

var greeting = "hello " + name;

// 22 Mar 2006:  Note on parser behavior:
// Originally the following did not include the "f" after "2.34",
// which lead to a message of '"VariableInitializerAllowIn" is invalid'
// (although the example was taken from the JavaScript book).
// TODO:  Check whether use of "LetterF" is required for floats

var x = 2.34f, y = Math.cos(0.75), r, theta;


// Function statement

function welcome() { alert("Welcome!"); }

function print(msg) {
	document.write(msg, "<br>");
}

function hypotenuse(x, y) {
	return Math.sqrt(x*x + y*y);
}


function factorial(n) {
	if (n <= 1) return 1;
	return n * factorial(n-1);
}

var v;

// 22 Mar 2006:  Note on parser behavior:
// Putting a comment directly after a function seems to result
// in the error '"SemicolonFull" is invalid', and the comment is
// not recognized as an unexpected token.  For that reason added
// var statement before these comments.
// TODO:  Check whether this makes sense.

// Return statement

return;

return false;

return x * x;


function foo(obj) {
	if (obj == null) return;
}

var v;


// Throw statement


throw false;

throw new Error();

// 22 Mar 2006:  Note on parser behavior:
// Note:  Line comments on separate lines in the middle of a function
// are not ignored as unexpected tokens and create problems in parsing
// the rest of the function
function factorial(x) {
	if (x < 0) throw new Error("x must not be negative");
	return n;
}


var v;

// Try/catch/finally statement

try {
	// do the normal thing here
	var x = 12;
} catch (e) {
	// catch an exception
	alert("Exception:  " + e.toString());
} finally {
	// do what's here in any case (normal or abnormal termination)
}

while (i < a.length) {
	try {
		if ((typeof a[i] != "number") || (isNaN(a[i])))
			continue;
		total += a[i];
	}
	finally {
		i++;
	}
}



// With statement

with(o)
	alert(o.toString());
	
with(frames[1].document.forms[0]) {
	name.value = "";
	address.value = "";
	email.value = "";
}


// Empty statement

;



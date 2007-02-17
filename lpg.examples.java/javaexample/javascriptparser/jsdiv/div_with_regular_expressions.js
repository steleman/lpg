/*
 * This file contains test bases for division operators in various
 * situations as well as some cases that should not be recognized
 * as division, including other constructs that involve slahses,
 * notably comments and regular expressions.
 * 
 * Note that some of these cases may represent lexical combinations
 * that may not be recognized by a parser.
 */

/* Acceptable statements, expressions and operators */

// var n = 3 / 4;
var n = 3 / 4;

// var n2 = 3 / 4
var n2 = 3 / 4;

// var m = 100 / 5 / 2;
var m = 100 / 5 / 2;

// var p = 22 / 7;
var p = 22 / 7;

//9 / 3; 	(parser may insert SemicolonFull if none present)
9 / 3;

//	/
/

// /=
/=

//var o /= 5;
var o /= 5;

/* With comments in line ... */

// comment 1

// comment 2


//var p /= 4	// Line comment in line
var p /= 4	// Line comment in line

//var p2 /= 4	//= Line comment in line
var p2 /= 4	//= Line comment in line

// var p3 /= 4 /* *** Single-line block comment */
var p3 /= 4 /* *** Single-line block comment */

/* With other operators ... */

// var q *= 12 /= 4;
var q *= 12 /= 4;

// var q2 /= 12 *= 4;
var q2 /= 12 *= 4;

//var q3 = 13 / 5 * 5 - 5;
var q3 = 13 / 5 * 5 - 5;


/* Unacceptable statements and expressions */

// /{a,b,c}/  (regular expression)
/{a,b,c}/

// var x = s / {{{	(statement with junk)
var x = s / {{{

// var y = s / /{a,b,c}	(statement with div and regular expression)
var y = s / /{a,b,c}


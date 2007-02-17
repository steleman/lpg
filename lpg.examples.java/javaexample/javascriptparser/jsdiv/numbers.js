/*
 * Tests of numerical representations and misrepresentations.
 */


// 12345	Regular integer, no leading zeros
12345

// 1 2 3	Multiple integers on one line
1 2 3

// 123L		L-designated long
123L

// 123l		l-designated long
123l

// 456F		F-designated float, no fractional part
456F

// 456f		f-designated float, no fractional part
456f

// 123.456F	F-designated float, fractional part
123.456F

// 0.987f	f-designated float, fractional part
0.987

// 123.456	Float in form, not "LetterF" designated
123.456

// 12345UL	UL-designated unsigned long
12345UL

// 12345ul	ul-designated undigned long
12345ul

// 9999999999999999999999999999999999	A really long number (no lexical rule against it)
9999999999999999999999999999999999


// 890Ul	Unsigned long with mixed-case designation--not allowed
890Ul

// 890L		Unsigned long with mixed-case designation--not allowed
890uL

// 01234	Integer with leading 0--not allowed as such (0 should be separated)
01234

// 001234	Integer with leading 0s--not allowed as such (0s should be separated)
001234

// 123E2F	F-designated E-exponentiated floating point with unsigned exponent (correct)
123.4E2F

// 123e3f	f-designated e-exponentiated floating point with unsigned exponent (correct)
123.4e3f

// 123E-2F	F-designated E-exponentiated floating point with negative exponent (correct)
123.4E-2F

// 123e-3f	f-designated e-exponentiated floating point with negative exponent (correct)
123.4e-3f

// 123E+2F	F-designated E-exponentiated floating point with positive exponent (correct)
123.4E+2F

// 123e+3f	f-designated e-exponentiated floating point with positive exponent (correct)
123.4e+3f


// 123 e3f	floating point including space (incorrect)
123 e3f

// 123e3.2f	floating point including fractional exponent (incorrect)
123e3.2f


// 0xFFEE	0x-designated hex literal
0xFFEE

// 0XABCD	0X-designated hex literal
0XABCD

// 0x1a2b	Hex literal with lower case and digits
0x1a2b



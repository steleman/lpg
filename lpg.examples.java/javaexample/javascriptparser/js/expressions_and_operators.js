
// 22 Mar 2006:  Notes on parser behavior
// - Floats aren't accepted without "LetterF"
// - Many sorts of expressions require a trailing semicolon
//   (which the parser will insert if not present)


1.7f

"JavaScript is fun!"

true

null

/* Recognition of the following as a regular expression
 * depends on use of appropriate lexer
 */

/java/

var v;

{ x:2, y:2 }

[2,3,5,7,11,13,17,19];

function(x) {return x*x;};

i;

sum;

i + 1.7f;

(i + 1.7f) - sum;

w = x + y * z;

w = (x + y) * z;

w = x + y + z;

w = ((x + y) + z);

w = ~-~y;

w = x = y = z;

q = a?b:c?d:e?f:g;

x = ~(-(~y));

w = (x = (y = z));

q = a?b:(c?d:(e?f:g));

i = 1;

j = ++i;

j = i++;

"1" == true;

var ts = "toSttring" in point;

d instanceof Date;

"hello" + " " + "there";

a = "2"; b = "2";
c = a + b;

1 + 2;

"1" + "2";

"1" + 2;

11 < 3;

"11" < "3";

"11" < 3;

"one" < 3;

s = (1 + 2) + " blind mice";

t = ("blind mice:  " + 1) + 2;

if (a == b) stop();

(a == b) && stop();

if ((a == null) && (b++ > 10)) stop();

(a = b) == 0;

a += b;
a = a + b;

a -= b;
a = a - b;

a *= b;
a = a * b;

a /= b;
a = a / b;

a %= b;
a = a % b;

a <<= b;
a = a << b;

a >>= b;
a = a >> b;

a >>>= b;
a = a >>> b;

a &= b;
a = a & b;

a |= b;
a = a | b;

a ^= b;
a = a ^ b;

x > 0 ? x * y : -x * y;

typeof i;

(typeof value == "string") ? "'" + value + "'" : value;

o = new Object;

delete o.x;

void f(a);

frames[1];

document.forms[i + j];

document.forms[i].element[j++]


/*
 * Note:  the NextInputElementNum rule requires (in effect) that whitespace
 * precede any identifier or keyword (as well as any numeric literal).  So
 * keywords at the start of a line will be seen as "unexpected" characters
 * and keyword tokens will not be recognized.
 */

// Four keywords, each at the start of a line
// (you should not see them)
as
break
case
catch

// Some keywords following some white space (some following blanks, some tabs)
 as
 break
 case
 catch
 class
 const
 continue
 default
 delete
 do
 else
 export
 extends
 false
 finally
 for
 function
 if
 import
 in
 instanceof
 is
	namespace
	new
	null
	package
	private
	public
	return
	super
	switch
	this
	throw
	true
	try
	typeof
	use
	var
	void
	while
	with
	abstract
	debugger
	enum
	goto
	implements
	interface
	native
	protected
	synchronized
	throws
	transient
	volatile
	get
	include
	set

// Some lines with whitespace:
 
	

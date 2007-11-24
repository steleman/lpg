Expr1:
    This grammar uses automatically generated Ast nodes and a default
    visitor that returns a Result to compute the value of a given expression
    
Expr2:
    This grammar uses automatically generated Ast nodes and a default
    visitor that does not return a value to compute the result of a
    given expression

Expr3:
    This grammar uses automatically generated Ast nodes to compute
    the result of a given expression on the fly. It stores the result
    of each subexpression in the Ast node corresponding to that
    subexpression. At the end of the parsing, the final result is obtained
    from the root node.

Expr4:
    This grammar computes the result of a given expression by computing
    its value on the fly as it is parsing it. It uses the parse stack to
    store intermediate values

Expr5:
    Same as Expr2 except that it uses the new PREORDER visitor instead of
    the DEFAULT visitor.
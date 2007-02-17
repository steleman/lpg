package expr5.ExprAst;

import lpg.javaruntime.*;

public abstract class AstList extends Ast
{
    private boolean leftRecursive;
    private java.util.ArrayList list;
    public int size() { return list.size(); }
    public Ast getElementAt(int i) { return (Ast) list.get(leftRecursive ? i : list.size() - 1 - i); }
    public java.util.ArrayList getArrayList()
    {
        if (! leftRecursive) // reverse the list 
        {
            for (int i = 0, n = list.size() - 1; i < n; i++, n--)
            {
                Object ith = list.get(i),
                       nth = list.get(n);
                list.set(i, nth);
                list.set(n, ith);
            }
            leftRecursive = true;
        }
        return list;
    }
    public void add(Ast element)
    {
        list.add(element);
        if (leftRecursive)
             rightIToken = element.getRightIToken();
        else leftIToken = element.getLeftIToken();
    }

    public AstList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken);
        this.leftRecursive = leftRecursive;
        list = new java.util.ArrayList();
    }

    public AstList(Ast element, boolean leftRecursive)
    {
        this(element.getLeftIToken(), element.getRightIToken(), leftRecursive);
        list.add(element);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (this.getClass() != o.getClass()) return false;
        AstList other = (AstList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Ast element = getElementAt(i);
            if (element == null)
                if (other.getElementAt(i) != null) return false;
                else;
            else if (! element.equals(other.getElementAt(i)))
                return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        for (int i = 0; i < size(); i++)
        {
            Ast element = getElementAt(i);
            hash = hash * 31 + (element == null ? 0 : element.hashCode());
        }
        return hash;
    }
}



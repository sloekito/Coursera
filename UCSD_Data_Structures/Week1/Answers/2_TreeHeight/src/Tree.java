public class Tree
{
    public Node Root;

    public void InsertFromInput(int child, int parent)
    {
        if (child == -1)
        {
            Root = new Node();
            Root.n = child;
            return;
        }

        Node node = Find(parent);
        if(node == null)
        {
            node.Left = new Node();
            node.Left.n = parent;
            return;
        }

        node = new Node();
        node.Right = new Node();
        node.Right.n = parent;

    }

    public Node Find(int n)
    {
        Node node = new Node();
        return node;
    }

    public void Insert(int n, Node node)
    {

        if(Root == null)
        {
            Root = new Node();
            Root.n = node.n;
            return;
        }

        if(node.n >= n) {
            if (node.Left == null) {
                node.Left = new Node();
                node.Left.n = n;
                return;
            }
            if (node.Left != null) {
                Insert(n, node.Left);
            }
        }
        else {
            if (node.Right == null) {
                node.Right = new Node();
                node.Right.n = n;
                return;
            }
            if (node.Right != null) {
                Insert(n, node.Right);
            }

        }

    }

    public int GetHeight()
    {
        return 0;
    }
}

 class Node
{

    public int n;
    public Node Left;
    public Node Right;
}

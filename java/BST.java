import java.util.Scanner;
/*
class BST
{
    int key;
    BST left,right;
    void Traversal(BST root)
    {
        if(root != null)
        {
            Traversal(root.left);
            System.out.print(root.key+" ");
            Traversal(root.right);
        }
    }
    BST getNode(int item)
    {
        BST temp = new BST();
        temp.key = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }
    BST Insert(BST root,int item)
    {
        if(root == null)
        {
            BST temp = new BST();
            temp = getNode(item);
            return temp;
        }
        
        if(item <= root.key)
            root.left = Insert(root.left,item);
        else
            root.right = Insert(root.right,item);
        
        return root;
    }
*/
class Node
{
    int key;
    Node left,right;
    void Traversal(Node root)
    {
        if(root != null)
        {
            Traversal(root.left);
            System.out.print(root.key+" ");
            Traversal(root.right);
        }
    }
    Node getNode(int item)
    {
        Node temp = new Node();
        temp.key = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }
    Node Insert(Node root,int item)
    {
        if(root == null)
        {
            Node temp = new Node();
            temp = getNode(item);
            return temp;
        }
        
        if(item <= root.key)
            root.left = Insert(root.left,item);
        else
            root.right = Insert(root.right,item);
        
        return root;
    }
};


class BST
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        Node ob = new Node();
        Node root = new Node();
        root = null;
        int k=1;
        while(k==1)
        { 
            System.out.println("1.Insert\n2.Traversal\n3.Exit");
            System.out.println("Enter your choice : ");
            int choice = jin.nextInt();
            switch(choice)
            {
                case 1:System.out.println("Enter item : ");
                        int item = jin.nextInt();
                        root = ob.Insert(root,item);
                        break;
                case 2:if(root==null)
                            System.out.println("Empty!");
                        else
                        {
                            System.out.println("Sorted order is...");
                            ob.Traversal(root);
                        }
                        break;
                case 3:System.exit(0);
                        break;
                default:System.exit(0);
                        break;
            }
            System.out.println("\n");
        }
    }
};
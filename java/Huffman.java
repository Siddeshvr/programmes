import java.util.Scanner;

class Huffman_util
{
    int f;
    char v;
    Huffman_util left,right;

    void Heapify(Huffman_util[] node,int n,int i)
    {
        int small = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<n && r<n && node[l].f > node[r].f)
        {
            Huffman_util temp = node[l];
            node[l] = node[r];
            node[r] = temp;
        }
        if(r<n && node[r].f<node[small].f)
        {
            Huffman_util temp = node[small];
            node[small] = node[r];
            node[r] = temp;
        }
        if(l<n && node[l].f<node[small].f)
            small = l;
    
        if(small != i)
        {
            Huffman_util temp = node[small];
            node[small] = node[i];
            node[i] = temp;
            Heapify(node,n,small);
        }
    }

    Huffman_util getNode(char v,int f)
    {
        Huffman_util temp = new Huffman_util();
        temp.f = f;
        temp.v = v;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    void printArr(int[] a,int n)
    {
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println("");
    }

    void Traversal(Huffman_util node,int[] a,int i) 
    {
        if(node.left != null)
        {
            a[i] = 0;
            Traversal(node.left,a,i+1);
        }
        if(node.right != null)
        {
            a[i] = 1;
            Traversal(node.right,a,i+1);
        }

        if(node.v != '$')
        {
            System.out.print(node.v+" : ");
            printArr(a,i);
        }
    }

    void Huffman(char[] v,int[] f,int n)
    {
        Huffman_util[] node = new Huffman_util[10];
        for(int i=0;i<n;i++)
            node[i] = getNode(v[i],f[i]);

        Huffman_util temp = new Huffman_util();  //for new node...
        int y = n;
        while(y > 1)
        {
            for(int i=y/2-1;i>=0;i--)
                Heapify(node,y,i);
        
            int x = node[0].f + node[1].f;
            temp = getNode('$',x);
            temp.left = node[0];
            temp.right = node[1];
            
            node[0] = temp;
            node[1] = node[y-1];
            y--;
        }
        int[] a = new int[10];
        Traversal(temp,a,0);  //Here temp holds the whole tree...
    }
};

class Huffman
{
    public static void main(String[] args)
    {
        Huffman_util ob = new Huffman_util();
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = jin.nextInt();
        System.out.println("Enter "+n+" characters...");
        char[] v = new char[10];
        for(int i=0;i<n;i++)
            v[i] = jin.next().charAt(0);
        System.out.println("Enter frequencies...");
        int[] f = new int[10];
        for(int i=0;i<n;i++)
            f[i] = jin.nextInt();
        
        ob.Huffman(v,f,n);
    }
};


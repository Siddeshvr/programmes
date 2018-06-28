import java.util.*;

class BFS_DFS
{
    public static void BFS(int L[][],int s,int n)
    {
        boolean visited[] = new boolean[10];
        for(int i=0;i<n;i++)
            visited[i] = false;
        visited[s] = true;
        ArrayList<Integer> stack = new ArrayList<Integer>(n);
        stack.add(s);
        while(!stack.isEmpty())
        {
            int x = stack.remove(0);
            System.out.println(x);
            for(int i=0;i<n;i++)
                if(L[x][i]==1 && visited[i]==false)
                {
                    visited[i] = true;
                    stack.add(i);
                }
        }
    }

    public static void DFS(int L[][],int s,int n)
    {
        boolean visited[] = new boolean[10];
        for(int i=0;i<n;i++)
            visited[i] = false;
        visited[s] = true;
        ArrayList<Integer> stack = new ArrayList<Integer>(n);
        stack.add(s);
        while(!stack.isEmpty())
        {
            int x = stack.remove(stack.size()-1);
            System.out.println(x);
            for(int i=0;i<n;i++)
                if(L[x][i]==1 && visited[i]==false)
                {
                    visited[i] = true;
                    stack.add(i);
                }
        }
    }

    public static void main(String[] args)
    {
        int[][] Graph = new int[10][10];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = input.nextInt();
        System.out.println("Enter Adj_matrix :");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                Graph[i][j] = input.nextInt();
        System.out.println("DFS Traversal is...");
        DFS(Graph,2,n);
        System.out.println("BFS Traversal is...");
        BFS(Graph,2,n);
    }
};
import java.util.Scanner;

class prims
{
    public static int Util(boolean mstSet[],int[] key,int n)
    {
        int min=999;
        int min_index=0;
        for(int v=0;v<n;v++)
            if(mstSet[v]==false && key[v]<min)
            {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }

    public static void prims(int G[][],int n)
    {
        int[] key = new int[10];
        boolean[] mstSet = new boolean[10];
        int[] parent = new int[10];
        for(int i=0;i<n;i++)
        {
            key[i] = 999;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;

        for(int i=0;i<n-1;i++)
        {
            int u = Util(mstSet,key,n);
            mstSet[u] = true;
            for(int v=0;v<n;v++)
                if(G[u][v]!=0 && mstSet[v]==false && G[u][v]<key[v])
                {
                    parent[v] = u;
                    key[v] = G[u][v];
                }
        }

        System.out.println("MST is...");
        System.out.println("Edge     Weight");
        for(int i=1;i<n;i++)
            System.out.println(parent[i]+"--"+i+"   "+G[i][parent[i]]);
    }

    public static void main(String[] arg)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = jin.nextInt();
        int[][] G = new int[10][10];
        System.out.println("Enter Adj_matrix : ");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                G[i][j] = jin.nextInt();
        prims(G,n);
    }
};
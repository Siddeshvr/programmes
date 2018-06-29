import java.util.*;

class floyds
{
    public static void printing(int G[][],int n)
    {
        System.out.println("All pair shortest path is...");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(G[i][j]==999)
                    System.out.print("∞"+" ");
                else
                    System.out.print(G[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    public static int min(int a,int b)
    {
        return a<b?a:b;
    }

    public static void Fn(int G[][],int n)
    {
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    G[i][j] = min(G[i][j],(G[i][k] + G[k][j]));
        printing(G,n);
    }

    public static void main(String[] args)
    {
        System.out.println("Enter n value : ");
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[][] G = new int[10][10];
        System.out.println("Enter Adj_matrix : ");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                G[i][j] = jin.nextInt();
        //printing(G,n);
        Fn(G,n);
    }
};
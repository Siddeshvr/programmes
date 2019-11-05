import java.util.*;

class Bellman_ford
{
    public static void ford(int[][] G,int s,int n)
    {
        int[] dist = new int[n];
        Arrays.fill(dist,999);

        for(int i=0;i<n-1;i++)
            for(int u=0;u<n;u++)
                for(int v=0;v<n;v++)
                    if(dist[v] > dist[u]+G[u][v]) dist[v] = dist[u]+G[u][v];
        for(int u=0;u<n;u++)
            for(int v=0;v<n;v++)
            if(dist[v] > dist[u]+G[u][v]) 
            {
                System.out.println("Present");
                return;
            }
        System.out.println("No");
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[][] G = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                G[i][j] = jin.nextInt();
        System.out.println("Enter start...");
        int s = jin.nextInt();
        jin.close();

        ford(G,s,n);
    }
}
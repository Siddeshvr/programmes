import java.util.*;

class Topological_sort
{
    public static ArrayList<Integer> S = new ArrayList<Integer>();

    public static void util(int[][] G,int s,int[] visited,int n)
    {
        visited[s] = 1;
        for(int i=0;i<n;i++)
            if(G[s][i]==1 && visited[i]==0)
                util(G,i,visited,n);
        S.add(s);
    }

    public static void Topology(int[][] G,int n)
    {
        int[] visited = new int[n];
        for(int i=0;i<n;i++)
            if(visited[i]==0)
                util(G,i,visited,n);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = input.nextInt();
        int[][] Graph = new int[n][n];
        System.out.println("Enter Adj_matrix :");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                Graph[i][j] = input.nextInt();
        input.close();

        Topology(Graph,n);

        for(int i=n-1;i>=0;i--)
            System.out.println(S.get(i));
    }
}
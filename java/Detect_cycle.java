import java.util.*;

class Detect_cycle
{
    public static boolean DFS(int[][] G,int n,int s)
    {
        int[] visited = new int[n];
        visited[s] = 1;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        ArrayList<Integer> S = new ArrayList<Integer>();
        stack.add(s);
        S.add(s);
        while(!stack.isEmpty())
        {
            int x = stack.remove(stack.size()-1);
            for(int i=0;i<n;i++)
            {
                if(G[s][i]==1 && S.contains(i)) return true;
                else if(G[s][i]==1 && visited[i]==0)
                {
                    visited[i] = 1;
                    stack.add(i);
                    S.add(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[][] G = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                G[i][j] = jin.nextInt();
        System.out.println("Enter starting...");
        int s = jin.nextInt();
        System.out.println(DFS(G,n,s)==true?"Present":"NO");
        jin.close();
    }
}
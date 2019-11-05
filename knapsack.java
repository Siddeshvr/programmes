import java.util.Scanner;

class knapsack
{
    public static int knapsack(int wt[],int v[],int W,int n)
    {
        int[][] k = new int[n+1][W+1];
        int w=0,i;
        for(i=0;i<=n;i++)
        {
            for(w=0;w<=W;w++)
            {
                if(i==0 || w==0)
                    k[i][w] = 0;
                else if(wt[i-1] <= w)
                    k[i][w] = Math.max(v[i-1]+k[i-1][w-wt[i-1]] , k[i-1][w]);
                else
                    k[i][w] = k[i-1][w];
            }
        }
        return k[n][W];
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = jin.nextInt();
        System.out.println("Enter weights...");
        int[] wt = new int[10];
        for(int i=0;i<n;i++)
            wt[i] = jin.nextInt();
        System.out.println("Enter values...");
        int[] v = new int[10];
        for(int i=0;i<n;i++)
            v[i] = jin.nextInt();
        System.out.println("Enter Max_weight : ");
        int W = jin.nextInt();
        System.out.println("Knapsack weight is "+knapsack(wt,v,W,n));
    }
};
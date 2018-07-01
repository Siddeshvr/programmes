import java.util.Scanner;

class TSP
{
    int swap(int a,int b)
    {
        return a;
    }
    
    boolean nextpermutation(int[] v) 
    {
        int n = v.length;
        int i = n-2;
        while(i>=0 && v[i] >= v[i+1])
            i--;
        if(i == -1)
            return false;
        int j = i+1;
        while(j<n && v[j]>v[i])
            j++;
        j--;
        v[i] = swap(v[j],v[j]=v[i]);   //swapping...


        int left = i+1;
        int right = n-1;
        while(left < right)
        {
            v[left] = swap(v[right],v[right]=v[left]);  //swapping...

            left++;
            right--;
        }
        for(i=0;i<v.length;i++)
            System.out.println(v[i]);
        return true;
    }
    
    void TSP(int[][] G,int s,int n)
    {
        int[] x = new int[n-1];
        int j=0;
        for(int i=0;i<n;i++)
            if(i!=s)
            {
                x[j] = i;
                j++;
            }
        
        int min_cost = 999;
        
        while(nextpermutation(x) == true) 
        {
            int cur_w = 0;
            int k = s;
            for(int i=0;i<x.length;i++)
            {
                cur_w += G[k][x[i]];
                k = x[i];
            }
            cur_w += G[k][s];
            
            if(min_cost > cur_w)
                min_cost = cur_w;
        }

        System.out.println("Minimum path cost is "+min_cost);
        
    }

    public static void main(String[] args)
    {
        TSP ob = new TSP();
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = jin.nextInt();
        System.out.println("Enter Adj_matrix : ");
        int[][] G = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                G[i][j] = jin.nextInt();
        System.out.println("Enter starting vertex : ");
        int s = jin.nextInt();
        ob.TSP(G,s,n);
    }
};
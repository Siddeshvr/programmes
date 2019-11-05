/*
import java.util.Scanner;   

class Easy_sum
{
    public static void fn(int[] N,int[] M,int n,int m)
    {
        int[] B = new int[n];
        int[] C = new int[100];

        int k=0;
        for(int i=0;i<M.length;i++)
            for(int j=0;j<N.length;j++)
            {
                C[k] = M[i]-N[j];
                k++;
            }
        
        int[] D = new int[100];
        int l=0;
        for(int i=0;i<N.length;i++)
        {
            for(int j=0;j<k;j++)
            {   
                int flag=0;
                for(int z=0;z<M.length;z++)
                    if(N[i]+C[j] == M[z]) flag=1;
                if(flag==0)
                {
                    D[l] = C[j];
                    l++;
                }
            }
        }

        k=0;
        for(int i=0;i<l;i++)
        {
            int z=0;
            while(z<=k)
            {
                B[k] = D[i];
                z++;
            }
            k++;
        }

        for(i=0;i<N.length;i++)
            System.out.print(B[i]+" ");
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        int m = jin.nextInt();
        int[] M = new int[m];
        for(int i=0;i<m;i++)
            M[i] = jin.nextInt();
        fn(N,M,n,m);
        jin.nextLine();
        jin.close();
    }
}
*/
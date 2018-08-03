import java.util.Scanner;

class play 
{   
    public static void fn(int[] A,int[] B,int[] C)
    {
        for(int j=1;j<B.length;j++)
        {
            int sum=0;
            for(int i=1;i<A.length;i++)
            {
                if(i>=B[j] && i<=C[j])
                    sum += A[i];
            }
            System.out.println(sum/(C[j]-B[j]+1));
        }
    }
    
    public static void main(String args[])
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int q = jin.nextInt();
        int[] A = new int[n+1];
        for(int i=1;i<=n;i++)
            A[i] = jin.nextInt();
        int[] B = new int[q+1];
        int[] C = new int[q+1];
        for(int i=1;i<=q;i++)
        {
            B[i] = jin.nextInt();
            C[i] = jin.nextInt();
        }
        fn(A,B,C);
        jin.close();
    }   
}

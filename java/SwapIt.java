import java.util.Scanner;

class SwapIt
{
    public static void fn(int[] A,int n,int k)
    {
        for(int i=0;i<k;i++)
        {
            int x=0;
            int j=1;
            while(j<=k)
            {
                if(A[j-1]>A[j])
                    x = j;
                j++;
            }
            if(x != 0)
            {
                int temp = A[x-1];
                A[x-1] = A[x];
                A[x] = temp;
            }
        }
        System.out.println("Minimal lexicographical order is...");
        for(int i=0;i<n;i++)
            System.out.print(A[i]+" ");
        System.out.println("");
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter n(num of elements) value...");
        int n = jin.nextInt();
        System.out.println("Enter k(Num of swaps) value...");
        int k = jin.nextInt();
        System.out.println("Enter n elements...");
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = jin.nextInt();
        fn(A,n,k);
        jin.close();
    }
}
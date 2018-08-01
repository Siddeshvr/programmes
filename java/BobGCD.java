import java.util.Scanner;

class BobGCD
{
    public static void fn(int[] A,int n,int k)
    {
        int result=0;
        for(int i=0;i<n;i++)
        {
            if(A[i]%k != 0)
            {
                while(A[i] < k)
                {
                    A[i]++;
                    result++;
                }

                int r=A[i]%k;
                while(r < k/2 && A[i]%k!=0)
                {
                    A[i] -= 1;
                    result++;
                    r++;
                }
                while(r >= k/2-1 && A[i]>0 && A[i]%k!=0) 
                {
                    A[i] += 1;
                    result++;
                    r--;
                }
            }
        }
        System.out.println("It took "+result+" operations...");
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter k(GCD value)...");
        int k = jin.nextInt();
        System.out.println("Enter array size...");
        int n = jin.nextInt();
        System.out.println("Enter elements...");
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = jin.nextInt();
        fn(A,n,k);
        jin.close();
    }
}
import java.util.Scanner;
import java.util.Arrays;

class Sock_Merchant
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();

        Arrays.sort(N);
        int result=0;
        int i=0;
        while(i<n-1)
        {
            int k=0;
            while(N[i]==N[i+1])
            {
                k++;
                i++;
                if(i==n-1) break;
            }
            k++;
            i++;
            while(k>1) 
            {
                result++;
                k -= 2;
            }
        }
        System.out.println(result);
        jin.close();
    }
}
import java.util.Scanner;
import java.lang.Math;

class multiply
{   
    public static void main(String args[])
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] A = new int[n];
        long result=1;
        for(int i=0;i<n;i++)
            A[i] = jin.nextInt();
        for(int i=0;i<n;i++)
            result = (long)((result*A[i]) % (Math.pow(10,9)+7));
        System.out.println(result);
        jin.close();
    }   
}

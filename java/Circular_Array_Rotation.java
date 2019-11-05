import java.util.Scanner;
import java.lang.System;
import java.util.Arrays;

class Circular_Array_Rotation
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int k = jin.nextInt();
        int q = jin.nextInt();
        int[] N = new int[n];
        int[] I = new int[q];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        for(int i=0;i<q;i++)
            I[i] = jin.nextInt();
        
        int[] M = new int[n];
            Arrays.fill(M,0);

        for(int i=0;i<k;i++) //Number of rotations...
        {
            int temp = N[n-1];
            System.arraycopy(N,0,M,1,n-1);
            M[0] = temp;
            N = M;
        }
        for(int i=0;i<q;i++)
            System.out.println(N[I[i]]);

        jin.close();
    }
}
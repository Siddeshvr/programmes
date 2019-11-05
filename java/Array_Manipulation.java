import java.util.Scanner;

class Array_Manipulation
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int m = jin.nextInt();
        int a,b;
        long inc;
        long[] L = new long[n+1];
        for(int i=0;i<m;i++)
        {
            a = jin.nextInt();
            b = jin.nextInt();
            inc = jin.nextInt();
            L[a] += inc;
            if(b+1 <= n) L[b+1] -= inc;
        }
        jin.close();

        long max=0,x=0;
        for(int i=1;i<=n;i++)
        {
            x += L[i];
            if(max < x) max = x;
        }

        System.out.println(max);
    }
}
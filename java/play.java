import java.util.Scanner;

class play 
{   
    public static void main(String args[])
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int q = jin.nextInt();
        long[] N = new long[n+1];
        for(int i=1;i<=n;i++)
            N[i] = N[i-1] + jin.nextLong();
        for(int i=0;i<q;i++)
        {
            int x = jin.nextInt();
            int y = jin.nextInt();
            System.out.println((N[y]-N[x-1])/(y-x+1));
        }
        jin.close();
    }   
}

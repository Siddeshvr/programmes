import java.util.Scanner;

class Electronic_shop
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        long b = jin.nextInt();
        int n = jin.nextInt();
        int m = jin.nextInt();
        long[] N = new long[n];
        long[] M = new long[m];
        long max=0;
        for(int i=0;i<n;i++) N[i] = jin.nextLong();
        for(int i=0;i<m;i++)
        {
            M[i] = jin.nextLong();
            for(int j=0;j<n;j++)
                if(N[j]+M[i] < b && N[j]+M[i]>max)  max = N[j]+M[i];
        }
        System.out.println((max==0) ? "-1":max);
        jin.close();
    }
}
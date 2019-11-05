import java.util.Scanner;

class Sequence_equation
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n+1];
        for(int i=1;i<=n;i++)
            N[i] = jin.nextInt();

        for(int i=1;i<=n;i++)
        {
            int x=0;
            for(int j=1;j<=n;j++)
                if(N[j]==i)
                {
                    x = j;
                    break;
                }
            for(int k=1;k<=n;k++)
                if(x == N[k]) System.out.println(k);
        }
        jin.close();
    }
}
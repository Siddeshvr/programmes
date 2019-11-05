import java.util.Scanner;
import java.lang.Math;

class Sherlock_and_Squares
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        int[][] N = new int[t][2];
        for(int i=0;i<t;i++)
            for(int j=0;j<2;j++)
                N[i][j] = jin.nextInt();
        jin.close();

        for(int i=0;i<t;i++)
        {
            int x = (int)Math.sqrt(N[i][0]);
            int y = (int)Math.sqrt(N[i][1]);

            int res=0;
            for(;x<=y;x++)
                if(Math.pow(x,2) >= N[i][0] && Math.pow(x,2) <= N[i][1]) res++;
            System.out.println(res);
        }
    }
}
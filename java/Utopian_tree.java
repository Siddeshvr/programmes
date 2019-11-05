import java.util.Scanner;
import java.lang.Math;

class Utopian_tree
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        for(int i=0;i<n;i++)
        {
            int res=1;
            for(int j=1;j<=N[i];j++)
            {
                if(j%2 == 0) res++;
                else res += res;
            }
            System.out.println(res);
        }
        jin.close();
    }
}
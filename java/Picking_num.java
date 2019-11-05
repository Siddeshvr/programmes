import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

class Picking_num
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        Arrays.sort(N);
        int max=0;
        for(int i=0;i<n-1;i++)
        {
            int res=0;
            for(int j=i+1;j<n;j++)
            {
                if(Math.abs(N[i]-N[j])<=1) res++;
                else break;
            }
            if(max<res) max=res;
        }
        System.out.println(max+1);
        jin.close();
    }
}
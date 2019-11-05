import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

class Flatland_Space_Stations
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int m = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<m;i++) N[i] = jin.nextInt();
        jin.close();

        /*
        int max=0;
        for(int i=0;i<n;i++)
        {
            int min=999,flag=0;
            for(int j=0;j<m;j++)
                if(i == N[j]) {flag=1;break;}
            
            if(flag==0)
                for(int j=0;j<m;j++)
                    if(i!=N[j])
                    {
                        int x = Math.abs(i-N[j]);
                        if(x<min) min=x;
                    }
            if(min!=999 && min>max) max=min;
        }
        System.out.println(max);
        */

        int a[] = new int[n];
        Arrays.fill(a,Integer.MAX_VALUE);
        for(int i=0; i<m; i++)
        {
            int x = N[i];
            for(int j=0; j<n; j++)
            {
                if(j==x)
                    a[j]=0;
                else if(a[j]>Math.abs(j-x))
                    a[j] = Math.abs(j-x);
            }
        }
        int max=a[0];
        for(int i=1;i<n;i++)
            if(max<a[i]) max = a[i];
        System.out.println(max);
    }
}

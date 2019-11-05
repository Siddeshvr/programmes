//Hacker rank...Between two sets...

import java.util.Scanner;
import java.util.Arrays;

class Btw_2_sets
{
    public static int gcd(int a,int b)
    {
        return b==0?a:gcd(b,a%b);
    }
    public static int find_lcm(int[] N,int n)
    {
        int ans = N[0];
        for(int i=1;i<n;i++)
            ans = (((N[i]*ans)) / (gcd(N[i],ans)));
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int m = jin.nextInt();
        int[] N = new int[n];
        int[] M = new int[m];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        for(int i=0;i<m;i++)
            M[i] = jin.nextInt();

        int lcm=0;
        if(n>1)
        {
            Arrays.sort(M);
            lcm = find_lcm(N,n);
        }
        else lcm = N[0];
        

        int i=1,j=0,k=0;
        int[] R = new int[101];
        while(k <= M[0])
        {
            k = lcm*(i++);
            R[j++] = k;
        }

        j--;
        k=0;
        while(j>=0)
        {
            int flag=0;
            for(i=0;i<m;i++)
                if(M[i]%R[j] != 0) flag=1;
            if(flag==0) k++;
            j--;
        }

        System.out.println(k);
        jin.close();
    }
}
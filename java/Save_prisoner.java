import java.util.Scanner;

class Save_prisoner
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        int[] n = new int[t];
        int[] m = new int[t];
        int[] s = new int[t];
        for(int i=0;i<t;i++)
        {
            n[i] = jin.nextInt();
            m[i] = jin.nextInt();
            s[i] = jin.nextInt();
        }
        for(int i=0;i<t;i++)
        {
            /*
            int j = m[i]+s[i];
            int res=0;
            if(j > n[i]) while(m[i] > n[i]) m[i] -= n[i];
            res = s[i] + m[i] -1;
            if(res > n[i]) res -= n[i];
            System.out.println(res);
            */

            if((m[i]+s[i]-1)%n[i] == 0) System.out.println(n[i]);
            else System.out.println((m[i]+s[i]-1)%n[i]);
        }
        jin.close();
    }
}
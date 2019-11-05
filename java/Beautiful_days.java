import java.util.Scanner;
import java.lang.Math;

class Beautiful_days
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int i = jin.nextInt();
        int j = jin.nextInt();
        int k = jin.nextInt();
        int res=0;
        for(int x=i;x<=j;x++)
        {
            int r=0;
            int n=x;
            while(n > 0)
            {
                r = (r*10) + (n%10);
                n /= 10;
            }
            int y = Math.abs(x-r);
            if(y%k == 0) res++;
        }
        System.out.println(res);
        jin.close();
    }
}
import java.util.Scanner;
import java.lang.Math;

class Modified_Kaprekar_Numbers
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int p = jin.nextInt();
        int q = jin.nextInt();
        jin.close();

        int count=0;
        for(int i=p;i<=q;i++)
        {
            int j=0; 
            if(i==10 || i==100 || i==1000 || i==10000) j=0;
            else if(i<10) j=1;
            else if(i<100) j=2;
            else if(i<1000) j=3;
            else if(i<10000) j=4;
            else if(i<100000) j=5;

            long n = (long)Math.pow(i,2);
            int k=0,res=0;
            long r=0;
            while(k<j)
            {
                r = n%10;
                res += (r*Math.pow(10,k));
                n /= 10;
                k++;
            }
            if(n+res == i) 
            {
                System.out.print(i+" ");
                count++;
            }
        }
        if(count==0) System.out.println("INVALID RANGE");
    }
}
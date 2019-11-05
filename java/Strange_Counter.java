import java.util.Scanner;

class Strange_Counter
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        long n = jin.nextLong();
        jin.close();

        long x=3;
        for(long i=0;i<n;i++)
        {
            if(x-2>=n) break;
            x *=2;
        }
        if(x-2 == n) System.out.println(x);
        else if(x-2>n)
            System.out.println(x-n-2);
    }
}
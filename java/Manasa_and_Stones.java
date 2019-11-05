import java.util.Scanner;
import java.lang.Math;

class Manasa_and_Stones
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();

        for(int i=0;i<t;i++)
        {
            int n = jin.nextInt();
            int a = jin.nextInt();
            int b = jin.nextInt();

            int sum=0,first=0;
            first = (n-1)*Math.min(a,b);
            System.out.print(first+" ");
            while(sum+first < (n-1)*Math.max(a,b))
            {
                sum += Math.abs(a-b);
                System.out.print(sum+first+" ");
            }
            System.out.println();
        }

        jin.close();
    }
}
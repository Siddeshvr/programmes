import java.util.Scanner;
import java.lang.System;

class Kangaroo
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int x1 = jin.nextInt();
        int v1 = jin.nextInt();
        int x2 = jin.nextInt();
        int v2 = jin.nextInt();

        if((x1<x2 && v1>v2) || (x1>x2 && v1<v2))
        {
            int i=0;
            while(i<100)
            {
                x1 += v1;
                x2 += v2;
                if(x1==x2)
                {
                    System.out.println("YES");
                    System.exit(0);
                }
                i++;
            }
        }
        System.out.println("NO");

        jin.close();
    }
}
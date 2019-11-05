import java.util.Scanner;
import java.lang.Math;

class Encryption
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        char[] S = jin.nextLine().toCharArray();
        jin.close();

        int x = (int)Math.sqrt(S.length);
        if(x*x != S.length) x++;

        int i=0;
        while(i<x)
        {
            int j=i;
            while(j<S.length)
            {
                System.out.print(S[j]);
                j += x;
            }
            System.out.print(" ");
            i++;
        }
        System.out.println();
    }
}
import java.util.Scanner;
import java.util.Arrays;

class Equalize_the_Array
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        jin.close();

        Arrays.sort(N);
        int mode=0,count=1;
        for(int i=0;i<n-1;i++)
        {
            if(N[i] == N[i+1])  count++;
            else
            {
                if(mode<count) mode=count;
                count=1;
            }
        }
        if(mode<count) mode=count;
        System.out.println(n-mode);
    }
}
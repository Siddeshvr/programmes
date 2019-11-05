import java.util.Arrays;
import java.util.Scanner;

class Organizing_Containers_of_Balls
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();        

        for(int i=0;i<t;i++)
        {
            int n = jin.nextInt();
            int[] R = new int[n];
            int[] C = new int[n];
            for(int k=0;k<n;k++)
                for(int j=0;j<n;j++)
                {
                    int x = jin.nextInt();
                    R[k] += x;             //Find sum of each row and maintain array...
                    C[j] += x;            //Find sum of each column and maintain array...
                }
            Arrays.sort(R);
            Arrays.sort(C);
            if(Arrays.equals(R, C)) System.out.println("Possible");
            else System.out.println("Impossible");
        }
        jin.close();
    }
}
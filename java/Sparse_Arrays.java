import java.util.Scanner;
import java.util.Arrays;

class Sparse_Arrays
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        char[][] A = new char[n][];
        for(int i=0;i<n;i++)
            A[i] = jin.nextLine().toCharArray();
        int q = jin.nextInt();
        jin.nextLine();
        char[][] B = new char[q][];
        for(int i=0;i<q;i++)
            B[i] = jin.nextLine().toCharArray();
        jin.close();

        for(int i=0;i<q;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
                if(Arrays.equals(B[i],A[j])) count++;
            System.out.println(count);
        }
    }
}
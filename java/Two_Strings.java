import java.util.Arrays;
import java.util.Scanner;

class Two_Strings
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        jin.nextLine();
        for(int i=0;i<t;i++)
        {
            String[] a = jin.nextLine().split(" ");
            char[] C = a[0].toCharArray();
            char[] S = a[1].toCharArray();

            int[] A = new int[123];
            int[] B = new int[123];

            for(int j=0;j<C.length;j++)
                A[C[j]]++;
            for(int j=0;j<S.length;j++)
                B[S[j]]++;
            int flag=0;
            for(int j='a';j<='z';j++)
                if((A[j]!=0 || B[j]!=0)&& A[j]!=B[j]) flag=1;
            System.out.println(flag==1?"NO":"YES");
        }
        jin.close();
    }
}
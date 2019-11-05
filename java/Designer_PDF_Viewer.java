import java.util.Scanner;

class Designer_PDF_Viewer
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int[] N = new int[26];
        for(int i=0;i<26;i++)
            N[i] = jin.nextInt();
        jin.nextLine();
        String S = jin.nextLine();
        char[] C = S.toCharArray();

        int max=0;
        for(int i=0;i<C.length;i++)
        {
            int x = C[i] - 97;
            if(max < N[x]) max = N[x];
        }
        System.out.println(max*C.length);
        jin.close();
    }
}
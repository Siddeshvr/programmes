import java.util.Scanner;

class Angry_professor
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        int[] n = new int[t];
        int[] k = new int[t];
        int[][] N = new int[t][1000];
        for(int i=0;i<t;i++)
        {
            n[i] = jin.nextInt();
            k[i] = jin.nextInt();
            for(int j=0;j<n[i];j++)
                N[i][j] = jin.nextInt();
        }

        for(int i=0;i<t;i++)
        {
            int res=0;
            for(int j=0;j<n[i];j++)
                if(N[i][j]<=0) res++;
            System.out.println(res>=k[i] ? "NO":"YES");
        }
        jin.close();
    }
}
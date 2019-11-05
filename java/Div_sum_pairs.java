import java.util.Scanner;

class Div_sum_pairs
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int k = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        int res=0;
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                if((N[i]+N[j])%k == 0) res++;
        System.out.println(res);
        jin.close();
    }
}
import java.util.Scanner;

class Hurdle_race
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int k = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        int max=N[0];
        for(int i=1;i<n;i++)
            if(max < N[i]) max = N[i];
        if(max > k) System.out.println(max-k);
        else System.out.println("0");
        jin.close();
    }
}
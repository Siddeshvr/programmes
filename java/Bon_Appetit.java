import java.util.Scanner;

class Bon_Appetit
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int m = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        int Bc = jin.nextInt();

        int Ba=0;
        for(int i=0;i<n;i++)
            if(i!=m) Ba += N[i];
        Ba /= 2;
        if(Bc > Ba) System.out.println(Bc-Ba);
        else if(Bc==Ba) System.out.println("Bon Appetit");
        jin.close();
    }
}
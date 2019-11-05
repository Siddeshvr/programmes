import java.util.Scanner;

class Life_universe
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int[] N = new int[10000];
        for(int i=0;i<10000;i++)
        {
            N[i] = jin.nextInt();
            if(N[i]==42) break;
            System.out.println(N[i]);
        }
        jin.close();
    }
}
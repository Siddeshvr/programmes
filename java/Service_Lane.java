import java.util.Scanner;

class Service_Lane
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int t = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();

        for(int i=0;i<t;i++)
        {
            int x = jin.nextInt();
            int y = jin.nextInt();
            int min = N[x];
            for(int j=x+1;j<=y && j<n;j++)
                if(min > N[j]) min = N[j]; 
            System.out.println(min);
        }

        jin.close();
    }
}
import java.util.Scanner;

class Fair_Rations
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        jin.close();

        int count=0;
        for(int i=0;i<n-1;i++)
        {
            if(N[i]%2 != 0)
            {
                N[i]++;
                N[i+1]++;
                count += 2;
            }
        }
        System.out.println(N[n-1]%2 != 0? "NO":count);
    }
}
import java.util.Scanner;

class Lisas_Workbook
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int k = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        jin.close();

        int count=0,page=1;
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<=N[i];j++)
            {
                if(j == page) count++;
                if(j%k==0) page++;
            }
            if(N[i]%k != 0) page++;
        }
        System.out.println(count);
    }
}
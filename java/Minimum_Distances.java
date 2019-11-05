import java.util.Scanner;

class Minimum_Distances
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        jin.close();

        int min=999;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=0;
                if(N[i]==N[j]) 
                {
                    temp = j-i;
                    if(min>temp) min = temp;
                }
            }
        }
        System.out.println(min==999?-1:min);
    }
}
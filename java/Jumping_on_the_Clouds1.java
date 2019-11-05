import java.util.Scanner;

class Jumping_on_the_Clouds1
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        jin.close();

        int res=0,i=0;
        while(i<n-1) 
        {
            int j=i+1;
            while(j<i+3 && j<n)
            {
                if(N[j]==1 && j==i+2) break;
                else j++;
            }
            res++;
            i = j-1;
        }
        System.out.println(res);
    }
}
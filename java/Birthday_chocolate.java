import java.util.Scanner;

class Birthday_chocolate
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        int d = jin.nextInt();
        int m = jin.nextInt();
        
        int res=0;
        for(int i=0;i<n-m+1;i++)
        {
            int k = i+m;
            int sum=0;
            for(int j=i;j<k;j++)
                sum += N[j];
            if(sum==d) res++;
        }
        System.out.println(res);
        jin.close();
    }
}
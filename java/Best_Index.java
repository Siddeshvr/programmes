import java.util.Scanner;

class Best_Index
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        long[] N = new long[n+1];
        for(int i=0;i<n;i++) 
        {
            N[i] = jin.nextLong();
            if(i>0) N[i] += N[i-1];
        }
        jin.close();

        long max = N[n];
        for(int i=0;i<n;i++)
        {
            long sum=0,count=0;
            int j;
            for(j=i;j<n;)
            {
                count++;
                if(j+count > n) break;
                else j+=count;
            }
            if(i==0) sum = N[j-1];
            else sum = N[j-1]-N[i-1];
            if(max<sum) max=sum;
        }
        System.out.println(max);
    }
}
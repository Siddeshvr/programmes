import java.util.*;

class Sherlock
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        for(int k=0;k<t;k++)
        {
            int n = jin.nextInt();
            int[] N = new int[n];
            int i=0,j=n-1,sum1=0,sum2=0,flag=0;
            while(i<=n-1 && j>=0)
            {
                if((sum1==sum2) && (i-j)==0)
                {
                    flag=1;
                    break;
                }
                else if(sum1<sum2) sum1 += N[i++];
                else sum2 += N[j--];
            }
            System.out.println(flag==1?"YES":"NO");
        }
        jin.close();    
    }
}
import java.util.Scanner;

class Find_digits
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        int[] n = new int[t];
        for(int i=0;i<t;i++)
            n[i] = jin.nextInt();
        for(int i=0;i<t;i++)
        {
            int res=0;
            int j=n[i];
            while(j>0)
            {
                int r = j%10;
                if(r!=0) if(n[i]%r == 0) res++;
                j /= 10;
            }
            System.out.println(res);
        }
        jin.close();
    }
}
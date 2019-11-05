import java.util.Scanner;

class Apple_orange
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int s = jin.nextInt();
        int t = jin.nextInt();
        int a = jin.nextInt();
        int b = jin.nextInt();
        int m = jin.nextInt();
        int n = jin.nextInt();
        int[] A = new int[m];
        int[] O = new int[n];

        int ap_res=0,or_res=0;
        for(int i=0;i<m;i++)
        {
            A[i] = jin.nextInt();
            if(a+A[i]>=s && a+A[i]<=t) ap_res++;
        }
        for(int i=0;i<n;i++)
        {
            O[i] = jin.nextInt();
            if(b+O[i]<=t && b+O[i]>=s) or_res++;
        }
        System.out.println(ap_res);
        System.out.println(or_res);
        jin.close();
    }
}
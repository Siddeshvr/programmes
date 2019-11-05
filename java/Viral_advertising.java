import java.util.Scanner;

class Viral_advertising
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int k=5;
        int res=0;
        for(int i=0;i<n;i++)
        {
            int j = k/2;
            res += j;
            k = j*3;
        }
        System.out.println(res);
        jin.close();
    }
}
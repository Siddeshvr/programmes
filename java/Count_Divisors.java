import java.util.Scanner;

class Count_Divisors
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int l = jin.nextInt();
        int r = jin.nextInt();
        int k = jin.nextInt();
        int count=0;
        while(l<=r)
        {
            if(l%k == 0) count++;
            l++;
        }
        System.out.println(count);
        jin.close();
    }
}
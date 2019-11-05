import java.util.Scanner;

class Halloween_Sale
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int p = jin.nextInt();
        int d = jin.nextInt();
        int m = jin.nextInt();
        int s = jin.nextInt();
        jin.close();

        int count=0;
        while(s>=m && s>=p)
        {
            s -= p;
            if(p>m) 
            {
                if(p-d < m) p=m;
                else p -= d;
            }
            count++;
        }
        System.out.println(count);
    }
}
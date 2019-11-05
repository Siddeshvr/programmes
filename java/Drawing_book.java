import java.util.Scanner;

class Drawing_book
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int p = jin.nextInt();
        int i=1;
        int front=0,back=0;
        while(i<=n)
        {
            if(p<=i) break;
            front++;
            i += 2;
        }
        i = n;
        while(i>0)
        {
            if(n%2==0)
            {
                if(p>=i) break;
                back++;
                i -= 2;
            }
            else
            {  
                if(p>=i-1) break;
                back++;
                i -= 2;
            }
        }
        System.out.println((front<back)?front:back);
        jin.close();
    }
}
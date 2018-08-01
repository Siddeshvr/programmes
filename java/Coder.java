//To make a String with 1's only...print time taken...
import java.util.Scanner;

class Coder
{
    public static boolean g(char[] C,int l,int n)
    {
        for(int i=l;i>n;i--)
            if(C[i]=='0')
                return false;
        return true;
    }

    public static boolean f(char[] C,int l,int n)
    {
        for(int i=l;i<n;i++)
            if(C[i]=='0')
                return false;
        return true;
    }

    public static void fn(char[] C,int n,int k)
    {
        int i=0;
        int j=n-1;
        int result = 0;
        while(i <= n-k || j >= k-1)
        {
            if(f(C,0,n)) 
                break;
            
            int x=i;
            boolean a = f(C,i,k+i);
            if(a==false)
                result++;
            while(x < k+i && a==false) 
            {
                if(C[x]=='0')
                    C[x] = '1';
                else
                    C[x] = '0';
                x++;
            }

            int y=j;
            a = g(C,j,j-k);
            if(a==false)
                result++;
            while(y > j-k && a==false) 
            {
                if(C[y]=='0')
                    C[y] = '1';
                else
                    C[y] = '0';
                y--;
            } 
            
            x = i;
            while(x <= n-k)
            {
                if(C[x]=='1')
                    i++;
                else
                    break;
                x++;
            }

            y = j;
            while(j >= k-1) 
            {
                if(C[y]=='1')
                    j--;
                else
                    break;
                y--;
            }
        }

        if(f(C,0,n))
            System.out.println("Took "+result+" sec...");
        else
            System.err.println("We can't do...");
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter a String containing only 1's and 0's...");
        char[] C = jin.nextLine().toCharArray();
        System.out.println("Enter k value...");
        int k = jin.nextInt();
        fn(C,C.length,k);
        jin.close();
    }
};
import java.util.Scanner;

class motupatlu
{
    public static void fn(int A[],int n)
    {
        int m_result=0;
        int p_result=0;
        int m=0;
        int p=0;
        int i=0;
        int j=n-1;
        int x=A[i];
        int y=A[j]; 
        while(m_result+p_result < n-1) 
        {
            m += 2;
            p += 1;
            if(i+1==j-1 && m >= x && p >= y)    //motu grabs from patlu...
            {
                m_result++;
            }
            else if(m >= x)   //If motu finish eating...
            {
                m_result++;
                i++;
                x += A[i];
            }
            else if(p >= y)  //If patlu finish eating...
            {
                p_result++;
                j--;
                y += A[j];
            } 
        }
        
        if(m_result > p_result+1)
        {
            System.out.println("Motu is winner...and he ate "+m_result+" ice-creams");
            System.out.println("Patlu is looser... and he ate "+(p_result+1)+" ice-creams");
        }
        else if(m_result+1 < p_result)
        {
            System.out.println("Patlu is winner...and he ate "+p_result+" ice-creams");
            System.out.println("Motu is looser... and he ate "+(m_result+1)+" ice-creams");
        }
        else
        {
            System.out.println("match tie...both ate equal number of ice-creams..."); 
        }
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter n value... ");
        int n = jin.nextInt();
        System.out.println("Enter heights of ice-cream...");
        int A[] = new int[n];
        for(int i=0;i<n;i++)
            A[i] = jin.nextInt();
        fn(A,n);
        jin.close();
    }
}
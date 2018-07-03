import java.util.Scanner;
import java.util.Stack;

class Histogram
{
    int Histogram(int[] H,int n)
    {
        int max_area = -1;
        int area;
        Stack<Integer> S = new Stack<Integer>();

        S.push(0);//Index of first item...
        int i=1;
        
        while(i < n)
        {
            try
            {
                while(H[i] < H[S.peek()] && S.empty()==false)  
                {
                    int x = S.pop();
                    if(S.empty())
                        area = H[x] * i;
                    else
                        area = H[x] * (i- S.peek() -1);
                    
                    if(max_area < area)
                        max_area = area;
                } 
            }
            catch(Exception e){}    //Throwning empty stack exception...

            S.push(i);
            i++;
        }

        while(!S.empty())
        {
            int x = S.pop();
            if(S.empty())
                area = H[x] * i;
            else
                area = H[x] * (i- S.peek() -1);
            
            if(max_area < area)
                max_area = area;
        }
        
        return max_area;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        Histogram ob = new Histogram();

        System.out.print("Enter n value : ");
        int n = jin.nextInt();

        System.out.println("Enter heights...");
        int[] H = new int[n];
        for(int i=0;i<n;i++)
            H[i] = jin.nextInt();

        System.out.println("Max Area is "+ob.Histogram(H,n)+" sq");
    }
};
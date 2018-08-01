import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

class JumpChampa
{
    public static void fn(int[] h,int n,int q,int s)
    {
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++)
            visited[i] = false;
        
        Arrays.sort(h);

        visited[s] = true;
        int result=0;
        
        for(int i=0;i<n;i++)
        {
            if(visited[i] == false)
            {
                result += q*Math.abs(h[s]-h[i]);
                s = i;
            }
        }
        
        System.out.println("Minimum amount is "+result);
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter number of cities...");
        int n = jin.nextInt();
        System.out.println("Enter quality of trip...");
        int q = jin.nextInt();
        System.out.println("Enter height of n cities...");
        int[] h = new int[n];
        for(int i=0;i<n;i++)
            h[i] = jin.nextInt();
        fn(h,n,q,0);
        jin.close();
    }
}
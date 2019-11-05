import java.util.*;

class Missing_number
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        int m = jin.nextInt();
        int[] M = new int[m];
        for(int i=0;i<m;i++) M[i] = jin.nextInt();
        
        Arrays.sort(N);
        Arrays.sort(M);
        for(int i=0,j=0;i<n;i++,j++)
        {
            if(N[i]!=M[j])
                System.out.print(M[j++]+" ");
        }
        
        jin.close();
    }
}
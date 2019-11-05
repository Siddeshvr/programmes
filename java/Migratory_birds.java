import java.util.Scanner;
import java.util.Arrays;

class Migratory_birds
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        
        int max=N[0];    
        for(int i=1;i<n;i++)
            if(max < N[i])
                max=N[i];
        int[] M = new int[max];
        Arrays.fill(M,0);
        for(int i=0;i<M.length;i++)
        {
            int k=0;
            for(int j=0;j<n;j++)
            {
                if(i+1==N[j]) k++;
            }
            M[i] = k;
        }
        max=M[0];
        int index=0;
        for(int i=1;i<M.length;i++)
            if(max < M[i])
            {
                max = M[i];
                index = i+1;
            }

        System.out.println(index);
        jin.close();
    }
}
import java.util.Scanner;

class Climbing_the_Leaderboard
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
        jin.close();

        int[] A = new int[n];     //Remove duplicates...
        int k=0;
        for(int i=0;i<n;i++)
        {
            if(i==n-1) A[k++]=N[i];
            else if(N[i]!=N[i+1]) A[k++]=N[i];
        }
        
        int rank=k+1,j=k-1;
        for(int i=0;i<m;i++)
        {
            while(j>=0)          //Go from last...continue where u left...for next score...
            {   
                if(j==k-1 && M[i]<A[j]) break; 
                else if(M[i]>=A[j]) rank--;
                else break;
                j--;
            }
            System.out.println(rank);
        }
    }
}
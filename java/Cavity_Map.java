import java.util.Scanner;

class Cavity_Map
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        char[][] N = new char[n][n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextLine().toCharArray();
        jin.close();    

        for(int i=1;i<n-1;i++)
            for(int j=1;j<n-1;j++)
                if((N[i][j] > N[i][j-1] && N[i][j] > N[i][j+1]) && (N[i][j] > N[i-1][j] && N[i][j] > N[i+1][j]))
                    N[i][j] = 'X';
        
        for(int i=0;i<n;i++)
            System.out.println(N[i]);
    }
}
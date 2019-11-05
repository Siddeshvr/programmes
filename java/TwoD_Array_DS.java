import java.util.Scanner;

class TwoD_Array_DS
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int[][] N = new int[6][6];
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
                N[i][j] = jin.nextInt();
        jin.close();

        int max=-99;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                int a = (N[i][j]+N[i][j+1]+N[i][j+2])+(N[i+1][j+1])+(N[i+2][j]+N[i+2][j+1]+N[i+2][j+2]);
                if(max < a) max = a;
            }
        }
        System.out.println(max);
    }
}
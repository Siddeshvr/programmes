import java.util.Scanner;
import java.lang.Math;

class Magic_square
{
    public static void main(String[] args) 
    {
        Scanner jin = new Scanner(System.in);
        int[][] M = new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                M[i][j] = jin.nextInt();

        int[][][] magic_mat = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}}, 
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, 
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},  
        };

        int min_value=99;
        for(int k=0;k<8;k++)
        {
            int crt_cost=0;
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                    crt_cost += Math.abs( M[i][j] - magic_mat[k][i][j] );
            if(crt_cost < min_value) min_value = crt_cost;
        }

        System.out.println(min_value);
        jin.close();
    }
}
import java.util.Scanner;
import java.util.ArrayList;

class Dynamic_Array
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int q = jin.nextInt();
        int[][] N = new int[q][3];
        for(int i=0;i<q;i++)
            for(int j=0;j<3;j++)
                N[i][j] = jin.nextInt();
        jin.close();

        int lastAnswer = 0;

        ArrayList<ArrayList<Integer>> L=new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++)
			L.add(new ArrayList<Integer>());

        for(int i=0;i<q;i++)
        {
            int x = (N[i][1]^lastAnswer)%n;
            if(N[i][0]==1)
            {
                L.get(x).add(N[i][2]);
            }
            else
            {
                int y = N[i][2]%L.get(x).size();
                lastAnswer = L.get(x).get(y);
                System.out.println(lastAnswer);
            }
        }
    }
}
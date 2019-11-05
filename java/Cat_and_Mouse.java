import java.util.Scanner;

class Cat_and_Mouse
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int q = jin.nextInt();
        int[][] N = new int[q][3];
        for(int i=0;i<q;i++)
            for(int j=0;j<3;j++)
                N[i][j] = jin.nextInt();
        for(int i=0;i<q;i++)
        {
            int d1=0,d2=0;
            if(N[i][0]<=N[i][2] && N[i][1]<=N[i][2])
            {
                d1 = N[i][2]-N[i][0];
                d2 = N[i][2]-N[i][1];
                if(d1<d2) System.out.println("Cat A");
                else if(d2<d1) System.out.println("Cat B");
                else System.out.println("Mouse C");
            }
            else if(N[i][0]>=N[i][2] && N[i][1]>=N[i][2])
            {
                d1 = N[i][0]-N[i][2];
                d2 = N[i][1]-N[i][2];
                if(d1<d2) System.out.println("Cat A");
                else if(d1>d2) System.out.println("Cat B");
                else System.out.println("Mouse C");
            }
            else if(N[i][0]>=N[i][2])
            {
                d1 = N[i][0]-N[i][2];
                d2 = N[i][2]-N[i][1];
                if(d1<d2) System.out.println("Cat A");
                else if(d2<d1) System.out.println("Cat B");
                else System.out.println("Mouse C");
            }
            else if(N[i][1]>=N[i][2])
            {
                d1 = N[i][2]-N[i][0];
                d2 = N[i][1]-N[i][2];
                if(d1<d2) System.out.println("Cat A");
                else if(d2<d1) System.out.println("Cat B");
                else System.out.println("Mouse C");
            }
        }
        jin.close();
    }
}
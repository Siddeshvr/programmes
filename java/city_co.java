//Cities and Co-ordinates...
import java.util.Scanner;
import java.lang.Math;

class city_co
{
    public static int fn(int[][] C,int n)
    {   
        int min1=C[0][0],max1=C[0][0],min2=C[0][1],max2=C[0][1];
        for(int i=1;i<n;i++)
            if(min1 > C[i][0])
                min1 = C[i][0];
        for(int i=1;i<n;i++)
            if(max1 < C[i][0])
                max1 = C[i][0];
        for(int i=1;i<n;i++)
            if(min2 > C[i][1])
                min2 = C[i][1];
        for(int i=1;i<n;i++)
            if(max2 < C[i][1])
                max2 = C[i][1];

        //System.out.println(Math.abs(min1)+max1);
        //System.out.println(Math.abs(min2)+max2);
        return (Math.abs(min1)+max1) > (Math.abs(min2)+max2) ? (Math.abs(min1)+max1)*(Math.abs(min1)+max1) : (Math.abs(min2)+max2)*(Math.abs(min2)+max2);
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter number of cities...");
        int n = jin.nextInt();
        System.out.println("Enter "+n+" co-ordinates...");
        int C[][] = new int[n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                C[i][j] = jin.nextInt();
        System.out.println("Minimum area is "+fn(C,n)+" sqmt");
        jin.close();
    }
}
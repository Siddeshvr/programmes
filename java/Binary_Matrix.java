import java.util.Scanner;
import java.lang.Math;

class Binary_Matrix
{
    public static int fn(int[] B,int n,int m)
    {
        int index=0,result=0;
        int temp = result;
        for(int i=0;i<n;i++)
        {
            result = 0;
            for(int j=0;j<m;j++) 
            {
                int x = B[i]/10;
                result += (B[i]%10)*Math.pow(2,j);
                B[i] = x;
            }
            //System.out.println("R "+result);
            //System.out.println("T "+temp);
            if(result > temp) 
            {
                index=i;
                temp = result;
            }
        }
        return index+1;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter N and M value...");
        int n = jin.nextInt();
        int m = jin.nextInt();
        System.out.println("Enter "+n+" Binary number of length "+m);
        int[] B = new int[n];
        for(int i=0;i<n;i++)
            B[i] = jin.nextInt();
        //System.out.println("Max number index is "+fn(B,n,m));
        System.out.println(fn(B,n,m)+"th number is the maximum");
        jin.close();
    }
}
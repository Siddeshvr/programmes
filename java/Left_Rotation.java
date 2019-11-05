import java.util.Scanner;

class Left_Rotation
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int d = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        jin.close();

        d = n-d;
        int[] M = new int[n];
        for(int i=0;i<n;i++)
        {
            int index = (i+d)%n;
            M[index] = N[i];
        }
        for(int i=0;i<n;i++)
            System.out.print(M[i]+" ");
        System.out.println();
    }
}
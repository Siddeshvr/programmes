import java.util.Scanner;

class Jumping_on_the_Clouds
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int k = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();
        int l = 100;
        int i=0;
        do 
        {
            i++;
            if(N[(k*i)%n] == 1) l -= 3;
            else l -= 1;
        } while ((k*i)%n != 0);
        System.out.println(l);
        jin.close();
    }
}
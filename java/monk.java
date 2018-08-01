//Monk visit Coreland...
import java.util.Scanner;

class monk
{
    public static void fn(int[] C,int[] L,int n)
    {
        int result=0;
        int j=0;
        int k=0;
        result = C[j]*L[k++];  //first checkpoint...
        while(k<n)
        {
            if(C[j] > C[k])
                j++;
            else
                result += C[j]*L[k++];
        }
        System.out.println("Minimum cost is "+result+" ₹");
    }

    public static void main(String[] ars)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter number of checkpoints...");
        int n = jin.nextInt();
        System.out.println("Enter cost of petrol/lt in each checkpoints...");
        int[] C = new int[n];
        for(int i=0;i<n;i++)
            C[i] = jin.nextInt();
        System.out.println("Enter amount of petrol required to reach next point from current...");
        int[] L = new int[n];
        for(int i=0;i<n;i++)
            L[i] = jin.nextInt();
        fn(C,L,n);
        jin.close();
    }
}
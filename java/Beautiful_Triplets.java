import java.util.Scanner;

class Beautiful_Triplets
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int d = jin.nextInt();
        int[] Array = new int[n];
        for(int i=0;i<n;i++) Array[i] = jin.nextInt();
        jin.close();

        int count=0;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(Array[j]-Array[i]==d)
                    for(int k=j+1;k<n;k++)
                        if(Array[k]-Array[j]==d) count++;
        System.out.println(count);
    }
}
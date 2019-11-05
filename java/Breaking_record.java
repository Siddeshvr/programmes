import java.util.Scanner;

class Breaking_record
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
            N[i] = jin.nextInt();

        int max=N[0],min=N[0],i=0,j=0;
        for(int k=1;k<n;k++)
        {
            if(N[k]>max)
            {
                i++;
                max = N[k];
            }
            else if(N[k]<min)
            {
                j++;
                min = N[k];
            }
        }
        System.out.println(i+" "+j);
        jin.close();
    }
}
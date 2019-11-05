import java.util.Scanner;

class Grading_system
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++)
        {
            N[i] = jin.nextInt();
            if(N[i]>37)
            {
                int r = N[i]%10;
                if(r>7 || (r>2 && r<5))
                {
                    if((r>2 && r<5)) N[i] += 5-r;
                    else N[i] += 10-r;
                }
            }
        }
        for(int i=0;i<n;i++)
            System.out.println(N[i]);
        jin.close();
    }
}
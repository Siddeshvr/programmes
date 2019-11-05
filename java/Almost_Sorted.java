import java.util.Scanner;

class Almost_Sorted
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n+1];
        int count=0,index=0;
        for(int i=1;i<=n;i++)
        {
            N[i] = jin.nextInt();
            if(N[i-1]<N[i] && N[index-count]>N[i] && count!=0) 
            {
                System.out.println("no");
                return;
            }
            else if(i>1 && N[i-1]>N[i])
            {
                count++;
                index=i;
            }
        }

        if(count==0) System.out.println("yes");
        else if(index-count == index-1) System.out.println("yes\n"+"swap"+" "+(index-count)+" "+index);
        else System.out.println("yes\n"+"reverse"+" "+(index-count)+" "+index);
        jin.close();
    }
}
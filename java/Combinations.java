import java.util.Scanner;

class Combinations
{
    public static void fn(int[] Array,int[] data,int start,int end,int index,int r)
    {
        if(index == r)
        {
            for(int i=0;i<r;i++) System.out.print(data[i]+" ");
            System.out.println();
            return;
        }
        
        for(int i=start ; i<=end && end-i+1 >= r-index ; i++)
        {
            data[index] = Array[i];
            fn(Array,data,i+1,end,index+1,r);
        }
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int r = jin.nextInt();
        int[] Array = new int[n];
        for(int i=0;i<n;i++) Array[i] = jin.nextInt();
        jin.close();

        int[] data = new int[r];
        fn(Array,data,0,n-1,0,r);
    }
}
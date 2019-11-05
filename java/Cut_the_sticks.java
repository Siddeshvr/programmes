import java.util.Scanner;

class Cut_the_sticks
{
    void find_k(int[] N)       //To find remaining numbers...
    {
        int k=0;
        for(int i=0;i<N.length;i++)
            if(N[i]>0) k++;
        System.out.println(k);
    }

    int smallest(int[] N)
    {
        int min=99;
        for(int i=0;i<N.length;i++)
            if(N[i]>0 && min>N[i]) 
                min = N[i]; 
        return min==99?0:min;            //If 0 is min , stop...
    }

    void fn(int[] N,int n)
    {
        while(true)
        {
            int min = smallest(N);
            if(min == 0) return;
            find_k(N);
            for(int j=0;j<n;j++) N[j] -= min;
        }
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++) N[i] = jin.nextInt();
        jin.close();

        Cut_the_sticks obj = new Cut_the_sticks();
        obj.fn(N,n);
    }
}
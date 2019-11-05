import java.util.Scanner;

class merge_sort
{
    void merge(int[] A,int m,int l,int r)
    {
        int p = m-l+1;
        int q = r-m;
        int[] B = new int[p];
        int[] C = new int[q];

        for(int i=0;i<p;i++)
            B[i] = A[l+i];
        for(int j=0;j<q;j++)
            C[j] = A[m+j+1];

        int i=0,j=0,k=l;
        while(i<p && j<q)
        {
            if(B[i] <= C[j])
                A[k++] = B[i++];
            else
                A[k++] = C[j++];
        }
        while(i<p)
            A[k++] = B[i++];
        while(j<q)
            A[k++] = C[j++];
    }

    void Sort(int[] A,int l,int r)
    {
        if(l < r)
        {
            int m = (l+r)/2;    //Brackets compulsory...
            Sort(A,l,m);
            Sort(A,m+1,r);
            merge(A,m,l,r);
        }
    }

    public static void main(String[] args)
    {
        merge_sort ob = new merge_sort();
        Scanner jin = new Scanner(System.in);
        System.out.print("Enter n value : ");
        int n = jin.nextInt();
        System.out.print("Enter elements : ");
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = jin.nextInt();
        ob.Sort(A,0,n-1);

        System.out.print("Sorted array : ");
        for(int i=0;i<n;i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
};

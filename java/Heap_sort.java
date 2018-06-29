import java.util.Scanner;

class Heap_sort
{
    public static void heapify(int[] A,int n,int i)
    {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<n && A[l]<A[largest])
            largest = l;
        if(r<n && A[r]<A[largest])
            largest = r;
        if(largest != i)
        {
            int item = A[largest];
            A[largest] = A[i];
            A[i] = item;
            heapify(A,n,largest);
        }
    }

    public static void Heap_sort(int[] A,int n)
    {
        for(int i=n/2-1;i>=0;i--)
            heapify(A,n,i);

        for(int i=n-1;i>=0;i--)
        {
            System.out.print(A[0]+" ");
            int item = A[0];
            A[0] = A[i];
            A[i] = item;
            heapify(A,i,0);
        }
    }

    public static void main(String[] arg)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n = jin.nextInt();
        System.out.println("Enter elements...");
        int[] A = new int[10];
        for(int i=0;i<n;i++)
            A[i] = jin.nextInt();
        System.out.println("Sorted order is...");
        Heap_sort(A,n);
        System.out.println(" ");
    }
}
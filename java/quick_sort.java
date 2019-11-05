class quick_sort
{
    public static int swap(int a,int b){return a;}

    public static int partition(int[] A,int l,int r)
    {
        int pivot = A[l],i=l+1,j=r;
        while(i<j)
        {
            while(A[i]<pivot && i<j) i++;
            while(A[j]>pivot) j--;
            if(i<j) A[i] = swap(A[j],A[j]=A[i]);
        }
        A[l] = swap(A[j],A[j]=A[l]);
        return i-1;
    }

    public static void Sort(int[] A,int l,int r)
    {
        if(l<r)
        {
            int p = partition(A,l,r);
            Sort(A,l,p-1);
            Sort(A,p+1,r);
        }
    }

    public static void main(String[] args) 
    {
        int[] A = {10,20,50,100,2};
        Sort(A,0,4);
        for(int i=0;i<5;i++)
            System.out.print(A[i]+" ");
        System.out.println(); 
    }
}
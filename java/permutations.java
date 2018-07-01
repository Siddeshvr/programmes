class permutations
{
    int swap(int a,int b)
    {
        return a;
    }

    void per(int[] x,int l,int r) 
    {
        if(l==r)
        {
            for(int i=0;i<x.length;i++)
                System.out.print(x[i]+" ");
            System.out.println("");
            return;
        }
        
        for(int i=l;i<=r;i++)
        {
            x[i] = swap(x[l] , x[l]=x[i]);
            per(x,l+1,r);
            x[i] = swap(x[l] , x[l]=x[i]);
        }
        
    }

    public static void main(String[] args) 
    {
        permutations ob = new permutations();
        int[] x = {1,2,3};
        ob.per(x,0,x.length-1);    
    }
}

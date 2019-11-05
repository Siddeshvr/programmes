import java.util.*;

class Travelling_salesman
{
    public static int swap(int a,int b){return a;}
    public static int min=999;

    public static void next_perm(int[][] L,int[] v,int l,int r,int s)
    {
        if(l==r)
        {
            int cur_weight = 0;
            int k = s;
            for(int i=0;i<v.length;i++)
            {
                cur_weight += L[k][v[i]];
                k = v[i];
            }
            cur_weight += L[k][s];
            if(min > cur_weight) min = cur_weight;
        }

        for(int i=l;i<=r;i++)
        {
            v[i] = swap(v[l],v[l]=v[i]);
            next_perm(L,v,l+1,r,s);
            v[i] = swap(v[l],v[l]=v[i]);
        }
    }

    public static void main(String[] args)
    {
        int[][] L = {{0,10,15,20},{10,0,35,25},{15,35,0,30},{20,25,30,0}};
        int[] v = {1,2,3};
        next_perm(L,v,0,v.length-1,0);
        System.out.println(min);
    }
}
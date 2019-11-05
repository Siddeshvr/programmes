import java.util.Scanner;
import java.lang.System;

class Game_Of_Thrones
{
    public static boolean palindrom(char[] C)
    {
        int j=C.length-1;
        int temp=0;
        for(int i=0;i<C.length/2+1;i++)
        {
            if(C[i] != C[j])
            {
                temp=1;
                break;
            }
            j--;
        }
        if(temp==1) return false;
        else return true;
    }

    public static char swap(char a,char b) {return a;}

    public static void permutation(char[] C,int l,int r)
    {
        if(l==r)
        {
            if(palindrom(C)) 
            {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for(int i=l;i<=r;i++)
        {
            C[i] = swap(C[l] , C[l]=C[i]);
            permutation(C,l+1,r);
            C[i] = swap(C[l] , C[l]=C[i]);
        }
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        char[] C = jin.nextLine().toCharArray();
        permutation(C,0,C.length-1);
        System.out.println("NO");
        jin.close();
    }
}
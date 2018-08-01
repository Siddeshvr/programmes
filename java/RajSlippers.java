import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

class RajSlippers
{
    public static int fn(int x,int y,int p,int q,int a,int b,int r,int s,int n,int[] h1,int[] m1,int[] h2,int[] m2)
    {
        int e=a;
        int f=b;
        /*
        if(p>a || (p==a && q>b))
        {
            e = p;
            f = q;
        }
        else
        {
            e = a;
            f = b;
        }
        */
        f = f+r+s+r;
        while(f > 60)
        {
            e++;
            f -= 60;
        }

        int index1=99;
        for(int i=0;i<n;i++)
        {
            if(h2[i]<a || (h2[i]==a && m2[i]<b))
            {
                index1 = i;
                break;
            }
        }
        int index2=99;
        for(int i=0;i<n;i++)
        {
            if((h1[i]>e || (h1[i]==e && m1[i]>f)) && (e<x || (e==x && f<y)))
            {
                index2 = i;
                break;
            }
        }

        if(index1 < index2)
            return index1;
        else if(index1 > index2)
            return index2;
        else
            return -1;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter in-time of hostel...");
        int x = jin.nextInt();
        int y = jin.nextInt();
        System.out.println("Time Raj wakes up...");
        int p = jin.nextInt();
        int q = jin.nextInt();
        System.out.println("Shop opening time...");
        int a = jin.nextInt();
        int b = jin.nextInt();
        System.out.println("Time to reach shop...");
        int r = jin.nextInt();
        System.out.println("Time Raj takes to select...");
        int s = jin.nextInt();
        System.out.println("Number of frnds...");
        int n = jin.nextInt();
        System.out.println("Enter his frnds time of using slippers...");
        int[] h1 = new int[n];
        int[] m1 = new int[n];
        int[] h2 = new int[n];
        int[] m2 = new int[n];
        for(int i=0;i<n;i++)
        {
            h1[i] = jin.nextInt();
            m1[i] = jin.nextInt();
            h2[i] = jin.nextInt();
            m2[i] = jin.nextInt();
        }
        int z = fn(x,y,p,q,a,b,r,s,n,h1,m1,h2,m2);
        if(z!=-1)
            System.out.println("Raj will take slipper from frnd "+(z+1));
        else
            System.out.println("He can't buy today...");
        jin.close();
    }
};
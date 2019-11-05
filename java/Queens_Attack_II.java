import java.util.Scanner;
import java.lang.Math;

class Queens_Attack_II
{
    public static int fn(int n,int k,int r,int c,int[] R,int[] C)
    {
        int l=c-1;
        int ri=n-c;
        int d=r-1;
        int u=n-r;
        int lu=Math.min(n-r, Math.abs(1-c));
        int ru=n - Math.max(r , c);
        int ld=Math.min(r , c) - 1;
        int rd=Math.min(n-c, r-1);
        int count = l+ri+d+u+lu+ru+ld+rd;
        for(int i=1;i<=k;i++)
        {
            if(R[i]==r) 
            {
                if(C[i]<c) count -= C[i];
                else if(C[i] > c) count -= n-C[i]+1;
            }
            else if(C[i]==c)
            {
                if(R[i]<r) count -= R[i];
                else if(R[i] > r) count -= n-R[i]+1;
            }
            else if(Math.abs(r-R[i]) == Math.abs(c-C[i]))
            {
                if(R[i]<r)
                {
                    if(C[i]<c) count -= ld-c+C[i]+1;        //ok...
                    else if(C[i]>c) count -= rd+c-C[i]+1;  //ok...
                }
                else if(R[i] > r)
                {
                    if(C[i]<c) count -= lu-c+C[i]+1; 
                    else if(C[i]>c) count -= rd+c-C[i]+1; 
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();        // the length of the board's sides...
        int k = jin.nextInt();        //number of obstacles...
        int r = jin.nextInt();
        int c = jin.nextInt();        //r and c refers to queens position...
        int[] R = new int[k+1];
        int[] C = new int[k+1];         //R and C refers to obstacles position...
        for(int i=1;i<=k;i++)
        {
            R[i] = jin.nextInt();
            C[i] = jin.nextInt();
        }
        jin.close();

        int res = fn(n,k,r,c,R,C);
        System.out.println(res);
    }
}











/*
import java.util.Scanner;

class Queens_Attack_II
{
    public static int fn(int n,int r,int c,int[][] B)
    {
        int count=0,i,j;
        i=c;
        while(i!=1)  //left...  
        {
            if(B[r][i-1]==1) break;
            count++;
            i--;
        } 
        i=c;
        while(i!=n)  //right...
        {
            if(B[r][i+1]==1) break;
            count++;
            i++;
        }
        i=r;
        while(i!=1)  //down...
        {
            if(B[i-1][c]==1) break;
            count++;
            i--;
        }
        i=r;
        while(i!=n)  //up...
        {
            if(B[i+1][c]==1) break;
            count++;
            i++;
        }
        i=c;
        j=r;
        while(i!=1 && j!=n)  //left-up...
        {
            if(B[j+1][i-1]==1) break;
            count++;
            i--;
            j++;
        }
        i=c;
        j=r;
        while(i!=n && j!=n) //right-up...
        {
            if(B[j+1][i+1]==1) break;
            count++;
            i++;
            j++;
        }
        i=c;
        j=r;
        while(i!=1 && j!=1) //left-down...
        {
            if(B[j-1][i-1]==1) break;
            count++;
            i--;
            j--;
        }
        i=c;
        j=r;
        while(i!=n && j!=1) //right-down...
        {
            if(B[j-1][i+1]==1) break;
            count++;
            i++;
            j--;
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();        // the length of the board's sides...
        int k = jin.nextInt();        //number of obstacles...
        int r = jin.nextInt();
        int c = jin.nextInt();        //r and c refers to queens position...
        int[] R = new int[k+1];
        int[] C = new int[k+1];         //R and C refers to obstacles position...
        int[][] B = new int[n+1][n+1];  //to create chess board where obstacles present...
        for(int i=1;i<=k;i++)
        {
            R[i] = jin.nextInt();
            C[i] = jin.nextInt();
            B[R[i]][C[i]] = 1;
        }
        jin.close();

        int res = fn(n,r,c,B);
        System.out.println(res);
    }
}
*/
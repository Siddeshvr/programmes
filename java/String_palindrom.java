import java.util.Scanner;

class String_palindrom
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        char[] S = jin.nextLine().toCharArray();
        int flag=0;
        for(int i=0,j=S.length-1 ; i<S.length/2+1 ; i++,j--)
            if(S[i] != S[j])
                flag=1;
        if(flag==1) System.out.println("NO");
        else System.out.println("YES");
        jin.close();
    }
}
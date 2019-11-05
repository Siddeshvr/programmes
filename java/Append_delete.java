import java.util.Scanner;
import java.util.Arrays;

class Append_delete
{
    public static boolean fn(String S,String T,int k)
    {
        if(S.length()+T.length() <= k) return true;

        int i=0;
        for( ; i<S.length() && i<T.length() ; i++)
            if(S.charAt(i) != T.charAt(i)) break;
        
        int minOperation = (S.length()-i)+(T.length()-i);
        return k >= minOperation && (k-minOperation)%2==0 ;
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        String S = jin.nextLine();
        String T = jin.nextLine();
        int k = jin.nextInt();
        System.out.println(fn(S,T,k)?"Yes":"No");
        jin.close();
    }
}

import java.util.*;

class Gemstones
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        String[] S = new String[n];
        for(int i=0;i<n;i++)
            S[i] = jin.nextLine();
        jin.close();
        int count=0;
        String A = "abcdefghijklmnopqrstuvwxyz";
        char[] C = A.toCharArray();
        for(int i=0;i<C.length;i++) 
        {
            int flag=0;
            CharSequence c = Character.valueOf(C[i]).toString();
            for(int j=0;j<n;j++)
            {
                if(!S[j].contains(c))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0) count++;
        }
        System.out.println(count);
    }
}
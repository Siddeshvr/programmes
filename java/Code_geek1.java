import java.util.Scanner;
import java.util.Arrays;

class Code_geek1
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        String[] S = new String[n];
        for(int i=0;i<5;i++)
            S[i] = jin.nextLine();
        Arrays.sort(S);
        
        String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String a = "abcdefghijklmnopqrstuvwxyz";

        int t = jin.nextInt();
        jin.nextLine();
        char[][] C = new char[t][];
        for(int i=0;i<t;i++)
            C[i] = jin.nextLine().toCharArray();
        
        for(int i=0;i<t;i++)
        {
            String C1 = new String(C[i]);
            int b = Arrays.asList(S).indexOf(C1);
            
            int z=0;
            int y=0;
            for(int x=0;x<C[i].length;x++)
            {
                CharSequence c = Character.valueOf(C[i][x]).toString();
                if(A.contains(c))
                    y = A.indexOf(C[i][x])+1;
                else if(a.contains(c))
                    y = a.indexOf(C[i][x])+1;
                z += y;
            }
            int res = z*(b+1);
            System.out.println(res);
        }
        jin.close();
    }
}
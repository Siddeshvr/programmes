import java.util.Arrays;
import java.util.Scanner;

class Two_Strings
{
    
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();           //Consume next line...
        char[][] C = new char[n][];
        char[][] S = new char[n][];
        for(int j=0;j<n;j++)
        {
            S[j] = jin.nextLine().toCharArray();
            C[j] = jin.nextLine().toCharArray();
        }

        for(int j=0;j<n;j++)
        {
            int flag=0;
            String c = Arrays.toString(S[j]);
            for(int i=0;i<C[j].length;i++) 
            {
                CharSequence a = Character.valueOf(C[j][i]).toString();
                if(c.contains(a)) flag=0; 
                else 
                {
                    flag=1;
                    break;
                }
            }

            String d = Arrays.toString(C[j]);
            for(int i=0;i<S[j].length;i++) 
            {
                CharSequence a = Character.valueOf(S[j][i]).toString();
                if(d.contains(a)) flag=0; 
                else 
                {
                    flag=1;
                    break;
                }
            }

            if(flag==0) System.out.println("YES");
            else System.out.println("NO");
        }
        
        jin.close();
    }
}
import java.util.Arrays;
import java.util.Scanner;

class Two_Strings
{
    
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();           //Consume next line...mandatory during array String or character...
        char[][] C = new char[n][];
        char[][] S = new char[n][];
        for(int j=0;j<n;j++)
        {
            S[j] = jin.nextLine().toCharArray();   //character array which stores string...
            C[j] = jin.nextLine().toCharArray();
        }

        for(int j=0;j<n;j++)   
        {
            int flag=0;
            String c = Arrays.toString(S[j]);         //character array to String...
            for(int i=0;i<C[j].length;i++)            //this loop is to compare first string with second....
            {
                CharSequence a = Character.valueOf(C[j][i]).toString();   //character to character-sequence...
                if(c.contains(a)) flag=0; 
                else 
                {
                    flag=1;
                    break;
                }
            }

            String d = Arrays.toString(C[j]);
            for(int i=0;i<S[j].length;i++)           //this loop is to compare second string with first....
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
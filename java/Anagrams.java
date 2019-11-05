import java.util.Arrays;
import java.util.Scanner;
/*
class Anagrams
{
    public static int fn(String A,String B,char[] S,char[] C)
    {
        int count=0;

        int len=B.length();
        String c = new String(S);   //array to string...
        for(int i=0;i<len;i++)            //this loop is to compare first string with second....
        {
            CharSequence a = Character.valueOf(C[i]).toString();   //character to character-sequence...
            if(c.contains(a)) 
            {
                String x = a.toString();  //char-sequence to String...
                int z = c.indexOf(x);     //get index of x in c...
                c = c.replaceFirst(String.valueOf(c.charAt(z)), "");   //remove x from c...here c is string...
                char[] C1 = Arrays.copyOfRange(C,1,B.length());        //remove first character from C...here C is char-array...
                C = C1;
                i--;
                len--;
            } 
            else count++;
        }


        String d = new String(C);
        S = c.toCharArray();    //String to character array...
        len = c.length();
        for(int i=0;i<len;i++)           //this loop is to compare second string with first....
        {
            CharSequence a = Character.valueOf(S[i]).toString();
            if(d.contains(a)) 
            {
                String x = a.toString();
                int z = d.indexOf(x);
                d = d.replaceFirst(String.valueOf(d.charAt(z)), "");
                char[] C1 = Arrays.copyOfRange(S,1,B.length());
                S = C1;
                i--;
                len--;
            } 
            else count++;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();

        for(int i=0;i<n;i++)
        {
            char[] S = new char[10000];
            char[] C = new char[10000];
    
            String A = jin.nextLine();
            String B = jin.nextLine();
    
            S = A.toCharArray();
            C = B.toCharArray();            
            int count = fn(A,B,S,C);
            System.out.println(count);
        }
        jin.close();
    }
}
*/
import java.util.Scanner;
import java.lang.Math;
class Anagrams
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        jin.nextLine();
        for(int i=0;i<t;i++)
        {
            int count=0;
            char[] C = jin.nextLine().toCharArray();
            char[] S = jin.nextLine().toCharArray();
            
            int[] C1 = new int[123];
            int[] S1 = new int[123];
            for(int j=0;j<C.length;j++)
                C1[C[j]]++;
            for(int j=0;j<S.length;j++)
                S1[S[j]]++;

            for(int j='a';j<='z';j++)
            {
                if(C1[j]!=0 || S1[j]!=0)
                {
                    count += Math.abs(C1[j]-S1[j]);
                }
            }
            System.out.println(count);
        }
        jin.close();
    }
}   
import java.util.Arrays;
import java.util.Scanner;

class Bigger_is_greater
{
    public static char[] S;

    public static boolean nextPermutation() 
    {
        int i = S.length - 1;
        while (i > 0 && S[i - 1] >= S[i]) {
            i--;
        }
    
        if (i <= 0) {
            return false;
        }
    
        int j = S.length - 1;
    
        while (S[j] <= S[i - 1]) {
            j--;
        }
    
        char temp = S[i - 1];
        S[i - 1] = S[j];
        S[j] = temp;
    
        j = S.length - 1;
    
        while (i < j) {
            temp = S[i];
            S[i] = S[j];
            S[j] = temp;
            i++;
            j--;
        }
    
        return true;
    }



    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        jin.nextLine();

        for(int k=0;k<t;k++)
        {
            S = jin.nextLine().toCharArray();

            boolean x = nextPermutation();

            if(x) System.out.println(S);
            else System.out.println("no answer");
        }

        jin.close();
    }
}
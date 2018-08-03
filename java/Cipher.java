import java.util.Scanner;

class Cipher
{
    public static void fn(char[] S,int q)
    {
        for(int i=0;i<S.length;i++)
        {
            if((int)S[i] >= 48 && (int)S[i] <= 57)
            {
                S[i] += q;
                while((int)S[i] > 57)                    
                    S[i] -= 10;
            }
            else if((int)S[i] >= 65 && (int)S[i] <= 90)
            {
                S[i] += q;
                while((int)S[i] > 90) 
                    S[i] -= 26;
            }
            else if((int)S[i] >= 97 && (int)S[i] <= 122)
            {
                S[i] += q;
                while((int)S[i] > 122) 
                    S[i] -= 26;
            }
        }
        System.out.println(S);
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter a String...");
        char[] S = jin.nextLine().toCharArray();
        System.out.println("Enter Encrypt key...");
        int q = jin.nextInt();
        fn(S,q);
        jin.close();
    }
}
//Robort Exploring ancient ruins...

import java.util.Scanner;

class ExploringRuins
{
    public static void fn(char[] C, int n)
    {
        for(int i=0;i<n;i++)
        {
            if(C[i] == '?')
            {
                if(i==0)
                {
                    if(C[i+1] != 'a')
                        C[i] = 'a';
                    else
                        C[i] = 'b';
                }
                else if(i==n-1)
                {
                    if(C[i-1] != 'a')
                        C[i] = 'a';
                    else
                        C[i] = 'b';
                }
                else
                {
                    if(C[i-1]=='a')
                        C[i] = 'b';
                    else if(C[i+1] == 'a')
                        C[i] = 'b';
                    else 
                        C[i] = 'a';
                }
            }
        }
        System.out.println("Your String is...");
        for(int i=0;i<n;i++)
            System.out.print(C[i]);
        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        System.out.println("Enter a string...");
        String S = jin.nextLine();
        char[] C = S.toCharArray();
        fn(C,S.length());
        //System.out.println(S.charAt(0)); 
        jin.close();        
    }
}
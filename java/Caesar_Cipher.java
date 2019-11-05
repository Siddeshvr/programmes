import java.util.Scanner;

class Caesar_Cipher
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        char[] S = jin.nextLine().toCharArray();
        int k = jin.nextInt();
        jin.close();
        
        for(int i=0;i<S.length;i++)
        {
            if((S[i]>='A' && S[i]<='Z') || (S[i]>='a' && S[i]<='z'))
            {
                if(S[i]>='a' && S[i]<='z' && S[i]+k > 'z') 
                {
                    int x = 'a'+(S[i]-'a'+k)%26;
                    S[i] = (char)x;
                }
                else if(S[i]>='A' && S[i]<='Z' && S[i]+k>'Z') 
                {
                    int x = 'A'+(S[i]-'A'+k)%26; 
                    S[i] = (char)x;
                }
                else S[i] += k;
            }
        }
        System.out.println(S);
    }   
}
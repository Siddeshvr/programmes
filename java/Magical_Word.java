import java.util.Scanner;

class Magical_Word
{
    public static void main(String args[] )
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        for(int i=0;i<t;i++)
        {
            int n = jin.nextInt();
            jin.nextLine();            
            char[] S = jin.nextLine().toCharArray();
            for(int j=0;j<S.length;j++)
            {
                if(S[j]<=(char)93)
                {
                    if(S[j]<=69) S[j]=(char)67;
                    else if(S[j]<=72) S[j]=(char)71;
                    else if(S[j]<=76) S[j]=(char)73;
                    else if(S[j]<=81) S[j]=(char)79;
                    else if(S[j]<=86) S[j]=(char)83;
                    else S[j]=(char)89;
                }
                else
                {
                    if(S[j]<=99) S[j]=(char)97;
                    else if(S[j]<=102) S[j]=(char)101;
                    else if(S[j]<=105) S[j]=(char)103;
                    else if(S[j]<=108) S[j]=(char)107;
                    else if(S[j]<=111) S[j]=(char)109;
                    else S[j]=(char)113;
                }
            }
            System.out.println(S);
        }
        jin.close();
    }
}

import java.util.Scanner;

class HackerRank_String
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        String Str = "hackerrank";
        char[] C = Str.toCharArray();
        for(int k=0;k<n;k++)
        {
            char[] S = jin.nextLine().toCharArray();
            int j=0,i=0;
            for(;i<C.length;i++)
            {
                if(j==S.length) break;
                for(;j<S.length;j++)
                {
                    if(C[i]==S[j]) 
                    {
                        j++;
                        break;
                    } 
                }
            }
            System.out.println(i==C.length?"YES":"NO");
        }
        jin.close();
    }
}
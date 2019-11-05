import java.util.Scanner;
import java.util.Arrays;

class Happy_Ladybugs
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();

        for(int i=0;i<t;i++)
        {
            int n = jin.nextInt();
            jin.nextLine();
            char[] S = jin.nextLine().toCharArray();
            int count=0,flag=0;

            if(n==1 && S[n-1]!='_') System.out.println("NO");
            else if(n==1 && S[n-1]=='_') System.out.println("YES");
            else
            {
                for(int j=0;j<n;j++)
                    if(S[j]=='_') count++;
                int j=0;
                for(j=0;j<n-1;)
                {
                    int k=j+1;
                    while(k<n && S[j]!='_' && S[j]==S[k])
                        k++;
                    if(S[j]!='_' && k == j+1) 
                    {
                        flag=1;
                        break;
                    }
                    j=k;
                }

                if(count == 0 && flag == 0) System.out.println("YES");
                else if(count==0 && flag==1) System.out.println("NO");
                else
                {
                    flag=0;
                    Arrays.sort(S);
                    for(j=0;j<n-1;)
                    {
                        int k=j+1;
                        while(S[j]!='_' && S[j]==S[k])
                            k++;
                        if(S[j]!='_' && k == j+1) 
                        {
                            flag=1;
                            break;
                        }
                        j=k;
                    }
                    if(flag==1) System.out.println("NO"); 
                    else System.out.println("YES");
                }
            }
        }

        jin.close();
    }
}
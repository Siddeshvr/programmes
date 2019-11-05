import java.util.Scanner;

class ACM_ICPC_Team
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int m = jin.nextInt();
        jin.nextLine();
        char[][] C = new char[n][m];
        for(int i=0;i<n;i++)
            C[i] = jin.nextLine().toCharArray();
        jin.close();

        int max=0,res=1;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int k=0,temp=0;
                while(k<m)
                {
                    if(C[i][k]=='1') temp++;
                    else if(C[i][k]=='0' && C[j][k]=='1') temp++;
                    k++;
                }
                if(max < temp)
                {
                    max = temp;
                    res=1;
                }
                else if(max == temp) res++;
            }   
        }
        System.out.println(max+"\n"+res);
    }
}
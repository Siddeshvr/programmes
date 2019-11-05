import java.util.Scanner;

class Magical_World
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        for(int k=0;k<n;k++)
        {
            int l = jin.nextInt();
            jin.nextLine();
            char[] C = jin.nextLine().toCharArray();
            for(int i=0;i<l;i++)
            {
                int x = (int)C[i];   
                int y = (int)C[i];   
                int flag=0;          
                for(int j=2;j<x/2+1;j++) 
                {
                    if(x%j==0 || y%j==0) 
                    {
                        if(x%j==0)x++;
                        if(y%j==0) y--;
                        j = 2;
                        flag = 1;
                    } 
                }
                if(flag==0)
                {
                    int a = C[i] - y;
                    int b = x - C[i];
                    if(a <= b) C[i] = (char)y;
                    else C[i] = (char)x;
                }
            }
            System.out.println(C);
        }
        jin.close();
    }
}
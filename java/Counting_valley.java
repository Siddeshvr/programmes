import java.util.Scanner;

class Counting_valley
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        char[] C = jin.nextLine().toCharArray();
        int count=0,res=0;
        for(int i=0;i<n;i++)
        {
            if(count==0 && C[i]=='D')
            {
                count++;
                while(i<n)
                {
                    if(count==0) 
                    {
                        res++;
                        break;
                    }
                    else if(C[i+1]=='D') count++;
                    else if(C[i+1]=='U') count--;
                    i++;
                }
            }
            else if(C[i]=='D') count++;
            else if(C[i]=='U') count--;
        }
        System.out.println(res);
        jin.close();
    }
}
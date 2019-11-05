//Hacker-Rank...to change normal time format to railway format...
import java.util.Scanner;

class Time_format
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        String S = jin.nextLine();
        char[] C = S.toCharArray();

        if(C[S.length()-2] == 'A') 
        {
            if(C[0]==49 && C[1]==50)
            {
                C[0] += -1;
                C[1] += -2;
            }
            char[] C1 = new char[S.length()-2];
            for(int i=0;i<S.length()-2;i++)
                C1[i] = C[i];
            System.out.println(C1);
        }
            
        else
        {
            if(C[0]=='1' && C[1]=='2')
            {
                char[] C1 = new char[S.length()-2];
                for(int i=0;i<S.length()-2;i++)
                    C1[i] = C[i];
                System.out.println(C1);
            }
            else
            {
                C[1] += 2;
                if(C[1] > 57) 
                {
                    C[0] += 2;
                    C[1] += -10;
                }
                else
                    C[0] += 1;
                char[] C1 = new char[S.length()-2];
                for(int i=0;i<S.length()-2;i++)
                    C1[i] = C[i];
                System.out.println(C1);
            }
        }
        jin.close();
    }
}
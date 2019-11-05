import java.util.Scanner;

class Repeated_String
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        char[] S = jin.nextLine().toCharArray();
        long n = jin.nextLong();
        jin.close();

        int as=0;
        for(int i=0;i<S.length;i++) if(S[i]=='a') as++;  //To find number of a's in S...

        long reminder = n%S.length;
        long quotient = n/S.length;
        long result = quotient*as;
        if(reminder>0)
        {
            for(int i=0;i<reminder;i++)
                if(S[i]=='a') result++;
        }
        System.out.println(result);
    }
}
import java.util.*;

class Beautiful
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        jin.nextLine();
        char[] S = jin.nextLine().toCharArray();
        jin.close();
        int count=0;
        for(int i=0;i<S.length-2;)
        {
            System.out.println(S[i]+" "+S[i+1]+" "+S[i+2]);
            if(S[i]=='0' && S[i+1]=='1' && S[i+2]=='0')
            {
                count++;
                i = i+3;
            } 
            else i++;
        }
        System.out.println(count);
    }
}
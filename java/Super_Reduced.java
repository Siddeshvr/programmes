import java.util.Scanner;

class Super_Reduced
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        String S = jin.nextLine();
        jin.close();
        for(int i=1;i<S.length();i++)
            if(S.charAt(i)==S.charAt(i-1))
            {
                S = S.substring(0,i-1)+S.substring(i+1);
                i=0;
            }
        if(S.length()==0) System.out.println("Empty String");
        else System.out.println(S); 
    }
}
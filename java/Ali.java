import java.util.Scanner;

class Ali
{
    public static int check(char C)
    {
        if(C=='A'||C=='E'||C=='I'||C=='O'||C=='U'||C=='Y'||C=='a'||C=='e'||C=='i'||C=='o'||C=='u'||C=='y') 
            return 0;
        else return 1;
    }
    
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        String S = jin.nextLine();
        jin.close();
        
        char[] C = S.toCharArray();
        int i=0,flag=0;
        for(;i<C.length-1;i++)
        {
            while(C[i]=='-' || C[i+1]=='-')
                i++;
            if((C[i]>='A' && C[i]<='Z')||(C[i]>='a' && C[i]<='z'))
            {
                if(check(C[i])==0)
                {
                    flag=1;
                    break;
                }
            }
            else if((C[i+1]>='A' && C[i+1]<='Z')||(C[i+1]>='a' && C[i+1]<='z')) 
            {
                if(check(C[i+1])==0)
                {
                    flag=1;
                    break;
                }
                i++;
            }
            else if((C[i]+C[i+1])%2 != 0)
            {
                flag=1;
                break;
            }
        }
        System.out.println(flag==0?"valid":"invalid");
    }
}

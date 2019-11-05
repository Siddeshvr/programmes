import java.util.Scanner;

class Book_of_Potion
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        char[] C = jin.nextLine().toCharArray();
        jin.close();
        
        if(C.length != 10) System.out.println("Illegal ISBN");
        else
        {
            int sum=0;
            for(int i=0;i<C.length;i++)
                sum += (C[i]*(i+1));
            System.out.println((sum%11==0)?"Legal ISBN":"Illegal ISBN");
        }
    }
}
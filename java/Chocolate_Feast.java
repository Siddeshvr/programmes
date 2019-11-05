import java.util.Scanner;

class Chocolate_Feast
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();

        for(int i=0;i<t;i++)
        {
            int n = jin.nextInt();
            int c = jin.nextInt();
            int m = jin.nextInt();

            int total_choc = n/c;
            int totalWrappers = total_choc;
            int freeChocs = 0;
            while(totalWrappers >= m)
            {
                int wrapperTogive=totalWrappers-(totalWrappers % m) ;
                freeChocs = totalWrappers/m;
                totalWrappers = (totalWrappers - wrapperTogive) + freeChocs;
                total_choc += freeChocs;
            }
            System.out.println(total_choc);
        }
        jin.close();
    }
}
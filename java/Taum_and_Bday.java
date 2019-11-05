import java.util.Scanner;

class Taum_and_Bday
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        for(int i=0;i<t;i++)
        {
            long b = jin.nextLong();
            long w = jin.nextLong();
            long x = jin.nextLong();
            long y = jin.nextLong();
            long z = jin.nextLong();

            x = x>y? ((x-y>z)? y+z : x) : x;
            y = y>x? ((y-x>z)? x+z : y) : y;
            System.out.println(b*x+w*y);
        }
        jin.close();
    }
}

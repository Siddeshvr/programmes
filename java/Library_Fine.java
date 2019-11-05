import java.util.Scanner;

class Library_Fine
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int d1 = jin.nextInt();
        int m1 = jin.nextInt();
        int y1 = jin.nextInt();
        int d2 = jin.nextInt();
        int m2 = jin.nextInt();
        int y2 = jin.nextInt();
        jin.close();

        int res=0;
        if((y1<y2) || (y1<=y2 && m1<m2) || (y1<=y2 && m1<=m2 && d1<d2)) res=0;
        else if(y1>y2) res += 10000;
        else if(m1>m2) res += (500*(m1-m2));
        else if(d1>d2) res += (15*(d1-d2));
        System.out.println(res);
    }
}
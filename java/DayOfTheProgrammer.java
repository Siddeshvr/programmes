import java.util.Scanner;

class DayOfTheProgrammer
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int[] M = new int[]{31,28,31,30,31,30,31,31};
        int y = jin.nextInt();
        if(y<1918 && y%4==0) M[1]++;
        else if((y>=1919) && ((y%4==0 && y%100!=0) || (y%400==0))) M[1]++;
        else if(y==1918) M[1] -= 13;
        int sum=0;
        for(int i=0;i<8;i++)
            sum += M[i];
        sum = 256-sum;
        System.out.println(sum+".09."+y);
        jin.close();
    }
}
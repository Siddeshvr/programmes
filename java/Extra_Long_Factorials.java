import java.util.Scanner;
import java.math.BigInteger;

class Extra_Long_Factorials
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        BigInteger res = new BigInteger("1");
        for(int i=2;i<=n;i++)
            res = res.multiply(BigInteger.valueOf(i));
        System.out.println(res);
        jin.close();
    }
}
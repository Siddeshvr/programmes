import java.util.Scanner;

class Monk_walk
{
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        String S = "AEIOUaeiou";
        jin.nextLine();
        char[][] C = new char[100][];
        for(int i=0;i<t;i++)
            C[i] = jin.nextLine().toCharArray();

        for(int i=0;i<t;i++)
        {
            int count=0;
            for(int j=0;j<C[i].length;j++)
            {
                CharSequence a = Character.valueOf(C[i][j]).toString();
                if(S.contains(a)) count++;
            }
            System.out.println(count);
        }
        jin.close();
    }
}
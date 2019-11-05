class Tower_of_Hanoi
{
    public static void fn(int n,String source,String destination,String temp)
    {
        if(n == 1) {System.out.println(source+" to "+destination); return;}

        fn(n-1,source,temp,destination);
        System.out.println(source+" to "+destination);
        fn(n-1,temp,destination,source);
    }

    public static void main(String[] args)
    {
        fn(3,"source","destination","temp");
    }
}
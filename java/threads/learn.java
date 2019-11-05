class Mythread extends Thread
{
    public void run()
    {
        System.out.println("Does Thread "+Thread.currentThread().getName()+" holds lock "+Thread.holdsLock(this));
        synchronized(this)
        {
            System.out.println("Does Thread "+Thread.currentThread().getName()+" holds lock "+Thread.holdsLock(this));
        }
    }
}

class learn
{
    public static void main(String[] args)
    {
        Mythread t1 = new Mythread();
        Mythread t2 = new Mythread();
        t1.setName("Siddesh");
        t2.setName("Sanjay");
        t1.start();
        t2.start();
    }
}
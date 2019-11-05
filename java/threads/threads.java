/*
class Myclass extends Thread
{
    public void run()
    {
        for(int i=0;i<5;i++)
            System.out.println(Thread.currentThread().getId() + " value = "+i);
        
        try 
        {
            Thread.sleep(100);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();    
        }
    }
};


class Myclass implements Runnable
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(Thread.currentThread().getId() + " value = "+i);
            try{Thread.sleep(10);}catch(Exception e){}
        }
    }
};

class threads
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Myclass());
        Thread t2 = new Thread(new Myclass());
        t1.start();
        t2.start();
    }
};


class threads
{
    public static int count = 0;
    public static synchronized void inccount()
    {
        count++;
    }
    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<5;i++)
                    inccount();
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<5;i++)
                    inccount();
            }
        });

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch(Exception e){}

        System.out.println("value : "+count);
    }
}
*/

class Mythread implements Runnable
{
    Thread thrd;
    Mythread(String name)
    {
        thrd = new Thread(this,name);
        thrd.start();
    }
    public void run()
    {
        System.out.println(thrd.getName()+" Starting...");
        try
        {
            for(int c=0;c<10;c++)
            {
                Thread.sleep(400);
                System.out.println("In "+thrd.getName()+", count is "+c);
            }
        }
        catch(InterruptedException e){System.out.println(thrd.getName()+" intrrupted...");}

        System.out.println(thrd.getName()+" terminating...");
    }
}

class threads
{
    public static void main(String[] args)
    {
        System.out.println("Main thread starting...");
        Mythread t1 = new Mythread("child1");
        Mythread t2 = new Mythread("child2");
        Mythread t3 = new Mythread("child3");

        for(int i=0;i<50;i++)
        {
            try{Thread.sleep(100);}
            catch(InterruptedException e){System.out.println("Main thread intrrupted...");}
        }
        System.out.println("Main thread terminating...");
    }
}
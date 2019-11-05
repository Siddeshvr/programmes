import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Date;

public class applet extends Applet
{
    private static final long serialVersionUID = 1L;    //just a synchronization ID...
    /*
    public void paint(Graphics g)
    {
        g.drawString("Hello World",20,20);
    }
    */

    Mythread m;
    Date d;

    public void start()
    {
        m = new Mythread(this);
        m.t.start();
    }
    public void paint(Graphics g)
    {
        g.drawString(d.toString(),40,40);
    }
}

class Mythread implements Runnable
{
    Thread t;
    applet ma;

    Mythread(applet ma)
    {
        this.ma = ma;
        t = new Thread(this);
    }
    public void run()
    {
        while(true)
        {
            ma.d = new Date();
            ma.repaint();
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
        }
    }
}
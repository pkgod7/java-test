
import java.net.ServerSocket;
import java.net.Socket;

public class TestThreadSocket extends Thread
{
    public int x1;
    public TestThreadSocket(int x)
    {
        x1=x;
    }
    public void run()
    {
        try
        {
            new ServerSocket(x1).accept();
        }
        catch(Exception err)
        {
        }
        System.out.println(x1);
    }
    public static void main(String args[])
    {
        TestThreadSocket c1=new TestThreadSocket(98);
        TestThreadSocket c2=new TestThreadSocket(99);
        TestThreadSocketGui c3=new TestThreadSocketGui();
        c1.start();
        c2.start();
    }
}

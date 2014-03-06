
import java.net.ServerSocket;

public class TestThreadSocket3 extends Thread
{
    public void run()
    {
        try
        {
                new ServerSocket(99).accept();
                while(true)
                {
                    System.out.println("server");
                }
        }
        catch(Exception err)
        {
        }
    }
}


import java.net.Socket;

public class TestThreadSocket2
{
    public TestThreadSocket2()
    {
        try
        {
            Socket connection=new Socket("localhost",99);
            while(true)
            {
                System.out.println("client");
            }
        }
        catch(Exception err)
        {
        }
    }
    public static void main(String args[])
    {
        new TestThreadSocket2();
    }
}


import java.net.Socket;

public class TestSocket2
{
    public TestSocket2()
    {
        try
        {
            Socket connection=new Socket("localhost",99);
            System.out.println("s");
        }
        catch(Exception err)
        {
        }
    }
    public static void main(String args[])
    {
        new TestSocket2();
    }
}

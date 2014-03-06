import java.io.DataInputStream;
import java.net.Socket;
public class TestUTFRead
{
    Socket connection;
    DataInputStream input;
    public TestUTFRead()
    {
        try
        {
            connection=new Socket("localhost",80);
            input=new DataInputStream(connection.getInputStream());
            System.out.println(input.readUTF());
        }
        catch(Exception err)
        {
        }
    }
    public static void main(String args[])
    {
        new TestUTFRead();
    }
}

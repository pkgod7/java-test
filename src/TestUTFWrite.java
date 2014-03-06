import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
public class TestUTFWrite
{
    Socket connection;
    DataOutputStream output;
    public TestUTFWrite()    
    {
        try
        {
            connection=new ServerSocket(80).accept();
            output=new DataOutputStream(connection.getOutputStream());            
            String x1="";
            File list[]=new File("src").listFiles();
            for(File file:list)
            {
                if(file.isFile())
                {
                    x1=x1+"\n"+file.getName();
                }
            }
            output.writeUTF(x1);
        }
        catch(Exception err)
        {
        }
    }
    public static void main(String args[])
    {
        new TestUTFWrite();
    } 
}

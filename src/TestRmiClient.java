import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
public class TestRmiClient
{
    public static void main(String args[])
    {
       TestRMI rmiServer;
       try
       {
           rmiServer=(TestRMI)(LocateRegistry.getRegistry("localhost",368).lookup("connection1"));
           rmiServer.establish(InetAddress.getLocalHost().getHostAddress());
       }
       catch(Exception err)
       {
       }
    }
}
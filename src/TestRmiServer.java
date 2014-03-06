import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
public class TestRmiServer extends UnicastRemoteObject implements TestRMI
{
    public TestRmiServer() throws RemoteException
    {
        try
        {
            LocateRegistry.createRegistry(368).rebind("connection1",this);
        }
        catch(Exception err)
        {
        }
    }
    public void establish(String x) throws RemoteException
    {
        System.out.println(x);
        System.exit(0);
    }
    public static void main(String args[])
    {
        try
        {
            new TestRmiServer();
        }
        catch(Exception err)
        {
        }
    }
}

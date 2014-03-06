import java.rmi.Remote;
import java.rmi.RemoteException;
public interface TestRMI extends Remote
{
    public void establish(String x) throws RemoteException;
}

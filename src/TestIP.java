
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class TestIP
{
    public static void main(String[] args) throws Exception
{
    System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
   
} 
}


import java.io.File;

public class TestFileExist
{
     public static void main(String args[])
    {
        if(new File("ahmad/pk.txt").exists())
        {
            System.out.println("exists");
        }
        else
        {
            System.out.println("nop");
        }
    }
}

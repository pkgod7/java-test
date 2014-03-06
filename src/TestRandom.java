
import java.util.Random;

public class TestRandom
{
    public static void main(String args[])
    {
        for(int i=0; i<10; i++)
        {
            System.out.println(i+" : "+(new Random().nextInt(100)+220));// random number bet 220 to 320
        }
    }
}

import javax.swing.*;
import java.awt.*;
public class TestRectangle
{
    public static void main(String args[])
    {
        Rectangle x1=new Rectangle(0,0,2,2);
        Rectangle x2=new Rectangle(1,1,1,1);
        if(x1.intersects(x2))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}

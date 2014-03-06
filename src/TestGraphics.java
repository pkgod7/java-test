import java.awt.*;
import javax.swing.*;
public class TestGraphics extends JFrame
{
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawString("hello",10,50);
        g.drawOval(10,70,50,50);
        g.drawLine(10,150,100,150);
        g.fillRect(10,200,50,50);
    }
    public static void main(String args[])
    {
        TestGraphics x1=new TestGraphics();
        x1.setSize(300,300);
        x1.setVisible(true);
        x1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

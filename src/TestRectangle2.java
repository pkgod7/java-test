import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TestRectangle2 extends JFrame
{
    public Rectangle x1;
    public Rectangle x2;
    public int x=80;
    public int y=80;
    public TestRectangle2()
    {
        addKeyListener(new Listener1());
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        x1=new Rectangle(50,50,20,20);
        x2=new Rectangle(x,y,10,10);
        g.setColor(Color.red);
        g.fillRect(x1.x,x1.y,x1.width,x1.height);
        g.setColor(Color.blue);
        g.fillRect(x,y,x2.width,x2.height);
        if(x1.intersects(x2))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
    class Listener1 implements KeyListener
    {
        public void keyTyped(KeyEvent e)
        {
        }
        public void keyReleased(KeyEvent e)
        {
        }
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                x-=1;
            }
            else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                x+=1;
            }
            else if(e.getKeyCode()==KeyEvent.VK_UP)
            {
                y-=1;
            }
            else if(e.getKeyCode()==KeyEvent.VK_DOWN)
            {
                y+=1;
            }
            System.out.println(x+" , "+y);
        }
    }
    public static void main(String args[])
    {
        TestRectangle2 frame=new TestRectangle2();
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true)
        {
            frame.repaint();
            try
            {
                Thread.sleep(80);
            }
            catch(Exception err)
            {
            }
        }
    }
}

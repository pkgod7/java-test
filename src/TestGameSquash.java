import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TestGameSquash extends JFrame
{
    public Rectangle x1;
    public Rectangle x2;
    public int x=40;
    int y=50;
    public String yDirection="down";
    public static String end="no";
    public int xx=40;
    public String xxDirection="right";
    public TestGameSquash()
    {
        addKeyListener(new Listener1());
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        x1=new Rectangle(xx,y,10,10);
        x2=new Rectangle(x,70,50,10);
        g.setColor(Color.red);
        g.fillRect(x1.x,x1.y,x1.width,x1.height);
        g.setColor(Color.blue);
        g.fillRect(x2.x,x2.y,x2.width,x2.height);
        if(yDirection.equals("down"))
        {
            if(y+1<=82)
            {
                y+=1;
            }
            if(y==82)
            {
                end="yes";
            }
        }
        else if(yDirection.equals("up"))
        {
            if(y-1>=30)
            {
                y-=1;
            }
            if(y==30)
            {
                yDirection="down";
            }
        }
        if(xxDirection.equals("right"))
        {
            if(xx+1<=114)
            {
                xx+=1;
            }
            if(xx==114)
            {
                xxDirection="left";
            }
        }
        else if(xxDirection.equals("left"))
        {
            if(xx-1>=8)
            {
                xx-=1;
            }
            if(xx==8)
            {
                xxDirection="right";
            }
        }
        if(x1.intersects(x2))
        {
            yDirection="up";
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
                if(x-1>=8)
                {
                    x-=1;
                }
            }
            else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                if(x+1<=74)
                {
                    x+=1;
                }
            }
            else if(e.getKeyCode()==KeyEvent.VK_UP)
            {
                if(y-1>=30)
                {
                    y-=1;
                }
            }
            else if(e.getKeyCode()==KeyEvent.VK_DOWN)
            {
                if(y+1<=82)
                {
                    y+=1;
                }
            }
        }
    }
    public static void main(String args[])
    {
        TestGameSquash frame=new TestGameSquash();
        frame.setSize(100,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true)
        {
            if(end.equals("no"))
            {
                frame.repaint();
                try
                {
                    Thread.sleep(40);
                }
                catch(Exception err)
                {
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Game Over","Game Over",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
}

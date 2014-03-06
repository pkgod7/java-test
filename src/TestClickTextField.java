
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestClickTextField
{
    public JTextField x1;
    public JTextField x2;
    public JLabel x3;
    public TestClickTextField()       
    {
        JFrame frame=new JFrame("JTextField");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        JPanel pane=new JPanel();
        x1=new JTextField("x1");
        x2=new JTextField("x2");
        x3=new JLabel("wei");
        x1.addMouseListener(new Listener1());
        x2.addMouseListener(new Listener1());
        pane.add(x1);
        pane.add(x2);
        pane.add(x3);
        frame.add(pane);
    }
    class Listener1 extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==x1)
            {
                x3.setText("this is x1");
            }
            else if(e.getSource()==x2)
            {
                x3.setText("this is x2");
            }
        }
    }
    public static void main(String args[])
    {
        new TestClickTextField();
    }
}

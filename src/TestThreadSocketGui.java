
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestThreadSocketGui
{
    public JButton x1;
    public TestThreadSocketGui()
    {
        JFrame frame=new JFrame("JLabel");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        x1=new JButton("abc");
        x1.addActionListener(new Listener1());
        frame.add(x1);
    }
    class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==x1)
            {
                 TestThreadSocket3 t1=new TestThreadSocket3();
                 t1.start();
            }
        }
    }
    public static void main(String args[])
    {
        TestThreadSocketGui c1=new TestThreadSocketGui();
    }
}

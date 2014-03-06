
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestSocket1
{
    JButton x1=new JButton("ok");
    public TestSocket1()
    {
        JFrame frame=new JFrame("JLabel");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        x1.addActionListener(new Listener1());
        frame.add(x1);
    }
    class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==x1)
            {
                System.out.println("x1");
                try
        {
            Socket connection=new ServerSocket(999).accept();
        }
        catch(Exception err)
        {
        }
            }
        }
    }
    public static void main(String args[])
    {
        new TestSocket1();
    }
}

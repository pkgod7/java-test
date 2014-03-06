import javax.swing.*;
import java.awt.*;
public class TestFullScreen
{
    public JFrame frame;
    public JPanel pane;
    public JButton x1;
    public TestFullScreen()
    {
        frame=new JFrame("Client");
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        x1=new JButton("This is a button");
        pane=new JPanel();
        pane.setLayout(null);
        pane.add(x1);
        x1.setBounds(100,100,100,40);
        frame.add(pane);
    }
    public static void main(String args[])
    {
        new TestFullScreen();
    }
}

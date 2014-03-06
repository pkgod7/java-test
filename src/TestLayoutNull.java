
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestLayoutNull
{
     public static void main(String args[])
    {
        JFrame frame=new JFrame("Null");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLayout(null);
        JButton x1=new JButton("Hello");
        frame.add(x1);
        x1.setBounds(50,50,100,20);
    }
}

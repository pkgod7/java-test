
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtonLogo
{
    public static void main(String args[])
    {
        JFrame frame=new JFrame("TestButtonLogo");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        JButton x1=new JButton("Hello",new ImageIcon("upload.png"));
        frame.add(x1);
    }
}

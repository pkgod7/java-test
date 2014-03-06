
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGuiBorder
{
    public static void main(String args[])
    {
        JFrame frame=new JFrame("Border Layout");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLayout(new BorderLayout());
        frame.add(new JButton("center"),BorderLayout.CENTER);
        frame.add(new JButton("north"),BorderLayout.NORTH);
        frame.add(new JButton("south"),BorderLayout.SOUTH);
        frame.add(new JButton("east"),BorderLayout.EAST);
        frame.add(new JButton("west"),BorderLayout.WEST);
        
    }
}
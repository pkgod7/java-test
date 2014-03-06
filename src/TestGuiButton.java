
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestGuiButton
{
    public JFrame deco1;
    public JButton x1;
    public JButton x2;
    public JLabel x3;
    public TestGuiButton()
    {
        deco1=new JFrame();
        deco1.setSize(500,500);
        deco1.setDefaultCloseOperation(deco1.EXIT_ON_CLOSE);
        deco1.setVisible(true);
        deco1.setLayout(new GridLayout(3,1));
        x1=new JButton("Download");
        x1.addActionListener(new Listener1());
        x2=new JButton("Upload");
        x2.addActionListener(new Listener1());
        x3=new JLabel("Status..");
        deco1.add(x1);
        deco1.add(x2);
        deco1.add(x3);
        SwingUtilities.updateComponentTreeUI(deco1);
    }
    class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==x1)
            {
                x3.setText("Status : Download");
            }
            else if(e.getSource()==x2)
            {
                x3.setText("Status : Upload");
            }            
        }
    }
    public static void main(String args[])
    {
        new TestGuiButton();
    }
}

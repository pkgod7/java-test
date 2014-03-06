
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TestDirButton
{
    public int i=0;
    public JButton x1[];
    public TestDirButton()
    {
        JFrame frame=new JFrame("TestDirButton");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        JPanel pane=new JPanel();
        pane.setLayout(new GridLayout(0,1));
        File list[]=new File("src").listFiles();
        x1=new JButton[list.length];
        for(File file:list)
        {
            if(file.isFile())
            {
                x1[i]=new JButton(""+file.getName());
                x1[i].addActionListener(new Listener1());
                pane.add(x1[i]);
                i++;
            }
        }
        frame.add(new JScrollPane(pane));
    }
    class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            for(int y=0; y<i; y++)
            {
                if(e.getSource()==x1[y])
                {
                    System.out.println(x1[y].getText());
                }
            }
        }
    }
    public static void main(String args[])
    {
        new TestDirButton();
    }
}

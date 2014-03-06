
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestButtonAndCard
{
    public JFrame frame;
    public JButton x1;
    public JButton x2;
    public JLabel x3;
    public JPanel pane;
    public CardLayout deck;
    public JPanel a;
    public JPanel b;
    public JButton a1;
    public JButton a2;
    public JButton b1;
    public JButton b2;
    public TestButtonAndCard()
    {
        frame=new JFrame("Button + Card");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        
        x1=new JButton("a");
        x1.addActionListener(new Listener1());
        x2=new JButton("b");
        x2.addActionListener(new Listener1());
        x3=new JLabel("Notification : ");
        frame.add(x1);
        frame.add(x2);
        frame.add(x3);
        x1.setBounds(10,10,100,20);
        x2.setBounds(120,10,100,20);
        x3.setBounds(230,10,100,20);
        
        pane=new JPanel();
        deck=new CardLayout();
        pane.setLayout(deck);        
        
        a=new JPanel();
        a1=new JButton("a1");
        a1.addActionListener(new Listener1());
        a2=new JButton("a2");
        a2.addActionListener(new Listener1());
        a.add(a1);
        a.add(a2);
        b=new JPanel();
        b1=new JButton("b1");
        b1.addActionListener(new Listener1());
        b2=new JButton("b2");
        b2.addActionListener(new Listener1());
        b.add(b1);
        b.add(b2);
        pane.add(a,"a");
        pane.add(b,"b");
        
        deck.show(pane,"b");
        frame.add(pane);
        pane.setBounds(200,200,100,100);
    }
    class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==a1)
            {
                x3.setText("Notification : a1");
            }
            else if(e.getSource()==a2)
            {
                x3.setText("Notification : a2");
            }
            else if(e.getSource()==b1)
            {
                x3.setText("Notification : b1");
            }
            else if(e.getSource()==b2)
            {
                x3.setText("Notification : b2");
            }
            else if(e.getSource()==x1)
            {
                x3.setText("Notification : a");
                deck.show(pane,"a");
            }
            else if(e.getSource()==x2)
            {
                x3.setText("Notification : b");
                deck.show(pane,"b");
            }
            SwingUtilities.updateComponentTreeUI(frame);
        }        
    }
    public static void main(String args[])
    {
        new TestButtonAndCard();
    }
}

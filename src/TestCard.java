
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCard
{
    public static void main(String args[])
    {
        JFrame frame=new JFrame("Card");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        JPanel pane=new JPanel();
        CardLayout DECK=new CardLayout();        
        pane.setLayout(DECK);        
        pane.add(new JButton("King"),"King");
        pane.add(new JButton("Queen"),"Queen");
        //DECK.show(pane,"Queen");
        //DECK.next(pane);
        frame.add(pane);
    }
}

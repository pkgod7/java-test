import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class TestMsgDialog
{
    public static void main(String args[])
    {        
        JOptionPane.showMessageDialog(null,"","",JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"","",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"","",JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null,"","",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"","",JOptionPane.QUESTION_MESSAGE);
    }
}

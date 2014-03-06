
import javax.swing.JOptionPane;

public class TestPromptChoice
{
    public static void main(String args[])
    {
        Object x[]={"Kelvin","Pei Yee","Carin"};
        String s=(String)JOptionPane.showInputDialog(null,"Available","Port Number",JOptionPane.PLAIN_MESSAGE,null,x,0);
    }
}

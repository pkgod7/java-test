import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class TestSpinnerNumber
{
  public static void main(String args[])
  {
    JFrame frame = new JFrame("JSpinner Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    SpinnerModel model1 = new SpinnerNumberModel();
    JSpinner spinner1 = new JSpinner(model1);

    JLabel label1 = new JLabel("Numbers");
    JPanel panel1 = new JPanel(new BorderLayout());
    panel1.add(label1, BorderLayout.WEST);
    panel1.add(spinner1, BorderLayout.CENTER);
    frame.add(panel1, BorderLayout.SOUTH);

 

    frame.setSize(200, 90);
    frame.setVisible(true);
  }
}
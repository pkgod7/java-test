import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class TestChat2 extends JFrame
{
    public JTextField x1;
    public JTextArea x2;
    public Socket connection;
    public ObjectOutputStream output;
    public ObjectInputStream input;
    public TestChat2()
    {
        super("Client");
        x1=new JTextField();
        x1.addActionListener(new Listener1());
        x2=new JTextArea();
        x2.setEditable(false);
        add(x1,BorderLayout.NORTH);
        add(new JScrollPane(x2),BorderLayout.CENTER);
        setSize(300,300);
        setVisible(true);
    }
    public void execute()
    {
        try
        {
            connection=new Socket(InetAddress.getByName("localhost"),80);
            output=new ObjectOutputStream(connection.getOutputStream());
            input=new ObjectInputStream(connection.getInputStream());
            while(true)
            {
                x2.append(input.readObject().toString());
            }
        }
        catch(Exception err)
        {
        }
    }
    class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                x2.append("Me : "+event.getActionCommand()+"\n");
                output.writeObject("Client : "+event.getActionCommand()+"\n");
            }
            catch(Exception err)
            {
            }
        }
    }
    
    public static void main(String args[])
    {
        TestChat2 charlie=new TestChat2();
        charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charlie.execute();
        
    }    
}

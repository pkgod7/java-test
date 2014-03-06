
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestAssGui1
{
    public Socket connection;
    public DataOutputStream output;
    public DataInputStream input;
    public JFrame frame;
    public JPanel pane;
    JTextField setup1=new JTextField("");
    JTextArea setup2=new JTextArea();
    JLabel setup3=new JLabel("Port Number : ");
    JScrollPane setup4=new JScrollPane(setup2);
    String setup5="";
    public TestAssGui1()
    {
        try
        {
            frame=new JFrame("Server");
            frame.setSize(360,500);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pane=new JPanel();
            pane.setOpaque(true);
            pane.setBackground(Color.WHITE);
            pane.setLayout(null);
            pane.add(setup3);
            pane.add(setup1);
            pane.add(setup4);
            setup3.setBounds(20,10,100,40);
            setup1.setBounds(20,50,300,40);
            setup1.setFont(new Font("SansSerif",Font.BOLD,30));
            setup2.setBounds(100,50,400,350);
            setup2.setText("Welcome to simple FTP {SERVER}\n===================\n\n");
            setup2.setBackground(Color.white);
            setup2.setEditable(false);
            setup2.setEnabled(false);
            setup4.setBounds(20,100,300,300);
            frame.add(pane);
            SwingUtilities.updateComponentTreeUI(frame);
            Object setup5t1[]={"99","999","9882"};
            setup5=(String)JOptionPane.showInputDialog(null,"Available","Port Number",JOptionPane.PLAIN_MESSAGE,null,setup5t1,0);
            setup2.setEnabled(true);
            setup2.setText(setup2.getText()+"Server ("+InetAddress.getLocalHost().getHostAddress()+") start.\n");
            setup2.setText(setup2.getText()+"Port "+setup5+" is listening ..\n");
            setup1.setText(setup5);
            if(setup5==null)
            {
                System.exit(0);
            }
            connection=new ServerSocket(Integer.parseInt(setup5)).accept();
            output=new DataOutputStream(connection.getOutputStream());
            input=new DataInputStream(connection.getInputStream());
            String temp1="";
            while(true)
                    {
                        String menu=input.readUTF();
                        if(menu.equals("bye"))
                        {
                            System.exit(0);
                        }
                        else if(menu.equals("hola"))
                        {
                            File list[]=new File("ahmad").listFiles();
                            try
                            {
                                output.writeUTF(""+list.length);
                            }
                            catch(Exception err)
                            {
                            }
                        }
                        else if(menu.equals("hola2"))
                        {
                            File list[]=new File("ahmad").listFiles();
                            try
                            {
                                for(File file:list)
                                {
                                    if(file.isFile())
                                    {
                                        output.writeUTF(file.getName());
                                    }
                                }
                            }
                            catch(Exception err)
                            {
                            }
                        }
                        else if(menu.equals("upload"))
                        {
                            String fileName="ahmad/upload_"+input.readUTF();
                            FileOutputStream fout=new FileOutputStream(new File(fileName));
                            int ch;
                            String temp;
                            do
                            {
                                temp=input.readUTF();
                                ch=Integer.parseInt(temp);
                                if(ch!=-1)
                                {
                                    fout.write(ch);
                                }
                            }
                            while(ch!=-1);
                            fout.close();
                            setup2.setText(setup2.getText()+"Client ("+temp1+") uploaded : "+fileName+"\n");
                        }
                        else if(menu.equals("download"))
                        {
                            String filename="ahmad/"+input.readUTF();
                            FileInputStream fin=new FileInputStream(new File(filename));
                            int ch;
                            do
                            {
                                ch=fin.read();
                                output.writeUTF(String.valueOf(ch));
                            }
                            while(ch!=-1);
                            fin.close();
                            setup2.setText(setup2.getText()+"Client ("+temp1+") downloaded : "+filename+"\n");
                        }
                        else if(menu.equals("connect"))
                        {
                            temp1=input.readUTF();
                            setup2.setText(setup2.getText()+"Client ("+temp1+") connected.\n");
                        }
                    }
        }
        catch(Exception err)
        {
        }
    }
    public static void main(String args[])
    {
        new TestAssGui1();
    }
}

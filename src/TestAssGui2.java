import javax.swing.*;
import java.awt.*;
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
import java.net.Socket;
import javax.swing.border.LineBorder;
public class TestAssGui2
{
    public Socket connection;
    public DataOutputStream output;
    public DataInputStream input;
    public JFrame frame;
    public JPanel pane;
    public JButton x1;
    public JButton x2;
    public JButton x3;
    public JLabel x4;
    public JPanel x5;
    public CardLayout x5c;
    public String x6;
    
    //x5
    JPanel setup=new JPanel();
    JLabel setup2=new JLabel("IP Address");
    JLabel setup3=new JLabel("Port Number");
    JTextField setup4=new JTextField("localhost");
    JTextField setup5=new JTextField("99");
    JButton setup6=new JButton("Connect");
    JButton setup11=new JButton("1");
    JButton setup12=new JButton("2");
    JButton setup13=new JButton("3");
    JButton setup14=new JButton("4");
    JButton setup15=new JButton("5");
    JButton setup16=new JButton("6");
    JButton setup17=new JButton("7");
    JButton setup18=new JButton("8");
    JButton setup19=new JButton("9");
    JButton setup20=new JButton("0");
    JButton setup21=new JButton(".");
    JButton setup22=new JButton("←");
    
    JPanel upload=new JPanel();
    JButton upload1[];
    int upload2=0;
    int upload3=20;
    
    JPanel download=new JPanel();
    JButton download1[];
    int download2=0;
    int download3=20;
    
    public TestAssGui2()
    {
        frame=new JFrame("Client");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,700);
        
        x1=new JButton("Upload");
        x2=new JButton("Download");
        x3=new JButton("Close");
        x4=new JLabel("Status : Welcome to simple FTP {CLIENT}");
        x5=new JPanel();
        x5c=new CardLayout();
        x6="";
        x1.setBackground(Color.lightGray);
        x1.setOpaque(true);
        x1.setBorderPainted(false);
        x1.setEnabled(false);
        x2.setBackground(Color.lightGray);
        x2.setOpaque(true);
        x2.setBorderPainted(false);
        x2.setEnabled(false);
        x3.setBackground(Color.lightGray);
        x3.setOpaque(true);
        x3.setBorderPainted(false);
        x4.setFont(new Font("SansSerif", Font.BOLD,12));
        x1.addActionListener(new Listener1());
        x2.addActionListener(new Listener1());
        x3.addActionListener(new Listener1());
       
        //x5
        setup2.setFont(new Font("SansSerif", Font.BOLD,9));
        setup3.setFont(new Font("SansSerif", Font.BOLD,9));
        setup4.addMouseListener(new Listener2());
        setup5.addMouseListener(new Listener2());
        setup4.setFont(new Font("SansSerif",Font.BOLD,30));
        setup5.setFont(new Font("SansSerif",Font.BOLD,30));
        setup4.setBackground(Color.white);
        setup5.setBackground(Color.white);
        setup6.setBackground(Color.lightGray);
        setup6.setOpaque(true);
        setup6.setBorderPainted(false);
        setup.setLayout(null);
        setup.add(setup2);
        setup.add(setup3);
        setup.add(setup4);
        setup.add(setup5);
        setup.add(setup6);
        setup.add(setup11);
        setup.add(setup12);
        setup.add(setup13);
        setup.add(setup14);
        setup.add(setup15);
        setup.add(setup16);
        setup.add(setup17);
        setup.add(setup18);
        setup.add(setup19);
        setup.add(setup20);
        setup.add(setup21);
        setup.add(setup22);
        setup2.setBounds(30,55,100,20);
        setup3.setBounds(30,100,100,20);
        setup4.setBounds(90,43,200,40);
        setup5.setBounds(90,93,200,40);
        setup6.setBounds(90,140,150,25);
        setup11.setBounds(80,200,50,40);
        setup12.setBounds(140,200,50,40);
        setup13.setBounds(200,200,50,40);
        setup14.setBounds(80,250,50,40);
        setup15.setBounds(140,250,50,40);
        setup16.setBounds(200,250,50,40);
        setup17.setBounds(80,300,50,40);
        setup18.setBounds(140,300,50,40);
        setup19.setBounds(200,300,50,40);
        setup20.setBounds(80,350,50,40);
        setup21.setBounds(140,350,50,40);
        setup22.setBounds(200,350,50,40);
        setup6.addActionListener(new Listener1());
        setup11.addActionListener(new Listener1());
        setup12.addActionListener(new Listener1());
        setup13.addActionListener(new Listener1());
        setup14.addActionListener(new Listener1());
        setup15.addActionListener(new Listener1());
        setup16.addActionListener(new Listener1());
        setup17.addActionListener(new Listener1());
        setup18.addActionListener(new Listener1());
        setup19.addActionListener(new Listener1());
        setup20.addActionListener(new Listener1());
        setup21.addActionListener(new Listener1());
        setup22.addActionListener(new Listener1());
        x5.setLayout(x5c);
        x5.add(setup,"0");
        
        pane=new JPanel();
        pane.setOpaque(true);
        pane.setBackground(Color.WHITE);
        pane.setLayout(null);
        pane.add(x1);
        pane.add(x2);
        pane.add(x3);
        pane.add(x4);
        pane.add(x5);
        x1.setBounds(50,20,100,40);
        x2.setBounds(160,20,100,40);
        x3.setBounds(270,20,100,40);
        x4.setBounds(50,600,500,20);
        x5.setBounds(50,60,320,500);
        
        frame.add(pane);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void uploading(String x)
    {
         try
         {
             output.writeUTF("upload");
             String fileName=x;
             output.writeUTF(fileName);
             FileInputStream fin=new FileInputStream(new File("ahmad/"+fileName));
             int ch;
             do
             {
                 ch=fin.read();
                 output.writeUTF(String.valueOf(ch));
             }
             while(ch!=-1);
             fin.close();
             x4.setText("Status : Upload success, \"upload_"+fileName+"\"\n");
             upload=new JPanel();
             upload.setLayout(null);
             upload2=0;
             upload3=20;
             File list[]=new File("ahmad").listFiles();
             upload1=new JButton[list.length];
             for(File file:list)
             {
                 if(file.isFile())
                 {
                     upload1[upload2]=new JButton(""+file.getName());
                     upload1[upload2].addActionListener(new Listener1());
                     upload.add(upload1[upload2]);
                     upload.setPreferredSize(new Dimension(300,list.length*27));
                     upload1[upload2].setBounds(10,upload3,280,20);
                     upload2++;
                     upload3+=25;
                 }
             }
             x5.add(new JScrollPane(upload),"1");
             x5c.show(x5,"1");
         }
         catch(Exception err)
         {
         }
    }
    public void downloading(String x)
    {
         try
         {
             output.writeUTF("download");
             String fileName=x;
             output.writeUTF(fileName);
             FileOutputStream fout=new FileOutputStream(new File("ahmad/download_"+fileName));
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
             x4.setText("Status : Download success, \"download_"+fileName+"\"\n");
             output.writeUTF("hola");
             String temp1=input.readUTF();
             download=new JPanel();
             download.setLayout(null);
             download2=0;
             download3=20;
             download1=new JButton[Integer.parseInt(temp1)];
             output.writeUTF("hola2");
             for(int i=0; i<Integer.parseInt(temp1); i++)
             {
                 download1[download2]=new JButton(""+input.readUTF());
                 download1[download2].addActionListener(new Listener1());
                 download.add(download1[download2]);
                 download.setPreferredSize(new Dimension(300,Integer.parseInt(temp1)*27));
                 download1[download2].setBounds(10,download3,280,20);
                 download2++;
                 download3+=25;
             }
             x5.add(new JScrollPane(download),"2");
             x5c.show(x5,"2");
         }
         catch(Exception err)
         {
         }
    }
    class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==x1)
            {
                x1.setBackground(Color.BLUE);
                x2.setBackground(Color.lightGray);
                upload=new JPanel();
                upload.setLayout(null);
                upload2=0;
                upload3=20;
                File list[]=new File("ahmad").listFiles();
                x4.setText("Status : My files ("+list.length+")");
                upload1=new JButton[list.length];
                for(File file:list)
                {
                    if(file.isFile())
                    {
                        upload1[upload2]=new JButton(""+file.getName());
                        upload1[upload2].addActionListener(new Listener1());
                        upload.add(upload1[upload2]);
                        upload.setPreferredSize(new Dimension(300,list.length*27));
                        upload1[upload2].setBounds(10,upload3,280,20);
                        upload2++;
                        upload3+=25;
                    }
                }
                x5.add(new JScrollPane(upload),"1");
                x5c.show(x5,"1");
            }
            else if(e.getSource()==x2)
            {
                x1.setBackground(Color.lightGray);
                x2.setBackground(Color.BLUE);
                try
                {
                    output.writeUTF("hola");
                    String temp1=input.readUTF();
                    x4.setText("Status : Server files ("+temp1+")");
                    download=new JPanel();
                    download.setLayout(null);
                    download2=0;
                    download3=20;
                    download1=new JButton[Integer.parseInt(temp1)];
                    output.writeUTF("hola2");
                    for(int i=0; i<Integer.parseInt(temp1); i++)
                    {
                        download1[download2]=new JButton(""+input.readUTF());
                        download1[download2].addActionListener(new Listener1());
                        download.add(download1[download2]);
                        download.setPreferredSize(new Dimension(300,Integer.parseInt(temp1)*27));
                        download1[download2].setBounds(10,download3,280,20);
                        download2++;
                        download3+=25;
                    }
                    x5.add(new JScrollPane(download),"2");
                    x5c.show(x5,"2");
                }
                catch(Exception err)
                {
                }
            }
            else if(e.getSource()==x3)
            {
                try
                {
                    output.writeUTF("bye");
                    System.exit(0);
                }
                catch(Exception err)
                {
                }
            }
            else if(e.getSource()==setup6)
            {
                try
                {
                    connection=new Socket(setup4.getText(),Integer.parseInt(setup5.getText()));
                    output=new DataOutputStream(connection.getOutputStream());
                    input=new DataInputStream(connection.getInputStream());
                    x4.setText("Status : FTP started.");
                    output.writeUTF("connect");
                    output.writeUTF(""+InetAddress.getLocalHost().getHostAddress());
                    setup4.setEnabled(false);
                    setup5.setEnabled(false);
                    setup6.setEnabled(false);
                    setup11.setEnabled(false);
                    setup12.setEnabled(false);
                    setup13.setEnabled(false);
                    setup14.setEnabled(false);
                    setup15.setEnabled(false);
                    setup16.setEnabled(false);
                    setup17.setEnabled(false);
                    setup18.setEnabled(false);
                    setup19.setEnabled(false);
                    setup20.setEnabled(false);
                    setup21.setEnabled(false);
                    setup22.setEnabled(false);
                    x1.setEnabled(true);
                    x2.setEnabled(true);
                }
                catch(Exception err)
                {
                    x4.setText("Status : Incorrect ip address or port number.");                    
                }
            }
            else if(e.getSource()==setup11)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"1");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"1");
                }
            }
            else if(e.getSource()==setup12)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"2");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"2");
                }
            }
            else if(e.getSource()==setup13)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"3");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"3");
                }
            }
            else if(e.getSource()==setup14)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"4");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"4");
                }
            }
            else if(e.getSource()==setup15)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"5");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"5");
                }
            }
            else if(e.getSource()==setup16)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"6");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"6");
                }
            }
            else if(e.getSource()==setup17)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"7");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"7");
                }
            }
            else if(e.getSource()==setup18)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"8");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"8");
                }
            }
            else if(e.getSource()==setup19)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"9");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"9");
                }
            }
            else if(e.getSource()==setup20)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+"0");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+"0");
                }
            }
            else if(e.getSource()==setup21)
            {
                if(x6.equals("setup4"))
                {
                    setup4.setText(setup4.getText()+".");
                }
                else if(x6.equals("setup5"))
                {
                    setup5.setText(setup5.getText()+".");
                }
            }
            else if(e.getSource()==setup22)
            {
                if(x6.equals("setup4"))
                {
                    if(setup4.getText().length()>0)
                    {
                        setup4.setText(setup4.getText().substring(0,setup4.getText().length()-1));
                    }
                }
                else if(x6.equals("setup5"))
                {
                    if(setup5.getText().length()>0)
                    {
                        setup5.setText(setup5.getText().substring(0,setup5.getText().length()-1));
                    }
                }
            }
            for(int i=0; i<upload2; i++)
            {
                if(e.getSource()==upload1[i])
                {
                     x4.setText("Status : "+upload1[i].getText());
                     uploading(upload1[i].getText());
                }
            }
            for(int i=0; i<download2; i++)
            {
                if(e.getSource()==download1[i])
                {
                     x4.setText("Status : "+download1[i].getText());
                     downloading(download1[i].getText());
                }
            }
        }        
    }
    class Listener2 extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==setup4)
            {
                x6="setup4";
                setup4.setBackground(Color.lightGray);
                setup5.setBackground(Color.white);
            }
            else if(e.getSource()==setup5)
            {
                x6="setup5";
                setup4.setBackground(Color.white);
                setup5.setBackground(Color.lightGray);
            }
        }
    }
    public static void main(String args[])
    {
        new TestAssGui2();
    }
}

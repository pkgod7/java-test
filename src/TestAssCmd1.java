import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class TestAssCmd1
{
    Socket connection;
    DataOutputStream output;
    DataInputStream input;
    public TestAssCmd1()
    {
        try
        {
            connection=new ServerSocket(99).accept();
            output=new DataOutputStream(connection.getOutputStream());
            input=new DataInputStream(connection.getInputStream());
            while(true)
            {
                String menu=input.readUTF();
                if(menu.equals("bye"))
                {
                   break;
                }
                else if(menu.equals("dir"))
                {
                    String x1="";
                    File list[]=new File("ahmad").listFiles();
                    for(File file:list)
                    {
                        if(file.isFile())
                        {
                            x1=x1+file.getName()+"\n";
                        }
                    }
                    output.writeUTF(x1);
                }
                else if(menu.equals("send"))
                {
                    if(input.readUTF().equals("yes"))
                    {
                        String fileName="ahmad/send_"+input.readUTF();
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
                    }
                }
                else if(menu.equals("get"))
                {
                    String filename="ahmad/"+input.readUTF();
                    String newFile="no";
                    if(new File(filename).exists())
                    {
                        if(!filename.equals("ahmad/"))
                        {
                            newFile="yes";
                        }
                    }
                    output.writeUTF(newFile);
                    if(newFile.equals("yes"))
                    {
                        FileInputStream fin=new FileInputStream(new File(filename));
                        int ch;
                        do
                        {
                            ch=fin.read();
                            output.writeUTF(String.valueOf(ch));
                        }
                        while(ch!=-1);
                        fin.close();
                    }
                }
            }
        }
        catch(Exception err)
        {
        }
    }
    public static void main(String args[])
    {
        new TestAssCmd1();
    }
}

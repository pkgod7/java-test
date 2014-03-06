import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class TestAssCmd2
{
    Socket connection;
    DataOutputStream output;
    DataInputStream input;
    Scanner keyboard;
    public TestAssCmd2()
    {
        try
        {
            keyboard=new Scanner(System.in);
            System.out.println("Enter host url address : ");
            String url=keyboard.nextLine();
            System.out.println("Enter host port number : ");
            String port=keyboard.nextLine();
            try
            {
                connection=new Socket(url,Integer.parseInt(port));
                output=new DataOutputStream(connection.getOutputStream());
                input=new DataInputStream(connection.getInputStream());
                System.out.println("Connected successful.");
            }
            catch(Exception err)
            {
                System.out.println("Incorrect host url or port number.");
                connection=new Socket(url,99);
                output.writeUTF("bye");
            }
            keyboard=new Scanner(System.in);
            while(true)
            {
                System.out.println("dir             - file list");
                System.out.println("send <filename> - upload a file");
                System.out.println("get <filename>  - download a file");
                System.out.println("bye             - quit connection");
                System.out.print("COMMAND : ");
                String menu=keyboard.nextLine();
                boolean validity=false;
                if(menu.length()==3)
                {
                    if(menu.substring(0,3).equals("bye"))
                    {
                        validity=true;
                        output.writeUTF("bye");
                        break;
                    }
                    else if(menu.substring(0,3).equals("dir"))
                    {
                        validity=true;
                        output.writeUTF("dir");
                        String x1="Server\n=====\n"+input.readUTF()+"\nClient\n=====\n";
                        File list[]=new File("ahmad").listFiles();
                        for(File file:list)
                        {
                            if(file.isFile())
                            {
                                x1=x1+file.getName()+"\n";
                            }
                        }
                        System.out.println(x1);
                    }
                }
                else if(menu.length()>=4)
                {
                    
                    if(menu.substring(0,4).equals("send"))
                    {
                        validity=true;
                        output.writeUTF("send");
                        String newFile="no";
                        String fileName="";
                        if(menu.length()>=5)
                        {
                            fileName=menu.substring(5);
                        }
                        if(fileName.length()==0)
                        {
                            newFile="no";
                        }
                        else if(new File("ahmad/"+fileName).exists())
                        {
                            newFile="yes";                            
                        }
                        output.writeUTF(newFile);
                        if(newFile.equals("yes"))
                        {
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
                            System.out.println("Send success, \"send_"+fileName+"\"\n");
                        }
                        else if(newFile.equals("no"))
                        {
                            System.out.println("File not exists.\n");
                        }
                    }
                    else if(menu.substring(0,3).equals("get"))
                    {
                        validity=true;
                        output.writeUTF("get");
                        String fileName=menu.substring(4);
                        output.writeUTF(fileName);
                        String newFile=input.readUTF();
                        if(newFile.equals("yes"))
                        {
                            if(fileName.length()==0)
                            {
                                System.out.println("File not exists.\n");
                            }
                            else
                            {
                                FileOutputStream fout=new FileOutputStream(new File("ahmad/get_"+fileName));
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
                                System.out.println("Get success, \"get_"+fileName+"\"\n");                                
                            }
                        }
                        else if(newFile.equals("no"))
                        {
                            System.out.println("File not exists.\n");
                        }
                    }
                }
                if(validity==false)
                {
                    System.out.println("Invalid command.\n");
                }
            }
        }
        catch(Exception err)
        {
        }
    }
    public static void main(String args[])
    {
        new TestAssCmd2();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ali.javan
 */
import java.net.*;
import java.io.*;

public class TestConnectURL
{
    public static void main(String[] args) throws Exception {
        URL sample = new URL("http://upload.wikimedia.org/wikipedia/en/2/23/Apu_Nahasapeemapetilon_(The_Simpsons).png");
        URLConnection yc = sample.openConnection();
            
         File f=new File("pk.jpg");
        //open the file requested by client on the server machine 
        FileOutputStream  fs=new FileOutputStream(f);
    //it creates an output stream to write bytes to the file
    BufferedInputStream d=new BufferedInputStream(yc.getInputStream());
    //it creates buffer to receive data from server machine
    BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(f));
    //it creates a buffer to write buffer of bytes to the file
    byte buffer[] = new byte[1024];
    int read;
    while((read = d.read(buffer))!=-1){
        outStream.write(buffer, 0, read);
        outStream.flush();
        //while the input buffer is not finished it reads the input sent by the server and writes it on the file created in the client machine
    }
    fs.close();
        
        
       
    }
}

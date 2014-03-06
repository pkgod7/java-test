import java.io.File;
public class TestDir
{
    public static void main(String args[])
    {
        File list[]=new File("test").listFiles();
        for(File file:list)
        {
            if(file.isFile())
            {
                System.out.println(file.getName());
            }
        }
        System.out.println(list.length);
    }
}

public class TestReturnString
{
    public String greeta="Hello Java";
    public String greet()
    {
        return "Hello World";
    }
    public static void main(String args[])
    {
        TestReturnString x1=new TestReturnString();
        System.out.println(x1.greet());
        System.out.println(x1.greeta);
    }
}
public class TestThread extends Thread
{
    public String x1;
    public TestThread(String x)
    {
        x1=x;
    }    
    public void run()
    {
        System.out.println(x1);
    }
    public static void main(String args[])
    {
        TestThread c1=new TestThread("Thread 1");
        TestThread c2=new TestThread("Thread 2");
        TestThread c3=new TestThread("Thread 3");
        c1.start();
        c2.start();
        c3.start();
    }
}

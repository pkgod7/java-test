public class TestBitwise
{
    public static void main(String args[])
    {
        // 5 = 0000 0101
        // 1 = 0000 0001
        //ans= 0000 0001 = 1
        System.out.println(5&1);
        
        // 5 = 0000 0101
        // 4 = 0000 0100 = 4
        //ans= 0000 0100
        System.out.println(5&4);
        
        // 60 = 0011 1100
        // 13 = 0000 1101
        //ans = 0000 1100 = 12
        System.out.println(13&60);
        
        // 7    = 00 0000 0000 0111
        // 9882 = 10 0110 1001 1010
        //ans   = 00 0000 0000 0010 = 2
        System.out.println(7&9882);
    }
}
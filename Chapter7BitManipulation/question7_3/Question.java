/**
    7.3     How to get bit, set bit, clear bit, update bit
    (CareerCups150 -- P90)
 */

package question7_3;

public class Question {
    
    // get bit
    public static boolean getBit(int num, int i){
        return (num&(1<<i))!=0;
    }
    
    // set bit to 1
    public static int setBitTo1(int num, int i){
        return num|(1<<i);
    }
    
    // clear bit(set bit to 0)
    public static int clearBit(int num, int i){
        return num&(~(1<<1));
    }
    
    // clear all bits from the most significant bit through i(inclusive)
    public static int clearBitsMSBthroughI(int num, int i){
        int mask = (1<<i)-1;
        return num&mask;
    }
    
    // clear all bits from i through 0(inclusive)
    public static int clearBitsIThroughO(int num, int i){
        int mask =  ~((1<<(i+1))-1);
        return num & mask;
    }
    
}

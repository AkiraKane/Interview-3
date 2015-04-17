/**
    7.9     Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
    (CareerCups150 -- 5.6)
 */

package question7_9;

import CtCILibrary.AssortedMethods;

public class Question {

    public static int swapOddEvenBits(int x) {
        return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
        
//        return (( (x>>1)& 0x55555555 ) | ( (x<<1)&0xaaaaaaaa ));
    }
    
    public static void main(String[] args) {
        int a = 103217;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        int b = swapOddEvenBits(a);
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
    }
}

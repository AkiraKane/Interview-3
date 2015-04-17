/**
 * 1.6  Reverse a string. (In-place???)
 * (CareerCups150--1.2)
 */


package question1_6;

public class Question {
    public static String reverse(String original){
        StringBuilder sb = new StringBuilder();
        for (int i=original.length()-1; i>=0; i--){
            sb.append(original.charAt(i));
        }
        return sb.toString();
    }
    
    
    // in place solution
    public static String reverse1(String original){
        char[] charArray = original.toCharArray();
        int left = 0;
        int right = original.length()-1;
        while(left<right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right]=temp;
            left++;
            right--;
        }
        
        return String.valueOf(charArray);
    }
    
    public static void main(String[] args) {
        System.out.println(reverse("hello") + " "+reverse1("hello"));
    }
}

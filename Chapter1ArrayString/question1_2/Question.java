/**
 * 1.2  Reverse a string. (In-place???)
 * (CareerCups150--1.2)
 */


package question1_2;

public class Question { 
    public static String reverse(String original){
        StringBuilder sb = new StringBuilder();
        for (int i=original.length()-1; i>=0; i--){
            sb.append(original.charAt(i));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}

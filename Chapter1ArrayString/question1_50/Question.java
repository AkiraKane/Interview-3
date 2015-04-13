/**
 * 1.5  Implement a method to perform basic string compressing using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2b1c5a3. 
 * If the ???compressed??? string would not become smaller than the original string, you method should return the original string.
 * (CareerCups150--1.5)
 */

package question1_50;

public class Question {
    public static String compression(String str){
        if(str==null || str.length()<1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char currentChar = str.charAt(0);
        int number=1;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)!=currentChar){
                sb.append(currentChar);
                sb.append(number);
                currentChar=str.charAt(i);
                number=1;
            } else {
                number++;
            }
        }
        sb.append(currentChar);
        sb.append(number);
        String compressed = sb.toString();
        if(compressed.length()<str.length()){
            return compressed;
        }
        return str;
    }
    
    public static void main(String[] args) {
        String str = "abbccccccde";
        String compressed = compression(str);

        System.out.println("Old String (len = " + str.length() + "): " + str);
        System.out.println("New String (len = " + compressed.length() + "): " + compressed);
    }

}

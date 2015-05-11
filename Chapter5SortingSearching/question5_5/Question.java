/**
    5.5     Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
    Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
    Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
    (CareerCups150 -- 11.5)
 */
package question5_5;

public class Question {

    public static int searchR(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }
        
        /* Move mid to the middle */
        int mid = (last + first) / 2;
        
        /* If mid is empty, find closest non-empty string. */
        if (strings[mid].isEmpty()) { 
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
            
        /* Check for string, and recurse if necessary */
        if (str.equals(strings[mid])) { // Found it!
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { // Search right
            return searchR(strings, str, mid + 1, last);
        } else { // Search left
            return searchR(strings, str, first, mid - 1);
        }
    }   
        
    public static int search(String[] strings, String str) {
        if (strings == null || str == null || str.isEmpty()) {
            return -1;
        }
        return searchR(strings, str, 0, strings.length - 1);
    }
    
    public static void main(String[] args) {

    }

}

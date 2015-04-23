/**
    8.35    Compare Version Numbers
    Compare two version numbers version1 and version2.
    If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
    You may assume that the version strings are non-empty and contain only digits and the . character.
    The . character does not represent a decimal point and is used to separate number sequences.
    For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
    Here is an example of version numbers ordering:
    0.1 < 1.1 < 1.2 < 13.37
    (leetcode165)
 */

package question8_35;

public class Question {
    
    
    public static int compareVersion(String version1, String version2) {
        int result = 0;
        int[] version1Num = getVersionNumbers(version1);
        int[] version2Num = getVersionNumbers(version2);
        
        if(version1Num[0]>version2Num[0]){
            result = 1;
        } else if(version1Num[0]<version2Num[0]){
            result = -1;
        } else{
            if(version1Num[1]>version2Num[1]){
                result = 1;
            } else if(version1Num[1]<version2Num[1]){
                result = -1;
            } else {
                result = 0;
            }
        }
        return result;
    }
    
    public static int[] getVersionNumbers(String version){
        int[] result = new int[2];
        String[] versions = version.split("\\.");
        
        try {
            result[0] = Integer.parseInt(versions[0]);
            result[1] = Integer.parseInt(versions[1]);
        } catch(NumberFormatException e){
            
        }
        return result;
    }

    public static void main(String[] args) {
        String version1 = "1.1";
        String version2 = "1.2";
        System.out.println(compareVersion(version1, version2));
        
    }

}

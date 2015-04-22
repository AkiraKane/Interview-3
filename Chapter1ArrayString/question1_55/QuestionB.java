/**
    Pascal Triangle II
    Given an index k, return the kth row of the Pascal's triangle.
    For example, given k = 3,
    Return [1,3,3,1].
    Note:
    Could you optimize your algorithm to use only O(k) extra space?
    (leetcode119)
    (leetcodecpp15.9)
 */

package question1_55;

public class QuestionB {

    public static int[] generateRow(int k){
        int[] result = new int[k+1];
        int[] cache = new int[k];
        cache[0] = 1;
        for(int i=1; i<=k; i++){
            for(int j=0; j<=i; j++){
                if(j==0||j==i){
                    result[j] = 1;
                } else {
                    result[j] = cache[j-1]+cache[j];
                }
            }
            if(i==k) break;
            for(int j=0; j<=i; j++){
                cache[j] = result[j];
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        int[] result = generateRow(4);
        for(int element : result){
            System.out.print(element + " ");
        }
    }
}

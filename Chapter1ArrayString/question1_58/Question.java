/**
    1.58    The Game of Master Mind is played as follows:
    The Computer has four slots, and each slot will contain a ball that is red(R), yellow(Y), green(G) or blue(B). For example, the computer might have RGGB(Slot#1 is red, slot#2 and #3 are green, slot#4 is blue).
    You, the user, are trying to guess the solution. You might, for example, guess YRGB.
    When you guess the correct color for the correct slot, you get a ‘hit’. If you guess a color that exists but is in the wrong slot, you get a ‘pseudo-hit’. Note that a slot that is a hit can never count as a pseudo-hit.
    For example, if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-hit.
    Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
    (CareerCups150--17.5)
 */
package question1_58;

public class Question {
    
    static class Result {
        public int hits;
        public int pseudoHits;
        
        public Result(int h, int p){
            this.hits = h;
            this.pseudoHits = p;
        }
        
        public Result() {
            this.hits =0;
            this.pseudoHits=0;
        }
        
        public String toString() {
            return "("+hits+","+pseudoHits+")";
        }
        
    }
    
    public static int code(char c){
        switch(c) {
        case 'B':
            return 0;
        case 'G':
            return 1;
        case 'R':
            return 2;
        case 'Y':
            return 3;
            default:
                return -1;
        }
    }
    
    public static Result estimate(String guess, String solution){
        if(guess.length()!=solution.length()) return null;
        Result result = new Result();
        int[] frequency = new int[4];
        
        for(int i=0; i<solution.length(); i++){
            if(guess.charAt(i)==solution.charAt(i)){
                result.hits++;
            } else {
                int code = code(solution.charAt(i));
                if(code>=0){
                    frequency[code]++;
                }
            }
        }
        
        for(int i=0; i<guess.length(); i++){
            int code = code(guess.charAt(i));
            if(code>=0 && frequency[code]>0 && guess.charAt(i)!=solution.charAt(i)){
                result.pseudoHits++;
                frequency[code]--;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {

    }
    
    
}

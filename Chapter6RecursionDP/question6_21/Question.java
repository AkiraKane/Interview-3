/**
    6.21    Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down. 
    How many possible paths are there for the robot to go from (0,0) to (X,Y)?
    FOLLOW UP
    Imagine certain spots are "off limits", such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
    (CareerCups -- 9.2)
     
    A robot is located at the top-left corner of a m × n grid (marked ‘Start’ in the diagram below). The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
    How many possible unique paths are there?
    (CleanCodeHandbook--43)
    (leetcode62)
    (leetcodecpp10.2)
    http://articles.leetcode.com/2010/11/unique-paths.html
     
    Similar to Question [43. Unique Paths], but now consider if some obstacles are added to the grids. How many unique paths would there be?    
    An obstacle and empty space are marked as 1 and 0 respectively in the grid. For example,
    There is one obstacle in the middle of a 3×3 grid as illustrated below.
    The total number of unique paths is 2.
    (CleanCodeHandbook--44)
    (leetcode63)
    (leetcodecpp10.3)
 */

package question6_21;

public class Question {

    // recursive solution
    public static int moveRecursive(int r, int c, int m, int n){
        if(r<0 || c<0){
            return 0;
        } else if(r==0 && c==0){
            return 1;
        }
        return moveRecursive(r-1, c, m,n)+ moveRecursive(r, c-1, m, n);
    }
    
    // recursive with cache
    public static int moveRecursiveWithCache(int r, int c, int m, int n, int[][] cache){
        if(r<0 || c<0){
            return 0;
        } else if(r==0 && c==0){
            return 1;
        }
        
        if(r>=1 && c>=0 && cache[r-1][c]==-1){
            cache[r-1][c] = moveRecursiveWithCache(r-1, c, m, n, cache);
        }
        if(r>=0 && c>=1 && cache[r][c-1]==-1){
            cache[r][c-1] = moveRecursiveWithCache(r, c-1, m, n, cache);
        }
        
        if(r==0){
            return cache[r][c-1];
        } else if(c==0){
            return cache[r-1][c];
        }
        return cache[r-1][c]+cache[r][c-1];
    }
    
    // DP solution
    public static int moveDP(int m, int n){
        int[][] mat = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            mat[0][i] = 1;
        }
        for(int i=0; i<=n; i++){
            mat[i][0] = 1;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                mat[i][j]=mat[i-1][j]+mat[i][j-1];
            }
            
        }
        return mat[m][n];
    }
    
    public static void main(String[] args) {
        int m=2, n=2;
        
        // solution 1
        System.out.println(moveRecursive(m,n,m,n));
        
        // solution 2
        int[][] cache = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                cache[i][j] = -1;
            }
        }
        System.out.println(moveRecursiveWithCache(m, n, m, n, cache));
        
        
        System.out.println(moveDP(m, n));
        
    }

}

/**
    6.6     Flood Fill algorithm
    Implement the “paint fill” function that one might see on many image editing programs.
    That is, given a screen (represented by a 2-dimensional array of Colors), a point, and a new color, fill in the surrounding area until you hit a border of that color.
    This is a very important computer graph algorithm.
    (CareerCups150 -- 9.7)
 */

package question6_6;

public class Question {

    public enum Color {
        Black, White, Red, Yellow, Green
    }
    
    public static void paintFill(Color[][] screen, int x, int y, Color ncolor){
        if(screen[x][y]==ncolor){
            return;
        }
        paintFill(screen, x, y, screen[x][y], ncolor);
    }
    
    public static void paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
        if(x<0 || x>=screen.length || y<0 || y>=screen[0].length){
            return;
        }
        if(screen[x][y]==ocolor){
            screen[x][y] = ncolor;
            paintFill(screen, x - 1, y, ocolor, ncolor); // left
            paintFill(screen, x + 1, y, ocolor, ncolor); // right
            paintFill(screen, x, y - 1, ocolor, ncolor); // top
            paintFill(screen, x, y + 1, ocolor, ncolor); // bottom
        }
    }

    public static void main(String[] args) {

    }

}

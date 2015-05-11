/**
    3.7     In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. They puzzle starts with disks sorted in ascending order of size from top to botton (i.e., each disk sits on top of an even larger one).
    You have the following constraints:
    (1) Only one disk can be moved at a time.
    (2) A disk is slid off the top of one rod onto the next rod.
    (3) A disk can only be placed on top of a larger disk.
    Write a program to move the disks from the first tower to the last using stacks.
    (CareerCups150 - 3.4)
 */
package question3_7;

public class Question {

    public static void main(String[] args) {
        int n=5;
        Tower[] towers = new Tower[3];
        for(int i=0; i<3; i++){
            towers[i] = new Tower(i);
        }
        for(int i=n-1; i>=0; i--){
            towers[0].add(i);
        }

        towers[0].moveDisks(n, towers[2], towers[1]);

        for(int i=0; i<3; i++){
            towers[i].print();
        }
    }
}

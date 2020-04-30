import java.util.Random;
import java.util.Scanner;
 
// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }, 
                           { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } }, 
                           { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
                           { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } }, 
                           { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } } };
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();
        while (true) {
            System.out.println("How many dice would you like to roll? ");
            int amount = scanner.nextInt(); // amount of dice to roll
            int[] result = new int[amount];
            int total = 0;
            for (int i=0; i<amount;i++)
            {
            result[i] = dice.roll();
            System.out.println("dice face value:" + result[i]);
            dice.draw(result[i]);
            total = total + result[i]; // calculate total value of dice rolled
            }

            System.out.println("Total value: " + total); // print total value of dice
            if ((amount == 2) && (total == 2)){
                System.out.println("Snakes eyes!");
            }
            else if ((amount != 2) && (total == 2)){
                System.out.println("Two for you!");
            }
            else if ((amount == 2) && (total == 3 )){
                System.out.println("Small ace deuce, can't produce!");
            }
            else if ((amount != 2) && (total == 3 )){
                System.out.println("Winner on the dark side!");
            }
            else if (total == 4 ){
                System.out.println("Little Joe!");
            }
            else if (total == 5 ){
                System.out.println("After five, the fields alive!");
            }
            else if (total == 6 ){
                System.out.println("Easy six, Jimmy Hicks!");
            }
            else if (total == 7 ){
                System.out.println("Seven's a bruiser, the front line's a loser!");
            }
            else if (total == 8 ){
                System.out.println("A square pair!");
            }
            else if (total == 9 ){
                System.out.println("Centre field!");
            }
            else if ((amount == 2) && (total == 10) && (result[0] == 4 || result[0] == 6 )){
                System.out.println("Tennessee!");
            }
            else if ((amount == 2) && (total == 10) && (result[0] == 5)){
                System.out.println("Puppy paws!");
            }
            else if (amount == 2 && total == 11){
                System.out.println("Six five, no jive!");
            }
            else if (amount != 2 && total == 11){
                System.out.println("Yo eleven!");
            } 
            else if (total == 12 ){
                System.out.println("Triple dipple!");
            }
            System.out.println("Roll again? (type no to quit):");
            String input = scanner.nextLine();
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("n") || 
                    input.equalsIgnoreCase("no")) {
                System.out.println("Bye!");
                scanner.close();
                return;
            }
        }
    }
 
    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");
 
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");
 
    }
 
    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}
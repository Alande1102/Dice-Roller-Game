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
            System.out.println("Would you like to: \r\n1. Guess an exact number \r\n2. Guess over under \r\n3. Roll against the AI "); 
            int option = scanner.nextInt();
            int[] result = new int[2];
            int total = 0;
            boolean Win = false;
            for (int i=0; i<2;i++)
            {
            result[i] = dice.roll();
            total = total + result[i]; // calculate total value of dice rolled
            }
            if (option == 2){
                System.out.println("What is your over under number?");
                int overunder = scanner.nextInt();
                System.out.println("Would you like to: \r\n1. Guess OVER? \r\n2. Guess UNDER?");
                int userselection = scanner.nextInt();
                if (userselection == 1 || userselection == 2){
                    Win = OverUnder(total, overunder, userselection);
                }
            }
            for (int i = 0; i<2; i++){
            System.out.println("dice face value:" + result[i]);
            dice.draw(result[i]);
            }
            switch (option){
                case 1:
                    // Guess exact number
                    break;
                case 3:
                    Win = RollAgainst(result[0], result[1]);
                    break;
            }
            if (Win)
                System.out.println("You Win!");
            else 
                System.out.println("You Lose");

            System.out.println("Total value: " + total); // print total value of dice
            if (total == 2){
                System.out.println("Snakes eyes!");
            }
            else if (total == 3 ){
                System.out.println("Small ace deuce, can't produce!");
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
            else if ((total == 10) && (result[0] == 4 || result[0] == 6 )){
                System.out.println("Tennessee!");
            }
            else if ((total == 10) && (result[0] == 5)){
                System.out.println("Puppy paws!");
            }
            else if (total == 11){
                System.out.println("Six five, no jive!");
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

    private static boolean RollAgainst(int PlayerDice, int AIDice)
    {
        if (PlayerDice > AIDice)
            return true;
        else 
            return false;
    }

    private static boolean OverUnder(int RolledNumber, int PlayerNumber, int OverOrUnder)
    {
        if (OverOrUnder == 1){
            if (RolledNumber > PlayerNumber)
                return true;
            else
                return false;
        }
        if (OverOrUnder == 2)   {
            if (RolledNumber < PlayerNumber)
                return true;
            else
                return false;
        }
        else 
            return false;
    }

    
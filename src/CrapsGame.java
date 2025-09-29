import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        Random rand = new Random();
        int die1 = 0;
        int die2 = 0;
        int dieTotal = 0;
        int point = 0;
        boolean userDone = false;
        String userInput = "";

        System.out.println("Welcome to Craps! \uD83C\uDFB2\uD83C\uDFB2");
        System.out.print("\n");


        do {
            System.out.println("Let's start a game!");
            //Initial roll
            System.out.println("# Rolling dice...");

            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            dieTotal = die1 + die2;
            point = 0;

            if (dieTotal == 2 || dieTotal == 3 || dieTotal == 12) {
                //Craps
                System.out.println("You rolled a \uD83C\uDFB2" + die1 + " and a \uD83C\uDFB2" + die2);
                System.out.println(">> Craps, a " + dieTotal + "! You Lost. <<");
            } else if (dieTotal == 7 || dieTotal == 11) {
                //Natural
                System.out.println("You rolled a \uD83C\uDFB2" + die1 + " and a \uD83C\uDFB2" + die2);
                System.out.println(">> A Natural " + dieTotal + "! You Win! <<");
            } else {
                System.out.println("You rolled a \uD83C\uDFB2" + die1 + " and a \uD83C\uDFB2" + die2);
                point = dieTotal;
                System.out.println(" >>The point is: " + point + ". <<");
                dieTotal = 0; //reset for while loop

                while (dieTotal != point && dieTotal != 7) {
                    System.out.println("# Rolling dice for point...");

                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    dieTotal = die1 + die2;

                    System.out.println("You rolled a \uD83C\uDFB2" + die1 + " and a \uD83C\uDFB2" + die2);

                    if(dieTotal == point) {
                        System.out.println(">> You hit the point with a " + dieTotal + "! You Win! <<");
                    } else if (dieTotal == 7) {
                        System.out.println(">> Tough luck, you rolled a " + dieTotal + ". You Lost. <<");
                    }
                }
            }

            System.out.print("\nEnter Q to quit, or anything else to play again: ");
            userInput = consoleIn.nextLine();
            System.out.print("\n");

            if (userInput.equalsIgnoreCase("Q")) {
                userDone = true;
            }
        } while (!userDone);
    }
}
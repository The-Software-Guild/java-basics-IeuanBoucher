import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {

   static int currentRound, ties, userChoice, computerChoice, playerWins, computerWins, rounds;
   static Random random;

   public static void main(String[] args) {
      runGame();
   }

   private static void resetCounters() {
      currentRound = 0;
      ties = 0;
      userChoice = 0;
      computerChoice = 0;
      playerWins = 0;
      computerWins = 0;
      rounds = 0;
   }

   private static void runGame() {
      resetCounters();

      System.out.println("Enter number of rounds to play, minimum 1, maximum 10");
      Scanner scanner = new Scanner(System.in);
      try {
         rounds = scanner.nextInt();
         if (rounds >= 1 && rounds <= 10) {
            System.out.println("Commencing " + rounds + " of rock, paper, scissors.");
         } else {
            System.out.println("Input not in range, exiting program");
            return;
         }
      } catch (Exception e) {
         System.out.println("Input not in range, exiting program");
      }

      currentRound++;
      System.out.println("Enter your choice: enter 1 for rock, 2 for paper or 3 for scissors.");

      boolean validInput = false;
      do {
         try {
            userChoice = scanner.nextInt();
            if (userChoice != 1 && userChoice != 2 && userChoice != 3) {
               System.out.println("Invalid input, please try again.");
            } else {
               validInput = true;
            }
         } catch (Exception e) {
            System.out.println("Invalid input, please try again.");
         }
      } while (!validInput);

      computerChoice = random.nextInt(3) + 1;

      int result = findWinner(userChoice, computerChoice);
   }

   /**
    * Method to take the choice of the player and the computer, and determine who wins
    *
    * @param userChoice     user's choice: 1 for rock, 2 for paper or 3 for scissors
    * @param computerChoice computer's choice: 1 for rock, 2 for paper or 3 for scissors
    * @return 0 for draw, 1 for player victory, 2 for compute victory
    */
   private static int findWinner(int userChoice, int computerChoice) {
      if (userChoice == computerChoice) {
         return 0;
      } else if (userChoice == 1) {
         if (computerChoice == 2) {
            return 2;
         } else if (computerChoice == 3) {
            return 1;
         }
      } else if (userChoice == 2) {
         if (computerChoice == 1) {
            return 1;
         } else if (computerChoice == 3) {
            return 2;
         }
      } else if (userChoice == 3) {
         if (computerChoice == 1) {
            return 2;
         } else if (computerChoice == 2) {
            return 1;
         }
      }
      return 0;
   }
}
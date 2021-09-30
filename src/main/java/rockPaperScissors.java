import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {

   static int currentRound, ties, userChoice, computerChoice, playerWins, computerWins, maxRounds;
   static Random random = new Random();
   static Scanner scanner = new Scanner(System.in);


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
      maxRounds = 0;
   }

   private static void runGame() {
      resetCounters();

      System.out.println("Enter number of rounds to play, minimum 1, maximum 10");

      try {
         maxRounds = scanner.nextInt();
         if (maxRounds >= 1 && maxRounds <= 10) {
            System.out.println("Commencing " + maxRounds + " rounds of rock, paper, scissors.");
         } else {
            System.out.println("Input not in range, exiting program");
            return;
         }
      } catch (Exception e) {
         System.out.println("Input not in range, exiting program");
      }

      while (!(currentRound > maxRounds)) {
         playRound();
      }
      printSummary();

      System.out.println("Play again? Enter Y or N");

      char input = 0;
      boolean validInput = false;

      do {
         try {
            input = scanner.nextLine().toLowerCase().charAt(0);
            if (input == 'y' || input == 'n') {
               validInput = true;
            } else {
               System.out.println("Invalid input, please try again.");
            }
         } catch (Exception e) {
            System.out.println("Invalid input, please try again.");
         }
      } while (!validInput);

      if (input == 'y') {
         runGame();
      } else {
         System.out.println("Thanks for playing!");
      }
   }

   private static void playRound() {
      currentRound++;

      if (currentRound > maxRounds) {
         return;
      }

      System.out.println("Round " + currentRound + "\nEnter your choice: enter 1 for rock, 2 for paper or 3 for scissors.");

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

      switch (result) {
         case (0):
            System.out.println("Tie!");
            ties++;
            break;
         case (1):
            System.out.println("Player wins!");
            playerWins++;
            break;
         case (2):
            System.out.println("Computer wins!");
            computerWins++;
            break;
      }
   }

   private static void printSummary() {
      System.out.println("Tied rounds: " + ties);
      System.out.println("Player wins: " + playerWins);
      System.out.println("Computer wins: " + computerWins);
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
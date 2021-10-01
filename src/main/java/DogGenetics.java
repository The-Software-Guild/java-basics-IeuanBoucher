import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
   private static String[] dogTypes = new String[]{"King Charles Spaniel", "Terrier", "Corgi", "German Shepherd", "Miniature Dachshund"};

   public static void main(String[] args) {
      runDogGenetics();
   }

   /**
    * Assigns DNA origin percentages to the five dog types, totalling 100%
    */
   private static void runDogGenetics() {

      Scanner scanner = new Scanner(System.in);
      System.out.println("What is the name of your dog?");
      String name = scanner.nextLine();

      System.out.println("Here is a DNA background report on your pet:");

      Random random = new Random();

      int remaningPercentage = 100;
      int temp;

      for (int x = 0; x < 4; x++) {
         temp = 1 + random.nextInt(remaningPercentage);
         remaningPercentage -= temp;
         System.out.println(temp + "% " + dogTypes[x]);
      }
      System.out.println(remaningPercentage + "% " + dogTypes[4]);
   }
}

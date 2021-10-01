import java.text.MessageFormat;
import java.util.Scanner;

public class HealthyHearts {
   public static void main(String[] args) {
      runHealthHearts();
   }

   private static void runHealthHearts() {
      System.out.println("What is your age?");
      Scanner scanner = new Scanner(System.in);
      int age;
      try {
         age = scanner.nextInt();
      } catch (Exception e) {
         System.out.println("Invalid age, please try again.");
         return;
      }

      int maxHeartRate = 220 - age;
      System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");

      int heartRateUpperBound = (int) Math.ceil(0.85 * maxHeartRate);
      int heartRateLowerBound = (int) Math.ceil(0.50 * maxHeartRate);

      System.out.println(MessageFormat.format("Your target HR zone is {0} - {1} beats  per minute", heartRateLowerBound, heartRateUpperBound));

   }
}

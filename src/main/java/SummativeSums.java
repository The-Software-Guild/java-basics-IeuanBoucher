import java.util.Arrays;

public class SummativeSums {
   public static void main(String[] args) {
      int result = totalIntArray(new int[]{1, 90, -33, -55, 67, -16, 28, -55, 15});
      System.out.println("1# Array sum: " + result);

      result = totalIntArray(new int[]{999, -60, -77, 14, 160, 301});
      System.out.println("2# Array sum: " + result);

      result = totalIntArray(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99});
      System.out.println("3# Array sum: " + result);
   }

   /**
    * Returns sum of provided int array
    *
    * @param ints int array to be totalled
    * @return sum of int array values
    */
   private static int totalIntArray(int[] ints) {
      return Arrays.stream(ints).sum();
   }
}

public class firstArray {
    public static void main(final String[] args) {
 
        // Initialize 2D arrays of integers.
  final int[][] array = {{ 1, 2 },{ 3, 4 },{ 5, 6, 7 }};
 
  // Print the contents of the 2D arrays.
  for (final int[] row : array) {
      for (final int col : row)
          System.out.print(col + "\t");
      System.out.println();
  }
}
}

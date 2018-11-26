import java.util.Arrays;
import java.util.Scanner;

public class GradesHistograms {
	 public static void main(String[] args) {
	      // Declare variables
	      int numStudents;
	      int[] grades;  // Declare array name, to be allocated after numStudents is known
	      int[] bins = new int[10];  // int array of 10 histogram bins for 0-9, 10-19, ..., 90-100
	      Scanner in = new Scanner(System.in);

	      // Prompt and read the number of students as "int"
	      System.out.print("Enter the number of students: ");
	      numStudents = in.nextInt();

	      // Allocate the array
	      grades = new int[numStudents];

	      // Prompt and read the grades into the int array "grades"
	      for (int i = 0; i < grades.length; ++i) {
	         System.out.print("Enter the grade for student " + (i + 1) + ": ");
	         grades[i] = in.nextInt();
	      }
	      // Print array for debugging
	      System.out.println("mang grades : "+Arrays.toString(grades));

	      // Populate the histogram bins
	      for (int grade : grades) {
	         if (grade == 100) {   // Need to handle 90-100 separately as it has 11 items.
	            ++bins[9];
	         } else {
	            ++bins[grade/10];
	         }
	      }
	      // Print array for debugging
	      System.out.println("mang bins :"+Arrays.toString(bins));

	      // Print the horizontal histogram
	      // Rows are the histogram bins[0] to bins[9]
	      // Columns are the counts in each bins[i]
	      for (int binIdx = 0; binIdx < bins.length; ++binIdx) {
	         // Print label
	         if (binIdx != 9) {  // Need to handle 90-100 separately as it has 11 items
	            System.out.printf("%2d-%3d: ", binIdx*10, binIdx*10+9);
	         } else {
	            System.out.printf("%2d-%3d: ", 90, 100);
	         }
	         // Print columns of stars
	         for (int itemNo = 0; itemNo < bins[binIdx]; ++itemNo) {  // one star per item
	            System.out.print("*");
	         }
	         System.out.println();
	      }

	      // Find the max value among the bins
	      int binMax = bins[0];
	      for (int binIdx = 1; binIdx < bins.length; ++binIdx) {
	         if (binMax < bins[binIdx]) binMax = bins[binIdx];
	      }

	      // Print the Vertical histogram
	      // Columns are the histogram bins[0] to bins[9]
	      // Rows are the levels from binMax down to 1
	      for (int level = binMax; level > 0; --level) {
	         for (int binIdx = 0; binIdx < bins.length; ++binIdx) {
	            if (bins[binIdx] >= level) {
	               System.out.print("   *   ");
	            } else {
	               System.out.print("       ");
	            }
	         }
	         System.out.println();
	      }
	      // Print label
	      for (int binIdx = 0; binIdx < bins.length; ++binIdx) {
	         System.out.printf("%3d-%-3d", binIdx*10, (binIdx != 9) ? binIdx * 10 + 9 : 100);
	            // Use '-' flag for left-aligned
	      }
	      System.out.println();

	      in.close();  // Close the Scanner
	   }
}


public class PascalTriangle1 {
	public static void main(String[] args) {
		printPascalTriangle1(7);
//		 int r, i, k, number=1, j;
//			Scanner scan = new Scanner(System.in);
//			
//			System.out.print("Enter Number of Rows : ");
//			r = scan.nextInt();
//			
//			for(i=0;i<r;i++)
//			{
//				for(k=r; k>i; k--)
//				{
//					System.out.print(" ");
//				}
//	            number = 1;
//				for(j=0;j<=i;j++)
//				{
//					 System.out.print(number+ " ");
//	                 number = number * (i - j) / (j + 1);
//				}
//				System.out.println();
//			}
	}

	private static void printPascalTriangle1(int numRows) {
		// generate array for Pascal Triangle
		int[][] intArray = new int[numRows][numRows];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numRows; j++) {
				intArray[i][j] = 0;
				if (j == 0 || i == j) {
					intArray[i][j] = 1;
				} else if (j < i) {
					intArray[i][j] = intArray[i - 1][j] + intArray[i - 1][j - 1];
				}
			}
		}

		// print Pascal Triangle1's array
		// for (int c = 0; c < intArray.length; c++) {
		// for (int c2 = 0; c2 < intArray[0].length; c2++) {
		// if (intArray[c][c2] == 0) {
		// System.out.print(" ");
		// } else {
		// System.out.print(intArray[c][c2] + " ");
		// }
		// }
		// System.out.println();
		// }
		// print Pascal Triangle1's array
		for (int k1 = 0; k1 < intArray.length; k1++) {
			int l = intArray.length - k1;
			for (int k2 = 0; k2 < l; k2++) {
				System.out.print(" ");
			}
			for (int c2 = 0; c2 <= k1; c2++) {
				System.out.print(intArray[k1][c2] + " ");

			}
			System.out.println();
		}
	}

	
}

import java.util.Arrays;
import java.util.Scanner;

// This program reads in points in N-Space from System.in and reports the
// distance between the two closest points.
//
// The input format starts with the number of dimensions or, equivalently, the
// number of coordinates per point, followed by the number of points.  There are
// at least two points in the file.  For example, the following defines
// three-points in the x-y-plane:
//  2 
//  3
//  0.0 0.5
//  1.0 1.0
//  1.0 0.5
// In this case, the two closest points are the last two, (1,1) and (1,0.5).
// The program will print the distance: 0.5.
public class Closest {

	// Main
	//
	// Add Documentation
	public static void main(String[] arg) throws Exception {
		double[][] table = readTable(new Scanner(System.in));
		double dist = minDistance(table);

		System.out.println(dist);
		
	}

	// Read a 2D table
	// Expects the following file format:
	//  number_of_columns 
	//  number_of_rows
	//  first row of data
	//  second row of data
	//
	// For example, this is a table with two columns and three rows
	//  2
	//  3
	//  1.0 1.0
	//  0.0 1.0
	//  1.0 0.0
	public static double[][] readTable(Scanner input) {
	
		Scanner number = new Scanner(System.in);

		int numbColumn = number.nextInt();
		int numbRow = number.nextInt();
		double[][] table = new double[numbRow][numbColumn];
		for (int i = 0; i < numbRow; i++) {
			for (int j = 0; j < numbColumn; j++) {
				table[i][j] = number.nextDouble();


			}
			System.out.println(java.util.Arrays.toString(table[i]));

		}
		number.close();

		return table;
	}


	// Minimum Distance
	// Finds and returns the distance between the two closest points in the
	// provided table of points.
	//
	public static double minDistance(double[][] table) throws Exception {
		double numbColumn = table[0].length;
		double numbRow = table.length;
		double  point1 = numbColumn;
		double  point2 = numbRow;
		double currentMinDistance = Math.sqrt(
			(Math.pow(point1 - point2, 2))
			+
			(Math.pow(point1 - point2, 2))
		);
		// for(int i = 0; i < numbColumn; i++)
		// 	for(int j = i+1; j < numbRow; j++){
		// 		
		// 		double dist = 
		// 	}
		System.err.println(currentMinDistance);
		return currentMinDistance;
		
	}	
}

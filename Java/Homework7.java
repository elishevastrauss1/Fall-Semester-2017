package homeworks;

public class Homework7 {

	public static final int SIZE=3;
	public static void main(String[] args) {
		//variables for inputs
		int matrixA[][]=new int[SIZE][SIZE];
		int matrixB[][]=new int[SIZE][SIZE];
		
		//variables to store the results
		int matrixSum[][]=new int[SIZE][SIZE];
		int matrixDifference[][]=new int[SIZE][SIZE];
		int matrixProduct[][]=new int[SIZE][SIZE];
		
		System.out.println("Intializing matrices...");
		createMatrices(matrixA, matrixB);
		System.out.println("\nMatrix A:");
		printMatrix(matrixA);
		System.out.println("\nMatrix B:");
		printMatrix(matrixB);
		
		addMatrix(matrixSum, matrixA, matrixB);
		System.out.println("\n\nMatrix Sum:");
		printMatrix(matrixSum);
		
		subMatrix(matrixDifference, matrixA, matrixB);
		System.out.println("\n\nMatrix Difference:");
		printMatrix(matrixDifference);
		
		mulMatrix(matrixProduct, matrixA, matrixB);
		System.out.println("\n\nMatrix Product:");
		printMatrix(matrixProduct);

	}
	private static void createMatrices(int[][] matrixA, int[][] matrixB) {
		int [][] matrixACopy={{1,2,3},{4,5,6},{7,8,9}};
		int [][] matrixBCopy={{9,8,7},{6,5,4},{3,2,1}};
		
		for (int i=0; i<matrixACopy.length; i++)
		{
		  for (int j=0; j<matrixACopy[i].length; j++)
		  {
			  matrixA [i][j]=matrixACopy[i][j];
			  matrixB [i][j]=matrixBCopy[i][j];
		  }
		 }

		
	}
	private static void printMatrix(int[][] matrixA) {
		for (int i=0; i<matrixA.length; i++)
		{
		  for (int j=0; j<matrixA[i].length; j++)
		  {
			  System.out.print(matrixA [i][j]);
		  }
		  System.out.println();
		 }
		
	}
	private static void addMatrix(int[][] matrixSum, int[][] matrixA, int[][] matrixB) {
		for (int i=0; i<matrixA.length; i++)
		{
		  for (int j=0; j<matrixA[i].length; j++)
		  {
			  matrixSum[i][j]=matrixA[i][j]+matrixB[i][j];
		  }
		}
		
	}
	private static void subMatrix(int[][] matrixDifference, int[][] matrixA, int[][] matrixB) {
		for (int i=0; i<matrixA.length; i++)
		{
		  for (int j=0; j<matrixA[i].length; j++)
		  {
			  matrixDifference[i][j]=matrixA[i][j]-matrixB[i][j];
		  }
		}
		
	}
	private static void mulMatrix(int[][] matrixProduct, int[][] matrixA, int[][] matrixB) {
		int counter=0;
		int tempNumber = 0;
		for (int i=0; i<matrixA.length; i++)
		{
		  for (int j=0; j<matrixA[i].length; j++) //until here have values for first matrix
		  {
			  while (counter<3) { //goes through
				  tempNumber+=matrixA[i][j]*matrixB[j][i];
				  counter++;
			  }
			  counter=0;
			  matrixProduct[i][j]=tempNumber;
			  
		  }
		}
		
	}

}

import java.io.*;
import java.util.*;

/**
 * 
 * @author Steven Wojsnis
 * Triangle Problem for internship application
 * 
 * Solves the triangle problem by finding the highest adjacent element in the row directly above
 * a given element. That adjacent element is then added to the given element. This process is continued
 * until the bottom row is reached, which will contain the total sums, which can then be cycled through
 * to find the highest.
 *
 */
public class Main {

	static int[] colmax=new int[100]; //holds the number of elements(columns) in each row
	static int[][] array = new int[100][]; //holds the triangle itself
	static int row=0, col=0;
	
	/**
	 * Reads in the triangle from the input file and stores it in a two dimensional array.
	 * Then, starting from the top, each element is replaced by the sum of that element with
	 * the greatest adjacent element from the previous row. Eventually reaching the bottom, allowing us
	 * to find the highest value, which is the value we print.
	 * 
	 * @param args
	 */
	public static void main(String args[]){

		//Reads in and stores input file
		try (BufferedReader br = new BufferedReader(new FileReader("triangle.txt"))){
			String line = br.readLine();
			while(line != null){
				StringTokenizer tokenizer = new StringTokenizer(line, " ");
				colmax[row] = tokenizer.countTokens(); //Storing the number of columns in each row
				array[row] = new int[colmax[row]]; //Creating the rows of the triangle
				while(tokenizer.hasMoreTokens()){
					array[row][col] = Integer.parseInt(tokenizer.nextToken()); //Filling the rows with elements
					col++;
				}
				col = 0;
				row++;
				line = br.readLine();
			}
		}	
		catch(IOException e){
			System.exit(0);
		}
		
		for(int i=0;i<row;i++){
			for(int j=0;j<colmax[i];j++){
				if(i==0) array[i][j] = array[i][j]; //If dealing with the first row, add nothing
				else if(j==0){ 
					array[i][j] = array[i][j]+array[i-1][j]; //If dealing with the first element, add the previous first element
				}
				else if(j==colmax[i]-1){
					array[i][j] = array[i][j]+array[i-1][j-1]; //If dealing with the last element, add the previous last element
				}
				
				//Finds the greater adjacent element in previous row and adds it to the current element
				else if(array[i-1][j-1] > array[i-1][j]){
					array[i][j] = array[i][j] + array[i-1][j-1];
				}
				else{
					array[i][j] = array[i][j] + array[i-1][j];
				}
			}
		}
		
		int answer = array[99][0];
		
		for(int k=1;k<colmax[99];k++){
			if(array[99][k]>answer) answer = array[99][k]; //Finds the highest sum
		}
		
		System.out.println(answer);

	}
}

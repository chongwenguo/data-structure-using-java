import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/*********************************************************************
 * CSCE146 
 * Homework05 
 * 
 * class to deal with Travelling Salesman Problem
 * 
 * @author chongwen guo
 *
**/
public class TSP {
	
	
	int dMin = 999999; //the min distance
	int cityOrder[] = new int[6]; //the order of cities go through
	ArrayList<String> city = new ArrayList<String>(); // ArrayList used to store city name
	
	// two dimension array used to store distances between two cities
	//Seattle     0
	//NewOrleans  1
	//LosAngeles  2
	//Tucson      3
	//Chicago     4
	//Miami       5
	//Omaha       6
	int distances[][] = new int[7][7];
	//the value of distance[0][1] is the distance between Seattle and NewOrleans 
	//the value of distance[1][2] is the distance between NewOrleans and LosAngeles, and so on.
	

/*********************************************************************
 * Constructor.
 * read data from input <code>Scanner</code> file. 
 * 
 * @param the <code>Scanner</code> from which to read.
 * 
**/	
	public TSP(Scanner inFile) 
	{
		
		Scanner localScanner = new Scanner(inFile.nextLine());// first line
		
		while(localScanner.hasNext())
		{
			String s = localScanner.next();
			city.add(s);//get all cities name 
		}
		
		int i = 0;
		while(inFile.hasNext())
		{
			localScanner = new Scanner(inFile.nextLine());
			int j = 0;
			while(localScanner.hasNext())
			    {
			    	int n = localScanner.nextInt();
			    	distances[i][j] = n; //get all distances data
			    	j++;
			    }
			i++;
		}
		
	 }//public TSP(Scanner inFile) 
	
/*********************************************************************
 * general method
 * 
 * method to get a ArrayList that store the order of cities going through
 * 
 * @return the <code>ArrayList<String></code>
**/			  
	public ArrayList<String> solveTSP(PrintWriter outFile) 
	{
		// start from Seattle, here we ignore 0
		// array used to count all the permutations from 1 to 6
		int arr[] = {1,2,3,4,5,6};
		
		permutations(arr, 0, 5);
		
		ArrayList<String> order = new ArrayList<String>();

		order.add("Seattle"); //start from Seattle
		
		// according to the values in the cityOrder, translate the integer code to city name
		for(int i = 0; i < cityOrder.length; i++)
		{
			
			int code = cityOrder[i];
			if(code == 0)
			{
				order.add("Seattle");
			}
			else if(code == 1)
			{
				order.add("NewOrleans");
			}
			else if(code == 2)
			{
				order.add("LosAngeles");
			}
			else if(code == 3)
			{
				order.add("Tucson");
			}
			else if(code == 4)
			{
				order.add("Chicago");
			}
			else if(code == 5)
			{
				order.add("Miami");
			}
			else if(code == 6)
			{
				order.add("Omaha");
			}
		}
		return order;
	}//	public ArrayList<String> solveTSP(PrintWriter outFile) 

/*********************************************************************
 * method to generates all the permutations, and then go through all 
 * permutations to count the min distance and the cityorder
 * 
 * @param <code>int[]c</code> the array contains numbers to generates all the permutations
 * 		  <code>begin</code> the begin index,
 * 		  <code>end</code> the end index,
 * 
 * @return <code>dmin</code> the min distance 
 * 
 */	
	public  int permutations(int[] c, int begin, int end) 
	{
		if (begin == end) 
		{
			
			int	distance = distances[0][c[0]] + //start from Seattle to second city
					distances[c[0]][c[1]] +     //distance between second city and third
					distances[c[1]][c[2]] + 	//distance between third city and forth
					distances[c[2]][c[3]] + 	//distance between forth city and fifth
					distances[c[3]][c[4]] + 	//distance between fifth city and sixth
					distances[c[4]][c[5]] + 	//distance between sixth city and seventh
					distances[0][c[5]]; 		//come back to Seattle
		
			// if the distance we just got from one of the permutations is less than dMin 
			// we assign the distance into dMin
			
			if(distance < dMin)
			{
				dMin = distance;
				cityOrder[0] = 0;//start from city 0: Seattle
				
				//get the city order form the min distance permutation
				for(int i = 0; i < c.length; i++)
				{
					cityOrder[i] = c[i];
				}
			}
		} 
		else //the elements is not all exchange yet
		{ 

			for (int i = begin; i <= end; i++)
			{

				int temp = c[begin];// exchange the begin element with the i th element.

				c[begin] = c[i];

				c[i] = temp;

				 //recursively generates all the permutations 

				permutations(c, begin + 1, end);

				//reset

				c[i] = c[begin];

				c[begin] = temp;
				
			}
			
		}
		return dMin;
	}//public  int permutations(int[] c, int begin, int end) 

/*********************************************************************
 * method to return the min distance
 * 
 * @return <code>dmin</code> the min distance
 */
	public int getMinDistance()
	{
		return dMin;
	}//	public int getMinDistance()

	
/**********************************
 * general toString method 
 * 
 * @return <code>String</code> the formated String
 */	
	public String toString(){
		
		String s = "           ";
		
		for(int i = 0; i < city.size(); i++)
		{
			s += String.format("%11s", city.get(i));
		}
		
		s += "\n";
		
		for(int i = 0; i < 7; i++)
		{
			s += String.format("%11s", city.get(i));
			for(int j = 0 ; j < 7; j++)
			{
			
				s += String.format("%11d", distances[i][j]);
			}
			s += "\n";
		}
		s += "\n";
		return s;
	}//	public String toString()
}

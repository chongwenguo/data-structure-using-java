/*********************************************************************
 * csce 146
 * homework01
 * @author chongwen guo
 * 
**/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MyListStructure implements IMyListStructure {

	static ArrayList<Basket> Blist = null;
	
/*********************************************************************
 * Constructor.
 * @param inFile the Scanner from which to read.
**/
	public MyListStructure(Scanner inFile)
	{
	    Blist = new ArrayList<Basket>();
	    this.readFile(inFile);
	} // public MyListStructure(Scanner inFile)
	
/*********************************************************************
 * Method to read an basket from an input file.  
 *
 * @param inFile the Scanner from which to read.
**/

	public void readFile(Scanner inFile) 
	{
		while(inFile.hasNext())
		{
			Basket basket = new Basket(inFile);
			Blist.add(basket); // add the all baskets into Blist
		}
	} //public void readFile(Scanner inFile) 
	
/*********************************************************************
 * Usual 'toString' method.
 * This formats a basket into fixed-width fields.
 *
 * @return a formatted 'toString' of the class
**/
	public String toString()
	{
		String s = "The list of " + Blist.size() + " itemsets is \n";
		
		for(int i = 0; i < Blist.size(); ++i)
		{
			s += Blist.get(i) + "\n";
		}
		return s;
	} //public String toString()
	  
/*********************************************************************
 * Method to sort the list in the basket.
**/
	public void sortTheList() 
	{
	    Collections.sort(this.Blist);
	} // public void sortTheList() 
	
/*********************************************************************
 * Method to uniquify the list.
**/
	public void uniqTheList() 
	{
		for(int i = Blist.size() -1 ; i > 0 ; --i)
		{
			//if two adjacent Baskets are the same, then remove one from the Blist
			if(Blist.get(i).equals(Blist.get(i-1))) 
			{
				Blist.remove(i);
			}   
		}
	} //public void uniqTheList() 
}

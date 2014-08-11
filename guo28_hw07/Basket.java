import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*********************************************
 * Homework 7: Computing frequent itemsets using 'TreeMap'.
 * 
 * @author Duncan A. Buell
 * 
 * This is the class that deals with a single basket.
 * Used with permission by chongwen guo student.
 *
 */


public class Basket implements IBasket {
	
	   ArrayList<Integer> list;

	/*********************************************************************
	 * Constructor.
	**/
	  public Basket(Scanner inFile)
	  {
	    this.list = new ArrayList<Integer>();
	    this.readFile(inFile);
	  }

	/*********************************************************************
	 * Accessors and mutators.
	**/

	/*********************************************************************
	 * General methods.
	**/
	/*********************************************************************
	 * Usual 'compareTo' method to implement 'Comparable'.
	 *
	 * @param inFile the Scanner from which to read.
	**/
	  public int compareTo(Basket that)
	  {
	    int returnValue = 0;

	    returnValue = 0;
	    if(this.size() < that.size())
	    {
	      returnValue = -1;
	    }
	    else if(this.size() > that.size())
	    {
	      returnValue = +1;
	    }
	    else
	    {
	      for(int i = 0; i < this.size(); ++i)
	      {
	        if(this.list.get(i) < that.list.get(i))
	        {
	          returnValue = -1;
	          break;
	        }
	        else if(this.list.get(i) > that.list.get(i))
	        {
	          returnValue = +1;
	          break;
	        }
	      }
	    }

	    return returnValue;
	  } // public int compareTo(Basket that)

	/*********************************************************************
	 * Method to test two baskets for equality of contents.
	 * This overrides the default 'equals'.
	 *
	 * @param that the basket to test against
	**/
	  public boolean equals(Object that)
	  {
	    return (0 == this.compareTo((Basket) that));
	  } // public boolean equals(Object that)

	/*********************************************************************
	 * Method to return one subscripted item from the basket.
	 *
	 * @param which the subscript of the item to return
	 * @return the item
	**/
	  public int getValue(int which)
	  {
	    if((0 > which) || (which > this.list.size()))
	    {
	      throw new RuntimeException("basket subscript out of bounds");
	    }
	    return list.get(which);
	  } // public int getValue(int which)

	/*********************************************************************
	 * Method to return the max value in this basket.
	 *
	 * @return the maximum value
	**/
	  public int maxValue()
	  {
	    int theMax = Integer.MIN_VALUE;
	    for(int i: this.list)
	    {
	      if(i > theMax) theMax = i;
	    }

	    return theMax;
	  } // public int maxValue()

	/*********************************************************************
	 * Method to return the min value in this basket.
	 *
	 * @return the minimum value
	**/
	  public int minValue()
	  {
	    int theMin = Integer.MAX_VALUE;
	    for(int i: this.list)
	    {
	      if(i < theMin) theMin = i;
	    }

	    return theMin;
	  } // public int minValue()

	/*********************************************************************
	 * Method to read an basket from an input file.  
	 *
	 * @param inFile the Scanner from which to read.
	**/
	  public void readFile(Scanner inFile)
	  {
	    Scanner localScanner = null;
	    if(inFile.hasNext())
	    {
	      localScanner = new Scanner(inFile.nextLine());
	      while(localScanner.hasNext())
	      {
	        int n = localScanner.nextInt();
	        list.add(n);
	      }
	    }
	  } // public void readFile(Scanner inFile)

	/*********************************************************************
	 * Method to return the size of the list that is the basket.
	 *
	 * @return the size of the list.
	**/
	  public int size()
	  {
	    return this.list.size();
	  } // public int size()

	/*********************************************************************
	 * Method to sort the list in the basket.
	**/
	  public void sortTheList()
	  {
	    Collections.sort(this.list);
	  } // public int size()

	/*********************************************************************
	 * Usual 'toString' method.
	 * This formats a basket into fixed-width fields.
	 *
	 * @return a formatted 'toString' of the class
	**/
	  public String toString()
	  {
	    String s = "";

	    s += String.format("%5d ", list.size());
	    s += "(";
	    for(Integer i: list)
	    {
	      s += String.format(" %5d", i);
	    }
	    s += ")\n";

	    return s;
	  } // public String toString()

	  
	  
	} // public class Basket implements Comparable<Basket>



import java.util.ArrayList;
// import java.util.Collections;
import java.util.Scanner;
/*********************************************************************
 * MyListStructure.
 * This is the application layer of Homework 01.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-07-03
**/
public class MyListStructure implements IMyListStructure
{
  ArrayList<Basket> basketList = null;

/*********************************************************************
 * Constructor.
**/
  public MyListStructure(Scanner inFile)
  {
    this.basketList = new ArrayList<Basket>();
    this.readFile(inFile);
  }

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Static method to read baskets from an input file.  
 *
 * @param inFile the Scanner from which to read.
**/
  public void readFile(Scanner inFile)
  {
    while(inFile.hasNext())
    {
      Basket basket = new Basket(inFile);
      basketList.add(basket);
    }
  } // public void readFile(Scanner inFile)

/*********************************************************************
 * Method to sort the list.
**/
  public void sortTheList()
  {

    //////////////////////////////////////////////////////////////////
    // first we sort the lists in each basket
    for(Basket basket: basketList)
    {
      basket.sortTheList();
    }

    //////////////////////////////////////////////////////////////////
    // then we sort the itemsets in the list of itemsets
//    Collections.sort(this.basketList);
// the bubblesort is commented out and we use the 'Collections' sort
    for(int i = 0; i < basketList.size()-1; ++i)
    {
      for(int j = i+1; j < basketList.size(); ++j)
      {
        if(basketList.get(i).compareTo(basketList.get(j)) > 0)
        {
          Basket temp = basketList.get(j);
          basketList.set(j, basketList.get(i));
          basketList.set(i, temp);
        }
      }
    }
/*
*/
	
  } // public void sortTheList()

/*********************************************************************
 * Method to uniquify the list.
**/
  public void uniqTheList()
  {
    for(int i = this.basketList.size()-2; i >= 0; --i)
    {
      if(this.basketList.get(i).equals(this.basketList.get(i+1)))
      {
        this.basketList.remove(i+1);
      }
    }
	
  } // public void uniqTheList()

/*********************************************************************
 * Usual 'toString' method.
 * This formats basket into fixed-width fields.
**/
  public String toString()
  {
    String s = "";

    s += String.format("The list of %d itemsets is\n", basketList.size());
    for(Basket basket: basketList)
    {
      s += String.format("%s\n", basket);
    }

    return s;
  } // public String toString()

  
/*********************************************************************
 * a method uniquifyMinusC to your code that will count the number of
 * occurrences of each basket and output that number.
**/
   public String uniqTheListMinusC() 
   {
 	  String s = "";
 	  int number = 1;
 	    for(int i = 0; i <= this.basketList.size()-2; i++)
 	    {
 	    // if two adjacent baskets are the same, then just count the number of occurrences
 	      if(this.basketList.get(i).equals(this.basketList.get(i+1)))
 	      {
 	    	 number ++;
 	      }
 	    // if two adjacent baskets are not the same, then add it to String with the number of occurrences
 	    // and then reset the number to be 1
 	      else  
 	      {
 	    	  s += "   "+ number  + " " + basketList.get(i).toString() + "\n";
 	    	  number = 1;
 	      }
 	    }
 	    
 	    s +=  "   "+ number  + " " + basketList.get(basketList.size() - 1).toString() + "\n"; //add the last item
 	return s;
   }//public String uniqTheListMinusC() 
 /*********************************************************************
  * 
  *
 **/
  public String itemsets3()
  {
	  
	 // computing the overall min and max value
	  int max = 0;
	  int min = 100;
	  for(int i = 0; i < basketList.size()-1; ++i)
	  {
		   Basket basket = basketList.get(i);
		   if(basket.maxValue() > max)
		   {
			   max = basket.maxValue();
		   }
		   if(basket.minValue() < min)
		   {
		   min = basket.minValue();
	       }
	    }
	  
	  //set up a 3-dimensional integer array
	  int[][][]arr = new int[max][max][max];
	  
	  //zero the array.
	  for(int j = 0; j < max; j++ )
	  {
		   for(int k = 0; k< max; k++)
		   {
			   for(int l = 0; l < max; l ++)
			   {
				   arr[j][k][l] = 0;
			   }
		   }
	   }
		   
	  
		   for(int i = 0; i < basketList.size()-1; ++i)
			  {
				   Basket basket = basketList.get(i);
				   for(int j = min; j < max; j++ )
				   {
					   for(int k = min; k< max; k++)
					   {
						   for(int l = min; l < max; l ++)
						   {
							  if(basket.size() >= 3) 
							  {
								  
							   if(basket.getValue(0) == j)
							   {
								   if(basket.getValue(1) == k)
								   {
									   if(basket.getValue(2) == l)
									   {
										  arr[j][k][l] = 1;
									   }
								   }
							   }
							  }
						   }
					   }
				   }
			 }
		   
		   for(int j = 0; j < max; j++ )
		   {
			   for(int k = 0; k< max; k++)
			   {
				   for(int l = 0; l < max; l ++)
				   {
					   if(arr[j][k][l] == 1)
					   {
						   System.out.println( j + " "+ k + " " + l);
					   }
				   }
			   }
		   }
		   

	  return "s";
  }
} // public class MyListStructure

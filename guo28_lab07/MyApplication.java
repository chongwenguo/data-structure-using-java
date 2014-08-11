import java.util.ArrayList;
// import java.util.Collections;
import java.util.Scanner;
/*********************************************************************
 * MyApplication.
 * This is the application layer of Lab 07.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-07-11
**/
public class MyApplication<T>
{
  T myData1 = null;
  T myData2 = null;

/*********************************************************************
 * Constructor.
 * 
  public MyApplication(Scanner inFile)
  {
    this.readFile(inFile);
  }
**/

/*********************************************************************
 * Constructor.
**/
  public MyApplication(T one, T two)
  {
    myData1 = one;
    myData2 = two;
  }

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to do "the operation".
 *
 * For data of 'Basket' type, the operation is to swap the two baskets.
**/
  public void operation()
  {
    T temp = myData1;
    myData1 = myData2;
    myData2 = temp;
  } // public void readFile(Scanner inFile)
  
/*********************************************************************
 * Method to read baskets from an input file.  
 *  
 * 
 */
  public T getValue()
  {
	  return myData1;
  }
  

  

/*********************************************************************
 * Method to read baskets from an input file.  
 *
 * @param inFile the Scanner from which to read.
  public void readFile(Scanner inFile)
  {
    myData1 = new Basket(inFile);
    myData2 = new Basket(inFile);
  } // public void readFile(Scanner inFile)
**/

/*********************************************************************
 * Usual 'toString' method.
 * This formats basket into fixed-width fields.
**/
  public String toString()
  {
    String s = "";

    s += String.format("Data 1: %s\n", myData1);
    s += String.format("Data 2: %s\n", myData2);

    return s;
  } // public String toString()

} // public class MyApplication

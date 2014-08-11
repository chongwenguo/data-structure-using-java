/*********************************************************************
 * Used and modified with permission by chongwen guo student.
 * 
 * Homework 3 is to convert your DLL from Homework 2
 * into a version that uses keys and generics.
 * This code has methods
 *   <code>add</code>,
 *   <code>contains</code>,
 *   <code>remove</code>,
 *   <code>toString</code>,
 * that are simply wrappers for methods of the same name in the DLL.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * 
 *  
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-07-06
**/
public class MyListStructure<T extends Comparable<T>> implements IMyListStructure<T>
{
/*********************************************************************
 * Instance variables for this class.
**/
  private DLL<T> dll;

/*********************************************************************
 * Constructor.
**/
  public MyListStructure()
  {
    this.dll = new DLL<T>();
  } // public MyListStructure()

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to add a <code>Basket</code> entry to the list.
 * This simply calls the DLL <code>add</code> method.  Therefore,
 * what we are really doing here is converting the <code>add</code>
 * of a <code>Basket</code> item to the <code>MyListStructure</code> into
 * the addition of a node with that <code>Basket</code> as data
 * payload into the <code>DLL</code>.
 *
 * @param basket the <code>Basket</code> to add.
 *
 * @return true if the list changes, else false.
**/
  public boolean add(T basket)
  {
    return this.dll.add(basket);
  } // public boolean add(T basket)

/*********************************************************************
 * Method to find if a list has a given basket. 
 *
 * @param basket the <code>Basket</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(T basket)
  {
    return this.dll.contains(basket);
  } // public boolean contains(T basket)

/*********************************************************************
 * Method to remove a node with a given basket value. 
 *
 * @param basket the <code>Basket</code> whose node is to be removed.
 *
 * @return the <code>boolean</code> that remove succeeded.
**/
  public boolean remove(T basket)
  {
    return this.dll.remove(basket);
  } // public boolean remove(T basket)

/*********************************************************************
 * Method to <code>toString</code> a complete MyListStructure.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
    String s = "";
    s = this.dll.toString();
    return s;
  } // public String toString()


} // public class MyListStructure<T extends Comparable<T>> implements IMyListStructure<T>

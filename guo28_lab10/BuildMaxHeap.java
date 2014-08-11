import java.util.ArrayList;
/*********************************************************************
 * Class for building a max heap from an <code>ArrayList</code>.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-10-10
**/
public class BuildMaxHeap
{
/*********************************************************************
 * Instance variables for the class.
**/
  private ArrayList<Integer> newList;

/*********************************************************************
 * Constructor.
**/
  public BuildMaxHeap()
  {
    newList = new ArrayList<Integer>();
  }

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to build a max heap from an input list.
 *
 * @param inputList the list to turn into a max heap
 * @return the output list that is a max heap
**/
  public ArrayList<Integer> buildMaxHeap(ArrayList<Integer> inputList)
  {

    for(int i = 0; i < inputList.size(); ++i)
    {
      this.newList.add(inputList.get(i));
    }

    for(int i = 1; i < this.newList.size(); ++i)
    {
      this.fixHeapUp(i);
    }

    return newList;
  } // public ArrayList<Integer> buildHeap(ArrayList<Integer> inputList)

/*********************************************************************
 * Method to check that an <code>ArrayList</code> is a max heap.
 *
 * @param list the list to check
 * @return the answer to whether the list is a max heap
**/
  public boolean checkHeap(ArrayList<Integer> list)
  {
    boolean returnValue;

    returnValue = true;
    for(int i = 1; i < list.size(); ++i)
    {
      // check the left child
      if(2*i < list.size())
      {
        if(list.get(i) < list.get(2*i))
        {
          returnValue = false;
          break;
        }
      }

      // check the right child
      if(2*i+1 < list.size())
      {
        if(list.get(i) < list.get(2*i+1))
        {
          returnValue = false;
          break;
        }
      }
    }

    return returnValue;
  } // public boolean checkHeap(ArrayList<Integer> list)

/*********************************************************************
 * Method to build a heap from an input list.
 *
 * @param inputList the list to turn into a max heap
 * @return the output list that is a max heap
**/
  public void fixHeapUp(int insertSub)
  {
    int parentSub;
    Integer insertInt = this.newList.get(insertSub);
    parentSub = insertSub/2;
    while(1 < insertSub)
    {
      if(this.newList.get(parentSub) < insertInt)
      {
        this.swap(insertSub, parentSub);
        insertSub = parentSub;
        insertInt = this.newList.get(insertSub);
        parentSub = insertSub/2;
      }
      else
      {
        break;
      }
    } // while(1 < insertSub)
  } // public void fixHeapUp(int insertSub)

/*********************************************************************
 * Method to swap two elements in the list.
 *
 * @param subA the first subscript of the swap
 * @param subB the second subscript of the swap
**/
  public void swap(int subA, int subB)
  {
    int temp;

    temp = this.newList.get(subA);
    this.newList.set(subA, this.newList.get(subB));
    this.newList.set(subB, temp);
  } // public void swap(int subA, int subB)

} // public class BuildHeap

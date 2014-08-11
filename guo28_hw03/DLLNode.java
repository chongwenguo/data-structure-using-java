/*********************************************************************
 * Used and modified with permission by chongwen guo student.
 * 
 * Class to handle a node for a doubly-linked list.
 * This code implements a standard node in a doubly-linked list.
 * Instance variables are
 *   <code>next</code>,
 *   <code>prev</code>,
 *   <code>nodeData</code>,
 * and all but the last are standard and no methods exist here
 * except the accessors and mutators for the instance variables and
 * the standard <code>toString</code> that returns a formatted
 * version of the data payload.
 *
 * Note that this hard-codes the data payload as an item of
 * <code>Basket</code> type, and this ought to be reworked to use
 * generics.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * 
 * 
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-01-01
**/

public class DLLNode<T> implements IDLLNode<T>
{
  private DLLNode<T> next;
  private DLLNode<T> prev;
  private T nodeData;

/*********************************************************************
 * Constructor for a node with totally dummy data;.
**/
  public DLLNode()
  {
    super();
    this.setNext(null);
    this.setPrev(null);
    this.setNodeData(null);
  } // public DLLNode()

/*********************************************************************
 * Constructor for a dummy node with nulls.
**/
  public DLLNode(T data)
  {
    super();
    this.setNext(null);
    this.setPrev(null);
    this.setNodeData(data);
  } // public DLLNode(T data)

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>nodeData</code>.
 *
 * @return the <code>nodeData</code>.
**/
  public T getNodeData()
  {
    return this.nodeData;
  } // public T getNodeData()

/*********************************************************************
 * Method to set the <code>nodeData</code>.
 *
 * @param newData the new value for the <code>nodeData</code>.
**/
  public void setNodeData(T newData)
  {
    this.nodeData = newData;
  } // public void setNodeNext(T newData)

/*********************************************************************
 * Method to get the <code>next</code> node.
 *
 * @return the next <code>DLLNode</code>.
**/
  public DLLNode<T> getNext()
  {
    return this.next;
  } // public DLLNode<T> getNext()

/*********************************************************************
 * Method to set the <code>next</code> node.
 *
 * @param newNext the new value for the next <code>DLLNode</code>.
**/
  public void setNext(DLLNode<T> newNext)
  {
    this.next = newNext;
  } // public void setNext(DLLNode<T> newNext)

/*********************************************************************
 * Method to get the <code>previous<code> node.
 *
 * @return the previous <code>DLLNode</code>.
**/
  public DLLNode<T> getPrev()
  {
    return this.prev;
  } // public DLLNode<T> getPrev()

/*********************************************************************
 * Method to set the <code>previous<code> node.
 *
 * @param newNext the new value for the previous <code>DLLNode</code>.
**/
  public void setPrev(DLLNode<T> newPrev)
  {
    this.prev = newPrev;
  } // public void setPrev(DLLNode<T> newPrev)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to return a <code>toString</code> of the node data.
 *
 * @return the <code>String</code> value for the node's data. 
**/
  public String toString()
  {
    String s = "";

    if(null == this.nodeData)
    {
      s = "Dummy Node";
    }
    else
    {
      s = this.nodeData.toString();
    }

    return s;
  } // public String toString()

} // public class DLLNode<T> implements IDLLNode<T>

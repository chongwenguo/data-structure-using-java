/*********************************************************************
 *  Used and modified with permission by chongwen guo student.
 * 
 * Class for a doubly linked list.
 * This code implements a standard version of a DLL.  In this case the
 * DLL is implemented with a dummy head and a dummy tail node.  The
 * instance variables are
 *   <code>size</code> (size to the user, thus total size less 2),
 *   <code>head</code>,
 *   <code>tail</code>,
 *
 * Accessor and mutator methods are:
 *   <code>getHead</code>,
 *   <code>setHead</code>,
 *   <code>getSize</code>,
 *   <code>getTail</code>,
 *   <code>setTail</code>,
 *
 * General methods are:
 *   <code>add</code> (wrapper that calls <code>addAtHead</code>),
 *   <code>addAtHead</code> (to add a node at the head),
 *   <code>contains</code>,
 *   <code>containsNode</code> (to run the loop to test
 *                              containment for contains and remove),
 *   <code>linkAfter</code> (optional: link after a given node),
 *   <code>remove</code> to remove with a data record as parameter,
 *   <code>remove</code> optional: to remove a specific indexed node,
 *   <code>toString</code>,
 *   <code>unlink</code> to unlink a node.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * 
 * 
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-07-06
**/
public class DLL<T extends Comparable<T>> implements IDLL<T>
{
/*********************************************************************
 * Instance variables for this class.
**/
//  private static final String TAG = "DLL: ";

  private int size;        // list size, counting head and tail
  private DLLNode<T> head;    // the head node of the list
  private DLLNode<T> tail;    // the tail node of the list

/*********************************************************************
 * Constructor.
**/
  public DLL()
  {
    this.setHead(new DLLNode<T>());
    this.setTail(new DLLNode<T>());
    head.setNext(this.tail);
    tail.setPrev(this.head);
    this.size = 2;
  } // public DLL()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to get the <code>head</code>.
 *
 * @return the node that is the value of <code>head</code>.
**/
  public DLLNode<T> getHead()
  {
    return this.head;
  } // public DLLNode<T> getHead()

/*********************************************************************
 * Method to set the <code>head</code>.
 *
 * @param value the value to be used
**/
  public void setHead(DLLNode<T> value)
  {
    this.head = value;
  } // private void setHead(DLLNode<T> value)

/*********************************************************************
 * Method to get the <code>size</code>.
 *
 * @return the value of <code>size</code>.
**/
  public int getSize()
  {
    return this.size;
  } // public int getSize()

/*********************************************************************
 * Method to get the <code>tail</code>.
 *
 * @return the node that is the value of <code>tail</code>.
**/
  public DLLNode<T> getTail()
  {
    return this.tail;
  } // public DLLNode<T> getTail()

/*********************************************************************
 * Method to set the <code>tail</code>.
 *
 * @param value the value to be used
**/
  public void setTail(DLLNode<T> value)
  {
    this.tail = value;
  } // private void setTail(DLLNode value)

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to add a node.
 * By default this adds the node at the head.
 * We deliberately fail to bulletproof w.r.t. the return value.
 *
 * @param dllData the <code>Basket</code> data item to add.
 *
 * @return a boolean to say the <code>Basket</code> was added.
**/
  public boolean add(T dllData)
  {
    this.addAtHead(dllData);
    return true;
  } // public boolean add(T dllData)

/*********************************************************************
 * Method to add a node at the head of a linked list. 
 *
 * @param newNode the <code>DLLNode</code> node to add. 
**/
  private void addAtHead(T dllData)
  {
    DLLNode<T> newNode = null;
    newNode = new DLLNode<T>();
    newNode.setNodeData(dllData);
    this.linkAfter(this.getHead(), newNode);
  } // private void addAtHead(T dllData)

/*********************************************************************
 * Method to find if a list has a given data item. 
 *
 * @param dllData the <code>Basket</code> to match against. 
 *
 * @return the <code>boolean</code> answer to the question.
**/
  public boolean contains(T dllData)
  {
    boolean returnValue = false;
    DLLNode<T> foundNode = null;
    foundNode = this.containsNode(dllData);
    if(null != foundNode)
    {
      returnValue = true;
    }
    return returnValue;
  } // public boolean contains(T dllData)

/*********************************************************************
 * Method to return the node with a given data item in it, else null.
 * This method eliminates duplicate code in <code>contains</code>
 * and <code>remove</code>. 
 *
 * @param dllData the <code>Basket</code> to match against. 
 *
 * @return the <code>DLLNode</code> answer, else null.
**/
  private DLLNode<T> containsNode(T dllData)
  {
    DLLNode<T> returnValue = null;
    DLLNode<T> currentNode = null;

    currentNode = this.getHead();
    currentNode = currentNode.getNext();
    while(currentNode != this.getTail())
    {
      if(0 == currentNode.getNodeData().compareTo(dllData))
      {
        returnValue = currentNode;
        break; // we violate the style rule
      }
      currentNode = currentNode.getNext();
    }

    return returnValue;
  } // private DLLNode containsNode(T dllData)

/*********************************************************************
 * Method to remove a node with a given basket as data. 
 *
 * @param dllData the <code>Basket</code> to match against. 
 *
 * @return the <code>boolean</code> as to whether the basket was
 *         found and removed or not.
**/
  public boolean remove(T dllData)
  {
    boolean returnValue = false;
    DLLNode<T> foundNode = null;
    foundNode = this.containsNode(dllData);
    if(null != foundNode)
    {
      this.unlink(foundNode);
      returnValue = true;
    }
    return returnValue;
  } // public boolean remove(T dllData)

/*********************************************************************
 * Method to remove a node at a given subscript.
 *
 * @param sub the subscript of the node to remove. 
 *
 * @return the subscript of the node removed,
 *         or else a negative number.
**/
  private int remove(int which)
  {
    int returnValue = -1;
    DLLNode<T> currentNode = null;

    if(which <= 0) // must include 0 as dummy head node
    {
    }
    else if(which >= this.getSize()-1) // must include size-1 as dummy tail node
    {
    }
    else
    {
      currentNode = this.getHead().getNext(); // start at first real node
      for(int i = 1; i < which; ++i)
      {
        currentNode = currentNode.getNext();
      }
      this.unlink(currentNode);
      returnValue = which;
    }

    return returnValue;
  } // private int remove(int which)

/*********************************************************************
 * Method to link a node after a given node. 
 *
 * @param baseNode the <code>DLLNode</code> to be linked after. 
 * @param newNode the <code>DLLNode</code> to be linked in. 
**/
  private void linkAfter(DLLNode<T> baseNode, DLLNode<T> newNode)
  {
    newNode.setNext(baseNode.getNext());
    newNode.setPrev(baseNode);

    baseNode.getNext().setPrev(newNode);
    baseNode.setNext(newNode);

    ++this.size;
  } // private void linkAfter(DLLNode<T> baseNode, DLLNode<T> newNode)

/*********************************************************************
 * Method to <code>toString</code> a complete DLL, including head and
 * tail nodes.
 *
 * @return the <code>toString</code> rep'n of the entire DLL.
**/
  public String toString()
  {
    int sequence;
    String s = "";
    DLLNode<T> node;

    s += String.format("There are %d entries%n", 
                       this.getSize());
    s += String.format("going forward%n");

// note that we include the head and then also the tail
    sequence = 0;
    node = this.head;
    s += String.format("%3d: %s%n", sequence, node.toString());
    while(node != tail)
    {
      node = node.getNext();
      ++sequence;
      s += String.format("%3d: %s%n", sequence, node.toString());
    }

    s += "\n";
    s += String.format("going backward%n");
    sequence = 0;
    node = this.tail;
    s += String.format("%3d: %s%n", sequence, node.toString());
    while(node != head)
    {
      node = node.getPrev();
      ++sequence;
      s += String.format("%3d: %s%n", sequence, node.toString());
    }

    return s;
  } // public String toString()

/*********************************************************************
 * Method to unlink a node.
 *
 * @param node the <code>DLLNode</code> to unlink.
**/
  private void unlink (DLLNode<T> node)
  {
    node.getNext().setPrev(node.getPrev());
    node.getPrev().setNext(node.getNext());

    node.setNext(null);
    node.setPrev(null);

    --this.size;
  } // private void unlink(DLLNode<T> node)


} //public class DLL<T extends Comparable<T>> implements IDLL<T>

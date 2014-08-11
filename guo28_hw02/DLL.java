/*********************************************************************
 * csce 146
 * homework02
 * @author chongwen guo
 * 
**/

public class DLL  implements IDLL {

	private int size;
	private DLLNode head;
	private DLLNode tail;
	private DLLNode node;

/*********************************************************************
 * Constructor.
**/	  	
	public DLL()
	{
		this.size = 2;
		head = new DLLNode();
		tail = new DLLNode();
		head.setNext(tail);
		tail.setPrev(head);
	}
/*********************************************************************
 * Accessors and mutators.
**/
	
	  public DLLNode getHead()
	  {
		return this.head;
	  }

	  public void setHead(DLLNode value)
	  {
		  this.head = value;
	  }

	  public int getSize()
	  {
		  return this.size;
	  }

	  public DLLNode getTail()
      {
		  return this.tail;
	  }

	  public void setTail(DLLNode value)
	  {
		  this.tail = value;
	  }
	  
/*********************************************************************
 * General methods.
 **/
/*********************************************************************
 * method to add a basket to dll link
 **/
	  public boolean add(Basket dllData) 
	  {
		  this.addAtHead(dllData);
		  return true;
	  } //public boolean add(Basket dllData) 
	  
/*********************************************************************
 * methods to add the basket after head
 **/	  
	  private void addAtHead(Basket dllData)
	  {
		  DLLNode newNode = null;
		  newNode = new DLLNode();
		  newNode.setNodeData(dllData);
		  this.linkAfter(this.getHead(), newNode);
		  
	  }//  private void addAtHead(Basket dllData)
 /*********************************************************************
  *  method to link to nodes
 **/	  
	  private void linkAfter(DLLNode thisNode, DLLNode newNode)
	  {
		  newNode.setNext(thisNode.getNext());
		  newNode.setPrev(thisNode);
		  thisNode.getNext().setPrev(newNode);
		  thisNode.setNext(newNode);
		  this.incrementSize();
	  } //private void linkAfter(DLLNode thisNode, DLLNode newNode)
/*********************************************************************
 * method for increasing size
 **/  
	  private void  incrementSize()
	  {
		  this.size++;
	  }//  private void  incrementSize()
/*********************************************************************
 * method for decreasing size
 **/
	  private void decrementSize()
	  {
		  this.size--;
	  }//private void decrementSize()
/*********************************************************************
 *  method to check if the list contains a basket
 **/
	  public boolean contains(Basket dllData) 
	  {
		  
		  boolean isContain = false;
		  this.node = head;
		  
		  while(node.getNext() != tail) //go through the list
		  {
			  if(0 == node.getNext().getNodeData().compareTo(dllData))
			  {
				  isContain = true;
				  break;
			  }
			  node = node.getNext();
		  }
		  return isContain;
	  }// public boolean contains(Basket dllData) 
/*********************************************************************
 * method to remove a basket from the list
 * **/
 public boolean remove(Basket dllData) 
	  {
	    if(contains(dllData))
		  {
	    	node = node.getNext(); //get the node that we want to move 
	    	
	    	node.getNext().setPrev(node.getPrev());
	    	node.getPrev().setNext(node.getNext());
	    	node.setNext(null);
	    	node.setPrev(null);
	    	this.decrementSize();
	    	return true;
		  }
	    return false;
	  }   // public boolean remove(Basket dllData) 
 /*********************************************************************
  * General to string methods.
  **/
	  public String toString() 
	  {
		  	String s = "";
			s += "There are " + this.getSize() + " entries \n" 
					+ "going forward \n";
			
			this.node = head;
			int i = 1;
			
			s +=  "  0: Dummy Node   \n";
			while(node.getNext() != tail)
			{
				s += "  " + i + ": " + node.getNext().getNodeData().toString() + "\n";
				node = node.getNext();
				i++;
			}
			s +=  "  " + i + ": Dummy Node   \n";
			
			s += "\ngoing backward \n";
			
			this.node = tail;
			i = 1;
			s +=  "  0: Dummy Node   \n";
			while(node.getPrev() != head)
			{
				s += "  " + i + ": " + node.getPrev().getNodeData().toString() + "\n";
				node = node.getPrev();
				i++;
			}
			s +=  "  " + i + ": Dummy Node   \n";
			return s;
	  }  // public String toString()
	  
} //public class DLL  implements IDLL 

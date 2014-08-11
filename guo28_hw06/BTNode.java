/*********************************************************************
 * BTNode class
 *
 * @author chongwen guo
 * 
**/


public class BTNode<T> implements IBTNode<T> {
	
	public BTNode<T> parent, leftChild, rightChild;
	private T rec;
	private int height = 0;
	
	public BTNode() 
	{  
		rec = null;
	}
	
	public BTNode(T rec, BTNode<T> leftChild, BTNode<T> rightChild, BTNode<T> parent) 
	{  
		this.rec = rec;
        this.leftChild = leftChild;  
        this.rightChild = rightChild;  
        this.parent = parent;   
	}
	
	public void setHeight()
	{
		if(this.getParent() == null)
		{
			height = 0;
		}
		else
		{
			height = this.getParent().getHeight() + 1;	
		}
	}
	
	public int getHeight() 
	{
		return height;
	}

	public BTNode<T> getLeft() 
	{
		return leftChild;
	}

	public void setLeft(BTNode<T> v) 
	{
		leftChild = new BTNode<T>();
		this.leftChild = v;

	}

	public BTNode<T> getParent() 
	{

		return parent;
	}

	public void setParent(BTNode<T> v) 
	{
		parent = new BTNode<T>();
		this.parent = v;
	}

	public T getRecord()
	{
		return rec;
	}

	public void setRecord(T rec) 
	{
		this.rec = rec;
	}


	public BTNode<T> getRight()
	{
		
		return rightChild;
	}


	public void setRight(BTNode<T> v)
	{
		rightChild = new BTNode<T>();
		this.rightChild = v;

	}


	public String toString()
	{
		return this.rec.toString();
	}

	
	public boolean hasLeft() 
	{
		if( leftChild == null)
		{
			return false;
		}
		return true;
	}
	
	public boolean hasRight()
	{
		if(rightChild == null)
		{
			return false;
		}
		return true;
	}
	
	public boolean hasParent() 
	{
		if(parent == null)
		{
			return false;
		}
		return true;
	}
}

	

/*********************************************************************
 * Homework 6:  Implement a binary search tree for doing a
 *              dictionary lookup.
 *
 * @author chongwen guo
 * 
**/
import java.util.TreeMap;
/*********************************************************************
 * Constructor.
 * read data from input <code>Scanner</code> file. 
 * 
 * @param the <code>Scanner</code> from which to read.
 * 
**/	

public class BST<T extends Comparable<T>> implements IBST<T> {
	
	
	private BTNode<T> root = null;
	TreeMap<T,BTNode<T>> Tmap;
	TreeMap<Integer,Integer> HeightHistory = new TreeMap<Integer,Integer>();
	int totalHeight;
	int maxHeight;   
	
	final int MAX_HEIGHT = 200;

	
/*********************************************************************
 * Constructor.
 * 
 * default constructor, initializing
**/		

	public BST()
	{
		maxHeight = 0;
		root = new BTNode<T>();
		Tmap = new TreeMap<T, BTNode<T>>();
	}//public BST()
	
/*********************************************************************
 * method to get average height
 * 
 * @return <double>aveHeight</double>
**/		
	public double getAverageHeight() 
	{
		Double AveHeight = (double)totalHeight / Tmap.size();
		return AveHeight;
	}//public double getAverageHeight() 

/*********************************************************************
 * method to get max height
 * 
 * @return <int>maxHeight</int>
**/		
	public int getMaxHeight()
	{
		return maxHeight;
	}//public int getMaxHeight()
	
/*********************************************************************
 * method to count nodes
 *  
 * @return <int>number of nodes</int>
**/	
	public int getNodeCount() 
	{
		return Tmap.size();
	}//public int getNodeCount() 
	
	
/*********************************************************************
 * method to get root
 *  
 * @return <BTNode>root</BTNode>
**/	
	public BTNode<T> getRoot()
	{
		return root;
	}//public BTNode<T> getRoot()
	
	
/*********************************************************************
 * method to check whether the tree map contains a testRecord
 *  
 * @return <boolean>true</boolean> if contains
 * 		   <boolean>false</boolean> if not contain
**/	
	public boolean contains(T testRecord)
	{
		boolean contain = false;
		if (Tmap.containsKey(testRecord))
		{
			contain = true;
		}
		return contain;
	}//public boolean contains(T testRecord)
/*********************************************************************
 * method to insert a record to a node
 *  
 * @return  <BTNode>newNode</BTNode>
**/	
	public BTNode<T> insert(T rec)
	{
		BTNode<T> newNode = new BTNode<T>();
		boolean Added = false;
		// if the rec already exists, skip it
		if (this.contains(rec)) 
		{
			return null;
		}
		// if the BST is empty add the rec to the root node
		if (this.isEmpty())
		{
			root.setRecord(rec);
			Tmap.put(rec, root);
			HeightHistory.put(0, 1);
			Added = true;
		}

		BTNode<T> node = new BTNode<T>();
		node = this.getRoot();
		
		while (Added == false) 
		{
			if (rec.compareTo(node.getRecord()) > 0) 
			{
				//go to the right child
				if (node.hasRight()) 
				{
					node = node.getRight();
				} 
				//set the newnode as a right child of current node
				else
				{
					newNode.setRecord(rec);
					node.setRight(newNode);
					newNode.setParent(node);
					newNode.setHeight();
					Tmap.put(rec, newNode);
					
					
					totalHeight += newNode.getHeight();
					if(HeightHistory.containsKey(newNode.getHeight()))
					{
						HeightHistory.put(newNode.getHeight(), HeightHistory.get(newNode.getHeight())+1);
					}
					else
					{
						HeightHistory.put(newNode.getHeight(), 1);
					}
					if (newNode.getHeight() > this.getMaxHeight()) 
					{
						maxHeight += 1;
						FileUtils.logFile.printf("new maxHeight  %d%n"
								,maxHeight);
					}
					Added = true;
				}
			} 
			else //smaller
			{
				//go to the left child
				if (node.hasLeft()) 
				{
					node = node.getLeft();
				}
				//set the newnode as a left child of current node
				else
				{
					newNode.setRecord(rec);
					node.setLeft(newNode);
					newNode.setParent(node);
					newNode.setHeight();
					Tmap.put(rec, newNode);
					totalHeight += newNode.getHeight();
					if(HeightHistory.containsKey(newNode.getHeight()))
					{
						HeightHistory.put(newNode.getHeight(), HeightHistory.get(newNode.getHeight())+1);
					}
					else
					{
						HeightHistory.put(newNode.getHeight(), 1);
					}
					if (newNode.getHeight() > this.getMaxHeight()) 
					{
						maxHeight += 1;
						FileUtils.logFile.printf("new maxHeight  %d%n"
								,maxHeight);
					}
					Added = true;
				}
			}
		}
		return newNode;
	}//public BTNode<T> insert(T rec)
	
/*********************************************************************
 * method to check if the BTS is empty or not
 *  
 * @return <boolean>true</boolean> the tree map empty
 * 		   <boolean>false</boolean> the tree map is not empty
**/		
	public boolean isEmpty()
	{
		boolean isEmpty = false;
		if (this.root.getRecord() == null) 
		{
			isEmpty = true;
		}
		return isEmpty;
	}//	public boolean isEmpty()
	
	
	public String toStringPreorder(BTNode<T> v)
	{

		return null;
	}

	
/*********************************************************************
 * method to get the String format of the BST in inorder 
 *  
 * @return <String>s</String>  String format of the BST in inorder 
 * 
**/			
	public String toStringInorder(BTNode<T> v)
	{

		String s = "";

		if (v.hasLeft()) 
		{
			s += toStringInorder(v.getLeft());
			s += String.format("%19s :  %-10d%n ", v.getRecord(),v.getHeight());
		} 
		else
		{
			s += String.format("%19s :  %-10d%n ", v.getRecord(),v.getHeight());
		}

		if (v.hasRight()) 
		{
			s += toStringInorder(v.getRight());
		}

		return s;
	}//public String toStringInorder(BTNode<T> v)


	public String toStringPostorder(BTNode<T> v)
	{

		return null;
	}
/*********************************************************************
 * method to write the height history
 *  
**/		
	public void writeHeightHisto()
	{
		for(int key : HeightHistory.keySet())
		{
			FileUtils.logFile.printf("BST:  heightHisto[%2d] =  %9d%n", key, HeightHistory.get(key) );
		}
	}//	public void writeHeightHisto()
		
}
/*********************************************************************
 * csce 146
 * homework02
 * @author chongwen guo
 * 
**/
public class MyListStructure implements IMyListStructure {
	
	
	  private DLL dll;
/*********************************************************************
 * Constructor.
 **/
	  public MyListStructure()
	  {
		  this.dll = new DLL();
	  } //public MyListStructure()
	
 /*********************************************************************
  * methods to add the basket into the list
  * @param that the basket is going to be added
  * @return true if successfully added
  **/	  
	  public boolean add(Basket basket)
	  {
		 return dll.add(basket);
	  } // public boolean add(Basket basket)

 /*********************************************************************
  *  methods to check if the list contains the basket
  *  @param that the basket from which to check if the list contains the basket
  *  @return true if contains, false if don't contain
  **/	
	  public boolean contains(Basket basket)
	  {
		  return dll.contains(basket);
	  }//public boolean contains(Basket basket)
 /*********************************************************************
  * methods to remove the basket from the list
  *  @param that the basket is going to be removed
  *  @return true if successfully removed
  **/
	  public boolean remove(Basket basket)
	  {
		  return dll.remove(basket);
	  }// public boolean remove(Basket basket)
/*********************************************************************
 * general toString method
 * @return a formatted 'toString' of the class
 **/
	 public String toString()
	  {
		  return dll.toString();
	  }// public String toString()
	 
}//public class MyListStructure implements IMyListStructure {

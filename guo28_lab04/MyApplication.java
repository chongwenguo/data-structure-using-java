import java.util.ArrayList;
/*********************************************************************
 * lab07
 * @author chongwen guo
**/

public class MyApplication<T> {

	ArrayList<T> list1 = new ArrayList<T>();
	ArrayList<T> list2 = new ArrayList<T>();
	
/*********************************************************************
 *  constructor
 *  
**/	
	public MyApplication(T t1, T t2) 
	{	
			list1.add(t1);
			list2.add(t2);
	}//public MyApplication(T t1, T t2) 

/*********************************************************************
 *  method to exchange items inside the list1 and list2
 * 
**/
	public void operation()
	{
		for(int i = 0; i < list1.size() ; i++)
		{
			T t1 = list1.get(i);
			T t2 = list2.get(i);
			list2.set(i,t1);
			list1.set(i,t2);
		}
	}//	public void operation()
/*********************************************************************
 * general toString method
 * 
**/	
	public String toString()
	{
		String s = "";
		for(int i = 0 ; i < list1.size(); i++)
		{
			s+= "Data 1: " + list1.get(i) + "\n";
		}
		for(int i = 0 ; i < list2.size(); i++)
		{
			s+= "Data 2: " + list2.get(i) + "\n";
		}
		return s;
	}	// public String toString()
}//public class MyApplication<T>

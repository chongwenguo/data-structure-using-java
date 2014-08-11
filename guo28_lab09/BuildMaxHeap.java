import java.util.ArrayList;

/*********************************************************************
 * BuildMaxHeap
 * CSCE146 
 * lab 09
 * 
 * @author chongwen guo
 *
**/

public class BuildMaxHeap {
	
	 ArrayList<Integer> list = new ArrayList<Integer>();
	 
	public ArrayList<Integer> buildMaxHeap(ArrayList<Integer> inputList) 
	{
		list = inputList;
		
		for(int i = 1; i < inputList.size(); ++i)
		{
			this.fixHeapUp(i);
		}	
		
		return list;
	}

	public boolean checkHeap(ArrayList<Integer> heapList)
	{
		boolean isHeap = true;
		
		for(int i = 1; i < heapList.size()/2 ; i++)
		{
			if(heapList.get(i) < heapList.get(2*i) 
					|| heapList.get(i) < heapList.get(2*i + 1))
			{
				isHeap = false;
			}
		}
		
		return isHeap;
	}

	public void fixHeapUp(int insertSub)
	{
		int parentSub;
		int insertNumber;
		
		insertNumber = list.get(insertSub);
		parentSub = insertSub/2;
		
		while(1< insertSub )
		{
			if(list.get(parentSub) < insertNumber)
			{
				//swap
				int temp1 = list.get(insertSub);
				int temp2 = list.get(parentSub);
				list.set(insertSub, temp2);
				list.set(parentSub, temp1);
				
				insertSub = parentSub;
				insertNumber = list.get(insertSub);
				parentSub = insertSub/2;
				
			}
			else
				break;
		}
	
	}
}


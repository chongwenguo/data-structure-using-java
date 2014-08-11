import java.util.ArrayList;
/*********************************************
 * Homework 7: Computing frequent itemsets using 'TreeMap'.
 * 
 * @author chongwen guo
 *
 */

public class Itemset implements IItemset {
	
	ArrayList<Basket> Baskets = new ArrayList<Basket>();
	ArrayList<Integer> items = new ArrayList<Integer>();
	int size;
	
	
	public void addBasket(Basket what) {
		
		Baskets.add(what);
	}


	public void addItem(int what) {
		
		items.add(what);

	}
	
	public void setSize(int size)
	{
		this.size = size;
	}


	public int basketListSize() {

		return Baskets.size();
	}


	public int compareTo(Itemset that) {

		 int returnValue = 0;

		    returnValue = 0;
		    if(this.items.size() < that.items.size())
		    {
		      returnValue = -1;
		    }
		    else if(this.items.size() > that.items.size())
		    {
		      returnValue = +1;
		    }
		    else
		    {
		      for(int i = 0; i < this.items.size(); ++i)
		      {
		        if(this.items.get(i) < that.items.get(i))
		        {
		          returnValue = -1;
		          break;
		        }
		        else if(this.items.get(i) > that.items.get(i))
		        {
		          returnValue = +1;
		          break;
		        }
		      }
		    }

		    return returnValue;
	}


	public Basket getBasket(int which) {

		return Baskets.get(which);
	}


	public int getItem(int which) {

		return items.get(which);
	}

	
	public ArrayList<Integer> getItemList() {

		return items;
	}

	
	public int getLargestItem() {
		
		int largest = 0;
		
		for(int i = 0; i < items.size(); i++)
		{
			if(items.get(i) > largest)
			{
				largest = items.get(i);
			}
		}
		
		return largest;
	}


	public int itemListSize() {

		return items.size();
	}
	
}

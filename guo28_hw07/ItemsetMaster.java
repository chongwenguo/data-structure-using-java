import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
/*********************************************
 * Homework 7: Computing frequent itemsets using 'TreeMap'.
 * 
 * @author chongwen guo
 *
 */


public class ItemsetMaster {
	
	int Itemsetcount = 0;
	int itemsetSize = 2;
	int minValue = 999;
	int maxValue = 0;
	
	ArrayList<Basket> basketList = null;
	TreeMap<String, Itemset> themap2 = null; 
	TreeMap<String, Itemset> themap3 = null;
	TreeMap<String, Itemset> themap4 = null;
	
	 int[][] itemset2Count;
	 int[][][] itemset3Count;
	 int[][][][] itemset4Count;
 /*********************************************
  * constructor
  * 
  * read all the basket from <Scanner> inFile</Scanner>
  * and then add them to <ArrayList> basketList </ArrayList>
  * also set the minValue and maxValue
  * 
  */	
	 public ItemsetMaster(Scanner inFile) 
	 {
		
		this.basketList = new ArrayList<Basket>();
		this.themap2 =  new TreeMap<String, Itemset>();
		this.themap3 =  new TreeMap<String, Itemset>();
		this.themap4 =  new TreeMap<String, Itemset>();

	    while(inFile.hasNext())
	    {
	      Basket basket = new Basket(inFile);
	      basketList.add(basket);
	      if(basket.minValue() < this.minValue)
	          this.minValue = basket.minValue();
	        if(basket.maxValue() > this.maxValue)
	          this.maxValue = basket.maxValue();
	    }
	}//public ItemsetMaster(Scanner inFile) 
	 
 /*********************************************
  * method to convert basketList into a formated string 
  * 
  * @return <String>s</String> the formated string
  * 
  */
	 
	public Object toStringBaskets() {
		
		String s = "";
		s += "Basket count: " + basketList.size() + "\n";
		for(int i = 0 ; i < basketList.size(); i++)
		{
			s += basketList.get(i).toString();
		}
		return s;
	}//public Object toStringBaskets() 

 /*********************************************
  * method to generate all itemsets
  * 
  */	
	public void naiveItemsets() {
		
		generateItemsets2();
		generateItemsets3();
		generateItemsets4();
		
	}//public void naiveItemsets() 
	
 /*********************************************
  * method to convert all the itemsets into a formated string 
  * 
  * @return <String>s</String> the formated string
  * 
  */	

	public Object toStringNaiveList() {
		
		String s = "";
		  s += "Itemset count: " + Itemsetcount + "\n";
		  
		  for(String key : themap2.keySet())
		  {
	    	
	    	 for(int i = 0; i < themap2.get(key).basketListSize(); i ++)
	    	 {
	    		 Itemset itemset = themap2.get(key);
	 
	    		 ArrayList<Basket> basketList = sort(itemset.Baskets);
	    		 s += "    0     0 " + key +" " + basketList.get(i).toString();
	    	 }
	      }
		 for(String key : themap3.keySet())
		 {
			 
		   for(int i = 0; i < themap3.get(key).basketListSize(); i ++)
		   {
			   Itemset itemset = themap3.get(key);
			   ArrayList<Basket> basketList = sort(itemset.Baskets);
			   s += "    0 " + key +" " + basketList.get(i).toString();
		     }

		  }
		 for(String key : themap4.keySet())
		 {
		    for(int i = 0; i < themap4.get(key).basketListSize(); i ++)
		    {
		    	Itemset itemset = themap4.get(key);
		    	ArrayList<Basket> basketList = sort(itemset.Baskets);
		    	s += key +" " + basketList.get(i).toString();
		    }
		 }
		 
		themap2.clear();
		themap3.clear();
		themap4.clear();
			  
		return s;
		
	}//public Object toStringNaiveList() 
	
 /*********************************************
  * method to generate all itemsets of size 2
  * 
  */
	public void generateItemsets2() {
		
		   this.itemset2Count = new int[this.maxValue+1][this.maxValue+1];
		    for(int i = 0; i <= this.maxValue; ++i)
		      for(int j = 0; j <= this.maxValue; ++j) 
		          this.itemset2Count[i][j] = 0;

		    //////////////////////////////////////////////////////////////////
		    // bump the counters
		    for(Basket basket: basketList)
		    {
		      for(int firstSub = 0; firstSub < basket.size()-1; ++firstSub)
		      {
		        for(int secondSub = firstSub+1; secondSub < basket.size(); ++secondSub)
		        {

		            int first = basket.getValue(firstSub);
		            int second = basket.getValue(secondSub);
		            ++this.itemset2Count[first][second];
		      	  Itemsetcount ++;
		         
		        } // for(int secondSub
		      } // for(int firstSub
		    } // for(Basket basket: basketList)

		    //////////////////////////////////////////////////////////////////
		    // produce and return the output string
		    String s = "";
		    for(int i = 0; i <= this.maxValue; ++i)
		      for(int j = 0; j <= this.maxValue; ++j)
		        {
		          if(0 < this.itemset2Count[i][j])
		          {
		        	  
		        	  Itemset itemset = new Itemset();
	
		        	  for(int k = 0; k < basketList.size(); k++)
		        	  {
		        		  Basket basket = basketList.get(k);
		        		  
		        		  //if a basket contains the itemset
		        		  //add it to the basketList of the itemset
		        		  for(int l = 0; l < basket.size(); l ++)
		        		  {
		        			  if(basket.getValue(l) == i)
		        			  {
		        				  for(int m = l; m < basket.size(); m ++)
		        				  {
		        					  if(basket.getValue(m) == j)
		        						  itemset.addBasket(basket);
		        				  }
		        			  }
		        		  } 
		        	  }
		        	  
		        	  itemset.addItem(i);
		        	  itemset.addItem(j);
		        	  
		        	  s = String.format("%5d %5d",i,j);
		            
		        	  itemset.setSize(this.itemset2Count[i][j]);
		        	  themap2.put(s, itemset);
		          }
		        }
	}//public void generateItemsets2() {

 /*********************************************
  * method to convert a itemsets into a formated string according to its size
  * 
  * @return <String>s</String> the formated string
  * 
  */		
	
	public Object toStringItemsets() {
		String s =  "";
		if(this.itemsetSize == 2)
		{	
		  s += "Itemset count: " + themap2.size()+ "\n";
		  
		  for(String key : themap2.keySet())
		  {
	    	s+= String.format(  "itemList count:     "+ itemsetSize + " ( " + key + ")\n"
	    			
	    	+ "basketList count:     " + themap2.get(key).basketListSize() + "\n");
	    	
	    	 for(int i = 0; i < themap2.get(key).basketListSize(); i ++)
	    	 {
	   
	    		 s +=" " + themap2.get(key).Baskets.get(i).toString();
	    	 }
	    	s += "\n\n";
	      }
		}
		else if(this.itemsetSize == 3)
		{
			  s += "Itemset count: " + themap3.size() + "\n";
			  for(String key : themap3.keySet())
			  {
		    	s+= String.format(  "itemList count:     "+ itemsetSize + " ( " + key + ")\n"
		    			
		    	+ "basketList count:     " + themap3.get(key).basketListSize() + "\n");
		    	
		    	 for(int i = 0; i < themap3.get(key).basketListSize(); i ++)
		    	 {
		    		 s +=" " + themap3.get(key).Baskets.get(i).toString();
		    	 }
		    	s += "\n\n";
		      }
		}
		else if(this.itemsetSize == 4)
		{
			  s += "Itemset count: " + themap4.size() + "\n";
			  for(String key : themap4.keySet())
			  {
		    	s+= String.format(  "itemList count:     "+ itemsetSize + " ( " + key + ")\n"
		    			
		    	+ "basketList count:     " + themap4.get(key).basketListSize() + "\n");
		    	
		    	 for(int i = 0; i < themap4.get(key).basketListSize(); i ++)
		    	 {
		    		 s +=" " + themap4.get(key).Baskets.get(i).toString();
		    	 }
		    	s += "\n\n";
		      }
		}
	    
		return s;
	}//public Object toStringItemsets() 

 /*********************************************
  * method to generate next 1 bigger size itemsets
  * 
  * 
  */	
	public void generateNextItemsets() {
		
		this.itemsetSize++;
		if(itemsetSize == 3)
		{
			generateItemsets3();
		}
		else if(itemsetSize == 4);
		{
			generateItemsets4();
		}
	}//	public void generateNextItemsets() {
	
	
/*********************************************
 * method to generate all itemsets of size 3
 * 
 */	
	public void generateItemsets3() {
		
		  //////////////////////////////////////////////////////////////////
	    // create and initialize the count array
	    this.itemset3Count = new int[this.maxValue+1][this.maxValue+1][this.maxValue+1];
	    for(int i = 0; i <= this.maxValue; ++i)
	      for(int j = 0; j <= this.maxValue; ++j)
	        for(int k = 0; k <= this.maxValue; ++k)
	          this.itemset3Count[i][j][k] = 0;

	    //////////////////////////////////////////////////////////////////
	    // bump the counters
	    for(Basket basket: basketList)
	    {
	      for(int firstSub = 0; firstSub < basket.size()-2; ++firstSub)
	      {
	        for(int secondSub = firstSub+1; secondSub < basket.size()-1; ++secondSub)
	        {
	          for(int thirdSub = secondSub+1; thirdSub < basket.size(); ++thirdSub)
	          {
	            int first = basket.getValue(firstSub);
	            int second = basket.getValue(secondSub);
	            int third = basket.getValue(thirdSub);
	            ++this.itemset3Count[first][second][third];
	            Itemsetcount ++;
	          } // for(int thirdSub
	        } // for(int secondSub
	      } // for(int firstSub
	    } // for(Basket basket: basketList)
	    

		    //////////////////////////////////////////////////////////////////
		    // produce and return the output string
		    String s = "";
		    for(int i = 0; i <= this.maxValue; ++i)
		      for(int j = 0; j <= this.maxValue; ++j)
		    	  for(int k = 0; k <=this.maxValue; k ++ )
		    	  {
		    		  if(0 < this.itemset3Count[i][j][k])
		    		  {

		    			  Itemset itemset = new Itemset();
		    			  for(int l = 0; l < basketList.size(); l++)
		    			  {
		    				  Basket basket = basketList.get(l);
		    				  
		    				//  if(basket.contains(i, j, k)
		    				//  {
		    				//	  basketList1.add(basket);
		    				//  }
		    				  
		    				  for(int l1 = 0; l1 < basket.size(); l1 ++)
		    				  {
		    					  
		    					  if(basket.getValue(l1) == i)
		    					  {
		    						  for(int l2 = l1; l2 < basket.size(); l2 ++)
		    						  {
		    							  if(basket.getValue(l2) == j)
		    								  for(int l3 = l2; l3 <basket.size(); l3 ++ )
		    									  if(basket.getValue(l3) == k)
		    										  itemset.addBasket(basket);
		    						  }
		    					  }
		    				  } 
		    			  }
		    	
		        	s = String.format("%5d %5d %5d",i,j,k);
		        	
		        	itemset.addItem(i);
		        	itemset.addItem(j);
		        	itemset.addItem(k);

		            itemset.setSize(this.itemset3Count[i][j][k]);
		            themap3.put(s, itemset);
		           
		          }
		
		        }

		 
	}//public void generateItemsets3() 
	
/********************************************
 *  method to generate all itemsets of size 4
 * 
 */		
	public void generateItemsets4() {
		
		  //////////////////////////////////////////////////////////////////
	    // create and initialize the count array
	    this.itemset4Count = new int[this.maxValue+1][this.maxValue+1][this.maxValue+1][this.maxValue+1];
	    for(int i = 0; i <= this.maxValue; ++i)
	      for(int j = 0; j <= this.maxValue; ++j)
	        for(int k = 0; k <= this.maxValue; ++k)
	        	for(int l = 0; l <= this.maxValue; ++l)
	        		this.itemset4Count[i][j][k][l] = 0;

	    //////////////////////////////////////////////////////////////////
	    // bump the counters
	    for(Basket basket: basketList)
	    {
	      for(int firstSub = 0; firstSub < basket.size()-2; ++firstSub)
	      {
	        for(int secondSub = firstSub+1; secondSub < basket.size()-1; ++secondSub)
	        {
	          for(int thirdSub = secondSub+1; thirdSub < basket.size(); ++thirdSub)
	          {
	        	  for(int fourthSub = thirdSub+1; fourthSub < basket.size(); ++fourthSub)
	        	  {
	        		  int first = basket.getValue(firstSub);
	        		  int second = basket.getValue(secondSub);
	        		  int third = basket.getValue(thirdSub);
	        		  int fourth = basket.getValue(fourthSub);
	        		  ++this.itemset4Count[first][second][third][fourth];
	        		  Itemsetcount ++;
	        	  }//for(int fourthSub
	          } // for(int thirdSub
	        } // for(int secondSub
	      } // for(int firstSub
	    } // for(Basket basket: basketList)
	    

		    //////////////////////////////////////////////////////////////////
		    // produce and return the output string
		    String s = "";
		    for(int i = 0; i <= this.maxValue; ++i)
		      for(int j = 0; j <= this.maxValue; ++j)
		    	  for(int k = 0; k <=this.maxValue; k ++ )
		    		  for(int l = 0; l <=this.maxValue; l ++ )
		    		  {
		    			  if(0 < this.itemset4Count[i][j][k][l])
		    			  {
		    				 // ArrayList<Basket> basketList1 = new ArrayList<Basket>();
		    				  Itemset itemset = new Itemset();
		    				  for(int m = 0; m < basketList.size(); m++)
		    				  {
		    					  Basket basket = basketList.get(m);
		    					//  if(basket.contains(i, j, k, l)
		    					//  {
		    					//	  basketList1.add(basket);
		    					//  }
		    					 
		    					  for(int m1 = 0; m1 < basket.size(); m1 ++)
		    					  {
		        			
		    						  if(basket.getValue(m1) == i)
		    						  {
		    							  for(int m2 = m1; m2 < basket.size(); m2 ++)
		    							  {
		    								  if(basket.getValue(m2) == j)
		    									  for(int m3 = m2; m3 <basket.size(); m3 ++ )
		    									  {
		    										  if(basket.getValue(m3) == k)
		    											  for(int m4 = m3; m4 <basket.size(); m4 ++ )
		    												  if(basket.getValue(m4) == l)
		    													  itemset.addBasket(basket);
		    									  }
		    							  }
		    						  }
		    					  } 
		        		  
		    				  }
		        	  
		    				 
		        	s = String.format("%5d %5d %5d %5d",i,j,k,l);
		        	
		        	itemset.addItem(i);
		        	itemset.addItem(j);
		        	itemset.addItem(k);
		        	itemset.addItem(l);
		        	
		            itemset.setSize(this.itemset4Count[i][j][k][l]);
		            themap4.put(s, itemset);
		           
		          }
		        }
		    
	}	//public void generateItemsets4() 
	
/*************************************************
 * methord to sort baskets in a basketList
 * 
 * @param <ArrayList>basketlist</ArrayList> from which to sort
 * 
 * @return sorted <ArrayList>basketlist</ArrayList>
 */
	public ArrayList<Basket> sort(ArrayList<Basket> basketlist)
	{
		for(int i = basketlist.size(); i > 1; --i)
		{
			for(int j = 0; j < basketlist.size()-1; j++)
			{
				Basket basket1 = basketlist.get(j);
				Basket basket2 = basketlist.get(j+1);
				if( 0 < basket1.compareTo(basket2))
				{
					basketlist.set(j, basket2);
					basketlist.set(j+1, basket1);
				}
			}
		}
		return basketlist;
	}//	public ArrayList<Basket> sort(ArrayList<Basket> basketlist)
}//public class ItemsetMaster 

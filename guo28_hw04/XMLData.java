import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**********************
 * XMLData Class
 * CSCE146 Homework04
 * @author chongwen guo
 */
public class XMLData implements IXMLData {

	Stack<String> stack;
	ArrayList<String> blist;
	HashMap<String,String> biography;
	
	
/*******************************************************************
 * Constructor
 * 
 */
	public XMLData() 
	{
		stack = new Stack<String>();
		blist = new ArrayList<String>();
		biography = new HashMap<String, String>();
		
		biography.put("surName","dummy");
		biography.put("foreName","dummy");
		biography.put("addName","dummy");
		biography.put("born","dummy");
		biography.put("married","dummy");
		biography.put("education","dummy");
		biography.put("profexp","dummy");
		biography.put("died","dummy");
		biography.put("note","dummy");
		biography.put("dissertation","dummy");
		biography.put("publications","dummy");
		biography.put("sources","dummy");
		biography.put("author","dummy");
		biography.put("p","dummy");
		
		String s = this.getFormat();
		blist.add(s);
		
	}//public XMLData() 

/*********************************************************************
 * method to get token according to its type 
 *
 * if it is a open token, getting rid of its '<' at the first index
 * and '>' at the last index. if it is a close token, getting rid of 
 * "</" at its first two character and '>' at the last index
 *
 * @param the <code>String</code> from which to read.
 *
 * @return <code>String</code> as the actual token
 * 
*/
	private String getToken(String s)
	{
		if(this.isOpenTag(s))
		{
			s = s.substring(1, s.length() - 1);
		}
			else if(this.isCloseTag(s))
		{
			s = s.substring(2, s.length() - 1);
		}
		return s;
	}// public String getToken(String s)
	
	
/*********************************************************************
 * Method to determine whether a token is a open tag or not
 * 
 * we assume that a open tag token is the one whose first
 * character is '<' and last character is '>' and the second 
 * character is not '/'.
 * 
 * @param the <code>Scanner</code> from which to read.
 *
 * @return <code>true</code> if the token is a open tag
 * @return <code>false</code> if the token is not a open tag
**/	
		public boolean isOpenTag(String s)
		{
			boolean isOpenTag = false;
			if(s.length() >= 2)
			{
				if(s.charAt(0) == '<' 
					&& s.charAt(s.length()-1 ) == '>' 
					&& s.charAt(1) != '/')
				{
				isOpenTag = true;			
				}
			}
			return isOpenTag;
		} // public boolean isOpenTag(String s)
			
/*********************************************************************
 * Method to determine whether a token is a close tag or not
 * 
 * we assume that a close tag token is the one whose first
 * character is '<' and last character is '>' and the second 
 * character is '/'.
 *
 * @param the <code>Scanner</code> from which to read.
 *
 * @return <code>true</code> if the token is a close tag
 * @return <code>false</code> if the token is not a close tag
*/
		public boolean isCloseTag(String s)
		{
			boolean isCloseTag = false;
			 if(s.length() >= 2)
			    {
				 if(s.charAt(0) == '<' 
						 && s.charAt(s.length()-1 ) == '>' 
						 && s.charAt(1) == '/')
				 {
					 isCloseTag = true;			
				 }
			   }
			return isCloseTag;
		} //public boolean isCloseTag(String s)	
		

/*********************************************************************
 * Method to read the file from <code>Scanner</code> inFile. parseTokens, 
 * extract each information between each person tags adding to the bList 
 * in formated form.
 * 
 * @param inFile the <code>Scanner</code> from which to read.
**/
		public void parseTokens(Scanner inFile)
		{
			String personInfo = "";
			String token1 = "";
			String token2 = "";
		
			
			while(inFile.hasNext())
			{
				token1 = inFile.nextLine().trim();
				if(this.isCloseTag(token1)) //it is close tag
				{		    	  
					token2 = this.getToken(token1);
	    	  
					while(!stack.peek().equals(token2))
					{
						personInfo += stack.peek();
						stack.pop();
					}
					stack.pop();
					biography.put(token2, personInfo);
					personInfo = "";
		    	  	  	
		    	  	if(token2.equals("person"))
		    	  	{
		    	  		personInfo = this.getFormat();
		    	  		blist.add(personInfo);
		    	  		biography.clear();
		    	  	}
		      } //  if(this.isCloseTag(s))  
	      
	     
				else if(this.isOpenTag(token1)) //it is open tag
				{
	    	
					token2 = this.getToken(token1);        
					stack.push(token2);      
	       
				} // if(this.isOpenTag(s))
      	  
				else //it is data
				{
					token2 = token1;
					stack.push(token2);
				}
	   
	    } // while(inFile.hasNext())
	    
	    
	  } // public void parseTokens(Scanner inFile)

	  
/*********************************************************************
 * method to determine whether a token is a tag 
 *
 *	if the token is not a open tag nor close tag, it is not a tag
 *
 * @param the <code>String</code> from which to read.
 *
 * @return <code>Boolean</code> to tell whether a token is a tag 
 * 
 */
			public boolean isTag(String s)
			{
				boolean isTag = true;
				if(isOpenTag(s) == false && isCloseTag(s) == false)
				{
					isTag = false;
				}

				return isTag;
			}//public boolean isTag(String s)
			
/***************************************************
 * the method to format the information 
 * 
 * @return <code>String</code> a formatted string
 */
		public String getFormat()
		{
		
			String s = "";	
			s += String.format("%1s%21s%21s \n %8s\n %8s \n %8s  %7s \n %8s \n %8s  %7s \n %8s \n %8s \n",
														biography.get("surName"),
														biography.get("foreName"),
														biography.get("addName"),
														biography.get("born"),
														biography.get("married"),
														biography.get("died"),
														biography.get("education"),
												 		biography.get("dissertation"),
												 		biography.get("profexp"),
												 		biography.get("publications"),
												 		biography.get("sources"),
												 		biography.get("author")); 
			 		return s;
		}//public String getFormat()
		
/**********************************
 * general toString method 
 * 
 */
	public String toString(){
		
		String s="";
		for(int i= 0; i < blist.size(); i++)
		{
			s += blist.get(i) + "\n";
		}
		
		return s;
	}// public String toString()

	
	
	public String getToken() {
		return null;
	}
	
	public boolean isTag() {
		return false;
	}
	

}// class XMLData()

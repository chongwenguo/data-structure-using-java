/*********************************************************************
 * Record class
 *
 * @author chongwen guo
 * 
**/

import java.util.Scanner;


public class Record implements IRecord {

	String s;
	
	
	public String getElement() 
	{
		return s.toLowerCase();
	}

	public void setElement(String what)
	{
		this.s = what;
	}


	public int compareTo(Record that)
	{
		return this.getElement().compareTo(that.getElement());
	}


	public boolean isAlpha() {
		
		for(int i = 0; i< s.length(); i++)
		{
			String cha = s.substring(i, i+1);
			int code = cha.hashCode();	
			
			if(code < 97 || code >122)
			{
				return false;
			}
		}
		return true;
		
	}

	
	public Record readRecord(Scanner inFile) {
		String s = inFile.next();
		s = s.toLowerCase().trim();
		this.setElement(s);
		return this;
	}
	 
	public String toString(){
		return s;
	}

}


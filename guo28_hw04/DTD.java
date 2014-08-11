import java.util.Scanner;

/*********************************************************************
 * DTD class
 * CSCE146 Homework04
 * @author chongwen guo
 * 
 * 
**/	
public class DTD implements IDTD {

	String dtd = "";
	
	
	public DTD(Scanner infile)
	{
		readFile(infile);
	}
/*********************************************************************
 * Method to read the token from an input
 * <code>Scanner</code> file. 
 * 
 * we read the infile then according to types of token print  
 * them out in proper format. 
 * 
 * 
 * @param the <code>Scanner</code> from which to read.
 *
**/	
	public void readFile(Scanner infile) 
	{
		String token = null;
	
		while(infile.hasNext())
		{
			token = infile.nextLine().trim();
		    dtd += " " + this.getToken(token) + "\n";
		}
	} //public void parseTokens(Scanner infile)
	
	public String toString()
	{
		return dtd;
	}
	
	
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
		if(s.charAt(0) == '<' 
				&& s.charAt(s.length()-1 ) == '>' 
				&& s.charAt(1) != '/')
		{
			isOpenTag = true;			
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
		if(s.charAt(0) == '<' 
				&& s.charAt(s.length()-1 ) == '>' 
				&& s.charAt(1) == '/')
		{
			isCloseTag = true;			
			}
		return isCloseTag;
	} //public boolean isCloseTag(String s)	
	
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
		
}	//public class DTD implements IDTD 
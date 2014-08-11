import java.util.ArrayList;
import java.util.Scanner;
/**********************************************
 * 
 * @author chongwen guo
 *
 */

public class TreeClass {

	ArrayList<String> a;

	public void buildTree(Scanner inFile) {
		
		a = new ArrayList<String>();
		
		a.add("DUMMY");
		while(inFile.hasNext())
		{
			String i = inFile.next();
			a.add(i);
		}
		
	}

	
	
	public String toStringPreorderTraversal(String myOutput, int i) {
		
	
		if(i < a.size()/2)
		{
			myOutput += a.get(i) + " " + toStringPreorderTraversal( myOutput, 2*i) + " " + toStringPreorderTraversal( myOutput, 2*i+1); 
		}
		else
			myOutput += a.get(i);
		
		return myOutput;
	}

	public String toStringPostorderTraversal(String myOutput, int i) {


		if(i < a.size()/2)
		{
			
			myOutput += toStringPostorderTraversal( myOutput, 2*i) + " " + toStringPostorderTraversal( myOutput, 2*i +1) +  " " + a.get(i);

		}
		else
			myOutput += a.get(i);
		
		return myOutput;
	}

	public String toStringInorderTraversal(String myOutput, int i) {


		if(i < a.size()/2)
		{
			
			myOutput += toStringInorderTraversal( myOutput, 2*i) + " "  + a.get(i) + " " +  toStringInorderTraversal( myOutput, 2*i +1);

		}
		else
			myOutput += a.get(i);
		
		return myOutput;
	}
	
	public String toString()
	{
		String s = "";
		for(int i = 0; i < a.size(); i ++)
		{
			s += a.get(i) + " ";
		}
		return s;
	}

}

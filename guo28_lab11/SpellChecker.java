import java.util.HashSet;
import java.util.Scanner;
/*********************************************************************
 * Csce146 
 * Lab 11: Spell checker.
 * 
 * @author chongwen guo
 *
**/

public class SpellChecker {
	

	HashSet<String> set = new HashSet<String>();
	
/*********************************************************************
 * Method to input a dictionary to a HashSet
 * 
 * @para <code>Scanner</code> inFile from which to read 
 *
**/		
	public void buildDictionary(Scanner inFile)
	{
		while(inFile.hasNext())
		{
			String s = inFile.nextLine();
			set.add(s);
		}
	}//public void buildDictionary(Scanner inFile)

/*********************************************************************
 * Method to check Spelling of the ztest text
 * 
 * @para <code>Scanner</code> inFile from which to read 
 *
**/			
	public void checkSpelling(Scanner inFile) 
	{
	    FileUtils.SetLogFile("zlog");
		
		while(inFile.hasNext())
		{
			String s = inFile.next();
			s = s.replace(':', ' ');
			s = s.replace(',', ' ');
			s = s.replace('.', ' ');
			s = s.toLowerCase().trim();

			if(set.contains(s))
			{
				FileUtils.logFile.println("'" + s +"' " + "is in the dictionary");
			}
			else
			{
				FileUtils.logFile.println("'" + s +"' " + "is NOT in the dictionary");
			}
			
		}
	}//	public void checkSpelling(Scanner inFile) 

}//public class SpellChecker


import java.util.Scanner;

/********************************************************
 * ParseTheData Class, to read and parse XML and to separate tags from real data.
 * 
 * CSCE146 Homework04
 * @author chongwen guo
 *
 */

public class ParseTheData {
	
		XMLData data;
		
/***************************************************
 * Constructor
 * 
 *  parsing the input file by calling the parseTokens methond in XMLData class
 * 
 * @param <code>Scanner</code> inFile from which to read
 */
	public ParseTheData(Scanner inFile) {
		
		data = new XMLData();
		data.parseTokens(inFile);
	}//	public ParseTheData(Scanner inFile) 
	
/**********************************
 * giving a format of this class data for printing out by calling the toString method in XMLData
 * 
 * @return String
 */
	public String toString(){
		
		return data.toString();
	}//	public String toString()

}//public class ParseTheData 

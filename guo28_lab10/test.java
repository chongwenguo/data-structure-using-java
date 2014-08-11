import java.util.ArrayList;
import java.util.Scanner;
import junit.framework.*;


/*********************************************************************
 * test.
 * CSCE146 lab08
 * 
 * @author chongwen guo
 * 
 */



public class test extends TestCase
{
	  BuildMaxHeap buildMaxHeap = null; 
	  ArrayList<Integer> inputList = null;
	  
	  Scanner inFile = FileUtils.ScannerOpen("zin");
	  
	  public void testConstructor()
	  
	  {
		  buildMaxHeap = new BuildMaxHeap();

		  System.out.println("Test the constructor");
		  assertNotNull(buildMaxHeap);
		
	  }
	  public void testCheckHeap()
	  {
		  	System.out.println("Test the CheckHeap");
		  	
		  	buildMaxHeap = new BuildMaxHeap();
		    inputList = new ArrayList<Integer>();

		    buildMaxHeap.buildMaxHeap(inputList);
		    
		    assertTrue(buildMaxHeap.checkHeap(inputList));
	  }
		
	
	
}

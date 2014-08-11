import java.util.Scanner;
import junit.framework.*;


/*********************************************************************
 * test.
 * CSCE146 lab08
 * 
 * @author chongwen guo
 * 
 */



public class Test extends TestCase
{
    MyApplication<Basket> myAppBasket = null;
    MyApplication<Integer> myAppInteger = null;
    
	  Scanner inFile = FileUtils.ScannerOpen("zin");
	  Basket basket1 = new Basket(inFile);
	  Basket basket2 = new Basket(inFile);
	  
	  Integer integer1 = inFile.nextInt();
	  Integer integer2 = inFile.nextInt();
	  
	  
	  private void setUp(Basket basket1, Basket basket2)
	  {

		  myAppBasket = new MyApplication<Basket>(basket1, basket2);
	  }
	  
	  private void setUp(int one, int two)
	  {
		 
		  myAppInteger = new MyApplication<Integer>(one, two);
	  }

	  protected void tearDown()
	  {
		  myAppBasket = null;
		  myAppInteger = null;
	  }
	  
	  public void testConstructor()
	  {
		  System.out.println("Test the constructor");
		  setUp(basket1,basket2);
		  assertEquals(basket1, myAppBasket.getValue1());
		  assertEquals(basket2, myAppBasket.getValue2());

		  
		  
		  myAppInteger = new MyApplication<Integer>(integer1, integer2);
		  setUp(integer1,integer2);
		  assertEquals(integer1, myAppInteger.getValue1());
		  assertEquals(integer2, myAppInteger.getValue2());
		
	  }
	  public void testOperation()
	  {
		  System.out.println("Test operation");

		  setUp(basket1,basket2);
		  myAppBasket.operation();
		  assertEquals(basket1, myAppBasket.getValue2());
		  assertEquals(basket2, myAppBasket.getValue1());
		  tearDown();

		  
		  setUp(integer1,integer2);
		  myAppInteger.operation();
		  assertEquals(integer1, myAppInteger.getValue2());
		  assertEquals(integer2, myAppInteger.getValue1());
		  tearDown();
		  
	  }
		
	
	
}

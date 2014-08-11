import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Counter.
 *
 * This class counts from 1 to 2^n in binary with an array and has
 * a Gray code method for converting from a binary array to Gray code.
 *
 * THE ONLY THING TO ESPECIALLY NOTICE about this code is that the
 * array has the bits going backward, but they are turned around into
 * standard notation by the 'toString'. That is, the subscript zero
 * location is the rightmost bit of the number, not the leftmost. 
 * This makes subscripting very much easier, and the user of this
 * code would never have to know that's how it's done.
 * 
 * 
 * Used with permission and modified by chongwen guo student.
 *
**/
public class Counter
{
  static private ArrayList<Integer> bits;

/*********************************************************************
 * Constructor.
**/
  public Counter(int length)
  {
    bits = new ArrayList<Integer>();
    for(int i = 0; i < length; ++i) bits.add(0); 
  }

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to return the grayCode value of the counter.
 *
 * @return the 'toString' equivalent of the Gray code.
**/
  public String grayCode()
  {
	  String s = "";
	  s += " " + bits.get(bits.size() - 1);
	  for(int i = bits.size() -1; i > 0 ; i--)
	  {
		  
		  if(bits.get(i) == bits.get(i-1))
		  {
			  //bits.set(i, 0);
			  s += " 0";
		  }
		  else
		  {
			  //bits.set(i, 1);
			  s += " 1";
		  }
	  }
	  
	  return s;
	  
  } // public void grayCode()

/*********************************************************************
 * Method to increment the counter.
 *
 * All this does is schoolchild addition with ripple carries.
 * When we run off the top edge, we reset to zero.
**/
  public void increment()
  {
    int carry;
    int digit;
    int sum;
    int length = bits.size();

    carry = 1;
    digit = 0;
    while(1 == carry)
    {
      sum = carry + bits.get(digit);
      bits.set(digit, sum);
      carry = 0;
      if(2 == sum)
      {
        carry = 1;
        sum = 0;
        bits.set(digit, sum);
        ++digit;
        if(digit >= length)
        {
          for(int i = 0; i < length; ++i) bits.set(i, 0); 
          break;
        }
      }
    }
    
  } // public void increment()

/*********************************************************************
 * Usual 'toString' method.
 *
 * As mentioned above, this reverses the order to print in standard
 * notation.
 *
 * @return a formatted 'toString' for the class
**/
  public String toString()
  {
    String s = "";

    for(Integer bit: bits)
    {
      s = String.format("%2d", bit) + s;
    }

    return s;
  } // public String toString()

} // public class Counter

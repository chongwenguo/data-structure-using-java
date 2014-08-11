import java.util.Scanner;
public interface IMyListStructure
{

/*********************************************************************
 * Static method to read baskets from an input file.  
 *
 * @param inFile the Scanner from which to read.
**/
  public void readFile(Scanner inFile);

/*********************************************************************
 * Method to sort the list.
**/
  public void sortTheList();

/*********************************************************************
 * Method to uniquify the list.
**/
  public void uniqTheList();

/*********************************************************************
 * Usual 'toString' method.
 * This formats basket into fixed-width fields.
**/
  public String toString();

} // public class MyListStructure

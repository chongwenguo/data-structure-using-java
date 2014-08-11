import java.util.Scanner;
/*********************************************************************
 * Driver for HW 02 on doubly linked lists.
 * The purpose of this code file is to drive a doubly-linked list
 * class and verify that the code of the DLL works as it should.
 * The "application" for testing is a list of market baskets.
 * To perform the test, we do the following:
 * 1. open an input file and a log file (with file names hard-coded);
 * 2. dump the empty list of baskets to show that we can dump an empty DLL;
 * 3. run a loop on the input file, reading in records and
 *    adding the data as nodes in the DLL, testing a record to see
 *    if it's in the list, or deleting it from the list.
 *
 * Note that the input data resembles data that might be submitted
 * to a database system. This documentation indicates that the driver
 * program knows that underneath the list is a DLL, but the
 * code is ignorant of this.  The code in this file knows only about
 * adding, containing, and removing records.
 *
 * Used with permission by chongwen guo student.
 * 
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-07-06
**/
public class Driver
{
/*********************************************************************
**/
  public static final String ADD = "add";
  public static final String CONTAINS = "contains";
  public static final String REMOVE = "remove";

/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    String control = "";
    Scanner inFile = null;
    Basket record = null;
    MyListStructure myList = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.SetLogFile("zlog");

    FileUtils.logFile.printf("beginning%n");

    //****************************************************************
    // dump the empty structure to show we can handle an
    // empty structure
    myList = new MyListStructure();
    FileUtils.logFile.printf("the empty list is%n%s%n",
                             myList.toString());
    FileUtils.logFile.flush();

    //****************************************************************
    // run the loop on the input data
    while(inFile.hasNext())
    {
      control = inFile.next();
      record = new Basket(inFile);
 
      //**************************************************************
      // if we have an 'add' we add the record and verify
      // that the add changed the collection
      if(0 == control.compareTo(ADD))
      {

        FileUtils.logFile.printf("ADD record '%s'%n",
                                 record.toString());
        if(myList.add(record))
        {
          FileUtils.logFile.printf("yes, added record '%s'%n",
                                   record.toString());
        }
        else
        {
          FileUtils.logFile.printf("no, did not add '%s'%n",
                                   record.toString());
        }
      } // if(0 == control.compareTo(ADD))
      //
      // if we have a 'contains' we test and respond
      //
      else if(0 == control.compareTo(CONTAINS))
      {
        FileUtils.logFile.printf("CONTAINS? '%s'%n",
                                 record.toString());
        FileUtils.logFile.flush();
        if(myList.contains(record))
        {
          FileUtils.logFile.printf("yes, list has '%s'%n",
                                   record.toString());
        }
        else
        {
          FileUtils.logFile.printf("no, list does not contain '%s'%n",
                                   record.toString());
        }
      } // else if(0 == control.compareTo(CONTAINS))
      //
      // if we have a 'remove', then we remove if possible and inform
      // the user of the result
      //
      else if(0 == control.compareTo(REMOVE))
      {
        FileUtils.logFile.printf("REMOVE '%s'%n",
                                 record.toString());
        if(myList.remove(record))
        {
          FileUtils.logFile.printf("successfully removed '%s'%n",
                                   record.toString());
        }
        else
        {
          FileUtils.logFile.printf("removal failed of '%s'%n",
                                   record.toString());
        }
      } // else if(0 == control.compareTo(REMOVE))
      //
      // if the command is invalid, we ignore and continue
      //
      else
      {
        FileUtils.logFile.printf("ERROR invalid control '%s', ignore%n",
                                 control);
        FileUtils.logFile.flush();
      } // else

      // dump the updated list
      FileUtils.logFile.printf("the list is now%n%s%n",
                               myList.toString());
      FileUtils.logFile.flush();
    } // while(inFile.hasNext())

    FileUtils.logFile.printf("ending%n");
    FileUtils.logFile.flush();
    FileUtils.CloseLogFile();

  } // public static void main (String[] args)
} // public class Driver

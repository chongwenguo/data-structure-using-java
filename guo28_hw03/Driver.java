import java.util.Scanner;
/*********************************************************************
 * Driver for HW 03 on doubly linked lists.
 * The purpose of this code file is to convert the Homework 02
 * DLL code into code that uses generics in the data payload.
 * The "application" for testing is a list of market baskets.
 * However, at this point we convert the 'Basket' code to deal
 * with generics instead of with integers.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * 
 *  Used with permission by chongwen guo student.
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
    MyListStructure<Basket> myList = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.SetLogFile("zlog");

    FileUtils.logFile.printf("beginning%n");

    //****************************************************************
    // dump the empty structure to show we can handle an
    // empty structure
    myList = new MyListStructure<Basket>();
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

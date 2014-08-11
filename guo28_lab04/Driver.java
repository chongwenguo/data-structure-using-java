import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 04.
 * This assignment is to modify Homework 01 so as to count the
 * number of baskets of each type rather than to remove the duplicates. 
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * Used with permission by chongwen guo student.
 * 
 * @author Duncan A. Buell
 * @version 1.00 2012-07-06
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    MyListStructure myList = null;
    Scanner inFile = null;
    PrintWriter outFile = null;

    System.out.printf("begin execution%n");

    //////////////////////////////////////////////////////////////////
    // set up the files for input and output
    inFile = FileUtils.ScannerOpen("zin");
    outFile = FileUtils.PrintWriterOpen("zout");

    //////////////////////////////////////////////////////////////////
    // create the list structure and input the data
    myList = new MyListStructure(inFile);
    FileUtils.CloseFile(inFile);

    //////////////////////////////////////////////////////////////////
    // dump the list as read in
    outFile.printf("The original list is\n");
    outFile.printf("%s\n", myList);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // sort the list, then print the sorted version
    outFile.printf("The sorted list is\n");
    myList.sortTheList();
    outFile.printf("%s\n", myList);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // finally, uniquify minus c the list and then print that version
    outFile.printf("The sorted list after uniquifying minus c is\n");
    outFile.printf("%s\n", myList.uniqTheListMinusC());
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // close up and go home
    FileUtils.CloseFile(outFile);

    System.out.printf("end execution%n");
  }

} // public class Driver


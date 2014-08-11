import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab Assignment 05.
 * This assignment is to read baskets into a list and to create
 * a list of the frequent itemsets of size three.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
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
    // count the frequent itemsets of size three
    outFile.printf("The list of frequent itemsets of size three is\n");
    outFile.printf("%s\n", myList.itemsets3());
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // close up and go home
    FileUtils.CloseFile(outFile);

    System.out.printf("end execution%n");
  }

} // public class Driver


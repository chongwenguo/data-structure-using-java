import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 08.
 * This assignment is to use generics to implement an operation
 * whose functionality is different depending on the underlying
 * data type passed as the generic.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * Used with permission by chongwen guo student.
 * @author Duncan A. Buell
 * @version 1.00 2012-07-11
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    MyApplication<Basket> myAppBasket = null;
    MyApplication<Integer> myAppInteger = null;
    Scanner inFile = null;
    PrintWriter outFile = null;

    System.out.printf("begin execution%n");

    //////////////////////////////////////////////////////////////////
    // set up the files for input and output
    inFile = FileUtils.ScannerOpen("zin");
    outFile = FileUtils.PrintWriterOpen("zout");

    //////////////////////////////////////////////////////////////////
    // FIRST WE DO THE BASKET VERSION
    //////////////////////////////////////////////////////////////////
    // create the list structure and input the data
    Basket basket1 = new Basket(inFile);
    Basket basket2 = new Basket(inFile);
    myAppBasket = new MyApplication<Basket>(basket1, basket2);

    //////////////////////////////////////////////////////////////////
    // dump the data as read in
    outFile.printf("The original Basket data is\n");
    outFile.printf("%s\n", myAppBasket);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // do the operation
    outFile.printf("After executing the operation, the Basket data is\n");
    myAppBasket.operation();
    outFile.printf("%s\n", myAppBasket);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // THEN WE DO THE INTEGER VERSION
    //////////////////////////////////////////////////////////////////
    // create the list structure and input the data
    Integer integer1 = inFile.nextInt();
    Integer integer2 = inFile.nextInt();
    myAppInteger = new MyApplication<Integer>(integer1, integer2);
    FileUtils.CloseFile(inFile);

    //////////////////////////////////////////////////////////////////
    // dump the data as read in
    outFile.printf("The original Integer data is\n");
    outFile.printf("%s\n", myAppInteger);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // do the operation
    outFile.printf("After executing the operation, the Integer data is\n");
    myAppInteger.operation();
    outFile.printf("%s\n", myAppInteger);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // close up and go home
    FileUtils.CloseFile(outFile);

    System.out.printf("end execution%n");
  }

} // public class Driver


import java.util.Scanner;
/*********************************************************************
 * Lab 02: Parse text for XML tokens.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
  *
  * Used with permission by chongwen guo student.
  *
 * @author Duncan A. Buell
 * @version 1.00 2012-07-04
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
	Scanner inFile = null;
    ParseTokens text = null;

    inFile = FileUtils.ScannerOpen("zin");
    System.out.printf("begin execution%n");
    

    text = new ParseTokens();
    text.parseTokens(inFile);
    
    

    System.out.printf("end execution%n");
  }
} // public class Driver


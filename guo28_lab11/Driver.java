import java.util.Scanner;
/*********************************************************************
 * Lab 11: Spell checker.
 * This code is for building a HashSet based spell checker.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * 
 * Used with permission of author by chongwen guo student.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-07-08
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    Scanner inFile = null;
    SpellChecker myChecker = null;

    FileUtils.SetLogFile("zlog");

    System.out.printf("begin execution%n");

    myChecker = new SpellChecker();
    inFile = FileUtils.ScannerOpen("dictionary.txt");
    myChecker.buildDictionary(inFile);
    FileUtils.CloseFile(inFile);

    inFile = FileUtils.ScannerOpen("ztest");
    myChecker.checkSpelling(inFile);
    FileUtils.CloseFile(inFile);

    FileUtils.CloseFile(inFile);
    FileUtils.CloseLogFile();

    System.out.printf("end execution%n");
  }
} // public class Driver


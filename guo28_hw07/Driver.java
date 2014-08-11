import java.util.Scanner;
/*********************************************************************
 * Homework 7: Computing frequent itemsets using 'TreeMap'.
 * The data is read one line at a time into an <code>ArrayList</code>
 * and then the list is processed to produce itemset lists of size
 * two, then three, then four, etc.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * Used with permission of author by chongwen guo
 * @author Duncan A. Buell
 * @version 1.00 2012-07-09
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    Scanner inFile = null;
    ItemsetMaster myMaster = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.SetLogFile("zlog");

    System.out.printf("begin execution%n");

    myMaster = new ItemsetMaster(inFile);
    FileUtils.CloseFile(inFile);

    FileUtils.logFile.printf("%s\n", myMaster.toStringBaskets());
    FileUtils.logFile.flush();

    myMaster.naiveItemsets();
    FileUtils.logFile.printf("%s\n", myMaster.toStringNaiveList());
    FileUtils.logFile.flush();

    myMaster.generateItemsets2();
    FileUtils.logFile.printf("%s\n", myMaster.toStringItemsets());
    FileUtils.logFile.flush();

    myMaster.generateNextItemsets();
    FileUtils.logFile.printf("%s\n", myMaster.toStringItemsets());
    FileUtils.logFile.flush();

    myMaster.generateNextItemsets();
    FileUtils.logFile.printf("%s\n", myMaster.toStringItemsets());
    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver


import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * HW 04: Parse XML and create pages of biographies.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * 
 * used by pemission of Duncan A. Buell by student chongwen guo
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
    PrintWriter outFile = null;
    DTD dtd = null;
    ParseTheData parseData = null;

    System.out.printf("begin execution%n");
    FileUtils.SetLogFile("zlog");

    outFile = FileUtils.PrintWriterOpen("zout");

    inFile = FileUtils.ScannerOpen("z.dtd");
    dtd = new DTD(inFile);
    FileUtils.CloseFile(inFile);

    outFile.printf("DTD is\n%s\n", dtd);

    inFile = FileUtils.ScannerOpen("zin");
    parseData = new ParseTheData(inFile);
    FileUtils.CloseFile(inFile);

    outFile.printf("%s\n", parseData);
    outFile.flush();
    FileUtils.CloseFile(outFile);

    System.out.printf("end execution%n");
  }
} // public class Driver


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Homework 05.
 * This assignment is to solve the Travelling Salesman Problem
 * by naive recursion.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 * Used with permission and modified by chongwen guo student.
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
    TSP tsp = null;
    Scanner inFile = null;
    PrintWriter outFile = null;

    System.out.printf("begin execution%n");

    //////////////////////////////////////////////////////////////////
    // set up the files for input and output
    inFile = FileUtils.ScannerOpen("zin");
    outFile = FileUtils.PrintWriterOpen("zout");
    FileUtils.SetLogFile("zlog");

    //////////////////////////////////////////////////////////////////
    // create the list structure and input the data
    tsp = new TSP(inFile);
    FileUtils.CloseFile(inFile);

    //////////////////////////////////////////////////////////////////
    // dump the list as read in
    outFile.printf("The cost matrix is\n");
    outFile.printf("%s\n", tsp);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // now solve the TSP
    outFile.printf("The optimal TSP cycle is\n");
    ArrayList<String> solution = tsp.solveTSP(outFile);
    outFile.printf("%s\n", solution);
    outFile.flush();

    int minDistance = tsp.getMinDistance();
    outFile.printf("The minimal TSP distance is %d\n", minDistance);
    outFile.flush();

    //////////////////////////////////////////////////////////////////
    // close up and go home
    FileUtils.CloseFile(outFile);

    System.out.printf("end execution%n");
  }

} // public class Driver


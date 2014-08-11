import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Lab 09: Build a heap.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2011-10-10
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";

    ArrayList<Integer> inputList = null;
    ArrayList<Integer> heapList = null;

    Scanner inFile = null;
    PrintWriter outFile = null;

    BuildMaxHeap buildMaxHeap = new BuildMaxHeap();

    System.out.printf("%s begin execution%n",TAG);

    inFile = FileUtils.ScannerOpen("zin");
    outFile = FileUtils.PrintWriterOpen("zout");

    // read the input list
    inputList = new ArrayList<Integer>();
    while(inFile.hasNext())
    {
      Integer junk = inFile.nextInt();
      inputList.add(junk);
    }

    // dump the input list
    for(int i = 0; i < inputList.size(); ++i)
    {
      outFile.printf("%8d %8d%n", i, inputList.get(i));
    }
    outFile.flush();

    // build the heap
    heapList = buildMaxHeap.buildMaxHeap(inputList);

    // build the heap
    if(buildMaxHeap.checkHeap(heapList))
    {
      outFile.printf("Yes, we built a heap.%n");
    }
    else
    {
      outFile.printf("No, we have not built a heap.%n");
    }

    // dump the heap
    outFile.printf("The new list is:%n");
    for(int i = 0; i < heapList.size(); ++i)
    {
      outFile.printf("%8d %8d%n", i, heapList.get(i));
    }


    FileUtils.CloseFile(inFile);
    FileUtils.CloseFile(outFile);

    System.out.printf("%s end execution%n",TAG);
  }
} // public class Driver


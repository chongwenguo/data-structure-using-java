import java.util.Scanner;
/*********************************************************************
 * Homework 6:  Implement a binary search tree for doing a
 *              dictionary lookup.
 *
 * Copyright(C) 2012 Duncan A. Buell.  All rights reserved.
 *
 * Used and modified with permission of author by chongwen guo
 * @author Duncan Buell
 * @version 1.00 2012-07-09
**/
public class Driver
{
/*********************************************************************
 * main method
**/
  public static void main (String[] args)
  {
    Scanner inFile = null;
    Scanner testFile = null;
    Record rec = null;
    Record testRec;
    BST<Record> theTree;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.SetLogFile("zlog");

    /*********************************************************************
     * First we build the tree of the dictionary.
    **/
    theTree = new BST<Record>();
    while(inFile.hasNext())
    {
      rec = new Record();
      rec = rec.readRecord(inFile);
      if(rec.isAlpha())
      {
        FileUtils.logFile.printf("Main:  is alpha, insert '%s'%n",
                  rec.getElement());
        FileUtils.logFile.flush();
        theTree.insert(rec);
      }
      else
      {
        FileUtils.logFile.printf("Main:  NOT ALPHA, skip '%s'%n",
                  rec.getElement());
        FileUtils.logFile.flush();
      }
    } // while(inFile.hasNext())

    /*********************************************************************
     * We have finished reading the input data, so we echo the list.
    **/
    FileUtils.logFile.printf("The inorder tree of all %d items%n%s%n",
              theTree.getNodeCount(),theTree.toStringInorder(theTree.getRoot()));
    FileUtils.logFile.printf("Main:  The average height of %d nodes is %f%n",
              theTree.getNodeCount(), theTree.getAverageHeight());
    theTree.writeHeightHisto();
    FileUtils.logFile.flush();

/*
    FileUtils.logFile.printf("%s The preorder tree of all %d items%n%s%n", TAG,
              theTree.getSize(),theTree.toStringPreorder(theTree.getRoot()));
    FileUtils.logFile.flush();

    FileUtils.logFile.printf("%s The postorder tree of all %d items%n%s%n", TAG,
              theTree.getSize(),theTree.toStringPostorder(theTree.getRoot()));
*/
    FileUtils.logFile.flush();
    FileUtils.CloseFile(inFile);

    /*********************************************************************
     * Now we run the lookup on the test file.
    **/
    testFile = FileUtils.ScannerOpen("ztest");
    while(testFile.hasNext())
    {
      testRec = new Record();
      testRec = testRec.readRecord(testFile);
      FileUtils.logFile.printf("Main:  The test record is '               %s'%n",
                testRec.toString());
      FileUtils.logFile.flush();
      if(theTree.contains(testRec))
      {
        FileUtils.logFile.printf("Main:  The test record '               %s' is in the tree%n%n",
                  testRec.toString());
        FileUtils.logFile.flush();
      }
      else
      {
        FileUtils.logFile.printf("Main:  The test record '               %s' is NOT in the tree%n%n",
                  testRec.toString());
        FileUtils.logFile.flush();
      }
    } // while(testFile.hasNext())
    

    /*********************************************************************
     * Close up, go home.
    **/
    FileUtils.logFile.printf("Main:  no more data, terminate%n");
    FileUtils.logFile.flush();
    
    FileUtils.CloseLogFile();
  }
} // public class Main






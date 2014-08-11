import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 12: Building a tree
 * This code is for building a tree and demonstrating the use of 
 * of tree traversal.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
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
    String myOutput = "";

    Scanner inFile = null;
    TreeClass myTree = null;

    inFile = FileUtils.ScannerOpen("zin");
    FileUtils.SetLogFile("zlog");

    System.out.printf("begin execution%n");

    myTree = new TreeClass();
    myTree.buildTree(inFile);

    myOutput = "";
    myOutput = myTree.toString();
    FileUtils.logFile.printf("dump%n%s%n%n", myOutput);

    myOutput = "";
    myOutput = myTree.toStringPreorderTraversal(myOutput, 1);
    FileUtils.logFile.printf("preorder traversal%n%s%n%n", myOutput);

    myOutput = "";
    myOutput = myTree.toStringPostorderTraversal(myOutput, 1);
    FileUtils.logFile.printf("postorder traversal%n%s%n%n", myOutput);

    myOutput = "";
    myOutput = myTree.toStringInorderTraversal(myOutput, 1);
    FileUtils.logFile.printf("inorder traversal%n%s%n%n", myOutput);

    FileUtils.CloseFile(inFile);
    FileUtils.CloseLogFile();

    System.out.printf("end execution%n");
  }
} // public class Driver


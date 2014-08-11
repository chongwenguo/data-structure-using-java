import java.math.BigInteger;
/*********************************************************************
 * Lab 06.
 * Gray coding.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * Used with permission by chongwen guo student.
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
    int length, power;
    Counter counter = null;

    System.out.printf("begin execution%n");
    FileUtils.SetLogFile("zlog");

    length = 5;

    //////////////////////////////////////////////////////////////////
    // These next few lines are just one way to get exponentiation
    // done simply for integers.
    BigInteger temp = new BigInteger("2");
    temp = temp.pow(length);
    power = temp.intValue();

    counter = new Counter(length);
    for(int i = 0; i < power; ++i)
    {
      FileUtils.logFile.printf("Counter, GrayCode %s : %s\n",
                                counter, counter.grayCode());
      counter.increment();
    }

    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver


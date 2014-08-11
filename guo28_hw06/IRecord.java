import java.util.Scanner;
public interface IRecord extends Comparable<Record>
{
  public String getElement();

  public void setElement(String what);

  public int compareTo(Record that);

  public boolean equals(Object that);

  public boolean isAlpha();

  public Record readRecord(Scanner inFile);

  public String toString();

} // public interface IRecord

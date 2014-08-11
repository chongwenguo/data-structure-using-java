import java.util.Scanner;
public interface IBasket
{
  public int compareTo(Basket that);

  public boolean equals(Object that);

  public int getValue(int which);

  public int maxValue();

  public int minValue();

  public void readFile(Scanner inFile);

  public int size();

  public void sortTheList();

  public String toString();
} // public interface IBasket

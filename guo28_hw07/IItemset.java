import java.util.ArrayList;
public interface IItemset
{

  public void addBasket(Basket what);

  public void addItem(int what);

  public int basketListSize();

  public int compareTo(Itemset that);

  public boolean equals(Object that);

  public Basket getBasket(int which);

  public int getItem(int which);

  public ArrayList<Integer> getItemList();

  public int getLargestItem();

  public int itemListSize();

  public String toString();

} // public interface IItemset

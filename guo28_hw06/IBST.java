public interface IBST<T extends Comparable<T>>
{

  public double getAverageHeight();

  public int getMaxHeight();

  public int getNodeCount();

  public BTNode<T> getRoot();

  public boolean contains(T testRecord);

  public BTNode<T> insert(T rec);

  public boolean isEmpty();

  public String toStringInorder(BTNode<T> v);

  public String toStringPreorder(BTNode<T> v);

  public String toStringPostorder(BTNode<T> v);

} // public interface IBT

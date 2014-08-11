public interface IBTNode<T>
{
  public int getHeight();

  public BTNode<T> getLeft();

  public void setLeft(BTNode<T> v);

  public BTNode<T> getParent();

  public void setParent(BTNode<T> v);

  public T getRecord();

  public void setRecord(T rec);

  public BTNode<T> getRight();

  public void setRight(BTNode<T> v);

  public boolean hasLeft();

  public boolean hasRight();

  public String toString();

} // public interface IBTNode

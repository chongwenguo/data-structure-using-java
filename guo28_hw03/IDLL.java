public interface IDLL<T>
{
  public DLLNode<T> getHead();

  public void setHead(DLLNode<T> value);

  public int getSize();

  public DLLNode<T> getTail();

  public void setTail(DLLNode<T> value);

  public boolean add(T dllData);

  public boolean contains(T dllData);

  public boolean remove(T dllData);

  public String toString();

} // public interface IDLL<T>

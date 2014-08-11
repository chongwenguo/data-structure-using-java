public interface IDLL
{
  public DLLNode getHead();

  public void setHead(DLLNode value);

  public int getSize();

  public DLLNode getTail();

  public void setTail(DLLNode value);

  public boolean add(Basket dllData);

  public boolean contains(Basket dllData);

  public boolean remove(Basket dllData);

  public String toString();

} // public interface IDLL

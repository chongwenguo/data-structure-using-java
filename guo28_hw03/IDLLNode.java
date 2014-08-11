public interface IDLLNode<T>
{
  public T getNodeData();

  public void setNodeData(T newData);

  public DLLNode<T> getNext();

  public void setNext(DLLNode<T> newNext);

  public DLLNode<T> getPrev();

  public void setPrev(DLLNode<T> newPrev);

  public String toString();

} // public interface IDLLNode<T>

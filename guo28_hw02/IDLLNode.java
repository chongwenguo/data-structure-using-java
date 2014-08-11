public interface IDLLNode
{
  public Basket getNodeData();

  public void setNodeData(Basket newData);

  public DLLNode getNext();

  public void setNext(DLLNode newNext);

  public DLLNode getPrev();

  public void setPrev(DLLNode newPrev);

  public String toString();

} // public interface IDLLNode<T>

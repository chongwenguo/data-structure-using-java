public interface IMyListStructure<T extends Comparable<T>>
{
  public boolean add(T basket);

  public boolean contains(T basket);

  public boolean remove(T basket);

  public String toString();

} // public interface IMyListStructure

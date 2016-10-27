//****************************************************************************************************
//  BagInterface.java
//  date : 08.30.2016
//  Author: Violeta Simovska
//  BagInterface represents  a generic interface for implementing a bag by using an array.
//****************************************************************************************************

public interface BagInterface<T>
{
    //Adds a new entry to this bag.
    public boolean add(T newEntry);
    
    //Retrieves all entries that are in this bag.
    public T[] toArray();
    
    //checking if the bag is empty
    public boolean isEmpty();
    
    //Gets the current number of entries in this bag.
    public int getCurrentSize();
    
    //Counts the number of times a given entry appears in this bag.
    public int getFrequencyOf(T anEntry);
    
    //Tests whether this bag contains a given entry.
    public boolean contains(T anEntry);
    
    //Removes one unspecified entry from this bag, if possible.
    public T remove();
    
    // Removes one occurrence of a given entry from this bag.
    public boolean remove(T anEntry);
    
    //Removes all entries from this bag.
    public void clear();
    
}

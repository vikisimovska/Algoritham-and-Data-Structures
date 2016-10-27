
//****************************************************************************************************
//LinkedBag.java       Author: Violeta Simovska
//date : 09/05/2016
//LinkedBag represents a class that implements a bag of objects by using a linked list.
//****************************************************************************************************

public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;
    
    //constructor
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    //add method
    public boolean add (T newEntry)
    {
        Node newNode = new Node (newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }
    
    //checking if the bag is empty
    public boolean isEmpty()
    {
        //numberOfEntries = 0;
        return firstNode == null;
    }
    
    // Removes all entries from this bag.
    public void clear()
    {
        while (!isEmpty())
            remove();
    }
    
    //Removes one unspecified entry from this bag, if possible.
    public T remove()
    {
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
        }
        
        return result;
    }
    
    //checking the size of the bag
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    
    //returns array of the entries currently in the bag
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object [numberOfEntries];
        Node currentNode = firstNode;
        int index = 0;
        
        while((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return result;
    }
    
    //Tests whether this bag contains a given entry.
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        
        while (found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }
        return found;
    }
    
    //Returns true if the bag has any two entries that are equal. Otherwise false.
    public boolean hasDuplicateEntries()
    {
        Node  current = firstNode;
        boolean found = false;
        
        while ((current != null) && (current.next != null))//check only w current.next
        {
            Node comparedTo = current;
            while (comparedTo.next != null)
            {
                if (comparedTo.next.data.equals(current.data))
                {
                    found = true;
                    break;
                }
                else
                    comparedTo = comparedTo.next;
            }
            if (found == true)
                break;
            else
                current = current.next;
        }
        return found;
    }
    
    //counts how many times an entry appears in this bag
    public int getFrequencyOf (T anEntry)
    {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;
        
        while ((loopCounter < numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
                frequency ++;
            loopCounter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }
    
    //Removes one occurrence of a given entry from this bag, if possible.
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        
        if (nodeN != null)
        {
            nodeN.data = firstNode.data; // Replace located entry with entry in first node
            firstNode = firstNode.next;  // Remove first node
            numberOfEntries--;
            result = true;
        }
        return result;
    }
    
    //returns reference to a given entry
    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }
        return currentNode;
    }
    
    //Returns true if two bags have the same entries. Otherwise false.
    public boolean equals(BagInterface<T> other)
    {
        boolean frequency = true;
        int loopCounter = 0;
        Node current = firstNode;
        
        if(this.getCurrentSize() != other.getCurrentSize())
            frequency = false;
        else
        {
            while ((loopCounter < numberOfEntries) && (current != null))
                
            {
                if(getFrequencyOf(current.data) == other.getFrequencyOf(current.data))
                {
                    loopCounter++;
                    current = current.next;
                }
                else
                {
                    frequency = false;
                    break;
                }
            }
        }
        return frequency;
    }
    
    //private inner class
    private class Node
    {
        private T data;
        private Node next;
        
        private Node(T newData)
        {
            this( newData, null);
        }
        private Node (T newData, Node newNextNode)
        {
            data = newData;
            next = newNextNode;
        }
    }
    
    public static void main(String[] args)
    {
        BagInterface<String> bag = new LinkedBag<>();
        
        System.out.println ("Adding some elements in the first bag..");
        bag.add("B");
        bag.add("B");
        bag.add("C");
        bag.add("B");
        bag.add("A");
        
        System.out.println ("Displaying the current items in the bag: ");
        Object[] bagArray = bag.toArray();
        for (int index = 0; index < bagArray.length; index++)
        {
            System.out.println(bagArray[index] + " ");
        } // end for
        
        //System.out.println("Checking whether the bag contains string 'B': "+ bag.contains("B"));
        
        System.out.println("Checking whether the bag has duplicate entries: "+ bag.hasDuplicateEntries());
        
        System.out.println("Checking the frequency of an entry B:" + bag.getFrequencyOf("B"));
        
        System.out.println ("Creating new bag..");
        BagInterface<String> bag2 = new LinkedBag<>();
        
        System.out.println ("Adding some elements in the second bag..");
        bag2.add("B");
        bag2.add("B");
        bag2.add("C");
        bag2.add("B");
        bag2.add("A");
        
        System.out.println ("Displaying the current items in the second bag: ");
        Object[] bagArray2 = bag2.toArray();
        for (int index = 0; index < bagArray2.length; index++)
        {
            System.out.println(bagArray2[index] + " ");
        } 
        
        System.out.println("Checking whether the second bag has duplicate entries: "+ bag2.hasDuplicateEntries());
        
        System.out.println("Checking whether the two bags have the same entries: "+ bag.equals(bag2));
        
        int size = bag2.getCurrentSize();
        System.out.println("The initial size of the second bag is: " + size);
        
        String remove = bag2.remove();
        System.out.println ("Removing one unspecified entry from this bag: " + remove);
        System.out.println("The size of the bag after the removal is: " + bag2.getCurrentSize());
        
        //removing a particular entry
        boolean remove2 =  bag2.remove("B");
        System.out.println("The entry 'B' has been removed from the second bag as well, " + remove2);
        
        System.out.println("Checking whether the two bags have the same entries: "+ bag.equals(bag2));
        
        boolean empty = bag.isEmpty();
        System.out.println ("Checking if the first bag is empty: " + empty);
        
        System.out.println ("Empting the bag.. ");
        bag.clear();
        System.out.println ("The bag is now empty: " + bag.isEmpty());
        
    }
}



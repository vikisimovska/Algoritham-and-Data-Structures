package homework6;
/**
A class that implements the ADT queue by using an expandable
circular array with one unused location.
*/
public final class ArrayQueue<T> implements QueueInterface<T>
{
    private T[] queue; // Circular array of queue entries and one unused location
    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayQueue(int initialCapacity)
    {
        checkCapacity(initialCapacity);
   
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
    }
    public void enqueue(T newEntry)
    {
        checkInitialization();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }
    public T getFront()
    {
        checkInitialization();
        if (isEmpty())
            throw new IllegalStateException();
        else
            return queue[frontIndex];
    }
    public T dequeue()
    {
        checkInitialization();
        if (isEmpty())
            throw new IllegalStateException();
        else
        {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }
    private void ensureCapacity()
    {
        if (frontIndex == ((backIndex + 2) % queue.length)) // if array is full,
        {                                                   // double size of array
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize);

            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2 * oldSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++)
            {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            } // end for
      
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }
    private void checkCapacity(int initialCapacity)
    {
        if (initialCapacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
    }
    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException ("Uninitialized object used " +
                                   "to call an ArrayBag method.");
    }
    public boolean isEmpty()
    {
        return frontIndex == ((backIndex + 1) % queue.length);
    }
    public void clear()
    {
        while (!isEmpty())
            dequeue();
    }
    //splice the parameter queue onto the end of the receiving queue
    public void splice(QueueInterface<T> q)
    {
        while (!q.isEmpty())
        {
            this.enqueue(q.dequeue());
        }
    }
    public void splice2(ArrayQueue<T> q)
    {
        checkInitialization();
        ensureCapacity();
        while (q.frontIndex != ((q.backIndex + 1) % q.queue.length))
        {
            //this.enqueue(q.queue[q.frontIndex]);
            this.backIndex = (this.backIndex + 1) % this.queue.length;
            this.queue[backIndex] = q.queue[q.frontIndex];
            q.queue[q.frontIndex] = null;
            q.frontIndex = (q.frontIndex + 1) % q.queue.length;
        }
    }
} 


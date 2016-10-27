//****************************************************************************************************
//  ArrayStack.java      
//  date : 9/14/2016
//  Author: Violeta Simovska
//  ArrayStack represents  a class that implements the StackInterface.
//****************************************************************************************************
package homework4;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	//constructor
	public ArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}
	//constructor
	public ArrayStack(int initialCapacity )
	{
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}
	private void checkInitialization()
	{
		if (!initialized)
			throw new SecurityException("ArrayStack object is not initialized properly.");
	}
	private void checkCapacity(int capacity)
	{
	     if (capacity > MAX_CAPACITY)
	        throw new IllegalStateException("Attempt to create a bag whose " +
	                                        "capacity exeeds allowed " +
	                                        "maximum of " + MAX_CAPACITY);
	}
	
	public void push(T newEntry)
	{
	   checkInitialization();
	   ensureCapacity();
	   stack[topIndex + 1] = newEntry;
	   topIndex++;
	}

	private void ensureCapacity()
	{
	   if (topIndex == stack.length - 1) // If array is full, double its size
	   {
	      int newLength = 2 * stack.length;
	      checkCapacity(newLength);
	      stack = Arrays.copyOf(stack, newLength);
	   } 
	}
	public T peek()
	{
	   checkInitialization();
	   if (isEmpty())
	      throw new EmptyStackException();
	   else
	      return stack[topIndex];
	}
	public T pop()
	{
	   checkInitialization();
	   if (isEmpty())
	      throw new EmptyStackException();
	   else
	   {
	      T top = stack[topIndex];
	      stack[topIndex] = null;
	      topIndex--;
	      return top;
	   } // end if
	}
	public boolean isEmpty()
	{
	   return topIndex < 0;
	}

	public void clear() 
	{
		while (!isEmpty()) 
         pop();
	}
	
	// Returns the element below the top element
	public T peek2()
	{
		if (topIndex < 1)//or -1
		{
			throw new EmptyStackException();
		}
		else
		{
			return stack[topIndex-1];
		}
	}
	// removes the last n entries from the stack
		public void remove(int n)
		{
			if (!isEmpty())
			{
				for (int i = 0; i < n; i++)
				{
					System.out.println("removing.. ");
					pop();
				}
			}
		}
		
		// pushes each element in the array, beginning with index 0.
		public void pushAll(T[] a)
		{
			for(int i = 0; i < a.length; i++)
			{
				push(a[i]);
			}
		}
		// Returns a string that shows all of the elements on the stack. 
		public String toString()
		{
			String s = "";
			int tempIndex = topIndex;
			for(int i = 0; i <= topIndex; i++)
			{
				s += stack[tempIndex] + " ";
				tempIndex--;
			}
			return s;
		}
}














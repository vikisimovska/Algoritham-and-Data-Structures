//****************************************************************************************************
//  LinkedStack.java      
//  date : 9/14/2016
//  Author: Violeta Simovska
//  LinkedStack represents  a class that implements the StackInterface.
//****************************************************************************************************

package homework4;
import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}
		
	public void push(T newEntry)
	{
		topNode = new Node(newEntry, topNode);
		//topNode = newNode;
	}
		
	public T peek()
	{
		 if (isEmpty())
			 throw new EmptyStackException();
		 else
		     return topNode.getData();
	}
		
	public T pop()
	{
		T top = peek();

		assert (topNode != null);
		topNode = topNode.getNextNode();

		return top;
	}
	
	// Returns the element below the top element
	public T peek2()
	{
		if (topNode.next == null || topNode == null )
			throw new EmptyStackException();
		else
		    return topNode.next.getData();
	}
	
	// Returns a string that shows all of the elements on the stack. 
	public String toString()
	{
		String elements ="";
		
		while (!isEmpty())
		{
			elements += ((String)(topNode.getData())) +  "  ";
			topNode = topNode.getNextNode();
		}

		return elements;
	}
	// removes the top n entries from the stack. Stops as soon as the stack is empty.
	public void remove(int n)
	{
		for (int i = 0; i < n; i++)
		{
			if (!isEmpty())
			{
				System.out.println("The element that is being removed is " + topNode.getData());
				pop();
			}
		}
	}
	//Takes each element in the array parameter and pushes it onto the stack
	public void pushAll(T[] a)
	{
		for (int i=0; i < a.length; i++)
		{
			push(a[i]);
		}
	}
		
	public boolean isEmpty()
	{
		return topNode == null;
	}

	public void clear()
	{
		topNode = null;
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
				
		private Node getNextNode()
		{
			return next;
		}
				
		private void setNextNode(Node newNextNode)
		{
			next = newNextNode;
		}
				
		private T getData()
		{
			return data;
		}
				
		private void setData(T newData)
		{
					
			data = newData;
		}
	}
}


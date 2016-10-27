package homework6;
/**
A class that implements the ADT queue by using a chain of nodes
that has both head and tail references.
*/
public final class LinkedQueue<T> implements QueueInterface<T>
{
   private Node queueNode; // References first node in queue
   private Node freeNode;  // References node after back of queue
   
   public LinkedQueue()
   {
      freeNode = new Node(null, null);
      freeNode.setNextNode(freeNode);
      queueNode = freeNode;
   }
	public void enqueue(T newEntry)
	{
	   freeNode.setData(newEntry);

	   if (isChainFull())
	   {
	      // Allocate a new node and insert it after the node that
	      // freeNode references
	      Node newNode = new Node(null, freeNode.getNextNode());
	      freeNode.setNextNode(newNode);
	   } // end if

	   freeNode = freeNode.getNextNode();
	}
	public T getFront()
	{
	   if (isEmpty())
	      throw new IllegalStateException();
	   else
	      return queueNode.getData();
	}
	public T dequeue()
	{
	   T front = getFront();  // Might throw EmptyQueueException
	   assert !isEmpty();

	   queueNode.setData(null);
	   queueNode = queueNode.getNextNode();

	   return front;
	}
	public boolean isEmpty()
	{
	   return queueNode == freeNode;
	} // end isEmpty

	private boolean isChainFull()
	{
	   return queueNode == freeNode.getNextNode();
	}
	
	public void clear()
	{
		queueNode = null;
	    freeNode = null;
	}
	
	public void splice(QueueInterface<T> q)
	{
		while (!q.isEmpty())
		{
			this.enqueue(q.dequeue());
		}
	}
	
	public void splice2(LinkedQueue<T> q)
	{
		while (q.queueNode != q.freeNode)
		{
			freeNode.setData(q.queueNode.getData());

			   if (isChainFull())
			   {
			      // Allocate a new node and insert it after the node that
			      // freeNode references
			      Node newNode = new Node(null, freeNode.getNextNode());
			      freeNode.setNextNode(newNode);
			   } // end if

			   freeNode = freeNode.getNextNode();
			
			//this.enqueue(q.queueNode.getData());
			q.queueNode.setData(null);
		    q.queueNode = q.queueNode.getNextNode();
		}
	}
	
	private class Node
	{
		private T    data; // Entry in queue
		private Node next; // Link to next node
   
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor
		
		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor
   
		private T getData()
		{
			return data;
		} // end getData
   
		private void setData(T newData)
		{
			data = newData;
		} // end setData
   
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LinkedQueue


//****************************************************************************************************
//  StackInterface.java      
//  date : 9/14/2016
//  Author: Violeta Simovska
//  StackInterface provides methods for manipulating a stack
//****************************************************************************************************

package homework4;

public interface StackInterface<T> {

	//adds elements onto the stack
	public void push(T newEntry);
	
	//returns the top element of the stack
	public T peek();
	
	//deletes the top element of the stack
	public T pop();
	
	//checks if the stack is empty
	public boolean isEmpty();
	
	//removes all the elements of the stack
	public void clear();
	
	//Returns the element below the top element, or throws an exception if there are less than two elements
	public T peek2(); 
	
	// Returns a string that shows all of the elements on the stack. 
	public String toString(); 
	
	// removes the top n entries from the stack. Stops as soon as the stack is empty.
	public void remove(int n); 
	
	// pushes each element in the array, beginning with index 0.
	public void pushAll(T[] a); 

}


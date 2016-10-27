package homework4;

public class Main {

	public static void main(String[] args) {
		
		//testing the LinkedStack		
		StackInterface<String> stringStack = new LinkedStack<> ();
		println("Adding some elements into the linked stack.. ");
		stringStack.push("Lucy");
		stringStack.push("John");
		stringStack.push("Aimee");
		println("Checking if the stack is empty: " + stringStack.isEmpty());
		println("The first element is: "+ stringStack.peek());
		println("The element bellow " + stringStack.peek() + " is: " + stringStack.peek2());
		//print("test" + stringStack.peek2());
		println("Deleting the top element: " + stringStack.pop());
		println("The element bellow " + stringStack.peek() + " is: " + stringStack.peek2());
		
		println("Adding some more elements...");
		
		stringStack.push("Lucy");
		stringStack.push("Tom");
		stringStack.push("Martin");
		
		String[] a = {"A", "B", "C"};
		stringStack.pushAll(a);
		println("Now the elements inside the stack are: " + stringStack.toString());
		
		 
		println("Deleting all the elements...");
		stringStack.clear();
		println("Checking if the stack is empty: " + stringStack.isEmpty());
		
		
		 
		
		println("******************************************************");
		
		//Testing the ArrayStack
		StackInterface<String> arrayStack = new ArrayStack<>();
		println("Adding some elements into the array stack.. ");
		arrayStack.push("one");
		arrayStack.push("two");
		arrayStack.push("three");
		
		println("Checking if the stack is empty: " + arrayStack.isEmpty());
		println("The elements inside the stack are: " + arrayStack.toString());
		
		println("The first element is: "+ arrayStack.peek());
		println("The element bellow " + arrayStack.peek() + " is: " + arrayStack.peek2());
		
		println("Deleting the top element: " + arrayStack.pop());
		println("The element bellow '" + arrayStack.peek() + "' is: " + arrayStack.peek2());
		
		println("Adding some more elements..");
		String[] b = {"A", "B", "C"};
		arrayStack.pushAll(b);
		println("The elements inside the stack are: " + arrayStack.toString());
		
		println("Removing the first 2 elements of the stack");
		arrayStack.remove(2);
		println("Checking if the stack is empty: " + arrayStack.isEmpty());
		
		println("The first element is: "+ arrayStack.peek());
		println("Now the elements inside the stack are: " + arrayStack.toString());
		
		println("Deleting all the elements.." );
		arrayStack.clear();
		println("Checking if the stack is empty now: " + arrayStack.isEmpty());				
	}
	
	public static void println (Object...o) 
	{
		if (o.length == 0) 
			System.out.println();
		else 
			 System.out.println(""+ o[0]);
	}

}

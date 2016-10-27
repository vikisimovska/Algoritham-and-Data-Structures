package homework7;

import java.util.*;

public class ListComparison {

	public static void main(String[] args) {

		// **************adding objects to ArrayBasedList*******
		Date start = new Date();
		ListInterface<String> al = new ArrayBasedList<>();
		for (int i = 0; i < 1000000; i++)
			al.add("");
		Date end = new Date();
		long elapsedTime = end.getTime() - start.getTime();
		println("Adding a million string objects to an array list would take: " + elapsedTime);

		// **************adding objects to LinkedListBasedList*******
		start = new Date();
		ListInterface<String> ll = new LinkedListBasedList<>();
		for (int i = 0; i < 1000000; i++)
			ll.add("");
		end = new Date();
		elapsedTime = end.getTime() - start.getTime();
		println("Adding a million string objects to an linked list would take: " + elapsedTime);

		// **************adding objects to ArrayBasedList*******
		start = new Date();
		for (int i = 0; i < 100; i++)
			al.add(randomIndexes(al), "");
		end = new Date();
		elapsedTime = end.getTime() - start.getTime();
		println("Adding a million string objects to an array list with random indexes would take: " + elapsedTime);

		// **************adding objects to LinkedListBasedList*******
		start = new Date();
		for (int i = 0; i < 100; i++)
			ll.add(randomIndexes(ll), "");
		end = new Date();
		elapsedTime = end.getTime() - start.getTime();
		println("Adding a million string objects to an linked list with random indexes would take: " + elapsedTime);

		// **************replacing objects from ArrayBasedList*******
		start = new Date();
		for (int i = 0; i < 10000; i++)
			al.replace(randomIndexes(al), "");
		end = new Date();
		elapsedTime = end.getTime() - start.getTime();
		println("Replacing 10000 string objects from an array list would take: " + elapsedTime);

		// **************replacing objects from LinkedListBasedList*******
		start = new Date();
		for (int i = 0; i < 10000; i++)
			ll.replace(randomIndexes(ll), "");
		end = new Date();
		elapsedTime = end.getTime() - start.getTime();
		println("Replacing 10000 string objects from an linked list would take: " + elapsedTime);

		// **************removing objects from ArrayBasedList*******
		start = new Date();
		for (int i = 0; i < 10000; i++)
			al.remove(randomIndexes(al));
		end = new Date();
		elapsedTime = end.getTime() - start.getTime();
		println("Removing 10000 string objects from an array list would take: " + elapsedTime);

		// **************removing objects from LinkedListBasedList*******
		start = new Date();
		for (int i = 0; i < 10000; i++)
			ll.remove(randomIndexes(ll));
		end = new Date();
		elapsedTime = end.getTime() - start.getTime();
		println("Removing 10000 string objects from an linked list would take: " + elapsedTime);
	}

	private static int randomIndexes(ListInterface<String> arrList) {
		Random rand = new Random();
		return rand.nextInt((arrList.getLength()+1) + 1);
	}

	// ***********println**************
	public static void println(Object... o) {
		if (o.length == 0)
			System.out.println();
		else
			System.out.println("" + o[0]);
	}
}
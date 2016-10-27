//****************************************************************************************************
//  Tester.java
//  Author: Violeta Simovska
//  date : 30.08.2016
//  This is a tester program for a ResizableArrayBag class.
//****************************************************************************************************


public class Tester
{
public static void main (String[] args)
{
    //testing bag1
    System.out.println();
    System.out.println("Testing the first bag");
    System.out.println("**********************");
    System.out.println();
    
    BagInterface<Integer> bag1 = new ResizableArrayBag<Integer>(8);
    System.out.println("The first bag is empty ,  " + bag1.isEmpty());
    System.out.println("It has " + bag1.getCurrentSize() + " elements.");
    bag1.add(3);
    bag1.add(3);
    bag1.add(3);

    System.out.println("It has " + bag1.getCurrentSize() + " elements.");
    bag1.remove(3);
    System.out.println("It has " + bag1.getCurrentSize() + " elements.");
    
    bag1.add(3);
    bag1.add(3);
    bag1.add(3);
    bag1.add(3);
    bag1.add(3);
    bag1.add(3);
    bag1.add(3);
    bag1.add(3);
    System.out.println("It has " + bag1.getCurrentSize() + " elements.");
    
    //testing bag2
    System.out.println();
    System.out.println("Testing the second bag");
    System.out.println("**********************");
    System.out.println();
    
    String[] items = {"A", "D", "B", "A", "C", "A", "D"};
    BagInterface<String> bag2 = new ResizableArrayBag<String>(items);
    
    System.out.println("We add some items to the second bag. Checking if it is empty ,  " + bag2.isEmpty());
    System.out.println("The second bag has, " + bag2.getCurrentSize() + " elements.");
    
    System.out.println("Adding the string 27 to the second bag, " + bag2.add("27"));
    System.out.println("And now the second bag has, " + bag2.getCurrentSize() + " elements.");
    
    System.out.println("Checking if the second bag contains number 27,  " + bag2.contains("27"));
    
    System.out.println("Removing the last item we put inside the second bag,  " + bag2.remove());
    
    System.out.println("Removing one occurrence of the letter 'A' in the second bag,  " + bag2.remove("A"));
    
    System.out.println("Checking for the current number of elements in the second bag,  " + bag2.getCurrentSize());
    
    System.out.println("Removing all the elements from the second bag. ");
    bag2.clear();
    System.out.println("And now checking for the current size of the second bag,  " + bag2.getCurrentSize());
    

                       
    
}
}

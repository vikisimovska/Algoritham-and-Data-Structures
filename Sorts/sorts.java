package homework5;

public class sorts 
{
	//***********numberOfComparisonInSelectionSort*****************************
		public static <T extends Comparable<? super T>> int numberOfComparisonInSelectionSort(T[] a) {
			int count = 0;
			int n = a.length;
			for (int index = 0; index < n - 1; index++) {
				int indexOfNextSmallest = index;
				T min = a[index];
				for (int i = index + 1; i < n; i++) {
					count++;
					if (a[i].compareTo(min) < 0) {
						min = a[i];
						indexOfNextSmallest = i;
					} // end if
				} // end for
				swap(a, index, indexOfNextSmallest);
			} // end for
			
			return count;
		} // end numberOfComparisonInSelectionSort
		
		// Swaps the array entries a[i] and a[j].
		private static void swap(Object[] a, int i, int j) {
				Object temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			} // end swap
		//***************numberOfComparisonInInsertionSort*************************
		public static <T extends Comparable<? super T>> int numberOfComparisonInInsertionSort(T[] a) 
		{
			int counter = 0;
			for (int unsorted = 1; unsorted < a.length; unsorted++) {

			T firstUnsorted = a[unsorted];
			int index = unsorted - 1;
					
			while ((index >= 0) && (firstUnsorted.compareTo(a[index]) < 0)) {
				a[index + 1] = a[index]; // Make room
				index--;
				counter++;
					} // end for	
				} // end for
				
			return counter;
			} // end insertionSort
		
		//***************generateRandomArrayWithLength*************************
		public static Integer[] generateRandomArrayWithLength(int length)
		{
			Integer intArray[] = new Integer[length];
			for (int i = 0; i < length; i++)
			{
				intArray[i] = (int) (Math.random() *10 + 1); 
			}
				return intArray;
		}
		//*****************main***************************************************    
		public static void main(String[] args) 
		{

			Integer[] randArray1 = generateRandomArrayWithLength(10);	
			System.out.println(numberOfComparisonInSelectionSort(randArray1));
			randArray1 = generateRandomArrayWithLength(10);	
			System.out.println(numberOfComparisonInInsertionSort(randArray1));
			
			System.out.println("-----------------------------------------------");
			
			Integer[] randArray2 = generateRandomArrayWithLength(100);
			System.out.println(numberOfComparisonInSelectionSort(randArray2));
			 randArray2 = generateRandomArrayWithLength(100);
			System.out.println(numberOfComparisonInInsertionSort(randArray2));
			
			
			System.out.println("-----------------------------------------------");
			
			Integer[] randArray3 = generateRandomArrayWithLength(1000);
			System.out.println(numberOfComparisonInSelectionSort(randArray3));
			
			randArray3 = generateRandomArrayWithLength(1000);
			System.out.println(numberOfComparisonInInsertionSort(randArray3));
			
			System.out.println("-----------------------------------------------");
			
			Integer[] randArray4 = generateRandomArrayWithLength(10000);
			System.out.println(numberOfComparisonInSelectionSort(randArray4));
			randArray4 = generateRandomArrayWithLength(10000);
			System.out.println(numberOfComparisonInInsertionSort(randArray4));
		    
		    }
	
	
}

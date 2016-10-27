 public class SimpleValue <T>
{
   
    private T value;
    
    public SimpleValue( T newValue)
    {
    
        value = newValue;
    
    }

    public  T getValue()
    {
        return value;
    
    }
    
    public void setValue(T newValue)
    {
        value = newValue;
    
    }
    

}


public class Tester
{
    
    public static void main(String args[])
    {
       
        SimpleValue <String> value1 = new SimpleValue <String> ("hello");
        System.out.println(value1);
        
        SimpleValue <Integer> value2 = new SimpleValue <Integer> (2);
        System.out.println(value2);
        
        ArrayList <Integer> ints = new ArrayList <Integer>();
        ints.add (1);
        ints.add (2);
        
        SimpleValue <ArrayList<Integer>> value3 = new SimpleValue <ArrayList<Integer>>(ints);
        System.out.println(values3);
    }
    
    
    
    









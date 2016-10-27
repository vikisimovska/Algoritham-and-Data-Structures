//****************************************************************************************************
//  MyFraction.java       Author: Violeta Simovska
//  date : 19.08.2016
//  MyFraction represents  a class that implements the Fraction interface.
//  Represents an interface that allows adding, subtracting, multipling, and dividing itself with another
//fraction object.

 // A valid fraction must not have zero in the denominator.
//****************************************************************************************************

public class Tester
    {
        
        public static void main(String args[])
        {
            Fraction Test1 = new MyFraction(-2,-5);
            String show;
            //Fraction test1=new Fraction();
            show=Test1.toString();
            System.out.println("in main first number"+show);
            
            System.out.println("*************");
            
            Fraction Test2 = new MyFraction(2,5);
            //Fraction test2=new Fraction();
            show=Test2.toString();
            System.out.println("in main second number"+show);
            
            System.out.println("*************");
           
            Fraction add;
            add=Test1.add(Test2);
            show=add.toString();
            System.out.println("in main add "+show);
            
            System.out.println("*************");
            
            Fraction sub;
            sub=Test1.subtract(Test2);
            show=sub.toString();
            System.out.println("in main subtraction is equal to "+show);
            
            
            System.out.println("*************");
            
            Fraction mult;
            mult=Test1.multiply(Test2);
            show=mult.toString();
            System.out.println("in main multiply is "+show);
            
           
            System.out.println("*************");
            
            Fraction dvd;
            dvd=Test1.divide(Test2);
            show=dvd.toString();
            System.out.println("in main division is "+show);
            
            System.out.println("*************");
            
            Fraction recip;
            recip=Test1.reciprocal(Test2);
            show=recip.toString();
            System.out.println(show);
            
            System.out.println("*************");
            
            
            recip=Test1.reciprocal();
            show=recip.toString();
            System.out.println(show);
            recip=Test2.reciprocal();
            show=recip.toString();
            System.out.println("in main reciprocal is "+show);
            
        
            System.out.println("*************");
            
            boolean equality;
            equality=Test1.equalTo(Test2);
            System.out.println("in main equality is " +equality);
            
            
            
            
            }
        
    }














        
        
        
        
        
        
        











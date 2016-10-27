//****************************************************************************************************
//  Fraction.java       Author: Violeta Simovska
//  date : 08.19.2016
//  Fraction.java represents an interface that allows adding, subtracting, multipling, and
//  dividing itself with another fraction object.
//  A valid fraction must not have zero in the denominator.
//****************************************************************************************************

public interface Fraction
    {
        //getter for the numerator
        int getNumerator ();
        
        //getter for the denominator
        int getDenominator ();
        
        //setter for the numerator
        void setNumerator (int newNum);
        
        //setter for the denominator
        void setDenominator (int newDen);
        
        // method that allow a fraction to add itself with another fraction object
        Fraction add (Fraction a);
     
        // method that allow a fraction to substract itself from another fraction object
        Fraction subtract (Fraction a);
   
        // method that allow a fraction to multiply itself with another fraction object
        Fraction multiply (Fraction a);
 
        // method that allow a fraction to divide itself with another fraction object
        Fraction divide (Fraction a);
        
        // method that returns the reciprocal of the receiving fraction
        Fraction reciprocal (Fraction a);
        
        //second version of a method that returns the reciprocal of existing fraction
        Fraction reciprocal();
       
        //method that compares a fraction with another for equality
        boolean equalTo (Fraction a);
        
        //method that returns a String version of the fraction.
        String toString ();
      
    }

        
        
        
        
        
        
        
        
        
        
        
        
        
        











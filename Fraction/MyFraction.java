//****************************************************************************************************
//  MyFraction.java       Author: Violeta Simovska
//  date : 19.08.2016
//  MyFraction represents  a class that implements the Fraction interface.
//
//  A valid fraction must not have zero in the denominator.
//****************************************************************************************************

public class MyFraction implements Fraction
    {
        private int numerator;
        private int denominator;
        
        //constructor 1
        public MyFraction ()
        {
            numerator = 0;
            denominator = 1;
        }
        
        //constructor 2
        public MyFraction (int newNum, int newDen)
        {
            numerator=newNum;
            denominator=newDen;
            
            //check if denominator is valid
            if (this.denominator == 0)
            {
                throw new IllegalArgumentException("invalid denominator");
            }
            
           //if both numerator and denominator are negative
            else if(newDen<0 && newNum<0)
            {
                this.numerator=newNum*-1;
                this.denominator=newDen*-1;
            }
            
            //if we have negative denominator
            else if(newDen<0 && newNum>0)
            {
                this.numerator=newNum*-1;
                this.denominator=newDen*-1;
            }
            
            // otherwise the sign is final without change
            else
           {
                numerator=newNum;
                denominator=newDen;
            }
        }

        public int getNumerator ()
        {
            return numerator;
        }
        
        public int getDenominator ()
        {
            return denominator;
        }
        
        public void setNumerator (int newNum)
        {
            numerator = newNum;
        }
	  
        public void setDenominator (int newDen)
        {
            denominator = newDen;
        }
        
        // method that allow a fraction to add itself with another fraction object
        public Fraction add (Fraction a)
        {
            //find the least common denominator
            int common = lcd (this.denominator, a.getDenominator());
            
            Fraction sum = new MyFraction ((common/this.denominator * this.numerator) + (common/a.getDenominator() * a.getNumerator()),common);
            
            return (((MyFraction)sum).simplify());
            
        }
        
        // method that allow a fraction to subtrack itself with another fraction object
        public Fraction subtract (Fraction a)
        {
            //find the least common denominator
            int common = lcd (this.denominator, a.getDenominator());
            
            Fraction subtracting = new MyFraction ((common/this.denominator * this.numerator) - (common/a.getDenominator() * a.getNumerator()),common);

            return (((MyFraction)subtracting).simplify());

        }
        
        //finding the least common denominator
        private int lcd (int denominator1, int denominator2)
        {
            int temp = denominator1;
            while ((denominator1 % denominator2) != 0)
                denominator1 += temp;
            return denominator1;
            
        }
        
        //finding the greatest common denominator
        private int gcd(int denom1, int denom2)
        {
            int factor = denom2;
            while (denom2 != 0)
            {
                factor = denom2;
                denom2 = denom1 % denom2;
                denom1 = factor;
            }
            return denom1;
        }
        
        // method that allow a fraction to multiply itself with another fraction object
        public Fraction multiply (Fraction a)
        {
            Fraction product = new MyFraction ((this.numerator * a.getNumerator()), (this.denominator * a.getDenominator()));
    
            // reduce the resulting fraction
            return (((MyFraction)product).simplify());
        }
    
        // method that allow a fraction to divide itself with another fraction object
        public Fraction divide (Fraction a)
        {
            Fraction division = new MyFraction ((this.numerator * a.getDenominator()), (this.denominator * a.getNumerator()));
            
            // reduce the resulting fraction
            return (((MyFraction)division).simplify());
        }

        // method that returns the reciprocal of the receiving fraction
        public Fraction reciprocal(Fraction a)
        {
            Fraction r = new MyFraction(a.getDenominator(),a.getNumerator());
            return r;
        }
        
        //method that returns reciprocal of the existing fraction
        public Fraction reciprocal()
        {
            Fraction r = new MyFraction(getDenominator(),getNumerator());
            return r;
        }

      
        //method that compares a fraction with another for equality
        public boolean equalTo (Fraction a)
        {
            MyFraction b = new MyFraction(this.numerator, this.denominator);
            MyFraction c = b.simplify();;
            MyFraction d = ((MyFraction)a).simplify();
        
            if (c.numerator == d.numerator && c.denominator == d.denominator)
                return true;
            else
                return false;
        }
 
        //method that returns a String version of the fraction.
        public String toString ()
        {
            String stringRep = numerator + "/" + denominator;
            return stringRep;
        }
        
        // method that simplifies a fraction 
        private MyFraction simplify ()
        {
            MyFraction result = new MyFraction();
            int common = 0;
            // get absolute values for numerator and denominator
            int num = Math.abs(numerator);
            int den = Math.abs(denominator);
            // figure out which is less, numerator or denominator
            if (num > den)
                common = gcd(num, den);
            else if (num < den)
                common = gcd(den, num);
            else  // if both are the same, don't need to call gcd
                common = num;
            
            // set result based on common factor derived from gcd
            result.numerator = numerator / common;
            result.denominator = denominator / common;
            return result;
        }
        
}














        
        
        
        
        
        
        











/**
 * 
 */
package CalcUtils;

import java.util.Scanner;

/** 
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers.  Numbers are entered into the dataset using
 * the enter(double) method.  Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the average, and the standard deviation
 */

public class StatCalc {

    private int count;   // Number of numbers that have been entered.
    private double sum;  // The sum of all the items that have been entered.
    private double squareSum;  // The sum of the squares of all the items.
    private double min=0;
    private double max=0;
    
    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num*num;
        if (min==0 || num<min) min=num;
        if (max==0 || num>max) max=num;
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;  
    }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() {  
        double mean = getMean();
        return Math.sqrt( squareSum/count - mean*mean );
    }
    
    public double getMin(){
    	return min;
    }
    
    public double getMax(){
    	return max;
    }
    
    public static void main(String [] args){
    	StatCalc calc = new StatCalc();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the first number you want to add in the dataset (enter 0 if you're done).");
    	double number = sc.nextDouble();
    	while (number!=0){
    		calc.enter(number);
        	System.out.println("Enter another number you want to add in the dataset (enter 0 if you're done).");
    		number=sc.nextDouble();
    	}
    	sc.close();
    	System.out.println("count : "+calc.getCount());
    	System.out.println("sum : "+calc.getSum());
    	System.out.println("min : "+calc.getMin());
    	System.out.println("max : "+calc.getMax());
    	System.out.println("mean : "+calc.getMean());
    	System.out.println("Standardin Deviation : "+calc.getStandardDeviation());
    	
    }

}
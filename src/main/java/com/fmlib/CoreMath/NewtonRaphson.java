/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.CoreMath;

/**
 *
 * @author Muddu
 */
public abstract class NewtonRaphson extends Derivative
{
public abstract double newtonroot(double rootvalue);
public double precisionvalue;
public int iterate;
public void accuracy(double precision,int iterations)
{
    super.h=precision;
    this.precisionvalue=precision;
    this.iterate=iterations;
}
public double newtraph(double lowerbound)
{
    int counter=0;
    double fx=newtonroot(lowerbound);
    double Fx=derivation(lowerbound);
    double x=(lowerbound-(fx/Fx));
    while(Math.abs(Math.abs(x)-Math.abs(lowerbound))> precisionvalue || counter>iterate)
        {
        	
            lowerbound=x;
            x = newtraph(lowerbound);
            counter++;
        }
        return x;
}
    public double deriveFunction(double inputa)
{
    double x1=newtonroot(inputa);
    return x1;
}
}

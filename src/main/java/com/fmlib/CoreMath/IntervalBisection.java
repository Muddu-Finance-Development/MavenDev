/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmlib.CoreMath;
/**
 *
 * @author Muddu
 */
public abstract class IntervalBisection
{
    //Compute function is used to evaluate successive root estimation
    public abstract double computeFunction(double rootvalue);
    protected double precisionvalue,lowerbound,upperbound;
    protected int iterations;
    protected IntervalBisection()//Default constructor
    {
        iterations=20;
        precisionvalue=1e-3;
    }
    protected IntervalBisection(int iterations,double precisionvalue)
    {
        this.iterations=iterations;
        this.precisionvalue=precisionvalue;
    }
    public int getiterations()
    {
        return iterations;
    }
    public double getprecisionvalue()
    {
        return precisionvalue;
    }
    public double evaluateRoot(double lower,double higher)
    {
        double fa,fb,fc,midvalue=0,precvalue=0;
        fa=computeFunction(lower);
        fb=computeFunction(higher);
        if(fa*fb>0)
        {
            midvalue=0;
        }
        else
            do
            {
                precvalue=midvalue;
                midvalue=lower+0.5*(higher-lower);
                fc=computeFunction(midvalue);
                if(fa*fc<0)
                {
                    higher=midvalue;
                }
                else 
                    if(fa*fc>0)
                {
                    lower=midvalue;
                }
            }
            while((Math.abs(fc)>precisionvalue&&precisionvalue<iterations));
        return midvalue;
    }
}

 

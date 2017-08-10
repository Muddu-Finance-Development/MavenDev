/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.FinApps;

import com.fmlib.CoreMath.NewtonRaphson;

/**
 *
 * @author Muddu
 */
public class NewtonYield_1 extends NewtonRaphson
{
public NewtonYield_1(double initialval, double precision,int iterations)
    {
	inputvalue=initialval;
	iteration=iterations;
	prec=precision;
    }
protected double nominalpricevalue;
protected double termperiod;
protected double couponrate;
protected double marketpricevalue;
protected double inputvalue;
protected double rateperTerm;
protected double maturityperiod;
protected double rateindex;
int iteration;
double prec;

    public NewtonYield_1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public double newtonroot(double rootinput)
    {
        double poscashflow,solution;
        poscashflow=rateperTerm;
        solution=(poscashflow/rootinput*(1.0-1.0/(Math.pow(1.0+rootinput,rateindex))))+(nominalpricevalue/(Math.pow(1.0+rootinput, rateindex)))-marketpricevalue;
        return solution;
    }
public double yieLd(double noms, double term, double coupon,double mktp, double period) 
    {
	nominalpricevalue=noms;
	termperiod=term;
	couponrate=coupon;
	marketpricevalue=mktp;
	rateperTerm=((coupon/term));
	maturityperiod=period;
	rateindex=(maturityperiod*term);
	accuracy(prec,iteration);
	return newtraph(inputvalue);
    }
public static void main(String[] args)
    {
        NewtonYield_1 CalcBond= new NewtonYield_1(0.05,1e-6,20);
        System.out.println("Required yiled through NewtonRaphson method is"+CalcBond.yieLd(100.0,2.0,11.0,108.120,3.0));
    }
}

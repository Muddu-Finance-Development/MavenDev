/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.FinApps;

import com.fmlib.CoreMath.IntervalBisection;

/**
 *
 * @author Muddu
 */
public class YieldBisect_1 extends IntervalBisection 
{
public YieldBisect_1()
{
    
}
public YieldBisect_1(int Nofiterations,double Precision,double high,double low)
{
    super(Nofiterations,Precision);
    inputevaluelow=low;
    inputvaluehigh=high;  
}
	protected double nominalstockprice;
	protected double termperiod;
	protected double couponrate;
	protected double marketpricevalue;
	protected double inputevaluelow;
	protected double inputvaluehigh;
	protected double rateperTerm;
	protected double maturityperiod;
	protected double rateindex;
public double computeFunction(double rootinput)
{
    double poscashflow,solution;
    poscashflow=rateperTerm;
    solution=(poscashflow/rootinput*(1.0-1.0/(Math.pow(1.0+rootinput,rateindex))))+(nominalstockprice/(Math.pow(1.0+rootinput,rateindex)))-marketpricevalue;
return solution; 
}
public double yieLd(double noms,double term,double coupon,double mktp, double period)
{
    nominalstockprice=noms;
    termperiod=term;
    couponrate=coupon;
    marketpricevalue=mktp;
    rateperTerm=((coupon/term));
    maturityperiod=period;
    rateindex=(maturityperiod*term);
return evaluateRoot(inputevaluelow,inputvaluehigh);   
}
public static void main(String[] args)
{
    YieldBisect_1 CalcBond=new YieldBisect_1(20,1e-6,0.07,0.03);
    double yieldvalue=CalcBond.yieLd(100.0,2.0,10.0,104.5,3.0);
    System.out.println("The required yield is "+yieldvalue*100+"%");
}
}

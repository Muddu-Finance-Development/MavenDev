/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.InterestRate;

/**
 *
 * @author Muddu
 */
public final class Intr 
{
    private static double cl0=0;
    private static double cl1=0;
    public Intr()
    {
        this.cl0=100;// sensible default values
        this.cl1=104;
    }
    public Intr(double a,double b)
    {
        this.cl0=a;
        this.cl1=b;
    }
    public static double realintr(double nintr)//implements real IR
    {
        return 100*((cl0*(1+nintr)/cl1)-1.0);
    }
    public static double erate(double intr,double convertp)//implements annual effective rate
    {
        return Math.pow((1+(intr/convertp)),convertp)-1;
    }
    public static double fint(double intr)//force of interest
    {
        return Math.log(1+intr);
    }
    public static double ancertain(double intr,double n)//series of payment for n periods(annuity certain)
    {
        return (Math.pow((1+intr),n-1))/intr;
    }
    public static double ancertainAd(double intr,double n)//series of payment for n periods(annuity certain) with advance
    {
        return ((Math.pow((1+intr),n-1))/intr)*(1+intr);
    }
    //A series of equal payments, for n periods.
	//Annual compounding and fixed interest rate.
    public static double pvancert(double intr,double n)
    {
        return (1.0-(1/Math.pow((1+intr),n)))/intr;
    }
    public static double pvancertAd(double intr,double n)//Above function with advance
    {
        return ((1.0-(1/Math.pow((1+intr),n)))/intr*(1+intr));
    }
    public static double pvainfprog(double intr,double growth,double value)//perpetuity present value
    {
        return value/intr-growth;
    }
    public static double pvanmult(double intr,double n)//present value increasing annuity
    {
        double value=1/(1+intr);
        return ((pvancertAd(intr,n))-(n*Math.pow(value,n)))/intr;
    }
    public static double effectintp(double annualintr,double p)//calculates the nominal rate
    {
        return Math.pow((1+annualintr),(1/p))-1;
    }
    public static double effectann(double nomnualintr,double p)//returns the nominal rate
    {
        return (Math.pow((1+nomnualintr/p),p)-1);
    }
}

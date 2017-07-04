/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.CoreMath;

/**
 *
 * @author Muddu
 */
public abstract class ContFract {

    public double prec = 1E-30;
    private double nume;
    private double denom;
    private double interim;
    private double lentzval;
    private double oldans;
    private int n = 1;
    double[] vars = new double[2];

    abstract void computeFract(int n);

    public void setInitial(double numerator, double denominator) {
        nume = numerator;
        denom = denominator;
    }

    public void setInt(int n) {
        this.n = n;
    }

    private int getInt() {
        return n;
    }

    public void setFrac(double initial) {
        //initial value of Fn //
        lentzval = initial;
    }

    public double floorvalue(double x) {
        return Math.abs(x) < Csmallnumber.getSmallnumber() ? Csmallnumber.getSmallnumber() : x;
    }

    public double getFrac() {
        return lentzval;
    }

    public void evalFract()// lentzs method..................//
    {
        int i = getInt();
        while (Math.abs(oldans - 1.0) > prec)// terminating criteria //
        {
            computeFract(++i);//set up the a, b, x and initial values for //
            denom = floorvalue((vars[1] + vars[0] * denom));//array contains numerator and denominator //
            denom = (1.0 / denom);
            nume = floorvalue((vars[1] + (vars[0] / nume)));
            oldans = nume * denom;
            lentzval *= (nume * denom);// Cn * Dn //
        }
        setFrac(lentzval);
    }

}

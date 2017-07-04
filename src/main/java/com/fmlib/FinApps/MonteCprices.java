/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

import com.fmlib.CoreMath.Genwiener;
import com.fmlib.CoreMath.Itoprocess;

/**
 *
 * @author Muddu
 */
public class MonteCprices {

    public MonteCprices() {
    }

    public MonteCprices(int n) {
        iterations = n;
    }

    public double getValuesim() {
        return finalvalue;
    }

    public double getValuesimln() {
        return finalvalueln;
    }

    public double getValuesimp() {
        return finalvaluep;
    }

    private int iterations;
    private double finalvalue;
    private double finalvalueln;
    private double finalvaluep;

    public double[] simValue(double mean, double sd, double initialvalue, double time) {
        double[] simvalues = new double[iterations];
        Itoprocess ito = new Itoprocess();
        for (int i = 0; i < iterations; i++) {
            simvalues[i] = ito.itoValue(mean, sd, time, initialvalue);
            initialvalue = initialvalue + simvalues[i];
        }
        finalvalue = initialvalue;
        return simvalues;//returns the changes from period to period
    }

    public double[] simValueP(double mean, double sd, double initialvalue, double time) {
        double[] simvalues = new double[iterations];
        Itoprocess ito = new Itoprocess();
        double change;
        for (int i = 0; i < iterations; i++) {
            simvalues[i] = initialvalue;
            change = ito.itoValue(mean, sd, time, initialvalue);
            initialvalue = initialvalue + change;
        }
        finalvalue = initialvalue;
        return simvalues;//returns the new price from period to period
    }

    public double[] simValueln(double mean, double sd, double initialvalue, double time)//continuos time
    {
        double[] simvalues = new double[iterations];
        double so = initialvalue;
        initialvalue = Math.log(initialvalue);
        Genwiener g = new Genwiener();
        mean = ((mean - (sd * sd)) / 2.0);
        sd = (Math.sqrt(time) * sd);
        for (int i = 0; i < iterations; i++) {
            simvalues[i] = initialvalue;
            double change = g.genWienerProc(mean, time, sd);// period to
            //period change
            initialvalue = (change + initialvalue);
        }
        finalvalueln = Math.exp(initialvalue);
        return simvalues;//returns the new prices from period to period
    }

}

/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

/**
 *
 * @author Muddu
 */
public class OptionLimits_1 {

    public OptionLimits_1() {
    }

    public double lowerlimitCall(double stockprice, double rate, double time, double strikeprice) {
        return Math.max((stockprice - PresentValue.pVcont(rate, time, strikeprice)), 0);
    }

    public double[] lowerlimitCall(double[] stockprice, double rate, double time, double[] strikeprice) {
        int indx = 0;
        double[] lowervalues = new double[stockprice.length];
        for (double s : stockprice) {
            lowervalues[indx] = Math.max((s - PresentValue.pVcont(rate, time,
                    strikeprice[indx])), 0);
            indx++;
        }
        return lowervalues;
    }

    public double lowerlimitPut(double stockprice, double rate, double time, double strikeprice) {
        return Math.max((PresentValue.pVcont(rate, time, strikeprice) - stockprice), 0);
    }

    public double[] lowerlimitPut(double[] stockprice, double rate, double time, double[] strikeprice) {
        int indx = 0;
        double[] lowervalues = new double[stockprice.length];
        for (double s : stockprice) {
            lowervalues[indx] = Math.max((PresentValue.pVcont(rate, time,
                    strikeprice[indx]) - s), 0);
            indx++;
        }
        return lowervalues;
    }

}

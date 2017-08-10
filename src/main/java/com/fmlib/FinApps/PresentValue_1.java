/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

/**
 *
 * @author Muddu
 */
public class PresentValue_1 {

    /**
     * Instance of the class*
     */
    public PresentValue_1() {
    }

    public static double pV(double[] discounts, double[] cashflows) {
        double presval = 0;
        for (int i = 0; i < cashflows.length; i++)//returns sum of discounted values
        {
            presval += discounts[i] * cashflows[i];
        }
        return presval;
    }

    public static double pV(double r, double[] cashflows)//implements PV for given IR
    {
        int indx = 1;
        double sum = 0;
        for (int i = 0; i < cashflows.length; i++) {
            sum += (cashflows[i] / Math.pow((1 + r), indx));
            indx++;
        }
        return sum;
    }

    public static double pV(double r, double cash, int period) {
        double sum = 0;
        int indx = 1;
        for (int i = 0; i < period; i++) {
            sum += (cash / Math.pow(1 + r, indx));
            indx++;
        }
        return sum;
    }

    public static double pVonecash(double[] discounts, double cashflow) {
        int i = 0;
        double pv = 0;
        for (double d : discounts) {
            pv += (Math.exp(-(i + 1) * Math.log(1.0 + (d / 100.0))) * cashflow);
            i++;
        }
        return pv;
    }

    public static double pVcont(double reporate, double d, double deliveryprice) {
        return (deliveryprice / Math.exp(reporate * d));
    }
    public static double pVcont(double reporate, double d) {
         return (1/ Math.exp(reporate * d));
    }
}

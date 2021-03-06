/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

import com.fmlib.BaseStats.Probnorm;


/**
 *
 * @author Muddu
 */
public class Timeswop {

    public Timeswop(int mperiod, int dayterm, double yield) {
        m = mperiod;
        crate = yield;
        daycount = dayterm;
    }

    private int m;
    private double q;
    private int daycount;
    private double brate = 0.0;
    private double crate = 0.0;

    public double cTswitch(double s, double x, double accumulate, double tmaturity, double rate, double volatility) {
        Probnorm p = new Probnorm();
        brate = crate < 0.0 ? 0.0 : (brate = crate != rate ? (rate - crate) : rate);
        double deltat = (1.0 / daycount);
        int n = (int) (tmaturity / deltat);
        //discards fraction..rounds down to o
        double d = 0.0;
        double sum = 0.0;
        double call = 0.0;
        double prevalue = (deltat * accumulate * Math.exp(-rate * tmaturity) * m);
        for (int i = 1; i < n + 1; i++) {
            d = ((Math.log(s / x) + (brate - ((volatility * volatility) * 0.5)) * i * deltat) / (volatility * Math.sqrt(i * deltat)));
            sum += (p.ncDisfnc(d) * deltat);
        }
        return (accumulate * Math.exp(-rate * tmaturity) * sum + prevalue);
    }

    public double pTswitch(double s, double x, double accumulate, double tmaturity, double rate, double volatility) {
        Probnorm p = new Probnorm();
        brate = crate < 0.0 ? 0.0 : (brate = crate != rate ? (rate - crate) : rate);
        double deltat = (1.0 / daycount);
        int n = (int) (tmaturity / deltat);
        //discards fraction..rounds down to o
        double d;
        double sum = 0.0;
        double put = 0.0;
        double prevalue = (deltat * accumulate * Math.exp(-rate * tmaturity) * m);
        for (int i = 1; i < n + 1; i++) {
            d = ((-Math.log(s / x) - (brate - ((volatility * volatility) * 0.5)) * i * deltat) / (volatility * Math.sqrt(i * deltat)));
            sum += (p.ncDisfnc(d) * deltat);
            put = (accumulate * Math.exp(-rate * tmaturity) * sum + prevalue);
        }
        return put;
    }

}

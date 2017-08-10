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
public class Cashornonop {

    //Cash-or-Nothing Two-Asset Correlated Option Valuation
    public Cashornonop(double rate, double yield, double time) {
        r = rate;
        crate = yield;
        t = time;
        b = crate == 0.0 ? 0.0 : (b = crate != r ? (r - crate) : r);
    }

    double b;
    double crate;
    double r;
    double t;

    public double cashornoCall(double s, double x, double sigma, double payout) {
        return payout * Math.exp(-r * t) * N(d(s, x, sigma));
    }

    public double cashornoPut(double s, double x, double sigma, double payout) {
        return payout * Math.exp(-r * t) * N(-d(s, x, sigma));
    }

    private double d(double s, double x, double sigma) {
        double sig = (sigma * sigma);
        double f = (Math.log(s / x) + ((b - sig * 0.5) * t)) / (sigma * Math.sqrt(t));
        return f;
    }

    private double N(double x) {
        Probnorm p = new Probnorm();
        double ret = x > (6.95) ? 1.0 : x < (-6.95) ? 0.0 : p.ncDisfnc(x);
        //restrict the range of cdf values to stable values
        return ret;
    }

}

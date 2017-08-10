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
public class Chosersimple {

    public Chosersimple(double yield, double choicetime) {
        crate = yield;
        time = choicetime;
    }

    private double crate;
    private double time;
    private double brate = 0.0;

    public double simpChose(double s, double x, double tmaturity, double rate, double volatility) {
        Blackscholecp b = new Blackscholecp(crate);
        Probnorm p = new Probnorm();
        b.bscholEprice(s, x, volatility, tmaturity, rate);
        double call = b.getCalle();
        double put = b.getPute();
        brate = crate == 0.0 ? 0.0 : (brate = crate != rate ? (rate - crate) : rate);
        double d;
        double y;
        d = ((Math.log(s / x) + (brate + (volatility * volatility) * 0.5) * tmaturity) / (volatility * Math.sqrt(tmaturity)));
        y = ((Math.log(s / x) + (brate * tmaturity) + ((volatility * volatility) * time) * 0.5) / (volatility * Math.sqrt(time)));
        double probd = p.ncDisfnc(d);
        double probdmv = p.ncDisfnc(d - volatility * Math.sqrt(tmaturity));
        double probdmy = p.ncDisfnc(-y + volatility * Math.sqrt(time));
        double proby = p.ncDisfnc(-y);
        double w = (s * Math.exp((brate - rate) * tmaturity) * probd - x * Math.exp(-rate * tmaturity) * probdmv - s * Math.exp((brate - rate) * tmaturity) * proby + x * Math.exp(-rate * tmaturity) * probdmy);
        return w;
    }

}

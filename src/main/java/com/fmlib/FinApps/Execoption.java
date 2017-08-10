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
public class Execoption {

    public Execoption(double jrate) {
        jump = jrate;
    }

    private double jump;
    private double callprice;
    private double callpricefm;
    private double putprice;

    public double getExcall() {
        return callprice;
    }

    public double getExcallfm() {
        return callpricefm;
    }

    public double getExput() {
        return putprice;
    }

    private void setCall(double call) {
        callprice = call;
    }

    private void setCallfm(double call) {
        callpricefm = call;
    }

    private void setPut(double put) {
        putprice = put;
    }

    public void execOpt(double s, double x, double volatility, double time, double rate, double yield) {
        //Jennergren & Naslund (1993)
        Blackscholecp b = new Blackscholecp(yield);
        b.bscholEprice(s, x, volatility, time, rate);
        setCall((Math.exp(-jump * time) * (b.getCalle())));
        setPut((Math.exp(-jump * time) * (b.getPute())));
    }

    public void execOptfm(double s1, double s2, double r, double sig1, double sig2, double time) {
        // after Fischer- Margrabe (1978) for index
        //-linked compensation
        Probnorm p = new Probnorm();
        double sigs = ((sig1 * sig1) - 2.0 * jump * sig1 * sig2 + (sig2 * sig2));
        double sigma = Math.sqrt(sigs);
        double d1 = ((Math.log(s1 / s2) + (sigs * time)) / (sigma * Math.sqrt(time)));
        double d2 = (d1 - sigma * Math.sqrt(time));
        double n = p.ncDisfnc(d1);
        double n2 = p.ncDisfnc(d2);
        double c = (s1 * n - s2 * n2);
        setCallfm(c);
    }

    public static void main(String[] args) {
        Execoption e = new Execoption(0.12);
        e.execOpt(50.0, 60.0, 0.30, 3.0, 0.05, 0.03);
        System.out.println("ANS==" + e.getExcall());
    }

}

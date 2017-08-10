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
public class Vasicekop {

    public Vasicekop(double meanrev, double revlevel,
            double volatility, double starttime) {
        a = meanrev;
        theta = revlevel;
        sigma = volatility;
        start = starttime;
    }

    private double a;
    private double theta;
    private double sigma;
    private double start;
    private double pstart;
    private double pmat;
    private double h;
    private double hw;
    private double bondvol;
    private double bondvolw;
    private double btstart;
    private double bmaturity;
    double bexpiry;

    private void vasiParams(double f, double x, double rate, double time, double tmaturity) {
        btstart = ((1.0 - Math.exp(-a * (time - start))) / a);
        bexpiry = ((1.0 - Math.exp(-a * (tmaturity - time))) / a);
        bmaturity = ((1.0 - Math.exp(-a * (tmaturity - start))) / a);
        double startat1 = ((btstart - time + start) * (((a * a) * theta) - ((sigma * sigma) * 0.5)) / (a * a));
        double startat2 = (((sigma * sigma) * (btstart * btstart)) / (4 * a));
        double starta = Math.exp(startat1 - startat2);
        double matat1 = ((bmaturity - tmaturity + start) * (((a * a) * theta) - ((sigma * sigma) * 0.5)) / (a * a));
        double matat2 = (((sigma * sigma) * (bmaturity * bmaturity)) / (4 * a));
        double mata = Math.exp(matat1 - matat2);
        pstart = (starta * Math.exp(-btstart * rate));
        pmat = (mata * Math.exp(-bmaturity * rate));
        bondvol = (bexpiry * (Math.sqrt((sigma * sigma) * (1.0 - Math.exp(-2 * a * (time - start))) / (2 * a))));
        h = ((1.0 / bondvol) * Math.log((pmat * f) / (pstart * x)) + (bondvol * 0.5));
    }

    public double vasiCall(double f, double x, double rate, double time, double tmaturity) {
        Probnorm p = new Probnorm();
        vasiParams(f, x, rate, time, tmaturity);
        return ((f * pmat * p.ncDisfnc(h))
                - (x * pstart * p.ncDisfnc(h - bondvol)));
    }

    public double vasiPut(double f, double x, double rate, double time, double tmaturity) {
        Probnorm p = new Probnorm();
        vasiParams(f, x, rate, time, tmaturity);
        return ((x * pstart * p.ncDisfnc(-h + bondvol))
                - (f * pmat * p.ncDisfnc(-h)));
    }

    public static void main(String[] args) {
        Vasicekop v = new Vasicekop(0.055, 0.095, 0.04, 0.0);
        double returnvalue = v.vasiCall(110.0, 100.0, 0.085, 3.0, 4.0);
        System.out.println(" CALL ==" + returnvalue);
    }

}

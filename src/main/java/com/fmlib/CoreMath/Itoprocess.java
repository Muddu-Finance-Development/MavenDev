/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.CoreMath;

/**
 *
 * @author Muddu
 */
public class Itoprocess {

    public Itoprocess() {
    }

    private double sdchange;
    private double meanvalue;
    private double changebase;

    private void setChange(double changevalue) {
        changebase = changevalue;
    }

    public double getBaseval() {
        return changebase;
    }

    private void setSd(double sd) {
        sdchange = sd;
    }

    public double getSd() {
        return sdchange;
    }

    private void setMean(double drift) {
        meanvalue = drift;
    }

    public double getMean() {
        return meanvalue;
    }
    /**
	*
	* @param mu mean value
	* @param sigma The variance
	* @param timedelta time periods for each step
	* @param basevalue the starting value
	* @return The change in the base value
	*/

    public double itoValue(double mu, double sigma, double timedelta, double basevalue) {
        setSd(basevalue * (sigma * Math.sqrt(timedelta)));
        Genwiener g = new Genwiener();
        mu = mu * basevalue;
        sigma = sigma * basevalue;
        double change = (g.genWienerProc(mu, timedelta, sigma));
        setChange(change);
        setMean(g.getDrift());
        return change;
    }
}

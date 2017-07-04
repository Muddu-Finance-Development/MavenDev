/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.CoreMath;

/**
 *
 * @author Muddu
 */
public class Genwiener {

    public Genwiener() {
    }

    private double constdrift;
    private double wienervalue;

    private void setDrift(double driftval) {
        constdrift = driftval;
    }

    public double getDrift() {
        return constdrift;
    }

    private void setWiener(double wienval) {
        wienervalue = wienval;
    }

    public double getWienerVal() {
        return wienervalue;
    }

    public double genWienerProc(double drift, double t, double sd) {
        Wiener w = new Wiener();
        double deltaz;
        double driftvalue;
        double deltax;
        deltaz = w.wienerProc(t);
        setWiener(deltaz);
        driftvalue = drift * t;
        setDrift(driftvalue);
        deltax = (driftvalue + (sd * deltaz));
        return deltax;
    }

}

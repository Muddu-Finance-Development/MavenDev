/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

/**
 *
 * @author Muddu
 */
public class Duration_1 {

    public Duration_1() {
        this.frequency = 2.0;
    }

    public Duration_1(double couponfreq) {
        this.frequency = couponfreq;
    }

    private void setMDyears(double mdperiods) {
        this.mdyrs = mdperiods / frequency;
    }

    public double getMDyears() {
        return mdyrs;
    }

    public double getMDmodyrs() {
        return modmdyrs;
    }

    private void setMDmodyrs(double mdyears, double discvalue) {
        this.modmdyrs = mdyears / discvalue;
    }

    private void setDduration(double modurationyrs, double price) {
        this.dolduration = ((modurationyrs * price) / 1e4);
    }

    public double getDolduration() {
        return dolduration;
    }

    private void setPerchange(double moduration) {
        this.percentchange = -moduration;
    }

    public double getPerchange(double basispoints) {
        return 100 * (percentchange * basispoints);
    }

    private double percentchange;
    private double dolduration;
    private double modmdyrs;
    private double mdyrs;
    private double frequency;

    /**
     * Requires the yield and coupon as a decimal value
     */
    public double duration(double yield, double period, double parprice, double coupon) {
        double val = 0;
        Volatility v = new Volatility(parprice, frequency);
        double bondprice = v.bondPrice((yield * 100.0), period, (coupon * 100.0));
        yield = yield / frequency;
        coupon = coupon / frequency;
        int n = (int) (period * frequency);
        val = (n * (PresentValue.pV(yield, parprice, n) / bondprice));
        for (int i = 1; i < (n + 1); i++) {
            double value = ((PresentValue.pV(yield, (coupon * parprice), i)) / bondprice);
            val += ((PresentValue.pV(yield, (coupon * parprice), i)) / bondprice);
            // individual period cash flows
        }
        setMDyears(val);
        setMDmodyrs(getMDyears(), (1 + yield));
        setDduration(getMDmodyrs(), bondprice);
        setPerchange(getMDmodyrs());
        return val;
    }

}

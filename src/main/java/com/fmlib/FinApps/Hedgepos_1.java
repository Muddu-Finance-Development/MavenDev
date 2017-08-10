/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

/**
 *
 * @author Muddu
 */
public class Hedgepos_1 {

    public Hedgepos_1() {
    }

    private double coveredcall;
    private double[] coveredcalls;
    private double revcoveredcall;
    private double[] revcoveredcalls;
    private double protectedput;
    private double[] protectedputs;
    private double revprotectedput;
    private double[] revprotectedputs;

    private void setProtectput(double profitvalue) {
        protectedput = profitvalue;
    }

    private void setProtectput(double[] profitvalue) {
        protectedputs = profitvalue;
    }

    private void setrevProtectput(double profitvalue) {
        revprotectedput = profitvalue;
    }

    private void setrevProtectput(double[] profitvalue) {
        revprotectedputs = profitvalue;
    }

    public double getProtectedput() {
        return protectedput;
    }

    public double[] getProtectedputs() {
        return protectedputs;
    }

    public double getrevProtectedput() {
        return revprotectedput;
    }

    public double[] getrevProtectedputs() {
        return revprotectedputs;
    }

    private void setCoveredcall(double profitvalue) {
        coveredcall = profitvalue;
    }

    private void setrevCoveredcall(double profitvalue) {
        revcoveredcall = profitvalue;
    }

    public double getCoveredcall() {
        return coveredcall;
    }

    public double getrevCoveredcall() {
        return revcoveredcall;
    }

    private void setCoveredcalls(double[] profitvalues) {
        coveredcalls = profitvalues;
    }

    private void setrevCoveredcalls(double[] profitvalues) {
        revcoveredcalls = profitvalues;
    }

    public double[] getCoveredcalls() {
        return coveredcalls;
    }

    public double[] getrevCoveredcalls() {
        return revcoveredcalls;
    }

    public void covercall(double costofstock, double strike, double stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        p.callprof(costofoption, strike, stockprice);
        double stockprofit = p.getShortcallprofit();
        double profit = costofstock <= stockprice ? (-costofstock + stockprice) : (stockprice - costofstock);
        setCoveredcall(profit + stockprofit);
    }

    public void covercall(double costofstock, double strike, double[] stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        int indx = 0;
        double[] profits = new double[stockprice.length];
        double[] optionvalues = new double[stockprice.length];
        p.callprof(costofoption, strike, stockprice);
        optionvalues = p.getShortcallprofits();
        for (double s : stockprice) {
            double profit = costofstock <= stockprice[indx] ? (-costofstock + stockprice[indx]) : (stockprice[indx] - costofstock);
            profits[indx] = (optionvalues[indx] + profit);
            indx++;
        }
        setCoveredcalls(profits);
    }

    public void revcovercall(double costofstock, double strike, double stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        p.callprof(costofoption, strike, stockprice);
        double stockprofit = p.getLongcallprofit();
        double profit = (costofstock - stockprice);
        setrevCoveredcall(profit + stockprofit);
    }

    public void revcovercall(double costofstock, double strike, double[] stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        int indx = 0;
        double[] profits = new double[stockprice.length];
        double[] optionvalues = new double[stockprice.length];
        p.callprof(costofoption, strike, stockprice);
        optionvalues = p.getLongcallprofits();
        for (double s : stockprice) {
            double profit = (costofstock - stockprice[indx]);
            profits[indx] = (optionvalues[indx] + profit);
            indx++;
        }
        setrevCoveredcalls(profits);
    }

    public void protectedput(double costofstock, double strike, double stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        p.callprof(costofoption, strike, stockprice);
        double stockprofit = p.getLongputprofit();
        double profit = costofstock <= stockprice ? (-costofstock + stockprice) : (stockprice - costofstock);
        setProtectput(profit + stockprofit);
    }

    public void protectedput(double costofstock, double strike, double[] stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        int indx = 0;
        double[] profits = new double[stockprice.length];
        double[] optionvalues = new double[stockprice.length];
        p.putprof(costofoption, strike, stockprice);
        optionvalues = p.getLongputprofits();
        for (double s : stockprice) {
            double profit = costofstock <= stockprice[indx] ? (-costofstock + stockprice[indx]) : (stockprice[indx] - costofstock);
            profits[indx] = (optionvalues[indx] + profit);
            indx++;
        }
        setProtectput(profits);
    }

    public void revprotectedput(double costofstock, double strike, double stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        p.putprof(costofoption, strike, stockprice);
        double stockprofit = p.getSputprofit();
        double profit = (costofstock - stockprice);
        setrevProtectput(profit + stockprofit);
    }

    public void revprotectedput(double costofstock, double strike, double[] stockprice, double costofoption) {
        Putcallpos p = new Putcallpos();
        int indx = 0;
        double[] profits = new double[stockprice.length];
        double[] optionvalues = new double[stockprice.length];
        p.putprof(costofoption, strike, stockprice);
        optionvalues = p.getSputprofits();
        for (double s : stockprice) {
            double profit = (costofstock - stockprice[indx]);
            profits[indx] = (optionvalues[indx] + profit);
            indx++;
        }
        setrevProtectput(profits);
    }

}

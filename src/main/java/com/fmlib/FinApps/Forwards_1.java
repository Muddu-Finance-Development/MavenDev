/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

/**
 *
 * @author Muddu
 */
public class Forwards_1 {

    public Forwards_1() {
    }

    public static double dollarIntr(double term, double reporate) {
        return reporate * (term / 360.0);
    }

    public static double delpriceNoinc(double spotprice, double maturity, double reporate) {
        return (spotprice * conintr(reporate, maturity));
    }

    private static double conintr(double reporate, double maturity) {
        return Math.exp(maturity * reporate);
    }

    public static double fpriceNoinc(double spotprice, double maturity, double currentime, double deliveryprice, double reporate) {
        return (spotprice - (PresentValue.pVcont(reporate, (maturity - currentime),
                deliveryprice)));
    }

    public static double fpriceInc(double spotprice, double maturity, double currentime, double reporate, double period, double dividend) {
        double income = 0.0;
        income = maturity == 1.0 ? PresentValue.pVcont(reporate, 1.0, dividend) : 0.0;
        double limit = 0.0;
        limit = (maturity - currentime);
        double time = (period / 12.0);
        double increment = time;
        while (time < limit) {
            income += PresentValue.pVcont(reporate, time, dividend);
            time = time + increment;
        }
        return ((spotprice - income) * (conintr(reporate,
                (maturity - currentime))));
    }

    public static double fpriceInc(double spotprice, double maturity, double currentime, double[] reporate, double period, double dividend) {
        double income = 0.0;
        double limit = 0.0;
        double forwardprice = 0.0;
        limit = (maturity - currentime);
        double time = (period / 12.0);
        double increment = time;
        for (double r : reporate) {
            income += PresentValue.pVcont(r, time, dividend);
            time = time + increment;
        }
        return ((spotprice - income) * (conintr(reporate[(reporate.length - 1)], (maturity - currentime))));
    }

    public static double fvalueInc(double spotprice, double maturity, double currentime, double reporate, double period, double dividend, double deliveryprice) {
        double income = 0.0;
        income = maturity == 1.0 ? PresentValue.pVcont(reporate, 1.0, dividend) : 0.0;
        double limit = 0.0;
        limit = (maturity - currentime);
        double time = (period / 12.0);
        double increment = time;
        while (time < limit) {
            income += PresentValue.pVcont(reporate, time, dividend);
            time = time + increment;
        }
        return ((spotprice - income) - (deliveryprice * PresentValue.pVcont(reporate, (maturity - currentime))));
    }

    public static double fvalueInc(double spotprice, double maturity, double currentime, double[] reporate, double period, double dividend, double deliveryprice) {
        double income = 0.0;
        double forwardprice = 0.0;
        double time = (period / 12.0);
        double increment = time;
        for (double r : reporate) {
            income += PresentValue.pVcont(r, time, dividend);
            time = time + increment;
        }
        return (spotprice - (income + (deliveryprice * PresentValue.pVcont(reporate[(reporate.length - 1)], (maturity - currentime)))));
    }
    // Also parity rate calculation

    public static double fvaluegen(double fprice, double delivprice, double maturity, double currentime, double reporate) {
        return ((fprice - delivprice) * PresentValue.pVcont(reporate, (maturity - currentime)));
    }

    public static double fpriceDyld(double spotprice, double maturity, double currentime, double reporate, double dividendyld) {
        return (spotprice * conintr((reporate - dividendyld), (maturity - currentime)));
    }

    public static double fvalueDyld(double spotprice, double maturity, double currentime, double reporate, double dividendyld, double deliveryprice) {
        return ((fpriceDyld(spotprice, maturity, currentime, reporate, dividendyld) - (deliveryprice)) * PresentValue.pVcont(reporate, (maturity - currentime)));
    }

}

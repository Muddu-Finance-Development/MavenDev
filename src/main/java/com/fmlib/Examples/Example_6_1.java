/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import com.fmlib.FinApps.OptionLimits;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Example_6_1 {

    public Example_6_1() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        OptionLimits ops = new OptionLimits();
        double[] stockprice = {51.0, 50.0, 52.3, 53.6, 51.0};
        double[] strikeprice = {50.0, 49.5, 51.5, 52.5, 50.5};
        double time = 0.5;
        double interest = 0.13;
        double[] premiums = ops.lowerlimitCall(stockprice, interest, time, strikeprice);
        for (double pr : premiums) {
            System.out.println("Call option premium per sahre ==" + formatter.format(Math.max(pr, 0)));
        }
    }

}

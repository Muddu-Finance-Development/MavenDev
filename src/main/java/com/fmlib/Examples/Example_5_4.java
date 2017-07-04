/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import static com.fmlib.FinApps.Forwards.fpriceDyld;
import static com.fmlib.FinApps.Forwards.fvalueDyld;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Example_5_4 {

    public Example_5_4() {
    }	

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(3);
        double forprice = fpriceDyld(29.50, 0.50, 0.0, 0.105, 0.05);
        double forvalue = fvalueDyld(29.50, 0.50, 0.0, 0.105, 0.05, 31.0);
        System.out.println("Long value == " + (formatter.format(forvalue)) + "Forward price : "+(formatter.format(forprice)));
	}
}

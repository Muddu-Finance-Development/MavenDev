/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import static com.fmlib.FinApps.Forwards.fpriceInc;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Example_6_11 {

    public Example_6_11() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(3);
        double futuresprice = fpriceInc(843.0, 1.0, 0.0, 0.015, 12.0, -6.80);
        System.out.println("Futures price for commodity = " + futuresprice);
    }

}

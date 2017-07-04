/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import static com.fmlib.FinApps.Forwards.fpriceDyld;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Example_5_10 {

    public Example_5_10() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(3);
        double futureprice = fpriceDyld(1.7830, 0.25, 0.0, 0.015, 0.0475);
        System.out.println("Futures price for the currency = " + formatter.format(futureprice));
    }

}

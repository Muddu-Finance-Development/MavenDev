/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import static com.fmlib.FinApps.Forwards.fpriceInc;
import static com.fmlib.FinApps.Forwards.fvalueInc;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Example_5_2 {

    public Example_5_2() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(3);
        double forprice = fpriceInc(60.50, 0.833, 0.0, 0.06, 3.0, 0.50);
        System.out.println("Forward price for income bearing security= " + formatter.format(forprice));
        double forvalue = fvalueInc(60.50, 0.833, 0.0, 0.06, 3.0, 0.50, 61.0);
        System.out.println("Forward value for income bearing security= " + formatter.format(forvalue));
    }

}

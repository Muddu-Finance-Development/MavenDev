/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import com.fmlib.FinApps.Optconvex;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Example_6_3 {

    public Example_6_3() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        formatter.setMinimumFractionDigits(3);
        Optconvex conv = new Optconvex();
        double prices[][] = {{420.0, 8.25}, {430.0, 4.75}, {440.0, 2.375}};
        double convalue = conv.convexcheck(prices);
        String s = (4.75 <= convalue) ? "OPTION DATA IS CONVEX: value " : "OPTION DATA NOT CONVEX: value ";
        System.out.println(s + convalue);
    }

}

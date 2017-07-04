/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import com.fmlib.CoreMath.Itoprocess;

/**
 *
 * @author Muddu
 */
public class Example_7_0 {

    public Example_7_0() {

    }

    public static void main(String[] args) {
        Itoprocess i = new Itoprocess();
        i.itoValue(0.1, 0.2, 0.0192, 65.0);
        System.out.println("NEW StockPrice == " + (65.0 + i.getBaseval()) + " for change of " + i.getBaseval() + " from a mean of " + i.getMean() + " and a standard deviation of " + i.getSd());
    }
}

/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import com.fmlib.FinApps.Volatility;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Exercise_3_5 {

    public Exercise_3_5() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(4);
        double currentprice;
        double par;
        try {
            PrintWriter w = new PrintWriter(new FileWriter("/Users/Muddu/data/Ex2_8data.txt"), true);
            double[] coups = {2.0, 5.0, 8.0, 9.0, 10.0};
            double[] maturity = {3.0, 5.0, 7.0, 15.0, 30.0};
            par = 100.0;
            double yield = 5.0;
            Volatility v = new Volatility(100.0, 2.0);
            System.out.println("Coupon initial Price Plus PVBP Less PVBP Maturity");
            while (yield < 11.0) {
                for (double d : coups) {
                    for (double f : maturity) {
                        v.pVbPoints(yield, f, d, 1.0);
                        currentprice = v.getCurrentPvb();
                        double up = v.getRelativeValue();
                        double down = v.getRelativeValuelow();
                        w.println(f + "," + formatter.format(currentprice));
                        System.out.println(" " + d + " $" + formatter.format(currentprice) + " $" + formatter.format(v.getRelativeValue()) + " $" + formatter.format(v.getRelativeValuelow()) + " " + f + " " + formatter.format(v.getUpPp()) + " " + formatter.format(v.getValuePUp()));
                    }
                }
                yield += yield;
            }
            w.println(" ");
        } catch (IOException foe) {
            System.out.println(foe);
        }
    }

}

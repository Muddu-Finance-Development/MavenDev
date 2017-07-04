/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import com.fmlib.FinApps.NewtonYield;
import com.fmlib.FinApps.Spread;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Exercise_3_3 {

    public Exercise_3_3() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(3);
        Spread ss = new Spread();
        double facevalue = 100.0;
        double terms = 6.0;
        double coupon = 8.0;
        double maturity = 11.0;
        int counter = 0;
        double[] testprices = {97.5, 98.0, 98.5, 99.0, 99.5, 100.0, 100.5, 101.0, 101.5, 102.0, 102.5};
        double[] aa = new double[testprices.length];
        double testspots[] = {2.5, 2.8, 3.0, 3.5, 3.8, 4.0, 4.9, 5.5, 6.5, 7.9, 8.9};
        double sptest[] = new double[testspots.length];
        double[] newspot = new double[testspots.length];
        double pcstat = ss.spreadsT(testspots, 100.0, 11, 8.0, 4.0);
        NewtonYield ct = new NewtonYield(0.06,1e-6,20);
        double yldpc = ct.yieLd(facevalue, terms, coupon, 100.0, maturity);
        double yldtr = ct.yieLd(facevalue, terms, coupon, 103.795, maturity);
        System.out.println("Static spread for 100.0 price==" + formatter.format(pcstat) + " YTM for the 100 cor bond==" + formatter.format(yldpc) + "YTM for the low risk bond==" + formatter.format(yldtr));
        System.out.println("Static spread for P=100.0:" + formatter.format(pcstat));
        System.out.println("Yield to Maturity for Corporate Bond with price=100.0 :" + formatter.format(yldpc));
        System.out.println("Yield to Maturity of the Treasury Bond with price=103.795 :" + formatter.format(yldtr));
        aa = ss.spreadrateS(testspots, testprices, 8.0, 11, 3.0);
        sptest = ss.spreadrateT(testspots, testprices, 8.0, 11, 2.0);
        System.out.println("Price(%of PAR) Static Spread Yield Spread");
        for (double d : testprices) {
            NewtonYield t = new NewtonYield(0.02,1e-6,20);
            double yields = t.yieLd(facevalue, terms, coupon, d, maturity);
            double sprd = aa[counter];
            double stat = sptest[counter];
            System.out.println(" " + formatter.format(d) + " " + formatter.format(stat) + " " + formatter.format(sprd));
            counter++;
        }
        formatter.setMaximumFractionDigits(3);
        formatter.setMinimumFractionDigits(3);
        int indx = 0;
        counter = 0;
        System.out.println("Spot :Spread=Adjusted rate Price Original");
        for (double f : sptest) {
            for (double d : testspots) {
                System.out.println(" " + formatter.format(d) + " " + formatter.format(f) + " " + formatter.format(d + f) + " - " + " - ");
                newspot[counter] = (d + f);
                counter++;
            }
            double newpriced = ss.spotPvannualT(newspot, 8.0, 2.0);
            System.out.println(" " + formatter.format(newpriced) + " " + formatter.format(testprices[indx]));
            indx++;
            counter = 0;
        }
    }

}

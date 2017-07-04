/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import java.text.NumberFormat;
import com.fmlib.FinApps.Volatility;
import static com.fmlib.InterestRate.Intr.*;

/**
 *
 * @author Muddu
 */
public class Exercise_2_9 {

    public Exercise_2_9() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        formatter.setMinimumFractionDigits(3);
        Volatility vol = new Volatility();
        double increase, decrease;
        double[] reqrdyield = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13};
        double[] yieldincrease = {2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 17};
        double coupon = 10, coupon2 = 50;
        int i = 0;
        double pv, par, pv2, par2;
        System.out.println("YIELD PRICE(10yr) PRICE(5yr) INCREASE(10yr) INCREASE(5yr) DECREASE(10yr) DECREASE(5yr)");
        for (double d : reqrdyield) {
            pv = coupon * pvancert((d / 100) / 2.0, 2 * 10);
            par = 1000 * (1.0 / Math.pow(1.0 + (d / 100) / 2, 2 * 10));
            pv2 = coupon2 * pvancert((d / 100) / 2.0, 2 * 5);
            par2 = 1000 * (1.0 / Math.pow(1.0 + (d / 100) / 2, 2 * 5));
            double tendecrease = vol.percentVolatility(d, 10, 6, (yieldincrease[i] - d) * 100.0);
            double tenincrease = vol.percentVolatility(yieldincrease[i], 10, 6, -(yieldincrease[i] - d) * 100.0);
            double fivedecrease = vol.percentVolatility(d, 5, 6, (yieldincrease[i] - d) * 100.0);
            double fiveincrease = vol.percentVolatility(yieldincrease[i], 5, 6, -(yieldincrease[i] - d) * 100.0);
            System.out.println(formatter.format(d) + "   " + formatter.format(pv + par) + "  " + formatter.format(pv2 + par2) + "    " + formatter.format(tenincrease) + "  " + formatter.format(fiveincrease) + "  " + formatter.format(tendecrease) + "   " + formatter.format(fivedecrease));
            i++;
        }
        System.out.println("YIELD PRICE(2%) PRICE(10%)");
        for (double d : reqrdyield) {
            pv = coupon * pvancert((d / 100.0) / 2, 2 * 15);
            par = 1000 * (1.0 / Math.pow(1.0 + (d / 100.0) / 2, 2 * 15));
            pv2 = coupon2 * pvancert((d / 100.0) / 2, 2 * 15);
            par2 = 1000 * (1.0 / Math.pow(1.0 + (d / 100.0) / 2, 2 * 15));
            double marktprice = (pv + par);
            double marktprice2 = (pv2 + par2);
            System.out.println(formatter.format(d) + "  " + formatter.format(pv + par) + "   " + formatter.format(pv2 + par2));
        }
    }

}

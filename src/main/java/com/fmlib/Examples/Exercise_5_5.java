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
public class Exercise_5_5 {
    public Exercise_5_5(){
    }
    public static void main(String[] args){
        NumberFormat formatter=NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(3);
        double futureprice=fpriceDyld(1103.30,0.25,0.0,0.042,0.033);
        System.out.println("Futures price for the index = "+formatter.format(futureprice));
    }
}

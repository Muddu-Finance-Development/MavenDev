/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.Examples;

import com.fmlib.FinApps.PutCallpar;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Example_6_4 {

    public Example_6_4() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        formatter.setMinimumFractionDigits(3);
        PutCallpar parp = new PutCallpar("put");
        double ansput = parp.europarity(3.5, 28.0, 30.0, 0.1, 0.5);
        System.out.println("PUT PRICE IS == " + ansput);
        PutCallpar parc = new PutCallpar("call");
        double anscall = parc.europarity(ansput, 28.0, 30.0, 0.1, 0.5);
        System.out.println("CALL PRICE IS == " + anscall);
    }

}

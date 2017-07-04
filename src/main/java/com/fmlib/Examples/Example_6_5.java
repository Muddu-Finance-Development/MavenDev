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
public class Example_6_5 {

    public Example_6_5() {
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        formatter.setMinimumFractionDigits(3);
        PutCallpar par = new PutCallpar("put");
        par.amerparity(2.40, 23.0, 21.0, 0.1, 0.25);
        double[] parval = par.getAmerput();
        System.out.println("PUT VALUE UPPER LIMIT ==  " + parval[0] + " PUT VALUE LOWER LIMIT == " + parval[1]);
    }

}

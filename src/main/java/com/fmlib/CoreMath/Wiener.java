/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.CoreMath;

import java.util.Random;

/**
 *
 * @author Muddu
 */
public class Wiener {

    public Wiener() {
    }

    public double wienerProc(double t) {
        Random r = new Random();
        double epsilon = r.nextGaussian();
        return Math.sqrt(t) * epsilon;
    }

}

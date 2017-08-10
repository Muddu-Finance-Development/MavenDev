/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

import com.fmlib.BaseStats.Probnorm;


/**
 *
 * @author Muddu
 */
public class Americbs {

    public Americbs() {
    }

    public Americbs(double carryrate) {
        crate = carryrate;
    }

    double brate;
    double crate = 0.0;
    double beta = 0.0;
    double time;
    double rate;
    double volatility;
    double ib;

    public double amerBs(double s, double x, double sigma, double t, double r, int pc) {
        brate = crate < 0.0 ? 0.0 : (brate = crate != r ? (r - crate) : r);
        return pc < 0 ? (amBs(x, s, sigma, t, (r - brate)))
                : amBs(s, x, sigma, t, r);
    }

    private double amBs(double s, double x, double sigma, double t, double r) {
        if (brate >= r) {
            Blackscholecp b = new Blackscholecp();
            b.bscholEprice(s, x, sigma, t, r);
            return b.getCalle();
        }
        time = t;
        rate = r;
        volatility = sigma;
        double alpha = params(s, x, sigma, t, r);// gets a
        return s >= ib ? alpha : ((alpha * (Math.pow(s, beta))) - (alpha * phi(s, t, beta, ib, ib)) + (phi(s, t, 1, ib, ib)) - (phi(s, t, 1, x, ib)) - (x * phi(s, t, 0, ib, ib)) + (x * phi(s, t, 0, x, ib)));
    }

    private double params(double s, double x, double sigma, double t, double r) {
        beta = ((0.5 - (brate / (sigma * sigma))) + Math.sqrt((Math.pow(((brate / (sigma * sigma)) - 0.5), 2) + (2.0 * (r / (sigma * sigma))))));
        double betinf = ((beta / (beta - 1.0)) * x);
        double bo = (Math.max(x, (r / (r - brate)) * x));
        double h = (-(brate * t + (2.0 * sigma * Math.sqrt(t))) * (bo / (betinf - bo)));
        ib = (bo + (betinf - bo) * (1.0 - Math.exp(h)));
        double a = ((ib - x) * Math.pow(ib, -beta));
        return s >= ib ? (s - x) : a;
    }

    private double phi(double s, double t, double gamma, double eta, double iota) {
        double sigma = volatility;
        double r = rate;
        Probnorm p = new Probnorm();
        double lambda = (-r + gamma * brate + 0.5 * gamma * (gamma - 1.0) * (sigma * sigma)) * t;
        double epsilon = -(Math.log(s / eta) + (brate + (gamma - 0.5) * (sigma * sigma)) * t) / (sigma * Math.sqrt(t));
        double kappa = 2.0 * brate / (sigma * sigma) + (2.0 * gamma - 1.0);
        double retval = Math.exp(lambda) * Math.pow(s, gamma) * (p.ncDisfnc(epsilon) - Math.pow((ib / s), kappa) * p.ncDisfnc(epsilon - 2 * Math.log(ib / s) / (sigma * Math.sqrt(t))));
        return retval;
    }

    public static void main(String[] args) {
        Americbs a = new Americbs(0.09);
        double retc = a.amerBs(82.0, 78.0, 0.32, 0.75, 0.05, 1);
        System.out.println("Value =" + retc);
    }

}

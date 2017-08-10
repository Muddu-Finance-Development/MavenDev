/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.FinApps;

/**
 *
 * @author Muddu
 */
public abstract class Interms_1
{
    public abstract void intermstimes();
    public Interms_1()
    {
    }
    public double disFromyld(double spotrate, double time)
    {
        return Math.exp(-spotrate*time);
    }
    public double yldFromdisc(double discount, double time)
    {
        return -Math.log(discount)/time;
    }
    public double forateFromspts(double spot1, double spot2)
    {
        return (Math.pow((1+spot2),2)/(1+spot1)-1);
    }
    public double forateFromdisc(double discount1, double discount2, double time1, double time2)
    {
        return (Math.log(discount1/discount2)/(time2-time1));
    }
    public double forateFromyld(double r1, double r2, double t1, double t2)
    {
        return(r2*(t2/(t2-t1)))-(r1*(t1/(t2-t1)));
    }
}

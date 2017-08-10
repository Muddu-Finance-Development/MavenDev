/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.FinApps;

import com.fmlib.CoreMath.Interpolate;

/**
 *
 * @author Muddu
 */
public class Intermstructure_1 extends Interms
{
    Interpolate It=new Interpolate();
    private int current_flag=0;
    private double[][]currentdata;
    public Intermstructure_1()
    {
    }
    public double DiscpOne(double interate, double time_1)
    {
        return disFromyld(interate,time_1);
    }
    public double SpotpOne(double interate, double time_1)
    {
        return yldFromdisc(interate,time_1);
    }
    public double Forwdisc(double interate_1,double interate_2,double time_1,double time_2)
    {
        return forateFromdisc(interate_1,interate_2,time_1,time_2);
    }
    public double Forwyld(double interate_1, double interate_2,double time_1,double time_2)
    {
    return forateFromyld(interate_1,interate_2,time_1,time_2);
    }
    public void setCurrentRatedata(double[][]yielddata)
    {
        currentdata=yielddata;
        current_flag=1;
    }
    public double getCurrentDiscOne(double timepoint_1)
    {
        return Errorcheck(timepoint_1)==1?disFromyld(It.lagrange(currentdata,timepoint_1),timepoint_1):0.0;
    }
    public double getCurrentSpotOne(double timepoint_1)
    {
        return Errorcheck(timepoint_1)==1?It.lagrange(currentdata,timepoint_1):0.0;
    }
    public double getCurrentForwardrateYlds(double timepoint_1,double timepoint_2)
    {
        return (Errorcheck(timepoint_1)==1&Errorcheck(timepoint_2)==1)?(forateFromyld(getCurrentSpotOne(timepoint_1),getCurrentSpotOne(timepoint_2),timepoint_1,timepoint_2)):0.0;
    }
    public void Intermstimes()
    {
    }
    private int Errorcheck(double timepoint)
    {
        if(current_flag==0)
        {
            System.out.println("Error:time variable out of data range");
            return 0;
        }
        return 1;
    }

    @Override
    public void intermstimes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
/**For calculating the spot rates, the first method provides spot rate for annual coupons the second provides the addition of period adjustments
 * to the algorithms. parCoupon provides functionality to compute the coupon for a par yield
 */
package com.fmlib.FinApps;
/**
 *
 * @author Muddu
 */
public class Spots 
{
    public Spots()
    {
    }
    public double[] spotFcoupon(double[][] pcdata)
    {
        int n=pcdata.length;
        double[] spots=new double[n];
        double price,indx=1.0;
        spots[0]=((100.0/pcdata[0][0])-1);
        price=pcdata[0][0]/100.0;
        for(int s=1;s<n;s++)
        {
            spots[s]=(Math.exp(1/indx*Math.log((pcdata[s][1]+100.0)/(pcdata[s][0]-(pcdata[s][1]*price))))-1);
            price+=(Math.exp(-indx*Math.log(1+spots[s])));
        }
       return spots;    
    }
    public double[] spotFcoupon(double[][] pcdata,int periods)//for period frequency of annual coupons
    {
        int n=pcdata.length;
        double[] spots=new double[n];
        double price,indx=1.0,temp=0;
        spots[0]=((100.0/pcdata[0][0])-1);
        price=pcdata[0][0]/100.0;
        for(int s=1;s<n;s++)
        {
            spots[s]=(Math.exp(1/indx*Math.log((pcdata[s][1]/periods+100.0)/(pcdata[s][0]-(pcdata[s][1]/periods*price))))-1);
            price+=(Math.exp(-indx*Math.log(1+spots[s])));
        }
        return spots;
    }
    /*returns the n period coupon for par price given the spot rate*/
    public double parCoupon(double[] spots,int nperiod)
    {
        int counter=0,j=0;
        double flowdisc=0.0;
        double finaldisc;
        if(nperiod>spots.length)
        {
            return -1.0;
        }
        finaldisc=(1.0-(Math.exp(-nperiod*Math.log(1.0+spots[(nperiod-1)]))));
        for(double d:spots)
        {
            if(nperiod>j)
            {
                j++;
                flowdisc+=(Math.exp(-j*Math.log(1.0+d)));
            }
        }
        return (finaldisc/flowdisc);
    }
}

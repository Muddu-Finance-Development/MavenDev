/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.Examples;
import com.fmlib.FinApps.Intermstructure;
import com.fmlib.FinApps.Spots;
import com.fmlib.FinApps.Volatility;
import com.fmlib.CoreMath.Interpolate;
/**
 *
 * @author Muddu
 */
public class Exercise_2_4
{
    public Exercise_2_4()
    {
    }
    public static void main(String[] args)
    {
        Intermstructure i=new Intermstructure();
        Interpolate test=new Interpolate();
        Spots s=new Spots();
        Volatility vol=new Volatility(100.0,2.0);
        double[][] xydat={{0.5,1.03},{1.0,1.28},{2.0,1.83},{3.0,2.36}};
        int j=0;
        double mat=0.5;
        double firstpoint=test.lagrange(xydat,1.5);
        double secondpoint=test.lagrange(xydat,2.5);
        double[] yields={1.03,1.28,firstpoint,1.83,secondpoint,2.36};
        double[] coupons={0.0,0.0,(firstpoint-0.4),1.53,(secondpoint-0.3),2.0};
        double[][]pcdata= new double[6][2];
        for(double yld:yields)
        {
            pcdata[j][0]=vol.bondPrice(yld,mat,coupons[j]);
            pcdata[j][1]=coupons[j];
            mat+=0.5;
            j++;
        }
        int n=0;
        double[]ansx=s.spotFcoupon(pcdata,2);
        for(double x:ansx)
        {
            System.out.println("THE SPOT RATE IS == " +(200.0*x)+ " For PRICE == " +pcdata[n][0]+ " and COUPON == "+pcdata[n][1]+" YIELD == "+yields[n]);
            n++;
        }
    }
}

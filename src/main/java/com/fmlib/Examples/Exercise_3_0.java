/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.Examples;
import com.fmlib.FinApps.Accruedconvention;
import java.text.NumberFormat;
import java.util.Calendar;
/**
 *
 * @author Muddu
 */
public class Exercise_3_0
{
    public Exercise_3_0()
    {
        
    }
    @SuppressWarnings("empty-statement")
    enum Markets{
            UStreasury(1),Irishsemi(2),UScorporate(5);
            private final int value;
            Markets(int value)
            {
                this.value=value;
            }
            public int mkt()
            {
                return value;
            }
        };
    public static void main(String[] args)
    {
        NumberFormat formatter=NumberFormat.getIntegerInstance();
        formatter.setMaximumFractionDigits(6);
        formatter.setMinimumFractionDigits(3);
        Calendar settlement=Calendar.getInstance();
        Calendar nextcoupon=Calendar.getInstance();
        settlement.set(2004,5,3);
        nextcoupon.set(2004,10,17);//next Coupon
        double coupon=0.12;
        double couponfrequency=2.0;
        Accruedconvention days=new Accruedconvention();
        for(Markets m:Markets.values())
        {
            days.dayCounts(m.mkt(), settlement, nextcoupon);
            double daytimes=days.getPreviousCouponDays();
            System.out.println("For the "+m+" The accrued % of the coupon=="+formatter.format(daytimes*100.0)+"%"+" accrued value per $100 par == $"+formatter.format((daytimes*coupon/couponfrequency)*100.0));
        }
    }

}

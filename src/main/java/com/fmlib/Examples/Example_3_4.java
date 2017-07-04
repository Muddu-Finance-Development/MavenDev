/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.Examples;
import java.text.NumberFormat;
import com.fmlib.FinApps.Spread;
/**
 *
 * @author Muddu
 */
public class Example_3_4 {
    public Example_3_4()
    {
    }
    public static void main(String[] args)
    {
        NumberFormat formatter=NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(3);
        Spread ss=new Spread();
        double[] risky={92,89,86,83,79};
        double[] riskless={97,95,92,91,89};
        double[] risk=new double[risky.length];
        risk=ss.creditS(riskless,risky);
        int i=0;
        System.out.println("Probability of default is: "+formatter.format(risk[i]));
        for(i=1;i<risk.length;i++)
        {
            System.out.println("Forward probability of default: period"+i+": "+formatter.format(risk[i]));
        }
    }
}

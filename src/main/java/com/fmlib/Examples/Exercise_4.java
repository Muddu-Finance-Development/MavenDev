/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.Examples;

import com.fmlib.FinApps.Duration;
import com.fmlib.FinApps.Volatility;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Exercise_4 {
    public Exercise_4()
    {
      
    }
    public static void main(String[] args){
       NumberFormat formatter=NumberFormat.getNumberInstance();
       formatter.setMaximumFractionDigits(3);
       formatter.setMinimumFractionDigits(3);
       Volatility vol=new Volatility(100.0,2.0);
       Duration d=new Duration();
       try{
           PrintWriter pw=new PrintWriter(new FileWriter("/Users/Muddu/Ex_volpvbp.txt",true));
           PrintWriter w=new PrintWriter(new FileWriter("/Users/Muddu/Ex_duration.txt",true));
           double coups=8.0;
           double maturity=15;
           double[] yields={0.0,0.01,0.02,0.03,0.05,0.10,0.20,0.30,0.50,1.0,2.0,3.0,5.0};
           double par= 100.0;
           double yield=10.0;
           d.duration(yield/100,15,par,coups/100.0);
           System.out.println("Basis points %volatility %duration estimate PVBP PVBP estimate ");
           for(double h: yields){
               double g=h/100;
               double percentvol=vol.percentVolatility(yield,maturity,coups,h*100);
               System.out.println("     "+formatter.format(h*100)+ "    "+formatter.format(+percentvol)+"   "+formatter.format(d.getPerchange(g))+"     "+formatter.format(vol.getRelativeValue())+"    "+formatter.format(d.getDolduration()*h*100.0));
               w.println(formatter.format(h*100)+","+formatter.format(vol.getRelativeValue())+","+formatter.format(d.getDolduration()*h*100.0));
               pw.println(formatter.format(h*100.0)+","+formatter.format(percentvol)+","+formatter.format(Math.abs(d.getPerchange(g))));
           }
           pw.println(" ");
           w.println(" ");
           pw.close();
           w.close();         
           }catch(IOException foe)
           {
               System.out.println(foe);
           }
    }
}

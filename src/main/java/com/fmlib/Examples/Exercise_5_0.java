/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.Examples;

import static com.fmlib.FinApps.Forwards.delpriceNoinc;
import static com.fmlib.FinApps.Forwards.fpriceNoinc;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

/**
 *
 * @author Muddu
 */
public class Exercise_5_0 {
    public Exercise_5_0(){
    }
public static void main(String[] args){
    NumberFormat formatter=NumberFormat.getNumberInstance();
    formatter.setMaximumFractionDigits(4);
    formatter.setMinimumFractionDigits(3);
    double forprice;
    double monthvalue=0.08333;
    double currentime=0;
    double delprice=delpriceNoinc(900.8,0.41665,0.05);
    double delpricenew=delpriceNoinc(910.8,0.41665,0.05);
    forprice=fpriceNoinc(900.8,0.41665,0.41665,919.7628,0.5);
    try{
        PrintWriter pw=new PrintWriter(new FileWriter("/Users/Muddu/data/example5_1a.txt"),true);
        PrintWriter w=new PrintWriter(new FileWriter("/Users/Muddu/data/example5_1b.txt"),true);
        System.out.println("Delivery Price == "+formatter.format(delprice));
        System.out.println("Delivery Price NEW == "+formatter.format(delpricenew));
        for(int i=0;i<6;i++){
            forprice=fpriceNoinc(900.8,0.41665,currentime,delprice,0.05);
            System.out.println("Forward Value == "+formatter.format(forprice));
            pw.println(formatter.format(forprice)+","+formatter.format(currentime));
            currentime+=monthvalue;
        }
        System.out.println("Delivery Price == "+formatter.format(delprice));
        for(int i=0;i<6;i++){
            forprice=fpriceNoinc(910.8,0.41665,currentime,delprice,0.05);
            System.out.println("Forward Value == "+formatter.format(forprice));
            w.println(formatter.format(forprice)+","+formatter.format(currentime));
            currentime+=monthvalue;
        }
        w.println(" ");
        w.close();
    }catch(IOException foe){
        System.out.println(foe);
    }
}
}

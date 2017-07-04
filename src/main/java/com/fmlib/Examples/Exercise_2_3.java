/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
/*Class for implementing the Spots class in FinApps*/
package com.fmlib.Examples;
import com.fmlib.FinApps.Spots;
/**
 *
 * @author Muddu
 */
public class Exercise_2_3 
{
    public Exercise_2_3()
    {
    }
    public static void main(String[] args)
    {
       // NumberFormat formatter=NumberFormatter.getNumberInstance();
      Spots s =new Spots();
      double[][] testdata={{98.736,0.0},{99.908,1.78},{99.735,2.26},{99.908,3.16},{99.822,3.67},{99.675,4.14},{98.759,4.92}};
      double[] ansx=s.spotFcoupon(testdata);
      for(double i:ansx)
      {
          System.out.println("The Spot Rate is "+i);
      }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmlib.CoreMath;

/**
 *
 * @author Muddu
 */
public abstract class Derivative 
{
   public abstract double deriveFunction(double fx);
   public double h;
   public double derivation(double InputFunc)
   {
       double value,x2,x1;
       x2=deriveFunction(InputFunc-h);
       x1=deriveFunction(InputFunc+h);
       value=((x1-x2)/2*h);
       return value;
   }
}

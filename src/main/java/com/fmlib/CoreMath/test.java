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
public class test extends IntervalBisection
{
    public double computeFunction(double rootinput)
    {
	    double solution=2-Math.pow(2,rootinput);
	    return solution;
    }
    public void main(String[] args)
    {
        System.out.println(evaluateRoot(1,0.5));
    }
}

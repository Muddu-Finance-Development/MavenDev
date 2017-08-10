/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */
package com.fmlib.FinApps;

/**
 *
 * @author Muddu
 */
public class PutCallpar_1 {

    public PutCallpar_1() {
    }

    String typeoption = "call";
    double[] Amerput = new double[2];
    double Amercall;

    public PutCallpar_1(String type) {
        this.typeoption = type;
    }

    public double[] getAmerput() {
        return Amerput;
    }

    private void setAmerput(double limitlower, double limithigher) {
        Amerput[0] = limitlower;
        Amerput[1] = limithigher;
    }

    private void setAmercall(double call) {
        Amercall = call;
    }

    public double europarity(double optionprice, double strike, double stcprice, double rate, double time) {
        double putfrmcall = (optionprice + (PresentValue.pVcont(rate, time, strike)) - stcprice);
        double callfrmput = ((optionprice + stcprice) - PresentValue.pVcont(rate, time, strike));
        return (typeoption == "put") ? putfrmcall : callfrmput;
    }

    public void amerparity(double optionprice, double strike, double stcprice, double rate, double time) {
        if (typeoption == "put") {
            double limit1 = Math.abs((stcprice - strike)) + optionprice;
            double limit2 = Math.abs((stcprice - PresentValue.pVcont(rate, time,
                    strike))) + optionprice;
            setAmerput(limit1, limit2);
        } else {
            double callvalue = (optionprice + stcprice) - strike;
            setAmercall(callvalue);
        }
    }
}

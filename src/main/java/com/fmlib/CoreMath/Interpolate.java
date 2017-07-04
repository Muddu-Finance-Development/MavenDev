/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.CoreMath;
import java.util.*;
/**
 *
 * @author Muddu
 */
public class Interpolate 
{
    public double lagrange(double[][] valpairs,double xval)
    {
        int n=valpairs.length;
        double pn=0.0,px;
        for(int i=0;i<n;i++)
        {
            px=1;
            for(int j=0;j<n;j++)
            {
                if(j!=i)
                    px*=((xval-valpairs[j][0])/(valpairs[i][0]-valpairs[j][0]));
            }
            pn+=px*valpairs[i][1];
        }
        return pn;
    }
    public double neville(double[][] valpairs,double xval)//interpolate for the given value xval Neville type interpolation
    {
        double prec=1e-2,x,v,nume,denom,newp=0,compareval;
        int k=0,ky=0,counter=0,m,indx=1,n;
        n = valpairs.length;
        double[][] kpvals=new double[n][2];
        ArrayList<Double> pvalues=new ArrayList<>();
        TreeMap<Double,Double> h= new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            if(xval>valpairs[i][0])
            {
                h.put(xval-(valpairs[i][0]),valpairs[i][1]);
            }
            else
            {
                h.put(Math.abs((xval-valpairs[i][0])),-valpairs[i][1]);
            }
        }
        Iterator<Double> kee=h.keySet().iterator();
        Iterator<Double> val=h.values().iterator();
        while(val.hasNext())
        {
            x=val.next();
            v=(x>0.0)?kee.next()-xval:xval+kee.next();
            x=Math.abs(x);
            v=Math.abs(v);
            kpvals[k][0]=v;
            kpvals[k][1]=x;
            if(counter>=1)
            {
                pvalues.add(ky,(((xval-kpvals[ky][0])*kpvals[ky+1][1])+((kpvals[ky+1][0]-xval)*kpvals[ky][1]))/(kpvals[ky+1][0]-kpvals[ky][0]));
                double res=pvalues.get(ky);
                ky++;
            }
            counter++;
            k++;
        }
        while(!pvalues.isEmpty())
        {
            indx++;
            compareval=pvalues.get(0);
            for(m=0;m<pvalues.size()-1;m++)
            {
                nume=(((xval-kpvals[m][0])*(pvalues.get(m+1)))+kpvals[indx+m][0]-xval)*(pvalues.get(m));
                denom=(kpvals[(indx+m)][0]-kpvals[m][0]);
                newp=nume/denom;
                pvalues.set(m,newp);
            }
            if((Math.abs(compareval-newp))<prec)
            {
                return compareval;
            }
            pvalues.remove(m);
        }
        return newp;
    }
}

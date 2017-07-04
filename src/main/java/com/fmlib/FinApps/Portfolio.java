/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.FinApps;

import java.util.*;

/**
 *
 * @author Muddu
 */
public class Portfolio 
{
public void folioreturns(String sname,int numshares,double initialprice, double expectedrets)
{
    ArrayList folioentry=new ArrayList();
    folioentry.add(sname);
    folioentry.add(numshares);
    folioentry.add(initialprice);
    folioentry.add(expectedrets);    
}
public void retInitprice()
{
    double tots=0.0,proportion=0.0,initialportval=0.0,totalinvest=0.0,portfolioreturn=0.0;
    ArrayList folioentry=new ArrayList();
    final int collectionsize =folioentry.size();
    for(int i=3;i<collectionsize;)
    {
        Double totals=(Double)folioentry.get(i-1);
        Integer totalnums=(Integer)folioentry.get(i-2);
        initialportval+=(totals*totalnums);
        i+=4;
    }
    for(int j=3;j<collectionsize;)
    {
        Double sums=(Double)folioentry.get(j);
        Double totalsinitial=(Double)folioentry.get(j-1);
        Integer totalnumsinitial=(Integer)folioentry.get(j-2);
        String security=(String)folioentry.get(j-3);
        tots=(totalsinitial*totalnumsinitial);
        proportion=tots/initialportval;
        totalinvest=sums*proportion;
        portfolioreturn+=totalinvest;
        j=j+4;
    }
    System.out.print("Start Peroiod Valuation of Portfolio:"+initialportval);
    System.out.print("Expected valationof portfolio return:"+portfolioreturn);
    folioentry.clear();
}

}

/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package com.fmlib.BaseStats;
import java.io.*;
/**
 *
 * @author Muddu
 */
public class inputmod 
{
    public static String readString()
    {
        BufferedReader buffin;
        buffin = new BufferedReader(new InputStreamReader(System.in),1);
        String string=" ";
        try
        {
            string=buffin.readLine();
        }catch(IOException ex)
            {
                System.out.println(ex);
            }
        return string;
    }
    public static int readInt()
    {
        return Integer.parseInt(readString());
    }
    public static double readDouble()
    {
        return Double.parseDouble(readString());
    }
    public static byte readByte()
    {
        return Byte.parseByte(readString());
    }
    public static long readLong()
    {
        return Long.parseLong(readString());
    }
    public static float readFloat()
    {
        return Float.parseFloat(readString());
    }
    public static short readShort()
    {
        return Short.parseShort(readString());
    }
}

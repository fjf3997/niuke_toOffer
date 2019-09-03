package com.fjf.integrality;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Power {
    public static double Power(double base, int exponent) {
        if(base==0)
            return 0;
        if(exponent==0)
            return 1;
        double s = 1.0;
        int e = exponent>0?exponent:-exponent;
        for(int i=1;i<=e;i++){
            s*=base;
        }
        return exponent>0?s:1/s;
        /*double s = base;
        if(exponent>0) {
            for (int i = 1; i < exponent; i++) {
                s *= base;
            }
        }
        if(exponent<0){
            for (int i = 1; i > exponent; i--) {
                s /= base;
            }
        }
        return s;*/
    }
}

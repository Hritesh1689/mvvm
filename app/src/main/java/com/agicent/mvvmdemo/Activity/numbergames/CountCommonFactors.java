package com.agicent.mvvmdemo.Activity.numbergames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CountCommonFactors {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab= br.readLine().trim().split(" ");
        System.out.println(getCommonFactorCount(new BigInteger(ab[0]),new  BigInteger(ab[1])));
    }

    public static BigInteger getCommonFactorCount(BigInteger a,BigInteger b){
        BigInteger gcd=getGCD(a,b);

        System.out.println(gcd);
        BigInteger count=BigInteger.ONE;
        BigInteger two=new BigInteger("2");

        while(gcd.mod(two).equals(BigInteger.ZERO)){
            count=count.add(BigInteger.ONE);
            gcd=gcd.divide(two);
        }
        BigInteger till=sqrt(gcd);

        for(BigInteger i=BigInteger.valueOf(3);i.compareTo(till)<=0;i=i.add(BigInteger.valueOf(2))){
            while(gcd.mod(i).equals(BigInteger.ZERO)){
               count= count.add(BigInteger.ONE);
                gcd=gcd.divide(i);
            }
        }

        if(gcd.compareTo(BigInteger.valueOf(2))>0)  count=count.add(BigInteger.ONE);

        return count;
    }

    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }


    public static BigInteger getGCD(BigInteger a,BigInteger b){
        if(a.equals(BigInteger.ZERO)) return new BigInteger(b.toString());
        if(b.equals(BigInteger.ZERO))  return new BigInteger(a.toString());

        if(a.equals(b)) return new BigInteger(a.toString());
        if(a.compareTo(b)>0) return getGCD(a.subtract(b),b);
        return getGCD(a,b.subtract(a));
    }
}

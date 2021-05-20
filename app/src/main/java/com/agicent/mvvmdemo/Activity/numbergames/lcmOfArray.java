package com.agicent.mvvmdemo.Activity.numbergames;

import java.util.HashMap;

public class lcmOfArray {

    public static void main(String[] args){
        lcmsOfArray(new int[]{2,7,3,9,4});
    }

    private static void lcmsOfArray(int[] ints) {
        HashMap<Long,Long> factorMap=new HashMap<>();
        for(int el:ints) factor(el,factorMap);

        long res=1l;
        for(long key:factorMap.keySet()) res=res*pow(key,factorMap.get(key));
         System.out.println(res);
    }

    private static long pow(long base, Long pow) {
        if(pow==0) return 1;

            long temp=pow(base,pow/2);
            if((pow&1)==0) return temp*temp;
            else return temp*temp*base;
    }

    private static void factor(int n, HashMap<Long, Long> factorMap) {
        if(n<=1) return;
        long p=2L;
        long fact=0;
        for(p=2; p*p<=n; p++){
             fact=0;

            while(n%p==0){
                fact++;
                n/=p;
            }

            if(fact==0) continue;

            if(factorMap.containsKey(p)) fact=Math.max(fact,factorMap.get(p));
            factorMap.put(p,fact);

        }

        if(n!=1){
            fact=1;
            if(factorMap.containsKey(n)) fact=Math.max(fact,1);
            factorMap.put((long) n,fact);
        }
    }
}

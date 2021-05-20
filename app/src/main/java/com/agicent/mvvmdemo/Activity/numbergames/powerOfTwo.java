package com.agicent.mvvmdemo.Activity.numbergames;

public class powerOfTwo {

    public static void main(String[] args){
        System.out.println(power("16"));
    }

    public static int power(String A) {
         A=trimZero(A);
        return is(A)?1:0;
    }

    public static boolean is(String a){
        if(a.equals("1")) return true;
        if(!mod2(a).equals("0")) return false;
        else return is(div2(a));
    }

    public static String mod2(String a){
        int n=a.length();
        int num=Integer.parseInt(a.substring(n-1));
        return num%2==0?"0":"1";
    }

    public static String div2(String a){
        int n=a.length();
        StringBuilder res=new StringBuilder();
        String rem="";
        int start=0;
        while(start<n){
            int num=Integer.parseInt(rem+a.substring(start,start+1));
            res.append((num/2)+"");
            start++;
            if((num&1)==0) rem="";
            else rem="1";
        }
        return trimZero(res.toString());
    }

    public static String trimZero(String A){
        while(A.charAt(0)=='0') A=A.substring(1);
        return A;
    }
}

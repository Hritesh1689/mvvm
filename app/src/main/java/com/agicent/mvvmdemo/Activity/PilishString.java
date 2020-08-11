package com.agicent.mvvmdemo.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class PilishString {

//    public static String pilish_string(String s) {
//        // String s=st+" ";
//
//        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(0,3,4,8,9,14,23,25,31,36,39,44,52,61,68,77));
//        String output="";
//        for(int i=0;i<arr.size();i++){
//            if(s.length()>=arr.get(i+1)){
//                output=output+s.substring(arr.get(i),arr.get(i+1))+" ";
//                if(s.length()==arr.get(i+1))
//                    break;
//            }
//            else {
//                output = output + s.substring(arr.get(i));
//                for(int j=0;j<(i+1-s.length());j++)
//                    output=output+s.charAt(s.length()-1);
//                break;
//            }
//        }
//
//        return output.trim();
//    }

    public static void main(String[] args){
        System.out.println(resist("(10, [20, 30])"));
    }

//mm/dd/yyyy
//    public static String[] palindromicDates(String date, int years) {
//        String output="";
//        String[] dmy=date.split("/");
//        int year=Integer.parseInt(dmy[2]);
//        String yrst=String.valueOf(year);
//        for(int i=year;i<=year+years;i++){
//            if(String.valueOf(i).length()==4) {
//                if (String.valueOf(i).substring(0, 2).equals(String.valueOf(i).substring(2, 4)))
//                    output += reverse(String.valueOf(i).substring(0, 2)) + "/" + reverse(String.valueOf(i).substring(0, 2)) + "/" + String.valueOf(i) + "@";
//
//            }else{
//                if (String.valueOf(i).substring(1, 3).equals(String.valueOf(i).substring(3, 5)))
//                    output += reverse(String.valueOf(i).substring(1, 3)) + "/" + reverse(String.valueOf(i).substring(1, 3)) + "/" + String.valueOf(i) + "@";
//            }
//        }
//
//        return output.split("@");
//    }

//    public static String reverse(String s){
//        int n=Integer.parseInt(s);
//        int reverse=0;
//        while(n != 0)
//        {
//            reverse = reverse * 10;
//            reverse = reverse + n%10;
//            n = n/10;
//        }
//
//        if(s.charAt(0)=='0')
//            return "0"+reverse;
//
//        return String.valueOf(reverse);
//    }

//    public static int[] characterMapping(String str) {
//        int[] o=new int[str.length()];
//        HashMap<Character,Integer> map=new HashMap<>();
//        for(int i=0;i<str.length();i++){
//             if(map.containsKey(str.charAt(i)))
//                 map.put(str.charAt(i),map.get(str.charAt(i))+1);
//             else
//                 map.put(str.charAt(i),1);
//             o[i]=map.get(str.charAt(i));
//        }
//        return  o;
//    }




    public static float resist(String net) {
        float output=0f;
        net=net.replaceAll(",","");
        net=net.replaceAll(" ","");
        Stack<String> stc=new Stack<>();
        for(int i=0;i<net.length();i++){
            if(String.valueOf(net.charAt(i)).equals(")")){
                while(!stc.peek().equals("("))
                    output=(output*Float.parseFloat(stc.peek()))/(output+Float.parseFloat((stc.pop())));
                stc.pop();
            }else if(String.valueOf(net.charAt(i)).equals("]")){
                while(!stc.peek().equals("["))
                    output=(output+Float.parseFloat(stc.pop()));
                stc.pop();
            } else
                stc.push(String.valueOf(net.charAt(i)));
        }
        return output;
    }
}

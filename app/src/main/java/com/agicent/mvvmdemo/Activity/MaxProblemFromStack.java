package com.agicent.mvvmdemo.Activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxProblemFromStack {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int no = Integer.parseInt(br.readLine());

        Stack<Integer> st=new Stack<>();
       // st.



    }

    static void countmax(String str){
        int max=0;
          for(int i=0;i<str.length();i++){
              if(Integer.parseInt(String.valueOf(str.charAt(i)))>max)
                  max=Integer.parseInt(String.valueOf(str.charAt(i)));
          }

    }

    static void solveit(String arra,Integer max){
        //String[] arr=arra.split(" ");
        int count=1;
        for(int i=0;i<arra.length();i++){
            for(int j=i+1;j<arra.length();j++){
               // if(max==countmax(arra.substring(i,j+1)))
                    count++;
            }
        }

        System.out.println(count);

    }


}

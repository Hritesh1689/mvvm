package com.agicent.mvvmdemo.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

public class HighestRating {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int M = Integer.parseInt(br.readLine().trim());
        int Q = Integer.parseInt(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
        {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        int out_ = findHighestRating(Q, arr, M);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int findHighestRating(int Q, int[] arr, int M){
        // Write your code here
        Hashtable<Integer,int[]> ht=new Hashtable();
        for(int i=0;i<arr.length;i++){
            int[] elements=new int[(Q*2)+1];
            elements[0]=arr[i];
            int o=0;
            for(int j=1;j<=Q;j++){
                o++;
                elements[o]=arr[i]+(M*j);
                o++;
                 elements[o]=arr[i]-(M*j);

            }
            ht.put(i,elements);
        }
        Hashtable<Integer,Integer> ho=new Hashtable();
        for(int i=0;i<ht.size();i++){
            for(int j=0;j<ht.get(i).length;j++){
                if(ho.containsKey(ht.get(i)[j]))
                    ho.put(ht.get(i)[j],ho.get(ht.get(i)[j])+1);
                else
                    ho.put(ht.get(i)[j],1);
            }
        }

       // ho.values();
        Enumeration e = ho.elements();

        int max=0;
        while (e.hasMoreElements()) {
            if(Integer.parseInt(String.valueOf(e.nextElement()))>max)
                max=Integer.parseInt(String.valueOf(e.nextElement()));
        }

       return max;
    }
}

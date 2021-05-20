package com.agicent.mvvmdemo.Activity.codechef;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Jattu {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main (String[] args) throws java.lang.Exception
    {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

       // Scanner sc=new Scanner(System.in);


        int no=Integer.parseInt(br.readLine());
        while(no-->0){

            int[] qandd= Arrays.asList(br.readLine().trim().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            int[] arr=Arrays.asList(br.readLine().trim().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            int max=Integer.MIN_VALUE;
            for(int el:arr) max=Math.max(max,el);
            int[] dp=new int[max+1];
            Arrays.fill(dp,-1);
//            for(int el:arr){
//
//            }

            for(int el:arr){

                if(dp[el]!=-1){
                    if(dp[el]==1) bw.write("YES\n");
                    else bw.write("NO\n");
                    continue;
                }

                boolean find=false;
                int curr=el;
                while(curr>0){
                    if(isd(curr,qandd[1])){
                        dp[curr]=1;
                        find=true;
                        break;
                    }

                    if(dp[curr]!=-1) {
                        if(dp[curr]==1) find=true;
                        else find=false;
                        break;
                    }
                    curr-=qandd[1];
                }
                if(find){
                    dp[el]=1;
                    bw.write("YES\n");
                }  else{
                    dp[el]=0;
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
    }

    public static boolean isd(int num,int d){
        while(num>0){
            if((num%10)==d) return true;
            num/=10;
        }
        return false;
    }
}

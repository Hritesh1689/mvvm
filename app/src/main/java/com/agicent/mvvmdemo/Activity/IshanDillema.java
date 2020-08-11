package com.agicent.mvvmdemo.Activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Handler;

public class IshanDillema {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int noOfTest = Integer.parseInt(s.nextLine());

        String[] stringSet=new String[noOfTest];
        for(int i_arr=0; i_arr<noOfTest; i_arr++){
            s.nextLine();
            stringSet[i_arr]=s.nextLine().trim();
        }

        for(int i_arr=0; i_arr<noOfTest; i_arr++)
            solveit(stringSet[i_arr]);

    }

    static void solveit(String Cupcake){
        String cupcakes=Cupcake+"T";
        int max=0;
        for(int i=0;i<cupcakes.length()-2;i++){
            for(int j=i+1;j<cupcakes.length()-1;j=j+2)
            {
                if(countChar('C',cupcakes.substring(i,j+1))==countChar('V',cupcakes.substring(i,j+1))){
                    if((j+1-i)>max)
                        max=j+1-i;
                }
            }
        }
        System.out.println(max);
    }

    static int countChar(Character s,String full){
        int count = 0;
        //Counts each character except space
        for(int i = 0; i < full.length(); i++) {
            if(full.charAt(i)==s)
                count++;
        }
        return count;
    }
}

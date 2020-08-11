package com.agicent.mvvmdemo.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanYouSolveIt {

    public static void main(String args[] ) throws Exception {
         int n=Integer.MAX_VALUE;

        String ho="abcdefgabcd";
        String output="";
        for (int i = 0, j = ho.length()-1; i < ho.length() && j >= 0; i++, j--) {
            if(ho.substring(0,i).equals(ho.substring(j+1)))
                output=ho.substring(0,i);
        }
            System.out.println(output);

         //  Integer.MIN_VALUE
        //Scanner
        Scanner s = new Scanner(System.in);
     //   s.next
       // System.out.println("Enter the no of TestCases");
        int no = Integer.parseInt(s.nextLine());
        // Reading input from STDIN
        List<String> listOfArrays=new ArrayList<>();
        for(int i=0;i<no;i++){
            //System.out.println("Enter the length of array "+i);
             s.nextLine();
            // System.out.println("Enter the element of array "+i);
             listOfArrays.add(s.nextLine());
             if(i==no-1)
                 solveiit(listOfArrays);
        }
    }

    private static void solveiit(List<String> listOfArrays) {
        for(int i=0;i<listOfArrays.size();i++){
            String[] elementArray=listOfArrays.get(i).trim().split(" ");
            int max=0;
            for(int j=0;j<elementArray.length-1;j++){
                for(int k=j+1;k<elementArray.length;k++){
                    if(k-j+Math.abs(Integer.parseInt(elementArray[k])-Integer.parseInt(elementArray[j]))>max)
                        max=k-j+Math.abs(Integer.parseInt(elementArray[k])-Integer.parseInt(elementArray[j]));
                }
            }
            System.out.println(max);
        }
    }
}

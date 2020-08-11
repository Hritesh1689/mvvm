package com.agicent.mvvmdemo.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LargeSubArrays {
    public static void main(String args[]) throws Exception {


        //Scanner
        System.out.println("Enter the number of textCases");
        Scanner s = new Scanner(System.in);
        int noOfTest = s.nextInt();// Reading input from STDI

        List<List<Integer>> ListOfNMK=new ArrayList<>();
        List<List<Integer>> ListOfArrays=new ArrayList<>();
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT


        for(int j=0;j<noOfTest;j++){
            List<Integer> myArray = new ArrayList<>();
            System.out.println("Enter "+j+"st"+" NMK List");
            for(int i = 0; i<3; i++) {
                myArray.add(s.nextInt());
            }
            ListOfNMK.add(myArray);
//            System.out.println("Enter the required size of the array :: ");
//            int size = s.nextInt();

            List<Integer> myArrays = new ArrayList<>();
            System.out.println("Enter the arrayList of size "+myArray.get(0));
            for(int k = 0; k<myArray.get(0); k++) {
                myArrays.add(s.nextInt());
            }
            ListOfArrays.add(myArrays);
            if(j==noOfTest-1){
             for(int l=0;l<noOfTest;l++)
                 solveProblem(ListOfNMK.get(l),ListOfArrays.get(l));
            }
        }
    }

    private static void solveProblem(List<Integer> ints, List<Integer> listOfArray) {
        int k=ints.get(2);
       // List<Integer> listAfterChange=new ArrayList<>();
        for(int i=0;i<ints.get(1);i++){
            if(i==0)
                continue;
            listOfArray.addAll(listOfArray);
        }
        int maxSize=0;

        for(int i=0;i<listOfArray.size();i++){
            List<Integer> singleItem=new ArrayList<>();

            for(int j=i;j<listOfArray.size();j++){

                singleItem.add(listOfArray.get(j));

                int sum=0;
                for(int p=0;p<new ArrayList<Integer>(singleItem).size();p++){
                    sum+=new ArrayList<Integer>(singleItem).get(p);
                }
                if(sum<=k)
                    maxSize++;
            }
        }

        System.out.println(maxSize);

    }
}

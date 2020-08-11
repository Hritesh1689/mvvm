package com.agicent.mvvmdemo.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryQueries {

    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array and no of queries");
        String sizeOfArrayAndNoOfQueries = s.nextLine().trim();
        String[] arrayOfBianry=new String[Integer.parseInt(sizeOfArrayAndNoOfQueries.split(" ")[0])];
        System.out.println("Enter Array");
        arrayOfBianry=s.nextLine().trim().split(" ");

        System.out.println("Enter the queries");
        List<String> listOfQueries= new ArrayList<>();
        for(int i=0;i<Integer.parseInt(sizeOfArrayAndNoOfQueries.split(" ")[1]);i++) {
            listOfQueries.add(s.nextLine().trim());
            if(i==Integer.parseInt(sizeOfArrayAndNoOfQueries.split(" ")[1])-1)
                solveTheProblem(arrayOfBianry,listOfQueries);
        }


    }

    private static void solveTheProblem(String[] arrayOfBianry, List<String> listOfQueries) {
        for(int i=0;i<listOfQueries.size();i++){
            if(listOfQueries.get(i).split(" ").length==2){
                if(arrayOfBianry[Integer.parseInt(listOfQueries.get(i).split(" ")[1])-1].equals("0"))
                    arrayOfBianry[Integer.parseInt(listOfQueries.get(i).split(" ")[1])-1]="1";
                else
                    arrayOfBianry[Integer.parseInt(listOfQueries.get(i).split(" ")[1])-1]="0";

            }
            else if(listOfQueries.get(i).split(" ").length==3){
                String binaryString="";
                 for(int j=0;j<arrayOfBianry.length;j++){
                     if(j>=Integer.parseInt(listOfQueries.get(i).split(" ")[1])-1 && j<=Integer.parseInt(listOfQueries.get(i).split(" ")[2])-1)
                       binaryString+=arrayOfBianry[j];

                     if(Integer.parseInt(binaryString,2)%2==0)
                        System.out.println("EVEN");
                     else
                         System.out.println("ODD");

                     break;

                 }
                 break;
            }
        }
    }
}

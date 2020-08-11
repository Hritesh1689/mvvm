package com.agicent.mvvmdemo.Activity;

import java.io.*;
import java.util.*;

public class TruckTour {

    static int truckTour(int[][] petrolpumps) {
        /*
         * Write your code here.
         */
        Queue<Integer> petrolKhapat=new LinkedList<>();
        for(int i=0;i<petrolpumps.length;i++){
            petrolKhapat.add(petrolpumps[i][0]-petrolpumps[i][1]);
        }

        int passedPetrolPumps=0;
        int remainingPetrol=0;
        int startPosition=0;
        while(passedPetrolPumps<petrolKhapat.size()){
            int currentKhapat=petrolKhapat.poll();
            remainingPetrol+=currentKhapat;
            if(remainingPetrol<0){
                passedPetrolPumps=0;
                remainingPetrol=0;
                  startPosition+=passedPetrolPumps+1;

            }else
                passedPetrolPumps++;
            petrolKhapat.add(currentKhapat);
        }

    return startPosition;
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }




    // Complete the solve function below.
    static int[] solve(int[] arr, int[] queries) {
        ArrayList<Integer> maxlist;
        ArrayList<Integer> singleMax;
        ArrayList<Integer> minList=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            maxlist=new ArrayList<>();
            for(int j=0;j<=arr.length-queries[i];j++){
                singleMax=new ArrayList<>();
                for(int k=j;k<j+queries[i];k++)
                    singleMax.add(arr[j]);
                maxlist.add(founMax(singleMax));
            }
            minList.add(foundMin(maxlist));
        }

        int[] output=new int[minList.size()];
        for(int k=0;k<minList.size();k++)
            output[k]=minList.get(k);

       // int[] ou=minList.stream().mapToInt(i->i).toArray();

        return  output;
    }

    private static Integer foundMin(ArrayList<Integer> maxlist) {
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<maxlist.size();i++){
//            if(maxlist.get(i)<min)
//                min=maxlist.get(i);
//        }
           Collections.sort(maxlist);
        return maxlist.get(0);
    }

    private static Integer founMax(ArrayList<Integer> singleMax) {

//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<singleMax.size();i++){
//            if(singleMax.get(i)>max)
//                max=singleMax.get(i);
//        }
//
//        return max;

        Collections.sort(singleMax);
        return singleMax.get(singleMax.size()-1);
    }

    public static int solveForExp(int a, int b) {


        return 0;
    }


    public static boolean isPalindromePossible(String str) {
        HashMap<Character,Integer> mao=new HashMap<>();
           for(int i=0;i<str.length();i++){
               if(mao.containsKey(str.charAt(i)))
                   mao.put(str.charAt(i),mao.get(str.charAt(i))+1);
               else
                   mao.put(str.charAt(i),1);
           }

                      Iterator<Integer> itr=mao.values().iterator();
           int count=0;
           while(itr.hasNext()){
               if(itr.next()==1)
                   count++;
           }

           if(count>1)
               return false;
           else
               return true;
    }


//    public static String translateWord(String word) {
//        char d=word.charAt(0);
//        String vowelChecker="aeiou";
//        if(vowelChecker.contains(String.valueOf(d))){
//            char ch=word.charAt(0);
//            while(vowelChecker.contains(String.valueOf(ch))){
//                word=word.replaceFirst(String.valueOf(ch),"");
//                word=word+String.valueOf(ch);
//            }
//            return word+"ay";
//        }else{
//            return word+"yay";
//        }
//    }

    public static String translateWord(String word) {
        String pigged = word.matches("(?i)[aeiou].*") ?
                word.replaceAll("(\\p{Punct}?)(\\w+)(\\p{Punct}?)", "$1$2yay$3")
                : word.replaceAll("(\\p{Punct}?)((?i)[^aeiou]*)((?i)[aeiou]\\w*)(\\p{Punct}?)", "$1$3$2ay$4");

        return pigged.matches("\\p{Punct}.*[A-Z].*") ?
                pigged.substring(0,2).toUpperCase() + pigged.substring(2).toLowerCase()
                : pigged.matches(".*[A-Z].*") ?
                Character.toUpperCase(pigged.charAt(0)) + pigged.substring(1).toLowerCase()
                : pigged;
    }

    public static String pilish_string(String s) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(0,3,4,8,9,14,23,25,31,36,39,44,52,61,68,77));
        String output="";
        for(int i=0;i<arr.size();i++){
            if(s.length()>=i+1)
              output=output+s.substring(i,i+1)+" ";
            else {
                output = output + s.substring(i);
                for(int j=0;j<(i+1-s.length());j++)
                    output+=s.charAt(s.length()-1);
            }
        }

        return output;
    }

}















package com.agicent.mvvmdemo.Activity;



import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.*;
import java.util.regex.*;

    public class PoisionPlants {

        // Complete the poisonousPlants function below.
        @RequiresApi(api = Build.VERSION_CODES.N)
        static int poisonousPlants(int[] p) {

            List<Integer> list = IntStream.of(p).boxed().collect(Collectors.toList());

            ArrayList<Integer> li=new ArrayList<>(list);

Collections.sort(li);
            //    Collections.addAll(li,p);

            boolean done=false;
            int daycount=0;
            Stack<Integer> positionDanger=new Stack<>();
            while(!done){

                for(int i=0;i<li.size()-1;i++){
                    if(li.get(i+1)>li.get(i))
                        positionDanger.push(i+1);
                    
                }

                if(!positionDanger.isEmpty()) {
                    while (!positionDanger.isEmpty()) {

                      //  li.add(positionDanger.pop(),0);
                        li.set(positionDanger.pop(),0);
                        //li.;
                    }
                    // li.remove(0);
                    li.removeAll(Collections.singleton(0));
                    daycount++;
                    done=false;
                }else{
                    done=true;
                }
            }
            return daycount;
        }

        private static final Scanner scanner = new Scanner(System.in);

        @RequiresApi(api = Build.VERSION_CODES.N)
        public static void main(String[] args) throws IOException {
           //   BufferedReader bufferedWriter = new BufferedReader(new InputStreamReader(System.in));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] p = new int[n];

            String[] pItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pItem = Integer.parseInt(pItems[i]);
                p[i] = pItem;
            }

            int result = poisonousPlants(p);

            // bufferedWriter.write(String.valueOf(result));
            System.out.println(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

            scanner.close();
        }

















        static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
            //  String[] str=Arrays.cop
            String[] strver=new String[grid.length];
            int gx=goalX;
            int gy=goalY;
            for (String s : grid) {
                for (int j = 0; j < grid.length; j++)
                    strver[j] = strver[j] + s.split(" ")[j];
            }
            int count=0;
            boolean goalReached=false;
            while(!goalReached) {
                if (startX == goalX) {
                      if (grid[startX].substring(startY, goalY).contains("*")) {
                             goalX=grid.length-1;
                             goalReached=false;
                        }
                }
               else if (startY == goalY) {
                    if (strver[startY].substring(startX, goalX).contains("*")) {
                        goalY=grid.length-1;
                        goalReached=false;
                    }
                }
               else {
                   if(goalY==grid.length-1)
                       goalX=startX;
                   else if(goalX==grid.length-1)
                       goalY=startY;
               }


               if(goalX==gx && goalY==gy) {
                   goalReached = true;
                   count++;
               }
               else
                   goalReached=false;
            }
            return  count;

        }
    }



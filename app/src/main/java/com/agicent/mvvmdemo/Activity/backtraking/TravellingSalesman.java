package com.agicent.mvvmdemo.Activity.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TravellingSalesman {
    public static void main(String[] args)
    {
        int[][] graph=new int[][]{};
        //tsp(graph);


        //solve(new int[]{1,4,2,3},new int[]{2,5,1,6});
    }

//    public static int[] solve(int[] A, int[] B) {
//        int n=A.length;
//        My obj = new My();
//        Arrays.sort(A,obj);
//        Arrays.sort(B,obj);
////
////        Arrays.sort(new int[][]{A},Collections.reverseOrder());
////
////        // Arrays.sort(A,Collections.reverseOrder());
////
////        // Arrays.sort(B,Collections.reverseOrder());
//
//        PriorityQueue<Integer> q=new PriorityQueue<>();
//
//        for(int i=0;i<A.length;i++){
//            for(int j=0;j<B.length;j++){
//                int sum=A[i]+B[j];
//                if(q.size()<=n){ q.add(sum); continue; }
//
//                if(sum<q.peek()) break;
//                else q.add(sum);
//
//
//                if(q.size()>n) q.poll();
//            }
//        }
//
//        int[] res=new int[n];
//        int counter=0;
//        while(!q.isEmpty()) res[counter++]=q.poll();
//        return res;
//    }
}

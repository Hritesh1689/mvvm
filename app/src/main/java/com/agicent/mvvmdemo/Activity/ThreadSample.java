package com.agicent.mvvmdemo.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class ThreadSample {

    public static List<Integer> riverSizes(int[][] matrix) {
        ArrayList<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                visited[i][j]=false;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(visited[i][j])
                    continue;
                traverseNode(i,j,matrix,visited,sizes);
            }
        }
        System.out.print(sizes);
        return sizes;
    }

    private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, ArrayList<Integer> sizes) {
        int currentRiverSize=0;
        List<List<Integer>> nodeToExplore= new ArrayList<>(Arrays.asList(Arrays.asList(i,j)));
       // nodeToExplore.add(Arrays.asList(i,j));

        while(nodeToExplore.size()!=0){
            List<Integer> currentNode=nodeToExplore.get(nodeToExplore.size()-1);
            nodeToExplore.remove(nodeToExplore.size()-1);
            int i1=currentNode.get(0);
            int j1=currentNode.get(1);
            if(visited[i1][j1])
                continue;
            visited[i1][j1]=true;

            if(matrix[i1][j1]==0)
                continue;
            currentRiverSize+=1;

            List<List<Integer>> unvisitedNeighbours=getUnvisitedNeighbour(i1,j1,matrix,visited);

            for(int k=0;k<unvisitedNeighbours.size();k++)
                nodeToExplore.add(unvisitedNeighbours.get(k));
        }

        if(currentRiverSize>0)
            sizes.add(currentRiverSize);
    }

    private static List<List<Integer>> getUnvisitedNeighbour(int i, int j, int[][] matrix, boolean[][] visited) {
        List<List<Integer>> unvisitedNeighbour=new ArrayList<>();

        if(i>0 && !visited[i-1][j])
            unvisitedNeighbour.add(Arrays.asList(i-1,j));
        if(i<matrix.length-1 && !visited[i+1][j])
            unvisitedNeighbour.add(Arrays.asList(i+1,j));
        if(j>0 && !visited[i][j-1])
            unvisitedNeighbour.add(Arrays.asList(i,j-1));
        if(j<matrix[0].length-1 && !visited[i][j+1])
            unvisitedNeighbour.add(Arrays.asList(i,j+1));

        return unvisitedNeighbour;
    }

    public static void main(String[] args){
//        int[][] matrixs= {
//                {1, 0, 0, 1, 0},
//                {1, 0, 1, 0, 0},
//                {0, 0, 1, 0, 1},
//                {1, 0, 1, 0, 1},
//                {1, 0, 1, 1, 0}
//  };
//        riverSizes(matrixs);

        int[] array={1,11,3,0,15,5,2,4,10,7,12,6};

        largestRange(array);

//        Thread t1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("hi");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//
//        Thread t2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("hello");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);
//        t2.start();
//        t1.start();


    }


    public static int[] largestRange(int[] array) {
        // Write your code here.
       // int[] finalResult=
        ArrayList<Integer> arrayList=new ArrayList<>();
        ArrayList<ArrayList<Integer>> rangerArrays=new ArrayList<>();

        boolean[] donePosition=new boolean[array.length];
        for(int i=0;i<array.length;i++) {
            donePosition[i] = false;
            arrayList.add(array[i]);
        }

        for(int j=0;j<array.length;j++){
            if(donePosition[j])
                continue;
            donePosition[j]=true;
            checkAdjacentForrThisPositionValue(j,array,donePosition,rangerArrays);
        }
        int maxsize=rangerArrays.get(0).size();
        int pos=0;
        for(int k=0;k<rangerArrays.size();k++){
            if(rangerArrays.get(k).size()>maxsize) {
                maxsize = rangerArrays.get(k).size();
                pos=k;
            }
        }
       // Arrays.sort(rangerArrays.get(pos));
        Collections.sort(rangerArrays.get(pos));

        int[] finalResult={rangerArrays.get(pos).get(0),rangerArrays.get(pos).get(rangerArrays.get(pos).size()-1)};

        System.out.print(finalResult[0]+","+finalResult[1]);

        return finalResult;
    }

    private static void checkAdjacentForrThisPositionValue(int j, int[] array,boolean[] donepos,ArrayList<ArrayList<Integer>> arr) {
        ArrayList<Integer> isAnyAvailableForsearch=new ArrayList<>(Arrays.asList(array[j]));
        ArrayList<Integer> rangerArr=new ArrayList<>();
        while(isAnyAvailableForsearch.size()!=0){
               int searchForWhat=isAnyAvailableForsearch.get(isAnyAvailableForsearch.size()-1);
            rangerArr.add(isAnyAvailableForsearch.get(isAnyAvailableForsearch.size()-1));
            isAnyAvailableForsearch.remove(isAnyAvailableForsearch.size()-1);
            for(int i=0;i<array.length;i++){
                  if(donepos[i])
                      continue;
                  if( array[i]==searchForWhat+1 || array[i]==searchForWhat-1) {
                         isAnyAvailableForsearch.add(array[i]);
                         donepos[i]=true;
                     }
            }
        }
        arr.add(rangerArr);
    }
}

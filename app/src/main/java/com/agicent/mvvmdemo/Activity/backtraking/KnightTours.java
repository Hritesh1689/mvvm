package com.agicent.mvvmdemo.Activity.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class KnightTours {
    static int N=8;
    public static  void main(String[] args){
        solveKt();
    }
    private static boolean solveKt() {


        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
       


        int[][] sol=new int[8][8];
        for(int i=0;i<8;i++)
            Arrays.fill(sol[i],-1);
        int[][] movedir=new int[][]{{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
       // int[][] movedir=new int[][]{{2,1},{1,2},{-1,2},{-2,-1},{-1,-2},{1,-2},{-2,1},{2,-1}};
        sol[0][0]=0;
        if(!solveKtUtil(sol,0,0,movedir,1)) {
            System.out.println("Solution doesnt exist");
            return false;
        }
        else
            printSol(sol);

        return true;
    }

    private static boolean solveKtUtil(int[][] sol,int x,int y, int[][] movedir, int curr) {
        int next_x,next_y;
        if(curr==64)
            return true;
        for(int i=0;i<8;i++){
            next_x=x+movedir[i][0];
            next_y=y+movedir[i][1];
            if(isSafe(next_x,next_y,sol)) {
                sol[next_x][next_y]=curr;
                if (solveKtUtil(sol, next_x, next_y, movedir, curr + 1))
                    return true;
                else
                    sol[next_x][next_y]=-1;
            }

        }
        return false;
    }

    private static boolean isSafe(int next_x, int next_y, int[][] sol) {
        return  next_x>=0 && next_y>=0 && next_x<N && next_y<N && sol[next_x][next_y]==-1;
    }


    private static void printSol(int[][] sol) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }





//    static int N = 8;
//
//    static boolean isSafe(int x, int y, int sol[][]) {
//        return (x >= 0 && x < N && y >= 0 &&
//                y < N && sol[x][y] == -1);
//    }
//
//    static void printSolution(int sol[][]) {
//        for (int x = 0; x < N; x++) {
//            for (int y = 0; y < N; y++)
//                System.out.print(sol[x][y] + " ");
//            System.out.println();
//        }
//    }
//
//    static boolean solveKT() {
//        int sol[][] = new int[8][8];
//        for (int x = 0; x < N; x++)
//            for (int y = 0; y < N; y++)
//                sol[x][y] = -1;
//
//        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
//        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
//
//       // int[][] movedir=new int[][]{{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
//
//        sol[0][0] = 0;
//        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
//            System.out.println("Solution does not exist");
//            return false;
//        } else
//            printSolution(sol);
//
//        return true;
//    }
//
//    static boolean solveKTUtil(int x, int y, int movei,
//                               int sol[][], int xMove[],
//                               int yMove[]) {
//        int k, next_x, next_y;
//        if (movei == N * N)
//            return true;
//        for (k = 0; k < 8; k++) {
//            next_x = x + xMove[k];
//            next_y = y + yMove[k];
//            if (isSafe(next_x, next_y, sol)) {
//                sol[next_x][next_y] = movei;
//                if (solveKTUtil(next_x, next_y, movei + 1,
//                        sol, xMove, yMove))
//                    return true;
//                else
//                    sol[next_x][next_y] = -1;// backtracking
//            }
//        }
//
//        return false;
//    }
//
//    /* Driver program to test above functions */
//    public static void main(String args[]) {
//        solveKT();
//    }
}

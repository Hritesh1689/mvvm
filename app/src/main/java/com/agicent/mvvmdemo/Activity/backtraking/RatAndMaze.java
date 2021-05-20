package com.agicent.mvvmdemo.Activity.backtraking;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RatAndMaze {
    static int n;
    static int[][] resMatrix;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int no=Integer.parseInt(br.readLine());
        n=no;
        int[][] matrix=new int[no][no];
        int[] el= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int counter=0;
        for(int i=0;i<no;i++)
            for(int j=0;j<no;j++)
                matrix[i][j]=el[counter++];
            resMatrix=new int[n][n];
         printAllPossiblePaths(matrix,0,0);
    }

    private static void printAllPossiblePaths(int[][] matrix, int r, int c) {
        if(r<0 || c<0 || r>=n || c>=n || matrix[r][c]==0 || resMatrix[r][c]==1)
            return;

        if(r==n-1 && c==n-1)
        {
            resMatrix[r][c]=1;
            printSol();
        }
        resMatrix[r][c]=1;
        printAllPossiblePaths(matrix,r+1,c);
        printAllPossiblePaths(matrix,r,c+1);
        printAllPossiblePaths(matrix,r-1,c);
        printAllPossiblePaths(matrix,r,c-1);
        resMatrix[r][c]=0;
    }

    private static void printSol() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(resMatrix[i][j]+" ");
            System.out.println();
        }
    }
}

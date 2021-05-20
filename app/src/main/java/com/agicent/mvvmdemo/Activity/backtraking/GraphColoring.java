package com.agicent.mvvmdemo.Activity.backtraking;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphColoring {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int no=Integer.parseInt(br.readLine());
        boolean f=true;
        for(int k=0;k<no;k++){
            int v=Integer.parseInt(br.readLine());
            int c=Integer.parseInt(br.readLine());
            int e=Integer.parseInt(br.readLine());
            int[][] adj=new int[v+1][v+1];
            int[] vis=new int[v+1];
            int[] edges= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int h=0;
            for(int i=0;i<e;i++,h+=2){
                adj[edges[h]][edges[h+1]]=1;
                adj[edges[h+1]][edges[h]]=1;
            }
            for(int i=1;i<=v;i++){
                if(vis[i]==0)
                {
                    vis[i]=1;
                    boolean flag=dfs(adj,v,c,i,vis);
                    if(!flag){
                        f=false;
                        break;
                    }
                }
            }
            if(f) System.out.println("1");
            else System.out.println("0");

        }
    }

    private static boolean dfs(int[][] adj, int n, int M, int curr, int[] vis) {
        for(int i=1;i<=n;i++){
            if(adj[curr][i]==1 && vis[curr]==vis[i]) return false;
            if(adj[curr][i]==1 && vis[i]==0){
                int j=0;
                for( j=1;j<=M;j++){
                    if(vis[curr]==j) continue;
                    vis[i]=j;
                    boolean flag=dfs(adj,n,M,i,vis);
                    if(flag) break;
                    vis[i]=0;
                }
                if(j==M+1) return false;
            }
        }
        return true;
    }



}

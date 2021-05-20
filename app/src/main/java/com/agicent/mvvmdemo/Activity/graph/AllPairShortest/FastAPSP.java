package com.agicent.mvvmdemo.Activity.graph.AllPairShortest;

public class FastAPSP {
    final static int INF = 99999;
    public static void main(String[] args){
        int[][] graph={{0,4,6,INF,INF,INF},{INF,0,6,3,4,INF},{INF,INF,0,1,INF,INF},{INF,INF,INF,0,2,3},{INF,INF,INF,INF,0,7},{INF,INF,INF,INF,INF,0}};
        solve(graph,graph.length);
    }

    private static void solve(int[][] graph, int v) {
        int counter=2;
        while(counter<v){
             graph=extend_shortest_path(graph);
             counter*=2;
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++)
               System.out.print(graph[i][j]==INF?"INF ":graph[i][j]+"   ");
            System.out.println();
        }
    }

    private static int[][] extend_shortest_path(int[][] graph) {
        int n=graph.length;
        int[][] res=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                res[i][j]=Integer.MAX_VALUE;
                for(int k=0;k<n;k++)
                    res[i][j]=Math.min(res[i][j],graph[i][k]+graph[k][j]);
            }
        return res;
    }
}

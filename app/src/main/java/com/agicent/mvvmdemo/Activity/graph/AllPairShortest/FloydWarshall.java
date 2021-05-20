package com.agicent.mvvmdemo.Activity.graph.AllPairShortest;

public class FloydWarshall {


    final static int INF = 99999;
    public static void main(String[] args){
        int[][] graph={{0,4,6,INF,INF,INF},{INF,0,6,3,4,INF},{INF,INF,0,1,INF,INF},{INF,INF,INF,0,2,3},{INF,INF,INF,INF,0,7},{INF,INF,INF,INF,INF,0}};
        FloydWarshall f=new FloydWarshall();
        f.solve(graph);
    }


    private  void solve(int[][] graph) {
        int n=graph.length;
        int[][] res=graph.clone();
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    res[i][j]=Math.min(res[i][j],res[i][k]+res[k][j]);

                printSolution(res,n);
    }

      void printSolution(int dist[][],int V)
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
                if (dist[i][j]==INF) System.out.print("INF ");
                else System.out.print(dist[i][j]+"   ");
            System.out.println();
        }
    }




}

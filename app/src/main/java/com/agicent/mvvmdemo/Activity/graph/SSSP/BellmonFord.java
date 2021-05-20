package com.agicent.mvvmdemo.Activity.graph.SSSP;

import com.agicent.mvvmdemo.Activity.graph.SSSP.Dijkstra;

import java.util.ArrayList;
import java.util.Comparator;

public class BellmonFord {

    public static  void main(String[] args){
        int[][] graph=new int[][]{{0,4,6,0,0,0},{4,0,6,3,4,0},{6,6,0,1,0,0},{0,3,1,0,2,3},{0,4,0,2,0,7},{0,0,0,3,7,0}};
        findSingleSourceShortestPathWithBellmon(graph,graph.length);
    }

    private static void findSingleSourceShortestPathWithBellmon(int[][] graph, int v) {
            Graph g=new Graph(v,true);
           for(int i=0;i<v;i++)
               for(int j=0;j<=i;j++)
                   if(graph[i][j]!=0) g.addEdge(i,j,graph[i][j]);

           Node[] nodes=new Node[v];
           for(int i=0;i<v;i++)
               nodes[i]=new Node(i,-1,Integer.MAX_VALUE);

           nodes[0].dis=0;

           for(int i=0;i<v-1;i++)
               for(int j=0;j<v;j++)
                   for(AdjNode adjs:g.adjList[j])
                       if(nodes[adjs.dest].dis>(nodes[j].dis+adjs.weight)) {
                           nodes[adjs.dest].dis = nodes[j].dis + adjs.weight;
                           nodes[adjs.dest].par=j;
                       }

        for(int j=0;j<v;j++)
            for(AdjNode adjs:g.adjList[j])
                if(nodes[adjs.dest].dis>(nodes[j].dis+adjs.weight)) {
                   System.out.println("Not possible");
                   break;
                }

        for(int i=0;i<v;i++){
            System.out.println("0-->"+nodes[i].vertex+"==="+nodes[i].dis);
        }


    }

    static  class  Graph{
        int v;
        boolean isDir;

        ArrayList<AdjNode>[] adjList;

        Graph(int v,boolean isDir){
            this.v=v;
            this.isDir=isDir;

            adjList=new ArrayList[v];
            for(int i=0;i<v;i++)
                adjList[i]=new ArrayList<>();
        }

       void addEdge(int i,int j,int w){
            AdjNode desti=new AdjNode(w,i);
            AdjNode destj=new AdjNode(w,j);

            adjList[i].add(destj);
            if(isDir)
                adjList[j].add(desti);
        }
    }

    static class AdjNode{
        int dest;
        int weight;

        AdjNode(int weight,int dest){
            this.weight=weight;
            this.dest=dest;
        }
    }

    static class comparator implements Comparator<Dijkstra.Node> {

        @Override
        public int compare(Dijkstra.Node o1, Dijkstra.Node o2) {
            return o1.dis-o2.dis;
        }
    }


    static class Node{
        int vertex;
        int par;
        int dis;

        Node(int vertex,int par ,int dis){
            this.par=par;
            this.dis=dis;
            this.vertex=vertex;
        }
    }
}

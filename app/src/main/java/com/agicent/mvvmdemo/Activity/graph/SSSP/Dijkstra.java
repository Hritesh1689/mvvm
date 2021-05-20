package com.agicent.mvvmdemo.Activity.graph.SSSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Dijkstra {

    public static void main(String[] args){
        int[][] graph=new int[][]{{0,4,6,0,0,0},{4,0,6,3,4,0},{6,6,0,1,0,0},{0,3,1,0,2,3},{0,4,0,2,0,7},{0,0,0,3,7,0}};
        findSingleSourceShortestPath(graph,graph.length);
    }

    private static void findSingleSourceShortestPath(int[][] graph, int length) {
        Graph g=new Graph(length,true);
        for(int i=0;i<length;i++)
            for(int j=0;j<i;j++)
                if(graph[i][j]!=0) g.addEdge(i,j,graph[i][j]);

        // initializeSingleSource(g,length);
        Node[] nodes=new Node[length];


        for(int i=0;i<length;i++)
            nodes[i]=new Node(i,-1,Integer.MAX_VALUE);

        nodes[0].dis=0;
        TreeSet<Node> pq=new TreeSet<Node>(new comparator());

       // HashSet<Integer> set=new HashSet<>();

        pq.addAll(Arrays.asList(nodes).subList(0, length));

        while(!pq.isEmpty()){
            Node curr=pq.pollFirst();
          //  set.add(curr.vertex);

            for(AdjNode adj:g.adjList[curr.vertex]){
                if(nodes[adj.dest].dis>(nodes[curr.vertex].dis+adj.weight)){
                    pq.remove(nodes[adj.dest]);
                    nodes[adj.dest].dis=nodes[curr.vertex].dis+adj.weight;
                    nodes[adj.dest].par=curr.vertex;
                    pq.add(nodes[adj.dest]);
                }
            }

        }

        for(int i=0;i<length;i++){
            System.out.println("0-->"+nodes[i].vertex+"==="+nodes[i].dis);
        }


    }


    static class Graph{
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

        public void addEdge(int i, int j, int i1) {
            AdjNode adgi=new AdjNode(i,i1);
            AdjNode adgj=new AdjNode(j,i1);

            adjList[i].add(adgj);
            if(isDir) adjList[j].add(adgi);
        }
    }


    static class AdjNode{
        int dest;
        int weight;

        AdjNode(int dest ,int weight){
            this.dest=dest;
            this.weight=weight;
        }
    }

    static class comparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.dis-o2.dis;
        }
    }


    static class Node {
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

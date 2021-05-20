package com.agicent.mvvmdemo.Activity.graph.mst;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

@RequiresApi(api = Build.VERSION_CODES.N)
//-----
public class PrimsAlgo {

    public static void main(String[] args){
        long time=System.currentTimeMillis();

       // int[][] graph=new int[][]{{0,4,6,0,0,0},{4,0,6,3,4,0},{6,6,0,1,0,0},{0,3,1,0,2,3},{0,4,0,2,0,7},{0,0,0,3,7,0}};
        int[][] graph=new int[][]{{0,1,10,3},{1,0,4,0},{10,4,0,2},{3,0,2,0}};
        System.out.println("Minimum Cost is---"+findMST(graph,graph.length,time));
    }


//    private static int findMST(int[][] graph, int V, long time) {
//        int[] weight=new int[V];
//        Arrays.fill(weight,Integer.MAX_VALUE);
//        weight[0]=0;
//        boolean[] processed=new boolean[V];
//        int[] parent=new int[V];
//        parent[0]=-1;
//        TreeSet<int[]> pq=new TreeSet<>((o1, o2) -> o1[0]-o2[0]);
//
//        pq.add(new int[]{0,0});
//        for(int i=0;i<V-1;i++){
//            int min_weight=pq.pollFirst()[1];
//            processed[min_weight]=true;
//            for(int j=0;j<V;j++){
//                if( weight[min_weight]!=Integer.MAX_VALUE && !processed[j] && graph[min_weight][j]!=0  && graph[min_weight][j]<weight[j])
//                {
//                    weight[j]=graph[min_weight][j];
//                    parent[j]=min_weight;
//                    pq.add(new int[]{weight[j],j});
//                }
//            }
//        }
//
//        int min_cost=0;
//        for(int i=1;i<parent.length;i++){
//            min_cost+=graph[parent[i]][i];
//        }
//
//        System.out.println("Execution Time ---"+(System.currentTimeMillis()-time));
//        return min_cost;
//    }
    //--------------O(ElogV+VlogE)--------------
    private static int findMST(int[][] graph, int V, long time) {
        Graph g=new Graph(V,true);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(graph[i][j]!=0) g.addEdge(i,j,graph[i][j]);
            }
        }
        boolean[] mstSet=new boolean[V];
        int[] parent=new int[V];
        Node[] verticesWithDis=new Node[V];

        //-----------O(V)----------------
        for(int i=0;i<V;i++){
            mstSet[i]=false;
            parent[i]=-1;
            verticesWithDis[i]=new Node(i,Integer.MAX_VALUE);
        }

        mstSet[0]=true;
        verticesWithDis[0].dis=0;
        TreeSet<Node> pq=new TreeSet<>(new comparator());
        //-------O(V)-------------
        for(int i=0;i<V;i++) pq.add(verticesWithDis[i]);
        int pathSum=0;
        while(!pq.isEmpty()){
            Node curr=pq.pollFirst(); //-----O(logV)
            mstSet[curr.vertex]=true;
            //-------------O(E)--------
            for(AdjNode adj:g.adj[curr.vertex]){
                if(mstSet[adj.dest]==false) {
                    //-----------O(logV)-------------
                    if (verticesWithDis[adj.dest].dis > adj.weight) {
                        pq.remove(verticesWithDis[adj.dest]);
                        if(verticesWithDis[adj.dest].dis!=Integer.MAX_VALUE) pathSum -= verticesWithDis[adj.dest].dis;
                        verticesWithDis[adj.dest].dis = adj.weight;
                        parent[adj.dest] = curr.vertex;
                        pathSum += adj.weight;
                        pq.add(verticesWithDis[adj.dest]);
                    }
                }
            }


        }


        System.out.print("Path is--");
        for(int i=0;i<V;i++){
            if(parent[i]!=-1) {
                System.out.print(i + "-->" + parent[i]);
            }
        }
        return pathSum;
    }

    static class Graph{
        int noOfVer;
        boolean isDir;

        ArrayList<AdjNode>[] adj;
        Graph(int v,boolean isDir){
            noOfVer=v;
            this.isDir=isDir;

            adj=new ArrayList[v];
            for(int i=0;i<v;i++) adj[i]=new ArrayList<>();
        }

        public void addEdge(int i, int j, int i1) {
            AdjNode desti=new AdjNode(i,i1);
            AdjNode destj=new AdjNode(j,i1);

            adj[i].add(destj);
            if(isDir)
                adj[j].add(desti);
        }
    }

    static class comparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.dis-o2.dis;
        }
    }

    static class Node{
        int vertex;
        int dis;

        Node(int vertex ,int dis){
            this.vertex=vertex;
            this.dis=dis;
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
}

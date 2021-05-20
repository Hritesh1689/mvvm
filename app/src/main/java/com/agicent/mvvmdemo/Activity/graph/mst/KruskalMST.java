package com.agicent.mvvmdemo.Activity.graph.mst;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@RequiresApi(api = Build.VERSION_CODES.N)
public class KruskalMST {

    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of vertices and Edges--");
        int[] st=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v=st[0];
        int e=st[1];

        Graph g=new Graph(v,e);
        System.out.println("Enter All Edges--");
        Edge[] edges=g.edges;
        for(int i=0;i<e;i++){
            int[] sr= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges[i]=new Edge(sr[0],sr[1],sr[2]);
        }
        ApplyKruskal(g,v,e);
    }

    private static void ApplyKruskal(Graph g, int v, int e) {
        Parent[] parent=new Parent[v];
        for(int i=0;i<v;i++)
            parent[i]=new Parent(-1,0);

        Arrays.sort(g.edges);
        Edge[] result=new Edge[v-1];
        for(int i=0;i<v-1;i++)
            result[i]=new Edge();
        int i=0,j=0;
        while(i<v-1){
            Edge currEdge=g.edges[j++];
            int fs=find(parent,currEdge.src);
            int ds=find(parent,currEdge.des);

            if(fs!=ds){
                result[i++]=currEdge;
                Union(parent,fs,ds);
            }
        }

        printMST(result);
    }

    private static void printMST(Edge[] result) {
        for(int i=0;i<result.length;i++)
            System.out.println(result[i].src+" "+result[i].des+" "+result[i].weight);
    }

    private static void Union(Parent[] parent, int fs, int ds) {
        if(parent[fs].rank>parent[ds].rank)
            parent[ds].paren=fs;
        else if(parent[fs].rank<parent[ds].rank)
            parent[fs].paren=ds;
        else{
            parent[fs].paren=ds;
            parent[ds].rank+=1;
        }
    }

    private static int find(Parent[] parent, int src) {
        if(parent[src].paren==-1) return src;
        return parent[src].paren=find(parent,parent[src].paren);
    }

    static class Graph{
        int V,E;
        Edge[] edges;

        Graph(int v,int e){
            V=v;
            E=e;
            edges=new Edge[e];
            for(int i=0;i<e;i++)
                edges[i]=new Edge();
        }
    }

    static class Edge implements Comparable<Edge>{
        int src,des,weight;
        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
        Edge(int s,int d,int w){
            src=s;
            des=d;
            weight=w;
        }
        Edge(){}
    }

    static class Parent{
        int paren;
        int rank;

        Parent(int p,int r){
            paren=p;
            rank=r;
        }
    }
}

package com.agicent.mvvmdemo.Activity.graph;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@RequiresApi(api = Build.VERSION_CODES.N)
//------------O(V+E)-----------------
public class TopoLogicalSort {


//    public static void main(String[] args) throws IOException {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter no of vertices and Edges--");
//        int[] st= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int e=st[0];
//        int v=st[1];
//
//        //-----only for third method-------------
//        vertex[] vertices=new vertex[v];
//        for(int i=0;i<v;i++) vertices[i]=new vertex("white",-1,-1,-1,i);
//
//
//
//        ArrayList<ArrayList<Integer>> li=new ArrayList<>();
//        for(int i=0;i<v;i++)
//            li.add(new ArrayList<>());
//        System.out.println("Enter All Edges--");
//        for(int i=0;i<e;i++){
//            int[] sr= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            li.get(sr[0]).add(sr[1]);
//        }
//
//        int[] res=topo(li,v,vertices);
//        for(int i=0;i<res.length;i++)
//            System.out.print(res[i]+" ");
//    }

    public int[] sort(int v,ArrayList<ArrayList<Integer>> li){

        //-----only for third method-------------
        vertex[] vertices=new vertex[v];
        for(int i=0;i<v;i++) vertices[i]=new vertex("white",-1,-1,-1,i);

//        ArrayList<ArrayList<Integer>> li=new ArrayList<>();
//        for(int i=0;i<v;i++)
//            li.add(new ArrayList<>());
//        System.out.println("Enter All Edges--");
//        for(int i=0;i<e;i++){
//            int[] sr= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            li.get(sr[0]).add(sr[1]);
//        }

        return  topo(li,v,vertices);
    }



    //-------method on BFS------------------
//    private static int[] topo(ArrayList<ArrayList<Integer>> adj, int N) {
//        int[] indegrees=new int[N];
//        int[] ret=new int[N];
//        for(int i=0;i<adj.size();i++)
//            for(int j=0;j<adj.get(i).size();j++)
//                indegrees[adj.get(i).get(j)]++;
//
//        Queue<Integer> q=new LinkedList<>();
//        for(int i=0;i<N;i++)
//            if(indegrees[i]==0) q.add(i);
//        int count=0;
//        while(!q.isEmpty()){
//            int curr=q.poll();
//            ret[count++]=curr;
//            for(int i=0;i<adj.get(curr).size();i++)
//                if(--indegrees[adj.get(curr).get(i)]==0)
//                    q.add(adj.get(curr).get(i));
//        }
//
//        return ret;
//    }


    ///---------------------Method on DFS----------------------

//     static int[] topo(ArrayList<ArrayList<Integer>> adj, int N) {
//         boolean[] visited=new boolean[N];
//         Stack<Integer> st=new Stack<>();
//         for(int i=0;i<N;i++)
//             if(!visited[i])
//               topoUtil(i,adj,visited,st);
//
//             int[] ret=new int[N];
//             int i=0;
//         while (!st.empty())
//           ret[i++]=st.pop();
//
//         return ret;
//         }
//
//         static void topoUtil(int start,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer>  st){
//             visited[start]=true;
//             for(int i=0;i<adj.get(start).size();i++)
//                 if(!visited[adj.get(start).get(i)])
//                 topoUtil(adj.get(start).get(i),adj,visited,st);
//
//             st.push(start);
//         }




    private static int[] topo(ArrayList<ArrayList<Integer>> li, int v, vertex[] vertices) {
           int time=0;
           for(vertex ver:vertices){
               if(ver.color.equals("white")){
                   dfs_visit(li,time,ver,vertices);
               }
           }

           Arrays.sort(vertices);
           int[] res=new  int[v];
           for(int i=0;i<v;i++)
               res[i]=vertices[i].pos;

           return res;

    }

    private static void dfs_visit(ArrayList<ArrayList<Integer>> li, int time, vertex ver, vertex[] vertices) {
        time++;
        ver.discoveryTime=time;
        ver.color="gray";

        for(Integer adj:li.get(ver.pos)){
            if(vertices[adj].color.equals("white")){
                vertices[adj].parent=ver.pos;
                dfs_visit(li,time,vertices[adj],vertices);
            }
        }

        ver.color="black";
        time++;
        ver.finishTime=time;
    }


    static class vertex implements Comparable<vertex> {
        String color;
        int discoveryTime;
        int finishTime;
        int parent;
        int pos;

        vertex(String color,int discoveryTime,int finishTime,int parent,int pos){
            this.color=color;
            this.discoveryTime=discoveryTime;
            this.finishTime=finishTime;
            this.parent=parent;
            this.pos=pos;
        }

        @Override
        public int compareTo(vertex o) {
            return this.finishTime-o.finishTime;
        }
    }



}

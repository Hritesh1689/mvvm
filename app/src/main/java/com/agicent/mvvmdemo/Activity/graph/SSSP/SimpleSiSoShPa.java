package com.agicent.mvvmdemo.Activity.graph.SSSP;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.agicent.mvvmdemo.Activity.graph.TopoLogicalSort;
import com.agicent.mvvmdemo.Activity.graph.mst.PrimsAlgo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

//-----O(V+E)
public class SimpleSiSoShPa {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args){
//        int[][] graph=new int[][]{{0,4,6,0,0,0},{4,0,6,3,4,0},{6,6,0,1,0,0},{0,3,1,0,2,3},{0,4,0,2,0,7},{0,0,0,3,7,0}};
//        simple(graph,graph.length);
        //System.out.println(longestSubsequenceLength(new int[]{1 ,3 ,5 ,6 ,4 ,8 ,4 ,3 ,2 ,1}));

        int[] input=new int[]{1,1,1,1,0};

        System.out.println(getOneCount(input,0,input.length-1));

    }

    public static int getOneCount(int[] arr,int start,int end){
        if(start==end) {
            if(arr[start]==1)
            return start+1;
            else return start;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==1) return getOneCount(arr,mid+1,end);
        else return getOneCount(arr,start,mid-1);
    }

    public static int longestSubsequenceLength(final int[] A) {
        int n=A.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        Stack<Integer> st=new Stack<>();
        Stack<Integer> tempst=new Stack<>();
        int i=0;
        leftMax[i++]=0;
        st.push(0);
        for(int j=1;j<A.length;j++){
            while(!st.isEmpty() && A[st.peek()]>=A[j]) tempst.push(st.pop());
            if(st.isEmpty()) leftMax[i]=0;
            else leftMax[i]=Math.max(1+leftMax[st.peek()],leftMax[i-1]);

            while(!tempst.isEmpty()) st.push(tempst.pop());

            st.push(j);
            i++;
        }

        i=n-1;
        rightMax[i--]=0;
        st=new Stack<>();
        tempst=new Stack<>();
        st.push(n-1);
        for(int j=n-2;j>=0;j--){
            while(!st.isEmpty() && A[st.peek()]>=A[j]) tempst.push(st.pop());
            if(st.isEmpty()) rightMax[i]=0;
            else rightMax[i]=Math.max(rightMax[i+1],1+rightMax[st.peek()]);

            while(!tempst.isEmpty()) st.push(tempst.pop());

            st.push(j);
            i--;
        }

        for(int el:leftMax) System.out.print(el+" ");
        System.out.println();
        for(int el:rightMax) System.out.print(el+" ");


        int res=Integer.MIN_VALUE;
        for(int j=0;j<n;j++){
            res=Math.max(res,1+leftMax[j]+rightMax[j]);
        }
        return res;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void simple(int[][] graph, int V) {
        Graph g=new Graph(V,true);
        ArrayList<ArrayList<Integer>> li= new ArrayList<>();
        for(int i=0;i<V;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<V;j++){
                if(graph[i][j]!=0) {
                    temp.add(j);
                    g.addEdge(i, j, graph[i][j]);
                }
            }
            li.add(temp);
        }

        //------------O(V+E)
        int[] topoSorted=new TopoLogicalSort().sort(V,li);
        Node[] vertices=new Node[V];
        for(int i=0;i<V;i++) vertices[i]=new Node(i,Integer.MAX_VALUE,-1);
        vertices[0].dis=0;

        //---------O(E)
        for(int i=0;i<V;i++){
            for(AdjNode adj:g.adj[vertices[topoSorted[i]].vertex]){
                if(vertices[adj.dest].dis>vertices[topoSorted[i]].dis+adj.weight){
                    vertices[adj.dest].dis=vertices[topoSorted[i]].dis+adj.weight;
                }
            }
        }


        for(int i=0;i<V;i++){
            System.out.println("0-->"+vertices[i].vertex+"==="+vertices[i].dis);
        }


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
        public int compare(Node o1,Node o2) {
            return o1.dis-o2.dis;
        }
    }

    static class Node{
        int vertex;
        int dis;
        int par;
        Node(int vertex ,int dis,int par){
            this.vertex=vertex;
            this.dis=dis;
            this.par=par;
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

package com.agicent.mvvmdemo.Activity.graph.SSSP;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;
import java.lang.*;
import java.io.*;
public class BellmanFordAlgo {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int no=Integer.parseInt(br.readLine());
        for(int i=0;i<no;i++){
            int[] vae=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Edge> edgeList=new ArrayList<>();
            int[] ep=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<vae[1]*3;j=j+3)
                edgeList.add(new Edge(ep[j],ep[j+1],ep[j+2]));
            if(BellMonFord(edgeList,vae[0])) System.out.println("1");
            else System.out.println("0");
        }
    }

    public static boolean BellMonFord(ArrayList<Edge> edgeList,int V){
        int[] dis=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        for(int i=0;i<V-1;i++)
            for(int j=0;j<edgeList.size();j++){
                Edge cur=edgeList.get(j);
                dis[cur.des]=Math.min(dis[cur.des],dis[cur.src]+cur.we);
            }

        int[] lastdis=dis.clone();
        for(int j=0;j<edgeList.size();j++){
            Edge cur=edgeList.get(j);
            lastdis[cur.des]=Math.min(lastdis[cur.des],lastdis[cur.src]+cur.we);
        }

        return !Arrays.equals(dis,lastdis);
    }


   static class Edge{
        int src,des,we;
        Edge(int src,int des,int we){
            this.src=src;
            this.des=des;
            this.we=we;
        }
    }
}


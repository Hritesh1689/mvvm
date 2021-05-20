package com.agicent.mvvmdemo.Activity.graph.questionsOnGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class CompetitiveRunner {


    public static void main(String[] args){
        HashMap<Integer,Integer> elevation=new HashMap<>();
        int[][] ele=new int[][]{{0, 5},{ 1, 25}, {2, 15}, {3, 20}, {4, 10}};
        for(int[] el:ele) elevation.put(el[0],el[1]);
        int size=elevation.size();
        int[][] paths=new int[][]{ {0, 1, 10},{0, 2, 8}, {0, 3, 15},
                                   {1, 3, 12}, {2, 4, 10}, {3, 4, 5}, {3, 0, 17}, {4, 0, 10}};
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        ArrayList<ArrayList<int[]>> upHillGraph=new ArrayList<>();
        ArrayList<ArrayList<int[]>> downHillgraph=new ArrayList<>();
        for(int i=0;i<size;i++) {
            graph.add(new ArrayList<>());
            upHillGraph.add(new ArrayList<>());
            downHillgraph.add(new ArrayList<>());
        }
        for(int[] el:paths){
            graph.get(el[0]).add(new int[]{el[1],el[2]});
            if(elevation.get(el[0])>elevation.get(el[1]))
                downHillgraph.get(el[1]).add(new int[]{el[0],el[2]});
            else
                upHillGraph.get(el[0]).add(new int[]{el[1],el[2]});
        }


//        printGraph(upHillGraph);
//        printGraph(downHillgraph);
//        System.out.println(upHillGraph);
//        System.out.println(downHillgraph);
       Stack<Integer> sorted1=topo(graph);
        Stack<Integer> sorted2= (Stack<Integer>) sorted1.clone();
       // System.out.println(sorted);

        int[] uphillDis=getDis(0,upHillGraph,sorted1);
        int[] downhillDis=getDis(0,downHillgraph,sorted2);

        System.out.println(Arrays.toString(uphillDis));
        System.out.println(Arrays.toString(downhillDis));

        int res=Integer.MAX_VALUE;
        for(int i=1;i<uphillDis.length;i++)
            if(uphillDis[i]!=Integer.MAX_VALUE && downhillDis[i]!=Integer.MAX_VALUE)
            res=Math.min(res,uphillDis[i]+downhillDis[i]);
        System.out.println(res);
    }

    private static void printGraph(ArrayList<ArrayList<int[]>> upHillGraph) {
        int count=0;
        for(ArrayList<int[]> el:upHillGraph){
            System.out.print(count+"---");
            for(int[] ell:el){
                System.out.print("{"+ell[0]+","+ell[1]+"}"+", ");
            }
            count++;
            System.out.println();
        }
    }

    private static int[] getDis(int start,ArrayList<ArrayList<int[]>> graph, Stack<Integer> sorted) {
        int[] dis=new int[graph.size()];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[start]=0;

        while(!sorted.isEmpty()){
            int curr=sorted.pop();

            for(int[] neighbour:graph.get(curr)){
                if(dis[neighbour[0]]>dis[curr]+neighbour[1])
                    dis[neighbour[0]]=dis[curr]+neighbour[1];
            }
        }

        return dis;
    }

    private static Stack<Integer> topo(ArrayList<ArrayList<int[]>> graph) {
        boolean[] vis=new boolean[graph.size()];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<graph.size();i++)
            if(!vis[i])
              helper(i,graph,vis,st);
        return st;
    }

    private static void helper(int i, ArrayList<ArrayList<int[]>> graph, boolean[] vis, Stack<Integer> st) {
        vis[i]=true;
        for(int[] el:graph.get(i)) if(!vis[el[0]]) helper(el[0],graph,vis,st);
        st.push(i);
    }
}


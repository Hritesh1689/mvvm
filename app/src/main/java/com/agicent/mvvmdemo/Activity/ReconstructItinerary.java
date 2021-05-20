package com.agicent.mvvmdemo.Activity;


import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class ReconstructItinerary {
    double result=1;
    double curr_max=1;
    int ends=0;

    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Nodwa>> graph=new ArrayList<>();

        ends=end;
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<n;i++)
            graph.get(edges[i][0]).add(new Nodwa(edges[i][1],succProb[i]));

               return  dfs(graph,start,1.0);

    }


    public void decode(String s,StringBuilder res){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
            st.push(s.charAt(i));


        StringBuilder temp=new StringBuilder();
        while(!st.isEmpty()){
            if(st.pop()==']') {
                res.append(temp);
                temp.setLength(0);
            }else if(st.pop()=='['){
                StringBuilder t=temp;
                for(int i=0;i<st.pop()-1;i++)
                    temp.append(t);
            }else
                temp.append(st.pop());

        }
    }


    public static int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1)
            i++;
        return i+1;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public int maxUniqueSplit(String s) {
        int[] countchar=new int[26];
        for(int i=0;i<s.length();i++)
            countchar[s.charAt(i)-'a']++;
        int[] math=new int[17];
        math[0]=0;
        math[1]=1;
        math[2]=1;
        math[3]=2;
        math[4]=2;
        math[5]=2;
        math[6]=3;
        math[7]=3;
        math[8]=3;
        math[9]=3;
        math[10]=4;
        math[11]=4;
        math[12]=4;
        math[13]=4;
        math[14]=4;
        math[15]=5;
        math[16]=5;



        int res=0;
        for(int i=0;i<26;i++){
            if(countchar[i]!=0){
                res+=math[countchar[i]];
            }
        }
        return res;
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();

       

        int np=countNo(p);
        int pl=p.length();
        Queue<Integer> q=new ArrayDeque<>();
        int subsValue=1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int x=(c-'a')+2;
            q.add(x);
            subsValue*=x;
            if(q.size()==pl){
                if(subsValue==np) res.add(i-pl+1);
                subsValue/=q.poll();
            }
        }
        return res;
    }
    public static int countNo(String s){
        int res=1;
        for(char c:s.toCharArray()){
            int x=(c-'a')+2;
            res*=x;
        }
        return res;
    }

   




    private double dfs(ArrayList<ArrayList<Nodwa>> graph, int st,double maxprob) {


            for(int i=0;i<graph.get(st).size();i++){
                if( graph.get(st).get(i).dest==ends ) {
                    if(maxprob==1)
                        return graph.get(st).get(i).weight;
                    else
                   return Math.max(maxprob, maxprob * graph.get(st).get(i).weight);
                }
                else {
                    if (maxprob == 1)
                        dfs(graph,graph.get(st).get(i).dest,graph.get(st).get(i).weight);
                    else
                        dfs(graph,graph.get(st).get(i).dest,maxprob*graph.get(st).get(i).weight);

            }
    }
     return 0.000;

}
}





class Nodwa implements Comparator<Nodwa> {
    int dest;
    double weight;
    Nodwa(int dest,double weight){
        this.dest=dest;
        this.weight=weight;
    }

    @Override
    public int compare(Nodwa o1, Nodwa o2) {
        return (int) (o1.weight-o2.weight);
    }
}










package com.agicent.mvvmdemo.Activity.heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap {
    static ArrayList<Integer> input;
    static ArrayList<Integer> gok;
    public static void main(String[] args){
//        input=new ArrayList<>();
//        gok= new ArrayList<>(Arrays.asList(5, 1, 23, 67, 23, 9, 8, 3, 14, 568, 51, 99, 100));
//        for(Integer el:gok) insert(el);
//       //  int i=-1/2;
//      //   System.out.println(i);
//        //buildMaxHeap(input,input.size());
//        for(Integer el:input){
//            System.out.print(el+" ");
//        }
//        poll();
//        System.out.println();
//        for(Integer el:input){
//            System.out.print(el+" ");
//        }

        System.out.println(lcm(new int[]{1,2,4}));
    }

    public static int lcm(int[] numbers) {
        int lcm = 1;
        int divisor = 2;
        while (true) {
            int cnt = 0;
            boolean divisible = false;
            for (int i = 0; i < numbers.length; i++) {

                if (numbers[i] == 0) return 0;
                else if (numbers[i] < 0)    numbers[i] = numbers[i] * (-1);

                if (numbers[i] == 1)   cnt++;

                if (numbers[i] % divisor == 0) {
                    divisible = true;
                    numbers[i] = numbers[i] / divisor;
                }
            }

            if (divisible)  lcm = lcm * divisor;
            else divisor++;


            if (cnt == numbers.length)  return lcm;

        }
    }

    public static String removeDuplicates(String S) {
        int n=S.length();
        if(n==0 || n==1) return S;
        StringBuilder temp=new StringBuilder();
        if(S.charAt(0)!=S.charAt(1))
            temp.append(S.charAt(0)+"").append(removeDuplicates(S.substring(1)));
        else{
            int i=0;
            while(i+1<n && S.charAt(i)==S.charAt(i+1)) i++;
            temp.append(removeDuplicates(S.substring(i+1)));
        }
        n=temp.length();
        if(temp.charAt(0)!=temp.charAt(1)) return temp.toString();
        else {
            int i = 0;
            while (i + 1 < n && temp.charAt(i) == temp.charAt(i + 1)) i++;
            if (i == n - 1) return "";
            else return temp.substring(i + 1).toString();
        }
    }

    MaxHeap(){
        input=new ArrayList<>();
    }

    private static void heapify(ArrayList<Integer> input, int n, int currpos) {
        int largest=currpos;
        int left=2*currpos+1;
        int right=2*currpos+2;

        if(left<n && input.get(left) > input.get(currpos)) largest=left;
        if(right<n && input.get(right) > input.get(largest)) largest=right;

        if(largest!=currpos){
            swap(input,currpos,largest);
            heapify(input,n,largest);
        }
    }

    private static void swap(ArrayList<Integer> input, int currpos, int largest) {
        int temp= input.get(currpos);
        input.set(currpos, input.get(largest));
        input.set(largest, temp);
    }

    public static void insert(int val){
        input.add(val);
        int size=input.size()-1;
        while( input.get(size) > input.get(parent(size))){
            swap(input,size,parent(size));
            size=parent(size);
        }
    }
    public static int parent(int pos){
        int res=((pos+1)/2)-1;
        return Math.max(res, 0);
    }

    public static int peek(){
        return input.get(0);
    }

    public static int poll(){
        swap(input,0,input.size()-1);
        int res=input.get(input.size()-1);
        input.remove(input.size()-1);
        heapify(input,input.size(),0);
        return res;
    }

}

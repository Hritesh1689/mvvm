package com.agicent.mvvmdemo.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddTwoNumbers {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> out=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0)
                        out.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }

        }
        return new ArrayList<>(out);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) throws NumberFormatException {
        ListNode dummywala=new ListNode(0);
        ListNode ln=dummywala;
        String firstno="";
        String secno="";
        while(l1!=null){
            firstno=l1.val+firstno;
            l1=l1.next;
        }

        while(l2!=null){
            secno=l2.val+secno;
            l2=l2.next;
        }

            if(firstno.length()<secno.length()){
                String trans=firstno;
                firstno=secno;
                secno=trans;
            }
                int sumable=0;
                String sum="";
                for(int i=firstno.length()-1;i>=0;i--)
                {
                    if(!secno.isEmpty()) {
                        sum=String.valueOf(Integer.parseInt(String.valueOf(firstno.charAt(i))) + Integer.parseInt(String.valueOf(secno.charAt(secno.length()-1)))+sumable);
                        if(sum.length()==1){
                            ln.next = new ListNode(Integer.parseInt(sum));
                            sumable=0;
                        }
                        else{
                            ln.next = new ListNode(Integer.parseInt(String.valueOf(sum.charAt(1))));
                            sumable = Integer.parseInt(String.valueOf(sum.charAt(0)));
                        }
                        secno=secno.substring(0,secno.length()-1);
                    }else{
                        sum=String.valueOf(Integer.parseInt(String.valueOf(firstno.charAt(i)))+sumable);
                        if(sum.length()==1){
                            ln.next = new ListNode(Integer.parseInt(sum));
                            sumable=0;
                        }else{
                            ln.next = new ListNode(Integer.parseInt(String.valueOf(sum.charAt(1))));
                            sumable = Integer.parseInt(String.valueOf(sum.charAt(0)));
                        }
                    }
                    ln=ln.next;
                }
                if(sumable!=0){
                    ln.next=new ListNode(sumable);
                    ln=ln.next;
                }

                return dummywala.next;
    }
}

 class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
      //  input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new AddTwoNumbers().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

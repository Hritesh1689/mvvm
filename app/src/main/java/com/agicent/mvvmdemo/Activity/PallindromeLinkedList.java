package com.agicent.mvvmdemo.Activity;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import kotlin.UnsignedKt;

public class PallindromeLinkedList {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            ListNode head = stringToListNode(line);
//
//            boolean ret = new Solution().isPalindrome(head);
//
//            String out = booleanToString(ret);



        String fir="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
      String sec=  "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";


        System.out.print(Solution.wordPattern(fir,sec));
           // System.out.print(fir.length()+" "+sec.split(" ").length);
       // }
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {

       // PallindromeLinkedList pl=new PallindromeLinkedList();
//        PallindromeLinkedList[] ji=new PallindromeLinkedList[3];
//        Integer[] jo=new Integer[4];

        if(head==null)
            return true;
        ArrayList<Integer> lol=new ArrayList<>();
        while(head.next!=null){
            lol.add(head.val);
            head=head.next;
        }
        lol.add(head.val);

        return isPallindrome(lol);
    }

    public boolean isPallindrome(ArrayList<Integer> c){
        int l=0,r=c.size()-1;
        while(l<r){
            if(c.get(l)<0 && c.get(r)<0){
                if(Math.abs(c.get(l))!=Math.abs(c.get(r)))
                    return false;
            }else if(c.get(l)>=0 && c.get(r)>=0){
                if(c.get(l)!=c.get(r))
                    return false;
            }else{
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

//    public int singleNumber(int[] nums) {
//        Set<Integer> helper=new HashSet<>();
//        for(int i=0;i<nums.length;i++){
//            if(helper.contains(nums[i]))
//                helper.remove(nums[i]);
//            else
//                helper.add(nums[i]);
//        }
//        return helper.iterator().hasNext()? helper.iterator().next() : 0;
//    }

    public static int singleNumber(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret=ret^nums[i];
        }
        return ret;
    }


    public String[] findRestaurant(String[] list1, String[] list2) {
        // int l1=0,l2=0;
        // String ou="";
        // int min=Integer.MAX_VALUE;
        // while(l1<list1.length && l2<list2.length){
        //     if(list1[l1].equals(list2[l2])){
        //       if((l2+l1)<min){
        //           min=l2+l1;
        //           ou=list1[l1]+"  ";
        //       }else if((l2+l1)==min){
        //           ou+=list1[l1]+"  ";
        //       }
        //           l2=0;
        //           l1++;
        //       }else{
        //          if(l2==list2.length-1){
        //               l2=0;
        //              l1++;
        //          }
        //         else
        //             l2++;
        //     }
        // }
        // return ou.split("  ");
        int l1=list1.length;
        int l2=list2.length;
        Hashtable<String,Integer> hash=new Hashtable<>();
        for(int i=0;i<l1;i++)
            hash.put(list1[i],i);
        int min=Integer.MAX_VALUE;
        String ou="";
        for(int i=0;i<l2;i++){
            if(hash.containsKey(list2[l2])){
                int temp=hash.get(list2[l2]);
                if(l2+temp<min){
                    min=l2+temp;
                    ou=list2[l2]+"  ";
                }else if(l2+temp==min)
                    ou+=list2[l2]+"  ";
            }
        }

        return ou.split("  ");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int findLHS(int[] nums) {
      int max=0;
      HashMap<Integer,Integer> map=new HashMap<>();
      for(int num:nums)
          map.put(num ,map.getOrDefault(num,0)+1);
      for(int num : map.keySet())
          max= map.containsKey(num+1) ? Math.max(max,map.get(num)+map.get(num+1)) : max;
      return  max;
    }


    public List<String> commonChars(String[] A) {
        String matcher="";
            for(String str : A)
                matcher= matcher.isEmpty() ? str : CommonString(matcher,str) ;
            return new ArrayList<>(Arrays.asList(matcher.split("")));
    }
     String CommonString(String s1, String s2)
    {
        String goal="";
        boolean v[]=new boolean[26];
        Arrays.fill(v,false);
        for (char i:s1.toCharArray())
            v[i - 'a'] = true;
        for (char i :s2.toCharArray())
            if (v[i - 'a'])
                goal+=i;
            return goal;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums1)
            map.put(i,map.getOrDefault(i,0)+1);
        ArrayList<Integer> ou=new ArrayList<>();
        for(int i:nums2){
            if(map.containsKey(i) && map.get(i)>0){
                ou.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        int[] out=new int[ou.size()];
        int count=0;
        for(int i:ou) {
            out[count]=i;
            count++;
        }

        return out;
    }

    public static String convertToTitle(int n) {
        if(n<=26)
            return (char) (n+64)+"";
        else if(n%26==0)
            return convertToTitle(n/26 -1)+"Z";
        else
            return convertToTitle(n/26) + ((char)((n%26) + 64));

    }

    public static int hammingWeight(int t) {
      //  unsigned int b = (unsigned int)n;
        long n=t;
        int count=0;
        String[] st=String.valueOf(n).split("");
        for(String r:st)
            if(r.equals("1"))
                count++;
        return count;
    }


    public static String secMax(int[] arr){
        int firstMax=Integer.MIN_VALUE,secMax=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
           if(arr[i]>firstMax){
               secMax=firstMax;
               firstMax=arr[i];
           }else if(arr[i]<firstMax){
               if(arr[i]>secMax)
                   secMax=arr[i];
           }
        }
        return firstMax+"and"+secMax;
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        if(s.length()==1)
            return true;
        int cs=0,ct=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))
                cs++;
            else
                cs=0;
            if(t.charAt(i)==t.charAt(i-1))
                ct++;
            else
                ct=0;
            if(cs!=ct)
                return false;
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] words=str.split(" ");
        if(pattern.length()!=words.length)
            return false;
        HashMap<Character,Integer> pat=new HashMap<>();
        HashMap<String,Integer> st=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            if(pat.containsKey(pattern.charAt(i)) && st.containsKey(words[i])){
                if(pat.get(pattern.charAt(i))!=st.get(words[i]))
                    return false;
                pat.put(pattern.charAt(i),i+1);
                st.put(words[i],i+1);
            }
            else if(!pat.containsKey(pattern.charAt(i)) && !st.containsKey(words[i])){
                pat.put(pattern.charAt(i),i+1);
                st.put(words[i],i+1);
            }else
                return false;
        }

        return true;
    }


//    public int islandPerimeter(int[][] grid) {
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[i].length;j++)
//                if(grid[i][j]==1)
//                    return calculateArea(i,j,grid);
//        }
//        return 0;
//    }

//    public int calculateArea(int i,int j,int[][] g){
//
//        Queue<List<Integer>> nodeToExplore= new ArrayDeque<>(Arrays.asList(Arrays.asList(i,j)));
//                    if(i==0 && j==0){
//            if(grid[i][j+1]==0 && grid[i+1][j]==0)
//                return 4;
//            else if(grid[i][j+1]==1 && grid[i+1][j]==1)
//                return 2;
//            else if(grid[i][j+1]==0 || grid[i+1][j]==0)
//                return 3;
//        }else if(i!=0 && j!=0){
//            if((grid[i][j+1]==0 && grid[i][j-1]==0) )
//        }
//    }
    }




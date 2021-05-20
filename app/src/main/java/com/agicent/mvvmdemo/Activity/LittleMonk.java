package com.agicent.mvvmdemo.Activity;

import android.os.Build;
import android.util.ArrayMap;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class LittleMonk {
    public static void main(String args[]) throws Exception {

       // StringBuilder out=new StringBuilder();


//        Scanner s = new Scanner(System.in);
//
//        int no = s.nextInt();
//        //s.
//        //s.ne
//        Deque<Integer>[] q = new Deque[5];
//        for (int i = 1; i < 5; i++)
//            q[i] = new ArrayDeque<Integer>();
//        Deque<Integer> first = new ArrayDeque<>();
//
//        for (int i = 0; i < no; i++) {
//            if (s.nextLine().equals("E")) {
//                int school = s.nextInt();
//                if (first.contains(school) == false) first.add(school);
//                q[school].add(s.nextInt());
//                s.nextLine();
//            } else if (s.nextLine().equals("D")) {
//                int index = first.peek();
//                System.out.println(index + " " + q[index].poll());
//                if (q[index].peek() == null)
//                    first.poll();
//                s.nextLine();
//            }
//        }

        //StringBuffer sb=new StringBuffer();



//
//         MyHashSet obj = new MyHashSet();
//  obj.add(122);
////  obj.remove(1);
//        obj.add(4);
//        obj.add(12);
//        obj.remove(12);
// // boolean param_3 = obj.contains(key);



        //--------------------star problem-----------------------------------------------------------------

//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the size");
//        int s=sc.nextInt();
//        int itr1=s;
//
//        int n=((s*(s+1))/2)+s;
//        int itr=n;
//
//        Set<Integer> set=new HashSet<>();
//        set.add(n);
//        for(int i=0;i<itr1;i++){
//            for(int j=1;j<=itr;j++){
//                if(set.contains(j))
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//            //if(i!=s-1) {
//                s--;
//                n = ((s * (s + 1)) / 2) + s;
//                set.add(n);
//           // }
//        }
//
//        for(int j=1;j<=itr;j++)
//            System.out.print("*");
//        System.out.println();
//
//
//        for(int i=0;i<itr1;i++){
//            for(int j=1;j<=itr;j++){
//                if(set.contains(j))
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//            s++;
//            n=((s*(s+1))/2)+s;
//            set.remove(n);
//        }




        


         System.out.println(firstUniqChar("loveleetcode"));

    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> h = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            h.add(nums[i]);
        }
        return h.size();
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        else
            return removeElements(head.next, val);
//        return head;
    }

    public static int strStr(String haystack, String needle) {
        String ori = haystack;
        int count = 1, out = 0;
        while (haystack.length() != 0) {
            if (haystack.indexOf(needle) == 0) {
                out = count - 1;
                break;
            } else
                haystack = ori.substring(count);
            count++;
        }
        return out;
    }

    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            if (l % i == 0) {
                int m = l / i;
                String sub = s.substring(0, i);
                String o = "";

                for (int j = 0; j < m; j++)
                    o += sub;

                if (o.length() == s.length())
                    return true;
            }
        }
        return false;
    }


//    private int search(int i, int j, int[] nums,int target) {
//        int mid=(i+j)/2;
//        if(nums[mid]==target)
//            return mid;
//        else if(target<nums[mid])
//            search(0,mid-1,nums,target);
//        else
//            search(mid+1,nums.length-1,nums,target);
//
//    }



    public static int findShortestSubArray(int[] nums) {
        if(nums.length>1){
            Hashtable<Integer, ArrayList<Integer>> h=new Hashtable<>();
            ArrayList<ArrayList<Integer>> positions=new ArrayList<>();
            int maxLength=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                if(!h.containsKey(nums[i]))
                    h.put(nums[i],new ArrayList<>(Arrays.asList(i)));
                else{
                    h.get(nums[i]).add(i);
                    h.put(nums[i],h.get(nums[i]));
                }
            }


            Iterator<Integer> itr=h.keySet().iterator();
            while (itr.hasNext()){
                int l=itr.next();
                if(h.get(l).size()>maxLength) {
                    maxLength=h.get(l).size();
                    // positions.add(h.get(l));
                }
            }

            Iterator<Integer> itr2=h.keySet().iterator();
            while (itr2.hasNext()){
                int l=itr2.next();
                if(h.get(l).size()==maxLength) {
                    //  maxLength=h.get(l).size();
                    positions.add(h.get(l));
                }
            }

            int min=Integer.MAX_VALUE;
            for(int i=0;i<positions.size();i++){
                int kool=positions.get(i).get(positions.get(i).size()-1)-positions.get(i).get(0)+1;
                if(kool<min)
                    min=kool;
            }


            return min;
        }else
            return 1;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double max=Double.MIN_VALUE;
        double sum=0;
        for(int i=0;i<nums.length;i++){
            if(i<k){
                sum+=nums[i];
                if(i==k-1){
                    if(sum/k >max)
                        max=sum/k;
                }
            }else{
                sum=sum+nums[i]-nums[i-k];
                if(sum/k >max)
                    max=sum/k;
            }

        }
        return (double)max;
    }

    public static int repeatedStringMatch(String A, String B) {
        double d=B.length();
        double d1=A.length();
        int loopcount=(int) (Math.round(d/d1)+1);
        if(A.contains(B))
            return 1;
           String j="";
        for(int i=1;i<=loopcount;i++){
            j+=A;
            if(j.contains(B))
                return i;
        }

        return 0;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ou=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int co=0;
            char[] ca=queries[i].toCharArray();
            Arrays.sort(ca);
            //StringBuilder iq=new StringBuilder(new String(ca));
          //  int count=iq.lastIndexOf(String.valueOf(ca[0]))+1;
            long count = new String(ca).chars().filter(ch -> ch == ca[0]).count();
            for(int j=0;j<words.length;j++){

                char[] ca2=words[j].toCharArray();
                Arrays.sort(ca2);
                StringBuilder iq2=new StringBuilder(new String(ca2));
                int count2=iq2.lastIndexOf(String.valueOf(ca2[0]))+1;


                if(count<count2)
                    co++;
            }
            ou[i]=co;
        }

            return ou;
    }

    public static int calculateMinFreq(String a) {

        int[] count = new int[26];

        for(int i=0; i<a.length(); i++)
            count[a.charAt(i) - 'a']++;


        int min = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                min = count[i];
                break;
            }
        }
        return min;
    }


    public static String addBinary(String a, String b) {
        Stack<Character> sta=new Stack<>();
        Stack<Character> stb=new Stack<>();
        String goal="";
        boolean haasil=false,extended=false;
        for(int i=0;i<a.length();i++)
            sta.push(a.charAt(i));
        for(int i=0;i<b.length();i++)
            stb.push(b.charAt(i));

        while(!sta.isEmpty() && !stb.isEmpty()){
            if(sta.peek()=='1' && stb.peek()=='1'){
                if(haasil)
                    goal="1"+goal;
                else{
                    goal="0"+goal;
                    haasil=true;
                }
            }else if(sta.peek()=='0' && stb.peek()=='0'){
                if(haasil) {
                    goal = "1" + goal;
                    haasil=false;
                }
                else
                    goal="0"+goal;
            }else{
                if(haasil)
                    goal = "0" + goal;
                else
                    goal="1"+goal;
            }
            sta.pop();
            stb.pop();
        }

        if(a.length()>b.length()){
            while(!sta.isEmpty()){
                if(sta.peek()=='1'){
                    if(haasil)
                        goal="0"+goal;
                    else
                        goal="1"+goal;
                }else{
                    if(haasil) {
                        goal = "1" + goal;
                        haasil=false;
                    }
                    else
                        goal="0"+goal;
                }
                sta.pop();
            }
        }

        if(a.length()<b.length()){
            while(!stb.isEmpty()){
                if(stb.peek()=='1'){
                    if(haasil)
                        goal="0"+goal;
                    else
                        goal="1"+goal;
                }else{
                    if(haasil) {
                        goal = "1" + goal;
                        haasil=false;
                    }
                    else
                        goal="0"+goal;
                }
                stb.pop();
            }
        }

          if(haasil)
              return "1"+goal;
          else
            return goal;
    }



    public List<Integer> addToArrayForm(int[] A, int K) {
        int currpos=A.length-1;
        Stack<Integer> ou=new Stack<>();
        Stack<Integer> in1=new Stack<>();
        Queue<Integer> in2=new ArrayDeque<>();
        boolean haasil=false;

        for(int i=0;i<A.length;i++)
            in1.push(A[i]);
        while(K != 0)
        {
            in2.add(K % 10);
            K = K / 10;
        }


        while(!in1.isEmpty() && !in2.isEmpty()){
            if(in1.peek()+in2.peek()>9){
                if(haasil)
                    ou.push((1 + in1.peek() + in2.peek()) % 10);
                else{
                    ou.push((in1.peek() + in2.peek()) % 10);
                    haasil=true;
                }
            }else if(in1.peek()+in2.peek()==9){
                if(haasil)
                    ou.push((1 + in1.peek() + in2.peek()) % 10);
                else
                    ou.push(9);
            }else{
                if(haasil) {
                    ou.push(1 + in1.peek() + in2.peek());
                    haasil=false;
                }
                else
                    ou.push(in1.peek() + in2.peek());
            }
            in1.pop();
            in2.poll();
        }

        if(in1.size()>in2.size()){
            while(!in1.isEmpty()){
                if(in1.peek()==9){
                    if(haasil)
                        ou.push((1 + in1.peek())% 10);
                    else
                       ou.push(9);
                }else{
                    if(haasil) {
                        ou.push(1 + in1.peek());
                        haasil=false;
                    }
                    else
                        ou.push(in1.peek());
                }
                in1.pop();
            }
        }

        if(in1.size()<in2.size()){
            while(!in2.isEmpty()){
                if(in2.peek()==9){
                    if(haasil)
                        ou.push((1 + in2.peek())% 10);
                    else
                        ou.push(9);
                }else{
                    if(haasil) {
                        ou.push(1 + in2.peek());
                        haasil=false;
                    }
                    else
                        ou.push(in2.peek());
                }
                in2.poll();
            }
        }

        if(haasil)
            ou.push(1);

        ArrayList<Integer> output=new ArrayList<>();

        while(!ou.isEmpty()){
            output.add(ou.pop());
        }

        return output;
    }

    public static String addStrings(String num1, String num2) {

        StringBuilder a = new StringBuilder(num1);
        StringBuilder b = new StringBuilder(num2);
        StringBuilder result = new StringBuilder();
        int count =0;
        if(a.length()>b.length())
        {
            b.reverse();
            count =a.length()-b.length();
            while(count!=0)
            {
                b.append(0);
                count--;
            }
            b.reverse();
        }
        else if(a.length()<b.length())
        {
            a.reverse();
            count =b.length()-a.length();
            while(count!=0)
            {
                a.append(0);
                count--;
            }
            a.reverse();
        }

        char carry='0';
        for(int i=b.length()-1;i>=0;i--)
        {
            int temp = a.charAt(i)+b.charAt(i)+carry-48*3;
            result.append(temp%10);
            carry = (char)(temp/10+'0');
        }
        if(carry!='0')
            result.append(carry);
        result.reverse();
        return String.valueOf(result);
    }

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,List<Integer>> h=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
       // Arrays.s
      //  Collections.sort(h.keySet().iterator());
        while(h.keySet().iterator().hasNext()){
            list.add(h.keySet().iterator().next());
        }

        Collections.sort(list);
        for(int i=0;i<nums.length;i++){
            if(!h.containsKey(nums[i]))
                h.put(nums[i],new ArrayList<>(Arrays.asList(i)));
            else {
                h.get(nums[i]).add(i);
                h.put(nums[i], h.get(nums[i]));
            }
        }
        int count=0;
        Iterator<Integer> itr=h.keySet().iterator();
       while(itr.hasNext()){
           count=count+getGood(h.get(itr.next()).size());
       }
       return count;
    }

    private int getGood(int size) {
        if(size==1)
            return 0;
        else
        {
            int coun=0;
            for(int i=1;i<=size;i++)
                coun=coun+i;

            return coun;
        }
    }


//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        Queue<TreeNode> q=new ArrayDeque<TreeNode>();
//        if(root!=null)
//            q.add(root);
//        else
//            return new ArrayList<>();
//        List<List<Integer>> ou=new ArrayList<>();
//        while(!q.isEmpty()){
//            List<Integer> temp=new ArrayList<>();
//            int qsize=q.size();
//            for(int i=0;i<q.size();i++){
//                TreeNode curr=q.poll();
//
//                temp.add(curr.val);
//                if(curr.left!=null)
//                    q.add(curr.left);
//                if(curr.right!=null)
//                    q.add(curr.right);
//
//                if(i==qsize-1)
//                    ou.add(new ArrayList<>(temp));
//
//            }
//        }
//        Collections.reverse(ou);
//        return ou;
//    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer,Integer> occur=new TreeMap<>();
        for (int value : arr1) {
            if (!occur.containsKey(value))
                occur.put(value, 1);
            else
                occur.put(value, occur.get(value) + 1);
        }

        int count=0;
        for (int value : arr2) {
            for (int j = 0; j < occur.get(value); j++) {
                arr1[count] = value;
                count++;
            }
            occur.remove(value);
        }

        for (int ko : occur.keySet()) {
            for (int j = 0; j < occur.get(ko); j++) {
                arr1[count] = ko;
                count++;
            }

        }

        return arr1;
    }

    public int maxProfit(int[] prices) {
        String pr="";
        for(int i:prices)
            pr+=prices[i]+" ";

        int[] sahara=prices;
        Arrays.sort(sahara);

        StringBuilder st=new StringBuilder("");
        for(int i:sahara)
            st.append(sahara[i]+" ");



       // if(pr.indexOf(String.valueOf(sahara[0]))<pr.indexOf(String.valueOf(sahara[sahara.length-1])))
            return sahara[sahara.length-1]-sahara[0];
//
//        int maxProfit=Integer.MIN_VALUE;
//        for(int i=0;i<prices.length-1;i++){
//            for(int j=i+1;j<prices.length;j++){
//                if(prices[j]-prices[i]>maxProfit)
//                    maxProfit=prices[j]-prices[i];
//            }
//        }
//        return (maxProfit>0)? maxProfit:0 ;
    }

    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i]= (int) Math.sqrt(A[i]);//*A[i];
            int k=i;
            while(k>0){
                if(A[k]<A[k-1])
                {
                    A[k-1]=A[k]+A[k-1];
                    A[k]=A[k-1]-A[k];
                    A[k-1]=A[k-1]-A[k];
                }
                k--;
            }
        }
        return A;
    }

    public static boolean isPalindrome(String s) {
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        s=s.toLowerCase();

        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }


    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        char[] st= s.toCharArray();
        StringBuilder go1=new StringBuilder(s);
        StringBuilder go2=new StringBuilder(s);


        while(l<r){
            if((st[l])!=(st[r])){
              go1.replace(l,l+1,"");
              go2.replace(r,r+1,"");
              break;
            }
            l++;
            r--;
        }

        char[] st1=go1.toString().toCharArray();
        char[] st2=go2.toString().toCharArray();
        int l1=0,r1=go1.length()-1;
        int l2=0,r2=go2.length()-1;



        while(l1<r1){
            if((st1[l1])!=(st1[r1])){
               return false;
            }
            l1++;
            r1--;
        }

        while(l2<r2){
            if((st2[l2])!=(st2[r2])){
                return false;
            }
            l2++;
            r2--;
        }


        return true;
    }


    private boolean isAlphaNumeric(char c) {
        return ('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }

    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j]==1)
                    return calculateArea(i,j,grid);
        }
        return 0;
    }

    public int calculateArea(int i,int j,int[][] g){

        Queue<List<Integer>> nodeToExplore= new ArrayDeque<>(Arrays.asList(Arrays.asList(i,j)));
        int totalArea=0;

        while(!nodeToExplore.isEmpty()){
            int i1=nodeToExplore.peek().get(0);
            int j1=nodeToExplore.peek().get(1);

            

            List<List<Integer>> unvisitedNeighbours=getUnvisitedNeighbour(i1,j1,g);

            for(int k=0;k<unvisitedNeighbours.size();k++)
                nodeToExplore.add(unvisitedNeighbours.get(k));
        }
        return totalArea;
    }

    private static List<List<Integer>> getUnvisitedNeighbour(int i, int j, int[][] matrix) {
        List<List<Integer>> unvisitedNeighbour=new ArrayList<>();

        if(i>0 && matrix[i-1][j]==1)
            unvisitedNeighbour.add(Arrays.asList(i-1,j));
        if(i<matrix.length-1 && matrix[i+1][j]==1)
            unvisitedNeighbour.add(Arrays.asList(i+1,j));
        if(j>0 && matrix[i][j-1]==1)
            unvisitedNeighbour.add(Arrays.asList(i,j-1));
        if(j<matrix[0].length-1 && matrix[i][j+1]==1)
            unvisitedNeighbour.add(Arrays.asList(i,j+1));

        return unvisitedNeighbour;
    }


    class MyStack {


        Queue<Integer> q;

        /** Initialize your data structure here. */
        public MyStack() {
           q=new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(q.iterator().hasNext()){
                Integer curr=q.iterator().next();
                if(q.iterator().next()==null) {

                    return q.poll();
                }
            }
            return 0;
        }

        /** Get the top element. */
        public int top() {
            while(q.iterator().hasNext()){
                Integer curr=q.iterator().next();
                if(q.iterator().next()==null)
                    return curr;
            }
            return 0;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
          return q.isEmpty();
        }


    }




    public static int rotatedDigits(int N) {
        int count=0;
        for(int i=1;i<=N;i++){
            while(i>0){
                int cur=i%10;
                if(cur==2 || cur==5 || cur==6 || cur==9){
                    count++;
                    break;
                }
                i/=10;
            }
        }

        return count;
    }

    public String getHint(String secret, String guess) {
        int BullCount=0,CowCount=0;
        int[] nums=new int[10];
        for(int i=0;i<secret.length();i++){
            int s=Character.getNumericValue(secret.charAt(i));
            int g=Character.getNumericValue(guess.charAt(i));

            if(s==g)
                BullCount++;

            if(nums[s]<0) CowCount++;
            if(nums[g]>0) CowCount++;

            nums[g]--;
            nums[s]++;
        }
        return BullCount+"A"+CowCount+"B";
    }

    public String reverseStr(String s, int k) {
        int count=0;
        String ou="";
        for(int i=0;i<s.length();i++){
           if(count<k){
               ou=s.charAt(i)+ou;
               count++;
           }else if(count<2*k){
               ou+=s.charAt(i);
               if(count==2*k-1)
                   count=0;
           }
        }
    return ou;

    }


    public static String reverseVowels(String s) {

        int start=0,end=s.length()-1;

        char[] c=s.toCharArray();

        while(start<end){

                while (!checkVowel(c[start]) && start<end)
                    start++;



                while (!checkVowel(c[end]) && start<end)
                    end--;


            reverse(c,start,end);

            start++;
            end--;
        }

        return new String(c);
    }

    public static void reverse(char[] c,int s,int e){
        char temp=c[e];
        c[e]=c[s];
        c[s]=temp;
    }

    public static boolean checkVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' )
            return true;
        else
            return false;
    }
//
//    public static int firstUniqChar(String s) {
//        ArrayMap<Character,List<Integer>> map=new ArrayMap<>();
//        for(int i=0;i<s.length();i++){
//            char c=s.charAt(i);
//            if(map.containsKey(c)) map.get(c).add(i);
//            else map.put(c,new ArrayList<>(Arrays.asList(i)));
//        }
//
//        Iterator<Character> itr=map.keySet().iterator();
//        while(itr.hasNext()){
//            char c=itr.next();
//            if(map.get(c).size()==1)
//                return map.get(c).get(0);
//        }
//
//        return -1;
//    }

    public static boolean isSubsequence(String s, String t) {
        int[] ch=new int[26];
        for(char c:s.toCharArray())
            ch[c-'a']++;

        for(int i=0;i<t.length();i++){
            if(ch[t.charAt(i)-'a']==0)
                t.replace(String.valueOf(t.charAt(i)),"");
            else
                ch[t.charAt(i)-'a']--;
        }

        return s.equals(t);
    }


    public String toHex(int num) {
        StringBuilder s=new StringBuilder();
        while(num!=0){
            int res=num%16;
            jodo(s,res);
            num/=16;
        }
        jodo(s,num);
        return s.reverse().toString();
    }

    public void jodo(StringBuilder sb,int el){
        if(el==10)
            sb.append("a");
        else if(el==11)
            sb.append("b");
        else if(el==12)
            sb.append("c");
        else if(el==13)
            sb.append("d");
        else if(el==14)
            sb.append("e");
        else if(el==15)
            sb.append("f");
        else
            sb.append(el);
    }

    public static int numTrees(int n) {
        int[] ou=new int[n+1];
        if(n==0 || n==1 || n==2)
            return n;
        if(n==3)
            return 5;
        ou[0]=0;
        ou[1]=1;
        ou[2]=2;
        ou[3]=5;

        for(int i=4;i<=n;i++){
            int counter=i-1;
            for(int j=0;j<(i+1)/2;j++) {
                  if(counter==i-1)
                    ou[i] += 2 * (ou[counter] *1 );
                  else
                      ou[i] += 2 * (ou[counter] * ou[i - 1 - counter]);
                counter--;
            }
        }

        return ou[n];
    }

    public static int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int res=0;
        int number=0;
        int sign=1;
        for(char c:s.toCharArray()) {
            if(Character.isDigit(c)){
                if(sign==3)
                    number/=(int)(c-'0');
                if(sign==2)
                    number*=(int)(c-'0');
                else
                    number=number*10+(int)(c-'0');
                sign=1;
            }
            else if(c=='+' || c=='-'){
                res+=sign*number;
                number=0;
                sign=(c=='+') ? 1 :-1;
            }
            else if(c=='*' || c=='/')
                sign= c=='*' ? 2 :3;

        }

        if(number != 0)
            res += sign * number;
        return res;
    }


    public boolean isPathCrossing(String path) {
        Set<String> s=new HashSet<>();
        s.add("(0,0)");
        int[] pichala=new int[]{0,0};
        for(char c:path.toCharArray()){

            if(c=='N')
                pichala[1]++;
            else if(c=='E')
                pichala[0]++;
            else if(c=='S')
                pichala[1]--;
            else if(c=='W')
                pichala[0]--;


            String dco="("+pichala[0]+""+pichala[1]+")";

            if(s.contains(dco))
                return true;
            else
                s.add(dco);
        }
        return false;
    }

    public String destCity(List<List<String>> paths) {
        Set<String> startCity=new HashSet<>();
        List<String> endCity=new ArrayList<>();

        for(int i=0;i<paths.size();i++){
            startCity.add(paths.get(i).get(0));
            endCity.add(paths.get(i).get(1));
        }

        for(int i=0;i<endCity.size();i++)
            if(!startCity.contains(endCity.get(i)))
                return endCity.get(i);

        return "";
    }

    public String sortString(String s) {
        int[] f=new int[26];
        for(char c:s.toCharArray())
            f[c-'a']++;

        int[] com=new int[26];
        String res="";
        while(!Arrays.equals(com,f)){
            for(int i=0;i<f.length;i++){
                if(f[i]!=0) {
                    res +=(int)(i+'a');
                    f[i]--;
                }
            }

            for(int i=f.length-1;i>=0;i--){
                if(f[i]!=0) {
                    res +=(int)(i+'a');
                    f[i]--;
                }
            }
        }
        return res;
    }

    public String generateTheString(int n) {

        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++)
            res.append("a");
        if(n%2==0)
            res.replace(res.length()-1,res.length(),"b");

        return res.toString();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int county(int[] A, int k){
        int start=0,n=A.length;
        int res=0;
        HashMap<Integer,Integer> s=new HashMap<>();
        for(int end=0;end<n;end++){
            s.put(A[end],s.getOrDefault(A[end],0)+1);
            k-=s.size();

            while(k<0 && start<end){
                if(s.get(A[start])==1)
                    k++;

                    s.put(A[start],s.getOrDefault(A[end],0)-1);

                start++;
            }
            res+=end-start+1;
        }
        return res;
    }


    public static int firstUniqChar(String s) {
        // int[] bh=new int[26];
        // for(char c:s.toCharArray())
        //     bh[c-'a']++;
        // for(int i=0;i<s.length();i++)
        //    if(bh[s.charAt(i)-'a']==1)
        //        return i;
        // return -1;
        int n=s.length();
        boolean[] isRepeated =new boolean[26];
       DoublyLinkedList dl=new DoublyLinkedList();
        DoublyLinkedList.Node[] address=new DoublyLinkedList.Node[26];
        for(char c:s.toCharArray()){
            if(isRepeated[c-'a'])
                continue;
            else if(address[c-'a']!=null){
                isRepeated[c-'a']=true;
               // DoublyLinkedList.Node newo=new  DoublyLinkedList.Node(c);
                 dl.Delete(c);
            }else{
                 DoublyLinkedList.Node add= dl.AddToTail(c);
                  address[c-'a']=add;
            }
        }
   return s.indexOf(dl.head.data);
    }

}

 class DoublyLinkedList{
    Node head;

     static class Node{
        char data;
        Node next;
        Node prev;

        public Node(char data)
        {
            this.data=data;
        }
    }

    public void AddToFront(char new_node){
        Node newNode=new Node(new_node);
        newNode.prev=null;
        newNode.next=head;

        if(head!=null)
        head.prev=newNode;

        head=newNode;
    }

     public Node AddToTail(char new_node){
         Node newNode=new Node(new_node);
         newNode.next=null;

         Node last=head;

         if(head==null){
             newNode.prev=null;
             head=newNode;
             return head;
         }

         while(last.next!=null)
             last=last.next;

         last.next=newNode;
         newNode.prev=last;

         return newNode;
     }

     public void AddAfter(Node prev_node,char new_node){
         Node newNode=new Node(new_node);

         if(prev_node==null)
             return;

         newNode.next=prev_node.next;
         prev_node.next=newNode;
         if(newNode.next!=null)
          newNode.next.prev=newNode;
         newNode.prev=prev_node;
    }

     public void AddBefore(Node next_node,char new_node){
         Node newNode=new Node(new_node);

         if(next_node==null)
             return;

         newNode.prev=next_node.prev;
         next_node.prev=newNode;
         if(newNode.prev!=null)
             newNode.prev.next=newNode;
         newNode.next=next_node;
     }

     public void Delete(char for_del){
        if(head==null )
                return;

            if(for_del==head.data) {
                head = head.next;
                return;
            }

            Node last=head;

            while(last!=null && last.data!=for_del)
                last=last.next;

            if(last.next!=null)
                last.next.prev=last.prev;

           // if(for_del.prev!=null)
                last.prev.next=last.next;

            return;
     }


     public boolean uniqueOccurrences(int[] arr) {
         HashMap<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<arr.length;i++)
             map.put(arr[i],map.getOrDefault(arr[i],0)+1);

         Iterator<Integer> itr=map.values().iterator();
         Set<Integer> val=new HashSet<>();
         while(itr.hasNext()){
             int cur=itr.next();
             if(!val.contains(cur))
                 val.add(cur);
             else
                 return false;

         }
            return true;
     }

     @RequiresApi(api = Build.VERSION_CODES.N)
     public String[] findWords(String[] words) {
             Set<Character> upper=new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
                     Set<Character> middle=new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
                             Set<Character> low=new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
                             ArrayList<String> out=new ArrayList<>();
                             for(int i=0;i<words.length;i++){
                                 boolean inup=false,inmid=false,inbel=false;
                                 for(int j=0;j<words[i].length();j++){
                                     if(upper.contains(words[i].toLowerCase().charAt(j)))
                                         inup=true;
                                     else if(middle.contains(words[i].toLowerCase().charAt(j)))
                                         inmid=true;
                                     else if(low.contains(words[i].toLowerCase().charAt(j)))
                                         inbel=true;
                                 }

                                 if((inup && !inbel && !inmid) || (!inup && inbel && !inmid) || (!inup && !inbel && inmid))
                                     out.add(words[i]);

                             }


                             return out.stream().toArray(String[]::new);
     }

     public boolean isAlienSorted(String[] words, String order) {
         for(int i=1;i<words.length;i++){
             if(words[i].length()>=words[i-1].length() && order.indexOf(words[i].charAt(0))>=order.indexOf(words[i-1].charAt(0)))
                 continue;
             else return false;
         }
         return true;
     }


     @RequiresApi(api = Build.VERSION_CODES.N)
     public boolean checkStraightLine(int[][] c) {
         if (c.length<=2) return true;

         PriorityQueue<int[]> pq=new PriorityQueue<>(c.length, new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 if(o1[0]<=o2[0] && o1[1]<=o2[1])
                     return 1;
                 else if(o1[0]>=o2[0] && o1[1]>=o2[1])
                     return -1;
                 return 0;
             }
         });
         double slope=(c[1][1]-c[0][1]+0.0)/(c[1][0]-c[0][0]);
         for(int i=2;i<c.length;i++)
             if(((c[i][1]-c[i-1][1]+0.0)/(c[i][0]-c[i-1][0]))!=slope)
                 return false;
         return true;
     }




}

class MyHashSet {
    int capacity=15000;
    List<Integer>[] buckets;

    public int myHashCode(int key){
        return key%capacity;
    }


    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=new LinkedList[capacity];
    }

    public void add(int key) {
        if(contains(key))
            return;

        
        int i=myHashCode(key);
        if(buckets[i]==null) buckets[i]=new LinkedList<>();
        if(buckets[i].indexOf(key)==-1)
            buckets[i].add(key);

    }

    public void remove(int key) {
        int i=myHashCode(key);
        if(buckets[i]==null) return;
        if(buckets[i].indexOf(key)!=-1)
            buckets[i].remove(buckets[i].indexOf(key));

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i=myHashCode(key);
        if(buckets[i]==null || buckets[i].indexOf(key)==-1) return false;
        else return true;
    }



}

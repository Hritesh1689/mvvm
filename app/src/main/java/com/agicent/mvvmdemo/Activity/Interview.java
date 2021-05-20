package com.agicent.mvvmdemo.Activity;

import android.os.Build;
import android.util.Pair;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
@RequiresApi(api = Build.VERSION_CODES.N)
public class Interview {
    public static int[][] dp=new int[1001][1001];

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) throws IOException {

        //printSecondAnswer(sortColors(new int[]{2,0,2,1,1,0}));
        for(int i=0;i<dp.length;i++)
         Arrays.fill(dp[i],-1);
         System.out.print(dp[1000][4]);
       // System.out.println(getOccurence(99, 3) );


        //  Scanner scan=new Scanner(System.in);
//        System.out.print("Enter the size of Array");
//
//        int n=scan.nextInt();
//        int[] arr=new int[n];
//        for(int i=0;i<n;i++)
//            arr[i] = scan.nextInt();
//
//        System.out.print("Enter the size of sec Array");
//
//        int m=scan.nextInt();
//        int[] arr2=new int[m];
//        for(int i=0;i<m;i++)
//            arr2[i] = scan.nextInt();


         // firstQuestion(arr);

       //printSecondAnswer(secondQuestion(arr));

      // System.out.print(thirdQuestion(arr,arr2));


//       System.out.print("Enter the no of Row");
//        fourthQuestion(scan.nextInt());

        System.out.println(frequencySort("tree") );
    }

    private static void printSecondAnswer(int[] secondQuestion) {
        for(int i=0;i<secondQuestion.length;i++)
            System.out.print(secondQuestion[i]+" ");
    }





    //---------------First  Question-----------------
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void firstQuestion(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:arr)
            map.put(ele,map.getOrDefault(ele,0)+1);

        Iterator<Integer> keys=map.keySet().iterator();
        while(keys.hasNext()){
            int curr=keys.next();
            if(map.get(curr)>2)
                System.out.print(curr+" ");
        }

    }



    //------------Third Question-----------------
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean thirdQuestion(int[] arr1,int[] arr2){
        if(arr2.length==0) return true;
        int pointer1=0,pointer2=0;
        int len1=arr1.length,len2=arr2.length;

        while(pointer1<len1 && pointer2<len2){
            if(arr1[pointer1]==arr2[pointer2])
            {
                pointer1++;
                pointer2++;
            }else
                pointer1++;
        }

        if(pointer2==len2 && pointer1==len1)
            return true;
        else if(pointer1==len1)
        return false;
        else
            return true;
    }




    //-------------------------Fourth Question-----------------
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void fourthQuestion(int n){
       if(n==1)
           System.out.print("1");
       else if(n==2){
           System.out.println(" 1");
           System.out.print("23");
       }
       int[] fab=new int[((n*(n+1))/2)+1];
       fab[0]=1;
       fab[1]=1;
       int itr=1;
       int counter=n;

       for(int i=1;i<=n;i++) {
           for (int j = 1; j <= n; j++) {
               if (j >= counter) {
                   if (itr==1)
                       System.out.print(" "+fab[itr++]);
                   else {
                       fab[itr]=fab[itr-1]+fab[itr-2];
                       System.out.print(" "+fab[itr]);
                       itr++;
                   }
               } else
                   System.out.print("  ");
           }
           System.out.println();
           counter--;
       }
    }





    //----------------Second Question-----------------------
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int[] secondQuestion(int[] arr){
      int[] out=new int[arr.length];

      int maxEle=Integer.MIN_VALUE;
      for(int el:arr)
          if(el>maxEle)
              maxEle=el;


      int[] hash=new int[maxEle+1];

      for(int ele:arr)
          hash[ele]++;

      for(int i=0;i<arr.length;i++){
          int currIndexValue=0;

          for(int j=arr[i]+1;j<hash.length;j++)
              if(hash[j]>0)
                  currIndexValue+=j*hash[j];

              if(currIndexValue==0)
                  out[i]=arr[i]*arr[i];
              else
                  out[i]=currIndexValue;

      }
      return out;
    }



    public static int[] sortColors(int[] nums) {
        int zeroCount=0,oneCount=0,twoCount=0;
        for(int i=0;i<nums.length;i++) {
           if(nums[i]==0)
               zeroCount++;
           else if(nums[i]==1)
               oneCount++;
           else if(nums[i]==2)
               twoCount++;
        }
        int count=-1;

        for(int i=0;i<zeroCount;i++)
            nums[++count]=0;

        for(int i=0;i<oneCount;i++)
            nums[++count]=1;

        for(int i=0;i<twoCount;i++)
            nums[++count]=2;

        return nums;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[][] merge(int[][] in) {
        ArrayList<int[]> ou=new ArrayList<>();
        for(int i=0;i<in.length-1;i++)
            if(in[i][1]>=in[i+1][0])  ou.add(new int[]{in[i][0],in[i+1][1]});
            else  ou.add(in[i]);
            return ou.stream().toArray(int[][]::new);
    }

    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s);
        int prev=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==' '){
                reverse(sb,prev,i-1);
                prev=i;
            }
        }
        reverse(sb,prev,s.length()-1);
        return sb.toString();
    }

    public void reverse(StringBuilder str,int st,int end){
        while(st<end) {
            char temp = str.charAt(end);
            str.setCharAt(end, str.charAt(st));
            str.setCharAt(st, temp);
            st++;
            end--;
        }
    }


    public String intToRoman(int num) {

        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numer={1000,900,500,400,100,90,50,40,10,9,5,4,1};

        int i=0;
        StringBuilder res=new StringBuilder();
        while(num>0){
            if(num-numer[i]>0){
                res.append(romans[i]);
                num-=numer[i];
            }else
                i++;
        }

        return res.toString();
    }



    static int getOccurence(int n, int d)
    {

        // Initialize result
        int result = 0;

        // Count appearances in numbers
        // starting from d.
        int itr = d;

        while (itr <= n)
        {

            // When the last digit is
            // equal to d
            if (itr % 10 == d)
                result++;

            // When the first digit is
            // equal to d then
            if (itr != 0 && itr/10 == d)
            {

                // increment result as
                // well as number
                result++;
                itr++;
            }

            // In case of reverse of number
            // such as 12 and 21
            else if (itr/10 == d-1)
                itr = itr + (10 - d);
            else
                itr = itr + 10;
        }

        return result;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<Integer>((o1, o2) -> o2-o1);

        for(int i:nums) q.offer(i);
        while(k-->0) q.poll();
        return q.peek();
    }




    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
                 PriorityQueue<int[]> q=new PriorityQueue<>((o1, o2) -> {
                     int p1=o1[0];
                     int p2=o2[0];
                     return p2-p1;
                 });


        // PriorityQueue<Long> o=new PriorityQueue<>((o1, o2) -> (int)(o2-o1))   ;

        for(int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
            q.offer(new int[]{map.get(i),i});

            if(q.size()>k)
                q.poll();
        }

        int[] out=new int[q.size()];
        int count=0;
        while(!q.isEmpty())
            out[count]=q.poll()[1];



        return out;
    }


    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int p1= o1[0]*o1[0]+o1[1]*o1[1];
                int p2= o2[0]*o2[0]+o2[1]*o2[1];
                return (p2-p1);
            }
        });

        for(int i=0;i<points.length;i++) {
            q.offer(points[i]);

            if(q.size()>K)
                q.poll();
        }


        return  q.toArray(new int[K][2]);


    }





    public static String frequencySort(String s) {
        HashMap<Character,Integer> fmap=new HashMap<>();
        List<Character>[] bucket=new List[s.length()+1];
        for(char c:s.toCharArray())
            fmap.put(c,fmap.getOrDefault(c,0)+1);

        for(char c:fmap.keySet()) {
            int freq=fmap.get(c);
            if(bucket[freq]==null)
                bucket[freq]=new ArrayList<>();
            bucket[freq].add(c);
        }

        StringBuilder out=new StringBuilder();
         for(int i=bucket.length-1;i>=0 ;i--)
             out.append(Arrays.toString(bucket[i].toArray()));

         return out.toString();
    }

    public static int find(int[] arr){
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i:arr) q.offer(i);
        long total=0;
        while(!q.isEmpty()){
            int sum=q.poll()+q.poll();
            if(!q.isEmpty())
                q.offer(sum);

            total+=sum;
        }
        return (int) total;
    }
    

}

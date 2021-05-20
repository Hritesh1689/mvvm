package com.agicent.mvvmdemo.Activity.Weekly207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RearrangeSpaces {

    public static void main(String[] args){
        reorderSpaces("  hello");


//
//        ArrayList mylist = new ArrayList();
//        mylist.add("Hello");
//        mylist.add("Java");
//        mylist.add("4");
//        Iterator it = mylist.iterator();
//        while(it.hasNext()){
//            Object element = it.next();
//            System.out.println((String)element);
//        }
    }


    static Iterator func(ArrayList mylist){
        Iterator it=mylist.iterator();
        while(it.hasNext()){
            Object element = it.next();
            it.remove();
            if(element.equals("###"))//Hints: use instanceof operator
                break;
        }
        return it;

    }

    public static String reorderSpaces(String text) {
        String[] oo=text.split(" ");

//        StringBuilder sb=new StringBuilder();
//        sb.


        ArrayList<String> sf=new ArrayList<>();
        int p = 0;
        for(String o : oo){
            if(o.length() > 0){
                sf.add(o);
                p++;
            }
        }

        String[] words = new String[sf.size()];
        for(int i=0;i<sf.size();i++)
            words[i]=sf.get(i);

        //if(words.length==1 || words.length==2) return text;
        int countspace=0;
        for(int i=0;i<text.length();i++)
        {
            if(text.charAt(i)==' ')
                countspace++;
        }

        int endspace=0;
        int midspace=0;
        if(words.length>1) {
             endspace = countspace % (words.length - 1);
            midspace = countspace / (words.length - 1);
        }
        else
            endspace=countspace;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<words.length;i++)
        {
            res.append(words[i]);
            if(i!=words.length-1)
            for(int j=0;j<midspace;j++)
                res.append(" ");
        }
        for(int j=0;j<endspace;j++)
            res.append(" ");
        return res.toString();
    }

    public int compareVersion(String A, String B) {

        String[] a=A.split(".");
        String[] b=B.split(".");
        if(a.length>b.length) return 1;
        else if(b.length>a.length) return -1;
        else {
            for(int i=0;i<a.length;i++)
                if(Integer.parseInt(a[i])>Integer.parseInt(b[i])) return 1;
                else if(Integer.parseInt(a[i])<Integer.parseInt(b[i])) return -1;
                else continue;
        }

        return 0;
    }


    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Set<ArrayList<Integer>> res=new HashSet<>();
        Collections.sort(A);
        int n=A.size();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int curr=A.get(i);
                int nextCurr=A.get(j);
                int start=j+1;
                int end=n-1;
                while(start<end){
                    int sum=curr+nextCurr+A.get(start)+A.get(end);
                    if(sum==B) res.add(new ArrayList<>(Arrays.asList(curr,nextCurr,A.get(start++),A.get(end--))));
                    else if(sum<B) start++;
                    else if(sum>B) end--;
                }
            }
        }

        ArrayList<ArrayList<Integer>> fol=new ArrayList<>(res);
        Collections.sort(fol,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                for(int i=0;i<o1.size();i++){
                    if(o1.get(i)>o2.get(i)) return o2.get(i)-o1.get(i);
                    else if(o1.get(i)<o2.get(i)) return  o1.get(i)-o2.get(i);

                }

                return 0;
            }
        });
        return fol;
    }


}

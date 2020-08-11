package com.agicent.mvvmdemo.Activity;

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class Removefriends {
    public static void main(String args[] ) throws Exception {

//        //BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int no = Integer.parseInt(br.readLine());                // Reading input from STDIN
//
//        for(int i=0;i<no;i++){
//            int noOfDeletion=Integer.parseInt(br.readLine().split(" ")[1]);
//            String[] listOfFriends=br.readLine().split(" ");
//            solveIt(noOfDeletion,listOfFriends);
//        }


        System.out.println(romanToInt("III"));

//        String do=String.valueOf(y);
//        String

    }

//    private static void solveIt(int noOfDeletion, String[] listOfFriends) {
//
//        //LinkedList<String> ll = new LinkedList(Arrays.asList(listOfFriends));
//        List<String> ll=new ArrayList<>(Arrays.asList(listOfFriends));
//        int count=0;
//
//        while(count<noOfDeletion) {
//            for (int i = 0; i < ll.size() - 1; i++) {
//                if (Integer.parseInt(ll.get(i)) < Integer.parseInt(ll.get(i + 1))) {
//                    ll.remove(i);
//                    count++;
//                    if(count==noOfDeletion)
//                        break;
//                }
//            }
//        }
//        Iterator iterator = ll.iterator();
//        while (iterator.hasNext()) {
//            // Print element to console
//            System.out.print((String) iterator.next());
//            if(iterator.hasNext())
//                System.out.print(" ");
//            else
//                System.out.println("");
//        }
//        // System.out.println(ll);
//
//    }

    private static int reverse(int x) {
        int ou=0,count=0;
        while(x!=0){
            count=x%10;
            ou= (int) (ou+(count)*(Math.pow(10,count-1)));
            x=x/10;
            //count++;
        }
        return ou;
    }

    public static int romanToInt(String s) {
        int ou=0;
        Stack<Integer> st=new Stack<>();

        String[] d=s.split("");
        String last="";
        for(int i=0;i<d.length;i++){
            switch(d[i]){
                case "I":
                    ou+=1;
                    break;

                    case "V":
                    if(last.equals("I"))
                        ou+=3;
                    else
                        ou+=5;
                    break;

                case "X":
                    if(last.equals("I"))
                        ou += 8;
                    else
                      ou+=10;
                    break;
                case "L":
                    if( last.equals("X"))
                        ou+=30;
                    else
                        ou+=50;
                    break;
                case "C":
                    if(last.equals("X"))
                        ou += 80;
                    else
                        ou+=100;
                    break;
                case "D":
                    if(last.equals("C"))
                        ou += 300;
                    else
                        ou+=500;
                    break;
                case "M":
                    if(last.equals("C"))
                        ou += 800;
                    else
                        ou+=1000;
                    break;
            };
            last=d[i];
        }
        return ou;
    }
}

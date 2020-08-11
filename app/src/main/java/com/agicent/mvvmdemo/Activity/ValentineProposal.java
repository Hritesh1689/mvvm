package com.agicent.mvvmdemo.Activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ValentineProposal {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String noofTest = br.readLine();                // Reading input from STDIN
        String noofTest="79 55";

//        noofTest.contains(String.valueOf('c'));
//        noofTest.replace
       // String toBeWorkOn=br.readLine();
        String toBeWorkOn="vaejyppozdgtwkwdeuiqfoasbydnbvlyvrkvhzlicrbadzfitnybcbvfbysfvfdrzpmgoaqsrrvvraf";
//        String[] queryList=new String[noofTest.split(" ")[1].length()];
//        for(int i=0;i<noofTest.split(" ")[1].length();i++)
//            queryList[i]=br.readLine();
//
//        for(int i=0;i<queryList.length;i++)
           // solveit(queryList[i],toBeWorkOn);

        solveit("46 73",toBeWorkOn);
    }

    static  void solveit(String query,String string){
        StringBuilder output = new StringBuilder("");
        String trys="abcdefghijklmnopqrstuvwxyz";
        String subString=string.substring(Integer.parseInt(query.split(" ")[0])-1,Integer.parseInt(query.split(" ")[1]));
        for(char c = 'a'; c <= 'z'; ++c)
            output.append(trys.charAt((countChar(c,subString)%26)+1-1));

        findPrefix(String.valueOf(output));
    }

    static void findPrefix(String ho){
        String output="";
        for (int i = 0, j = ho.length()-1; i < ho.length() && j >= 0; i++, j--) {
            if(ho.substring(0,i).equals(ho.substring(j+1)))
                output=ho.substring(0,i);
        }

        if(output.isEmpty())
            System.out.println("None");
        else
            System.out.println(output);
    }


//    static void findPrefix(String ho){
//        String output="";
//        boolean isFound=false;
//        for (int i = 0, j = ho.length()-1; i < ho.length() && j >= 0; i++, j--) {
//            if(ho.substring(0,i).equals(ho.substring(j+1))){
//                if(i>0){
//                    isFound=true;
//                    output=ho.substring(0,i);
//                }
//            }else{
//                if(isFound)
//                    break;
//            }
//        }
//        if(output.isEmpty())
//            System.out.println("None");
//        else
//            System.out.println(output);
//    }


    static int countChar(Character s,String full){
        int count = 0;
        //Counts each character except space
        for(int i = 0; i < full.length(); i++) {
            if(full.charAt(i)==s)
                count++;
        }
        return count;
    }

    static void solveits(String pattern,String string){
        boolean isFound=false;
        for(int j=0;j<string.length()-pattern.length()+1;j++){
             if(arePermutation(pattern,string.substring(j,j+pattern.length()))) {
                 isFound=true;
                 System.out.println("YES");
                 break;
             }
        }
        if(!isFound)
            System.out.println("YES");
    }


    static boolean arePermutation(String str1, String str2)
    {
        // Get lenghts of both strings
        int n1 = str1.length();
        int n2 = str2.length();

        // If length of both strings is not same,
        // then they cannot be Permutation
        if (n1 != n2)
            return false;
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        // Sort both strings
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (ch1[i] != ch2[i])
                return false;

        return true;
    }
}

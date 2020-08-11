package com.agicent.mvvmdemo.Activity;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class BinaryNumbers {
    public static Runnable runnable;

    public static void main(String args[] ) throws Exception {

        //Scanner
        String name="Rajkumar";
        
        System.out.println(name.substring(1,8));
        System.out.println("Enter the number of textCases");
         Scanner s = new Scanner(System.in);
        int noOfTest = s.nextInt();// Reading input from STDI
        ExecutorService executorService= Executors.newFixedThreadPool(noOfTest);
        for(int i = 0; i<noOfTest; i++) {
            runnable = new SolveRunable(s.nextInt());
            executorService.execute(runnable);
        }

    }

    private static void solveit(Integer nextBigInteger) {
        int count=0;
        int iteratrion=1;
        while(count<nextBigInteger){
            if(!convertIntegerToBinary(iteratrion).contains("11"))
                count++;
            iteratrion++;
        }

        System.out.println(convertIntegerToBinary(iteratrion-1));

    }

    private static String convertIntegerToBinary(Integer n) {
        String x = "";
        while(n > 0)
        {
            int a = n % 2;
            x = a + x;
            n = n / 2;
        }
           return x;
    }

   static class SolveRunable implements Runnable{
        private Integer pos;

        public SolveRunable(Integer pos) {
            this.pos=pos;
        }
        @Override
        public void run() {
            solveit(pos);
        }
    }
}

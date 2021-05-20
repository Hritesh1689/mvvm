package com.agicent.mvvmdemo.Activity.stringproblems;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SubstringAndDistinctChar {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int len=Integer.parseInt(br.readLine());
        String str=br.readLine().trim();
        long timest=System.currentTimeMillis();
        int[] res=new int[26];

        for(int i=len;i>=1;i--)
            res[i-1]=get_Count_Of_Substring_With_I_Distinct_Char(str.toCharArray(),len,i);

        for(int i=24;i>=0;i--) res[i]+=res[i+1];

        for(int el:res) System.out.print(el+" ");
        System.out.println();
        System.out.println("time tAKEN--"+(System.currentTimeMillis()-timest));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static int get_Count_Of_Substring_With_I_Distinct_Char(char[] str, int len, int k) {
        int res = 0, count = 0, lo = 0, hi = 0, max = 0, n;
        Map<Character, Integer> dp = new HashMap<>();

        while (hi < len) {

            // find the first range starting with lo, and has K distinct numbers
            while (hi < len) {
                n = dp.getOrDefault(str[hi], 0);
                if (n == 0) count++;
                dp.put(str[hi], n+1);

                // if found hi, then define max
                if (count == k) {
                    max = hi;
                    while (max+1 < len && dp.getOrDefault(str[max+1], 0) > 0) max++;
                    break;
                }
                hi++;
            }

            // define how many ranges starting with lo, and has K distinct numbers
            while (count == k) {
                res += max - hi + 1;
                n = dp.get(str[lo]);
                if (n == 1) {
                    count--;
                    hi++;
                }
                dp.put(str[lo], n-1);
                lo++;
            }
        }

        return res;
    }
}

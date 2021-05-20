package com.agicent.mvvmdemo.Activity.numbergames;

import java.util.Arrays;

public class ConsecutiveTriangle {

    public static void main(String[] args){
        nTriang(new int[]{1,1,1,2,2});
    }

    public static int nTriang(int[] A) {
        int mod=1000000007;
        int count=0;
        Arrays.sort(A);
        int n=A.length;

        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++){
                int sum=A[i]+A[j];
                int index=getGreaterThanSumIndice(A,j+1,n-1,sum);
                count=((count%mod)+(index-j-1)%mod)%mod;
            }
        }
        return count;
    }

    //side1+side2>side3

    public static int getGreaterThanSumIndice(int A[], int l, int r, int x) {
        int res = A.length;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(A[mid] >= x) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}

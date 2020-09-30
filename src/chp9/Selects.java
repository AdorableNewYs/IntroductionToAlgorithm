package chp9;

import chp7.QuickSort;

public final class Selects {

    public static int minimum(int[] A){
        int min = A[0],len = A.length;
        for (int i = 1; i < len; i++) min = A[i] < min ? A[i] : min;
        return min;
    }

    public static int randomizedSelect(int[] A,int l,int r ,int i){
        if(l == r)return A[l];
        int q = QuickSort.random_partition(A,l,r) , k = q - l + 1;
        if(i == k) return A[q];
        if(i < k) return randomizedSelect(A,l,q - 1,i);
        return randomizedSelect(A,q + 1,r,i - k);
    }

    public static void main(String[] args) {
        int[] A = {1,3,4,6,7,3,2,8,0,3,21,4};
        for (int i = 1; i <= A.length; i++) {
            System.out.println(randomizedSelect(A,0,A.length - 1,i));
        }
    }

}

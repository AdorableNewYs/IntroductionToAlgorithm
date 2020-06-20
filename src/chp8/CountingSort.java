package chp8;

import test.SortTest;

public final class CountingSort {
    //不是原算法，供测试用
    public static void countingSort(int[] A){
        int len = A.length;


        int k = 0;
        for (int i = 0; i < len; i++) k = k < A[i] ? A[i] : k;
        //∀x∈A,x∈[0,k]
        int[] C = new int[k + 1] , B = new int[len];
        for (int i = 0; i < len; i++) C[A[i]] += 1;
        for (int i = 1; i < k + 1; i++) C[i] += C[i-1];
        //保证稳定性,从后向前遍历
        for (int i = len - 1; i >= 0 ; i--) {
            B[C[A[i]] - 1] = A[i];C[A[i]]--;
        }
        for (int i = 0; i < len; i++) A[i] = B[i];
    }
    //这才是原算法
    public static void countingSort(int[] A,int k){
        int len = A.length;
        //∀x∈A,x∈[0,k]
        int[] C = new int[k + 1] , B = new int[len];
        for (int i = 0; i < len; i++) C[A[i]] += 1;
        for (int i = 1; i < k + 1; i++) C[i] += C[i-1];
        //保证稳定性,从后向前遍历
        for (int i = len - 1; i >= 0 ; i--) {
            B[C[A[i]] - 1] = A[i];C[A[i]]--;
        }
        for (int i = 0; i < len; i++) A[i] = B[i];
    }

    public static void main(String[] args) throws Exception {
        SortTest.IntArrayTest("chp8.CountingSort",5,100,0,100);
    }

}

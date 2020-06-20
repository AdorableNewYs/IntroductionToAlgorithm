package chp2;

import test.SortTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

/**
 * 2.3 设计算法
 */
public final class MergeSort {
    public static void mergeSort(int[] A){
        mergeSort(A,0,A.length-1);
    }

    public static void mergeSort(int[] A , int l,int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(A, l, mid);
            mergeSort(A, mid + 1, r);
            merge(A, l, mid, r);
        }
    }
    private static void merge(int[] A,int l,int m,int r){
        int len1 = m - l + 1, len2 = r - m;
        int[] L = new int[len1], R = new int[len2];
        for (int i = 0; i < len1; i++) L[i] = A[l + i];
        for (int i = 0; i < len2; i++) R[i] = A[i + m + 1];
        int i = 0,j = 0 , k = l;
        while (i < len1 && j < len2){
            if(L[i] < R[j]) A[k++] = L[i++];
            else A[k++] = R[j++];
        }
        while (i < len1) A[k++] = L[i++];
        while (j < len2) A[k++] = R[j++];
    }

    public static void main(String[] args) throws Exception {
        SortTest.IntArrayTest("chp2.MergeSort",5,100,-100,100);
    }
}

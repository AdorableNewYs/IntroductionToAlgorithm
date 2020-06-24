package chp7;

import test.SortTest;

import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] A){
        quickSort(A,0,A.length - 1);
    }

    public static void quickSort(int[] A , int p,int r){
        if(p < r) {
            int mid = random_partition(A,p,r);
            quickSort(A, p, mid - 1);
            quickSort(A, mid + 1, r);
        }
    }

    private static int partition(int[] A,int p, int r){
        int j = p - 1,k = A[r];
        for (int i = p; i < r; i++) {
            //降序<= , 升序 >=
            if(A[i] <= k){
                int temp = A[i];
                A[i] = A[++j];
                A[j] = temp;
            }
        }
        A[r] = A[++j];
        A[j] = k;
        return j;
    }

    //随机化版本
    private static int random_partition(int[] A,int p,int r){
        int k_index = Math.abs(new Random().nextInt()) % (r - p + 1) + p;
        int temp = A[k_index];
        A[k_index] = A[r];
        A[r] = temp;
        return partition(A,p,r);
    }
    //思考题7.1
    private static int hoare_partition(int[] A,int p, int r){
        int k = A[p], i = p - 1 , j = r + 1;
        while (true){
            do j--; while (A[j] > k);
            do i++; while (A[i] < k);
            if(i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }else break;
        }
        i = j;
        //寻找k
        while (A[i] != k) i++;
        A[i] = A[j];
        A[j] = k;
        return j;
    }

    public static void main(String[] args) throws Exception {
        SortTest.IntArrayTest("chp7.QuickSort",5,100,-100,100);
    }

}

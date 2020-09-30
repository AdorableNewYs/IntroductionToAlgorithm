package chp6;

import test.SortTest;

public final class HeapSort {

//    private static class Heap{
//        private int[] Arr;
//        private int size;
//        private Heap(int[] A){
//            Arr = A;
//            size = A.length;
//        }
//    }

    public static void heapSort(int[] A){
        buildMaxHeap(A);
        int size = A.length;
        for (int i = A.length - 1; i > 0 ; i--) {
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            maxHeapify(A,0,--size);
        }
    }
    public static void buildMaxHeap(int[] A){
        for (int i = parent(A.length - 1); i >= 0; i--) {
            maxHeapify(A,i);
        }
    }

    public static void maxHeapify(int[] A,int position){
        maxHeapify(A,position,A.length);
    }

    private static void maxHeapify(int[] A,int position,int size){
        int l = left(position),r = right(position);
        int i;
        if(l < size && A[position] < A[l]) i = l;
        else i = position;
        if(r < size && A[i] < A[r]) i = r;
        if(i != position){
            int temp = A[i];
            A[i] = A[position];
            A[position] = temp;
            maxHeapify(A,i,size);
        }
    }
    private static int parent(int i){ return (i - 1) / 2; }
    private static int left(int i){ return 2 * i + 1; }
    private static int right(int i){ return 2 * (i + 1);}

    public static void main(String[] args) throws Exception {
        SortTest.IntArrayTest("chp6.HeapSort",5,100,0,200);
    }

}

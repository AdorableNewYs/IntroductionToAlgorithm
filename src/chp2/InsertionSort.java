package chp2;

import test.SortTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

/**
 * 2.1 插入排序
 */
public final class InsertionSort {

    public static void insertionSort(int[] A){
        int len = A.length;
        for (int i = 1; i < len; i++) {
            int temp = A[i] , j = i - 1;
            while (j >= 0 && A[j] > temp) A[j + 1] = A[j--];
            A[j + 1] = temp;
        }
    }


    public static void main(String[] args) throws Exception {
        SortTest.IntArrayTest("chp2.InsertionSort",5,100,-100,100);
//        Random random = new Random();
//        int length;
//        do{
//            length = Math.abs(random.nextInt());
//        } while (!(length >= 0 && length < 100));
//        int[] A = new int[length];
//        for (int i = 0; i < length; i++) {
//            A[i] = random.nextInt() % 1000;
//        }
//        Arrays.stream(A).forEach(e-> System.out.print(e + " "));
//        System.out.println();
//        InsertSort(A);
//        Arrays.stream(A).forEach(e-> System.out.print(e + " "));

    }


}

package test;

import org.w3c.dom.ranges.RangeException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public final class SortTest {

    private static int[] buildRandomArray(int len , int min, int max) throws Exception {
        if(max <= min) throw new Exception("max <= min");
        if(len <= 0) throw new Exception("len <= 0");
        Random random = new Random();
        int[] A = new int[len];
        int K = max - min + 1;
        for (int i = 0; i < len; i++) {
            A[i] = Math.abs(random.nextInt()) % K + min;
        }
        return A;
    }
    public static void IntArrayTest(String sortClassName, int start,int arrayLen, int arrayMin,int arrayMax) throws Exception {
        //获取排序算法所在的类
        Class cl = Class.forName(sortClassName);
        System.out.println(cl.getName());
        String clName = cl.getName().substring(start);
        StringBuilder sortName = new StringBuilder();
        sortName.append(Character.toLowerCase(clName.charAt(0))).append(clName.substring(1));
        System.out.println(sortName.toString());

        //一般形式为public static void,且只有一个
        Method sortAlgorithm = cl.getMethod(sortName.toString(),int[].class);
        //随机选取数组长度、内容
        int[] A = buildRandomArray(arrayLen,arrayMin,arrayMax);
        //测试算法正确性
        Arrays.stream(A).forEach(e-> System.out.print(e + " "));
        System.out.println();
        sortAlgorithm.invoke(null,A);
        Arrays.stream(A).forEach(e-> System.out.print(e + " "));

    }




//    public static void IntArrayTest() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        Random random = new Random();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("please input sort algorithm's name :");
//        Class cl = Class.forName(scanner.nextLine());
//        System.out.println(cl.getName());
//        System.out.println("input a number let the class string sub it start in this number:");
//        int start = scanner.nextInt();
//        String clName = cl.getName().substring(start);
//        StringBuilder sortName = new StringBuilder();
//        sortName.append(Character.toLowerCase(clName.charAt(0))).append(clName.substring(1));
//        System.out.println(sortName.toString());
//        //一般形式为public static void,且只有一个
//        Method sortAlgorithm = cl.getMethod(sortName.toString(),int[].class);
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
//
//        sortAlgorithm.invoke(null,A);
//
//        Arrays.stream(A).forEach(e-> System.out.print(e + " "));
//
//    }
}

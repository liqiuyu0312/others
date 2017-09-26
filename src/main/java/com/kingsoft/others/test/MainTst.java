package com.kingsoft.others.test;

import com.kingsoft.others.algorithm.Algorithm;

/**
 * Created by BZD on 2017/8/1.
 */
public class MainTst {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        int[] a = {5,3,7,1,0,9};

        /*//冒泡
        algorithm.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }*/

      /*  //冒泡优化
        algorithm.bubbleSortOptimize(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }*/

      /*//插入排序
        algorithm.insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }*/

      //希尔排序
        algorithm.shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}

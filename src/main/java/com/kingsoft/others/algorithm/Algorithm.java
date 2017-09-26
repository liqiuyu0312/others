package com.kingsoft.others.algorithm;

/**
 * Created by BZD on 2017/8/1.
 */
public class Algorithm {
    /**
     * 冒泡排序
     *
     * @param a
     */
    public void bubbleSort(int[] a) {
        int temp = 0;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++)
                if (a[j - 1] > a[j]) {
                    //注意分清是a[j-1]还是a[j]不然容易出现边界问题
                    // 从小到大排序
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
        }
    }

    /**
     * 冒泡排序的优化
     *
     * @param a
     */
    public void bubbleSortOptimize(int[] a) {
        int temp = 0;
        int len = a.length;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 1; j < len - 1; j++)
                if (a[j - 1] > a[j]) {
                    // 注意分清是a[j-1]还是a[j]不然容易出现边界问题
                    // 从小到大排序
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                    for (int i = 0; i < a.length; i++) {
                        System.out.print(a[i] + " ");
                    }
                    System.out.println("-------------");
                    // 设置标志位
                    flag = true;
                }
        }
    }

    /**
     * 快速排序
     * <p>
     * 1）从数列中挑出一个元素，称为 “基准”（pivot），
     * 2）重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * 3）递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        // 解决和合并
        if (low<= high) {
            int mid = partition(arr, low, high);
            // 递归
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        // 分解
        int pivot = arr[high];
        int i = low - 1;
        int temp;
        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 交换中间元素和privot
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;

    }

    /**
     * 插入排序
     * O(N^2)
     *
     * @param a
     */
    public static void insertionSort(int[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            int tmp = a[p];
            for (j = p; j > 0 && tmp < a[j - 1]; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    /**
     * 希尔算法
     * 插入排序的优化
     *
     * @param a
     */
    public static void shellSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        //增量
        int incrementNum = a.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < a.length; i++) {
                //进行插入排序
                for (int j = i; j < a.length - incrementNum; j = j + incrementNum) {
                    if (a[j] > a[j + incrementNum]) {
                        int temple = a[j];
                        a[j] = a[j + incrementNum];
                        a[j + incrementNum] = temple;
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum / 2;
        }

    }


}

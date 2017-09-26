package com.kingsoft.others.jianzhi;

import java.util.HashMap;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by BZD on 2017/8/21.
 */
public class ArraryFound {
    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(hasNumber(array,1));
    }

    public static boolean hasNumber(int[][] array, int target){
        int columns = array[0].length;
        int rows = array.length;
        if (array != null && columns > 0 && rows > 0){
            int row = 0;
            int column = columns - 1;
            while (rows > row && column >= 0){
                if(array[row][column] == target){
                    return true;
                }else if (array[row][column] > target){
                    //去除一列
                    column --;
                }else{
                    //去除一行
                    row ++;
                }
            }
        }
        return false;

    }


}

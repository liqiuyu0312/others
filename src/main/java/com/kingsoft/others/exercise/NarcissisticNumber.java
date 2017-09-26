package com.kingsoft.others.exercise;

/**
 * Created by BZD on 2017/8/2.
 */
public class NarcissisticNumber {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (isNarcissisticNumber(i)){
                System.out.print("水仙花数：" + i + "  ");
            }

        }

    }
    public static boolean isNarcissisticNumber(int x){
        //百位
        int i = x / 100;
        //个位
        int j = x % 10;
        //十位
        int z = x % 100 / 10;
        if (x == i * i * i + j * j * j + z * z * z){
            return true;
        }
        return false;

    }
}

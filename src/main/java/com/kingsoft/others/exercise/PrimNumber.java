package com.kingsoft.others.exercise;

/**
 * 题目：判断101-200之间有多少个素数，并输出所有素数。
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
 * Created by BZD on 2017/8/2.
 */
public class PrimNumber {
    public static void main(String[] args) {
        for (int i = 101; i < 201; i++) {
            if (isPrimNumber(i)){
                System.out.print( "素数有：" + i + "   ");
            }
        }


    }
    public static boolean isPrimNumber(int x){
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }

}

package com.kingsoft.others.exercise;

/**
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 程序分析：兔子的规律为数列1,1,2,3,5,8,13,21....
 * Created by BZD on 2017/8/2.
 */
public class FeiBo {
    public static void main(String[] args) {
        FeiBo fb = new FeiBo();
        for (int i = 1; i < 5; i++) {
            System.out.println(fb.rabbitQuestion(i));
        }

    }

    private static int rabbitQuestion(int x){
        if (x == 1 || x == 2){
            return 1;
        }else {
            return rabbitQuestion(x - 1) + rabbitQuestion(x - 2);
        }
    }
}

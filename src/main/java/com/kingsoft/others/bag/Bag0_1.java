package com.kingsoft.others.bag;

/**
 * 0-1背包算法：
 * 有编号分别为a,b,c,d,e的五件物品，它们的重量分别是2,2,6,5,4，它们的价值分别是6,3,5,4,6，每件物品数量只有一个，
 * 现在给你个承重为10的背包，如何让背包里装入的物品具有最大的价值总和？
 * Created by BZD on 2017/9/13.
 */
public class Bag0_1 {

    int[] w = {0,8, 10, 6, 3, 7, 2};
    int[] v ={0,4, 6, 2, 2, 5, 1};

    //承重
    int sum = 12;

    int m[][] = new int[w.length + 1][sum + 1];


    public int maxPrice(){

        for (int i = 1; i < w.length; i++){
            for (int j = 1; j <= sum; j ++){
                if (w[i] <= j){
                        if (m[i - 1][j] >= m[i - 1][j - w[i]] + v[i]){
                            m[i][j] = m[i - 1][j];
                        }else{
                            m[i][j] = m[i - 1][j - w[i]] + v[i];
                        }

                }else {
                    m[i][j] = m[i - 1][j];
                }
                System.out.println( i + "-" + j + ":" + m[i][j]);

            }
        }
        return m[w.length - 1][sum];
    }

    public static void main(String[] args) {
        Bag0_1 bag0_1 = new Bag0_1();
        System.out.println(bag0_1.maxPrice());

    }





}

package com.kingsoft.others.jianzhi;

import java.util.ArrayList;

/**
 * Created by BZD on 2017/8/22.
 */
public class MainTest {
    public static void main(String[] args) {
        /*//替换空格
        ReplaceBlank rb = new ReplaceBlank();
        String string = rb.replaceSpace(new StringBuffer("we are a"));
        System.out.println(string);*/

//        Integer a = 100,b=100,c = 150,d = 150;
//        System.out.println(a == b);
//        System.out.println(c == d);
        BinaryTree binaryTree = new BinaryTree();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        binaryTree.reConstructBinaryTree(pre,in);



    }
}

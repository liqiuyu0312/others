package com.kingsoft.others.test;

/**
 * Created by BZD on 2017/9/19.
 */
public class A {
    {
        System.out.println("A的自由");
    }
    A(){
        System.out.println("A的构造");
    }
    static {
        System.out.println("A的静态");
    }

}

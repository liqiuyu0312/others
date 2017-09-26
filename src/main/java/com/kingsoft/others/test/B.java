package com.kingsoft.others.test;

/**
 * Created by BZD on 2017/9/19.
 */
public class B extends A {
    B(){
        System.out.println("B的构造");
    }
    static {
        System.out.println("B的静态");
    }
    {
        System.out.println("B的自由");
    }
}

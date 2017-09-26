package com.kingsoft.others.jianzhi;

/**
 *
 * Created by BZD on 2017/8/22.
 */
public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        String string = "";
        while (str.indexOf(" ") != -1){
            int index = str.indexOf(" ");
            str =  str.replace(index,index + 1,"%20");
        }
        string = str.toString();
        return string;
    }
}

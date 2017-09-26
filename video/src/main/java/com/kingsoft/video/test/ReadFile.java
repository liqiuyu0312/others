package com.kingsoft.video.test;

import java.io.File;

/**
 * Created by BZD on 2017/8/30.
 */
public class ReadFile {
    public static void main(String[] args) {
        readFile("F:/video/");
    }

    public static void readFile(String filepath){
        File file = new File(filepath);
        if (!file.isDirectory()) {
            System.out.println("path===" + file.getPath().replaceAll("\\\\","/"));

        } else  {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(filepath + "\\" + filelist[i]);
                if (!readfile.isDirectory()) {
//                    System.out.println("path=" + readfile.getAbsolutePath().replaceAll("\\\\","/"));
                    if (!readfile.getName().startsWith("._")){
//                        System.out.println("getAbsolutePath" + "F:/input/" + file.getAbsolutePath().substring(9).replaceAll("\\\\","/") +"/" + readfile.getName() );
                        System.out.println(file.getAbsolutePath().replaceAll("\\\\","/") + "/" +readfile.getName() )  ;                  }
                    CreateMultilayerFile("D:/input/" + file.getAbsolutePath().substring(9).replaceAll("\\\\","/") );
                } else if (readfile.isDirectory()) {
                    readFile(filepath + "\\" + filelist[i]);
                }
            }

        }

    }

    private static boolean CreateMultilayerFile(String dir) {
        try {
            File dirPath = new File(dir);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
        } catch (Exception e) {
            System.out.println("创建多层目录操作出错: "+e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }


}

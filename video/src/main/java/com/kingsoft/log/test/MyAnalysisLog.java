package com.kingsoft.log.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * Created by BZD on 2017/9/5.
 */
public class MyAnalysisLog {
    String filePath ;
    MyAnalysisLog(String filePath){
        this.filePath = filePath;
    }

    public static void AnalysisLog(String filePath, String target){
        File file = new File(filePath);
        File targetFile = new File(target);
        try {
            GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(file));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile));
            Scanner scanner = new Scanner(gzipInputStream);
            while (scanner.hasNextLine()){
                String string = scanner.nextLine();
                List<String> list = new ArrayList<String>();
                list.add("listening/dialogue/one");
                list.add("listening/dialogue/upload/one");
                list.add("listening/dialogue/identity");
                list.add("listening/read/one");
                list.add("listening/read/post/one");
                for (String str: list) {
                    if (string.indexOf(str) != -1){
                        //截取信息
                        String info = substringInfo(string);
                        bufferedWriter.write(info);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String substringInfo(String s) {
        String info = "";
        //截取日
        String date = s.substring(s.indexOf("[") + 1,s.indexOf("/"));
        //截取月
        String month = s.substring(s.indexOf("/") + 1,s.indexOf("/" , s.indexOf("/") + 1));
        int start = s.indexOf("/",s.indexOf("/") + 1) + 1;
        //截取年
        String year = s.substring(start,start + 4);
        //截取时间
        String time = s.substring(s.indexOf(":") + 1,s.indexOf(":") + 9);


        //截取IP
        String ip = s.substring(0,s.indexOf("-") - 1);
        String uid = "";
        //截取uid
        if (s.indexOf("uid") != -1 && s.substring(s.indexOf("uid") -1,s.indexOf("uid") + 3).equals("uuid")){
            uid = s.substring(s.indexOf("uid=") + 4 ,s.indexOf("&",s.indexOf("uid=") + 4));
        }
        String uuid = "";
        //截取uuid
        if (s.indexOf("uuid") != -1){
            uuid = s.substring(s.indexOf("uuid=") + 5 , s.indexOf("&" ,s.indexOf("uuid=") + 5 ));
        }
        String class_name = "speak";
        String class_id = "3";
        String content = "";
        String content_id = "";
        if (s.indexOf("dialogueId") != -1){
            content = "2";
            content_id = s.substring(s.indexOf("dialogueId") + 11 );
        }else if (s.indexOf("readingId") != -1){
            content = "1";
            content_id = s.substring(s.indexOf("readingId=") + 10 );
        }
        String client = "";
        if (s.indexOf("client") != -1){
            client = s.substring(s.indexOf("client") + 7,s.indexOf("&",s.indexOf("client")));
        }

        info =year + "-" + month + "-" + date + " " + time + "  " + ip + "  " + uid + "  " + uuid + "  " + class_name + "  " + class_id + "  " + content + "  " + content_id
        + "  " + client;
        if (uuid != "" && uid != "" && content != "" && content_id != "" && client != null){
            return info;
        }
        return "";


    }


}

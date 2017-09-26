package com.kingsoft.video.test;

import java.io.File;

/**
 * Created by BZD on 2017/8/30.
 */
public class ConvertVideo {

    //输入文件的路径
    private  String inputPath;
    //输出文件的路径
    private  String outputPath;
    //ffmpeg在windows下的安装路径
    private  String ffmpegPath;
    /**
     *
     * @param inputPath
     * @param outputPath
     * @param ffmpegPath
     */
    public ConvertVideo(String inputPath, String outputPath,
                          String ffmpegPath) {
        super();
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.ffmpegPath = ffmpegPath;
    }


    private  void getPath() { // 先获取当前项目路径，在获得源文件、目标文件、转换器的路径
        File diretory = new File("");
        try {
            String currPath = diretory.getAbsolutePath();
            inputPath = currPath + "\\input\\test.wmv";
            outputPath = currPath + "\\output\\";
            ffmpegPath = currPath + "\\ffmpeg\\";
            System.out.println(currPath);
        }
        catch (Exception e) {
            System.out.println("getPath出错");
        }
    }



}

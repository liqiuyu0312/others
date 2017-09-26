package com.kingsoft.video.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyConvertVideo {

	/*  //输入文件的路径
      private static String inputPath = "C:\\ffmpeg\\input\\1.avi";
      //输出文件的路径
      private static String outputPath = "C:\\ffmpeg\\output\\1.mp4";
       //ffmpeg在windows下的安装路径
      private static String ffmpegPath = "D:\\softwarework\\MinGW\\msys\\1.0\\bin\\";
      */
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
	public MyConvertVideo(String inputPath, String outputPath,
						  String ffmpegPath) {
		super();
		this.inputPath = inputPath;
		this.outputPath = outputPath;
		this.ffmpegPath = ffmpegPath;
	}
	/**
	 *
	 * @Title: getPath
	 * @Description: 先获取当前项目路径，在获得源文件、目标文件、转换器的路径
	 * @param
	 * @return void
	 * @throws
	 */
	/*private  void getPath() { // 先获取当前项目路径，在获得源文件、目标文件、转换器的路径
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
	}*/
	/**
	 *
	 * @Title: process
	 * @Description: 检查格式，完成其他格式的视频转换为mp4格式
	 * @param
	 * @return boolean
	 * @throws
	 */
	private  boolean process() {
		int type = checkContentType();
		boolean status = false;
		if (type == 0) {
			System.out.println("直接转成mp4格式");
			status = processMP4(inputPath);// 直接转成MP4格式
		} else if (type == 1) {
			String avifilepath = processAVI(type);
			if (avifilepath == null)
				return false;// 没有得到avi格式
			status = processMP4(avifilepath);// 将avi转成mp4格式
		}
		return status;
	}
	/**
	 *
	 * @Title: checkContentType
	 * @Description: 检查视频文件的类型，如果是avi、mpg、wmv、3gp、mov、asf、asx、flv返回int值0，
	 * 				如果是wmv9，rm，rmvb等返回int值9      mp4
	 * @param
	 * @return int
	 * @throws
	 */
	private  int checkContentType() {
		String type = inputPath.substring(inputPath.lastIndexOf(".") + 1, inputPath.length())
				.toLowerCase();
		// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
		if (type.equals("avi")) {
			return 0;
		} else if (type.equals("mpg")) {
			return 0;
		} else if (type.equals("wmv")) {
			return 0;
		} else if (type.equals("3gp")) {
			return 0;
		} else if (type.equals("mov")) {
			return 0;
		} else if (type.equals("mp4")) {
			return 0;
		} else if (type.equals("asf")) {
			return 0;
		} else if (type.equals("asx")) {
			return 0;
		} else if (type.equals("flv")) {
			return 0;
		}
		// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
		// 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
		else if (type.equals("wmv9")) {
			return 1;
		} else if (type.equals("rm")) {
			return 1;
		} else if (type.equals("rmvb")) {
			return 1;
		}
		return 9;
	}
	/**
	 *
	 * @Title: checkfile
	 * @Description: 判断给出的输入文件地址，是否真的是文件，而不是文件夹
	 * @param
	 * @return boolean
	 * @throws
	 */
	private   boolean checkfile(String path) {
		File file = new File(path);
		if (!file.isFile()) {
			return false;
		}
		return true;
	}

	/**
	 *
	 * @Title: processAVI
	 * @Description: 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
	 * @param
	 * @return String
	 * @throws
	 */
	private  String processAVI(int type) {
		List<String> commend = new ArrayList<String>();
		commend.add(ffmpegPath + "mencoder");
		commend.add(inputPath);
		commend.add("-oac");
		commend.add("lavc");
		commend.add("-lavcopts");
		commend.add("acodec=mp3:abitrate=64");
		commend.add("-ovc");
		commend.add("xvid");
		commend.add("-xvidencopts");
		commend.add("bitrate=600");
		commend.add("-of");
		commend.add("avi");
		commend.add("-o");
		commend.add(outputPath + "a.avi");
		try {
			ProcessBuilder builder = new ProcessBuilder();
			Process process = builder.command(commend).redirectErrorStream(true).start();
			new PrintStream(process.getInputStream());
			new PrintStream(process.getErrorStream());
			process.waitFor();
			return outputPath + "a.avi";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *
	 * @Title: processMP4
	 * @Description: ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	 * @param
	 * @return boolean
	 * @throws
	 */
	private  boolean processMP4(String oldfilepath) {

		if (!checkfile(inputPath)) {
			System.out.println(oldfilepath + " is not file");
			return false;
		}

		List<String> command = new ArrayList<String>();
		command.add(ffmpegPath+"ffmpeg.exe ");
		command.add("-i");
		command.add(oldfilepath);
		command.add("-vcodec");//视频编码器
		command.add("h264");
		command.add("-b:v");//视频码率
		command.add("3500000");
		command.add("-acodec");//音频编码器
		command.add("aac");
		command.add("-ar");//音频采样频率
		command.add("44100");
		command.add("-ab");//音频码率
		command.add("320000");
		command.add("-s");
		command.add("1280x720");
		command.add("-f");
		command.add("mp4");
		command.add(outputPath);
		try {

			// 方案1
//	            Process videoProcess = Runtime.getRuntime().exec(ffmpegPath + "ffmpeg -i " + oldfilepath
//	                    + " -ab 56 -ar 22050 -qscale 8 -r 15 -s 600x500 "
//	                    + outputPath + "a.flv");

			// 方案2

			System.out.println(command.toString());

			Process videoProcess = new ProcessBuilder(command).redirectErrorStream(true).start();

			new PrintStream(videoProcess.getErrorStream()).start();

			new PrintStream(videoProcess.getInputStream()).start();

			videoProcess.waitFor();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void getPath(String filepath){
		File file = new File(filepath);
		if (!file.isDirectory()) {
			String inputPath = file.getPath().replaceAll("\\\\","/");
			String outputPath = "F:/input/" + file.getAbsolutePath().substring(9).replaceAll("\\\\","/") + "/" + file.getName();
//			CreateMultilayerFile("F:/input/" + file.getAbsolutePath().substring(9).replaceAll("\\\\","/") );
			convert(inputPath,outputPath);

		} else if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				File readfile = new File(filepath + "\\" + filelist[i]);
				if (!readfile.isDirectory()) {
					if (!readfile.getName().startsWith("._")){
						String inputPath = file.getAbsolutePath().replaceAll("\\\\","/") + "/" +readfile.getName();
						String outputPath = "F:/input/" + file.getAbsolutePath().substring(9).replaceAll("\\\\","/") + "/"  + readfile.getName();
						convert(inputPath,outputPath);
					}

				} else if (readfile.isDirectory()) {
					getPath(filepath + "\\" + filelist[i]);
				}
			}

		}

	}

	public static void convert(String inputPath,String outputPath){
		String ffmpegPath = "D:\\MinGW\\msys\\1.0\\bin\\";
		MyConvertVideo conver = new MyConvertVideo(inputPath,outputPath,ffmpegPath) ;
		// getPath();

		if (!conver.checkfile(inputPath)) {
			System.out.println(inputPath + " is not file");
			return;
		}
		if (conver.process()) {
			System.out.println("ok");
		}
	}


	/**
	 *
	 * @Title: main
	 * @Description: 测试方法
	 * @param
	 * @return void
	 * @throws
	 */
	public static void main(String args[]) throws IOException {
	/*	//输入文件的路径
		String inputPath = "E:\\video\\test.mp4";
		//输出文件的路径
		String outputPath = "E:\\1.mp4";
		//ffmpeg在windows下的安装路径
		String ffmpegPath = "D:\\MinGW\\msys\\1.0\\bin\\";
		MyConvertVideo conver = new MyConvertVideo(inputPath,outputPath,ffmpegPath) ;
		// getPath();

		if (!conver.checkfile(inputPath)) {
			System.out.println(inputPath + " is not file");
			return;
		}
		if (conver.process()) {
			System.out.println("ok");
		}


	}*/

		getPath("F:/video/考研数学线性代数基础2018-方浩");


	}


	class PrintStream extends Thread
	{
		java.io.InputStream __is = null;
		public PrintStream(java.io.InputStream is)
		{
			__is = is;
		}

		public void run()
		{
			try
			{
				while(this != null)
				{
					int _ch = __is.read();
					if(_ch != -1)
						System.out.print((char)_ch);
					else break;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}}

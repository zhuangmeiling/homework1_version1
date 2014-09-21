package cn.edu.nju.software.utils;

public class Setting {
	
	// 输入所在的文件路径
	public static final String INPUT_FILE_PATH = "input/test4.txt";
	
	//当前时间，TaskRunner中的task应该是在currentTime之前或currentTime的时候到达的
	private static int currentTime = 0;		
	
	public static void increaseTime(){
		currentTime++;
	}
	
	public static int getCurrentTime(){
		return currentTime;
	}
	
	public static void recoverTime(){
		currentTime = 0;
	}
}

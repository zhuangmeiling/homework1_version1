package cn.edu.nju.software.io.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nju.software.io.InputHelper;
import cn.edu.nju.software.utils.Setting;

public class FileInputHelperImpl implements InputHelper{
	
	
	public FileInputHelperImpl() {}
	
	@SuppressWarnings("resource")
	@Override
	public List<String> getInput() {
		List<String> inputLines = new ArrayList<String>();
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			file = new File(Setting.INPUT_FILE_PATH);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String dataLine = bufferedReader.readLine();
			while(dataLine != null){
				inputLines.add(dataLine);
				dataLine = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inputLines;
	}

}

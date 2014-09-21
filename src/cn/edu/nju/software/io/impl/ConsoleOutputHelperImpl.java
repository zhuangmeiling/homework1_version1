package cn.edu.nju.software.io.impl;

import cn.edu.nju.software.entity.OutputUnit;
import cn.edu.nju.software.io.OutputHelper;

public class ConsoleOutputHelperImpl implements OutputHelper{
	private OutputUnit outputUnit;

	@Override
	public void print(OutputUnit outputUnit) {
		this.outputUnit = outputUnit;
		printPriority();
		printFinishTime();
	}
	
	private void printPriority(){
		System.out.println(outputUnit.getPriority());
	}
	
	private void printFinishTime(){
		for(int time : outputUnit.getFinishTimeOfTasks()){
			System.out.print(time);
			System.out.print(" ");
		}
	}

}

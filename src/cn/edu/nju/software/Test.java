package cn.edu.nju.software;

import java.util.List;

import cn.edu.nju.software.entity.InputUnit;
import cn.edu.nju.software.entity.OutputUnit;
import cn.edu.nju.software.io.InputHelper;
import cn.edu.nju.software.io.OutputHelper;
import cn.edu.nju.software.io.impl.ConsoleOutputHelperImpl;
import cn.edu.nju.software.io.impl.FileInputHelperImpl;
import cn.edu.nju.software.logic.Printer;

public class Test {
	
	public static void main(String[] args){
		InputHelper inputHelper = new FileInputHelperImpl();
		List<String> inputLines = inputHelper.getInput();
		InputUnit inputUnit = new InputUnit(inputLines);
		OutputUnit outputUnit = new OutputUnit();
		Printer printer = new Printer(inputUnit,outputUnit);
		printer.start();
		OutputHelper outputHelper = new ConsoleOutputHelperImpl();
		outputHelper.print(outputUnit);
	}
}

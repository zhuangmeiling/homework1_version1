package cn.edu.nju.software.entity;

import java.util.ArrayList;
import java.util.List;

public class OutputUnit {
	
	private int priority;
	private List<Integer> finishTimeOfTasks;
	
	public OutputUnit(){
		finishTimeOfTasks = new ArrayList<Integer>();
	}

	public List<Integer> getFinishTimeOfTasks() {
		return finishTimeOfTasks;
	}

	public void setFinishTimeOfTasks(List<Task> tasks) {
		if(tasks==null || tasks.size()==0){
			return;
		}
		for(Task task : tasks){
			finishTimeOfTasks.add(task.getFinishTime());
		}
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}

package cn.edu.nju.software.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class InputUnit {
	
	private int taskCount;
	private List<Task> tasks;
	private int timeOfTaskXFinished;
	
	
	public InputUnit(List<String> inputLines){
		tasks = new ArrayList<Task>();
		parseInputLines(inputLines);
	}
	
	public void setPriorityOfTaskX(int priority){
		for(Task tmp : tasks){
			if(tmp.getPriority() == -1){
				tmp.setPriority(priority);
				break;
			}
		}
	}

	public boolean setFinishTimeOfTask(Task task){
		boolean isFound = false;
		for(Task tmp : tasks){
			boolean result = task.equal(tmp);
			if(result){
				isFound = true;
				tmp.setFinishTime(task.getFinishTime());
				break;
			}
		}
		if(!isFound){
			for(Task tmp : tasks){
				if(tmp.getPriority() == -1){
					tmp.setFinishTime(task.getFinishTime());
				}
			}
			return true;
		}
		return false;
	}
	
	public int getTaskCount() {
		return taskCount;
	}
	
	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public int getTimeOfTaskXFinished() {
		return timeOfTaskXFinished;
	}
	
	public void setTimeOfTaskXFinished(int timeOfTaskXFinished) {
		this.timeOfTaskXFinished = timeOfTaskXFinished;
	}
	
	/**
	 * 解析输入文件
	 * @param inputLines
	 */
	private void parseInputLines(List<String> inputLines){
		if(inputLines==null || inputLines.size()==0){
			return;
		}
		String taskCountStr = inputLines.get(0);
		this.taskCount = Integer.parseInt(taskCountStr);
		int size = 2 + taskCount;
		if(inputLines.size() != size){
			return;
		}
		for(int i=0;i<taskCount;i++){
			String task = inputLines.get(i+1);
			parseInputLine(task);
		}
		String taskXFinishedTimeStr = inputLines.get(size-1);
		this.timeOfTaskXFinished = Integer.parseInt(taskXFinishedTimeStr);
	}
	
	
	/**
	 * 解析一行的任务
	 * @param line
	 */
	private void parseInputLine(String line){
		if(line == null){
			return;
		}
		String[] strs = line.split("\\s+");
		if(strs==null || strs.length!=3){
			return;
		}
		int arriveTime = Integer.parseInt(strs[0]);
		int spareTime = Integer.parseInt(strs[1]);
		int priority = Integer.parseInt(strs[2]);
		Task task = new Task(arriveTime,spareTime,priority,spareTime);
		if(tasks == null){
			tasks = new ArrayList<Task>();
		}
		this.tasks.add(task);
	}
	
	/**
	 * 对任务根据优先级进行排序
	 * @return	任务中最大优先级
	 */
	public int sortTasksByPriority(List<Task> tasksTemp){
		if(this.tasks==null || this.tasks.size()==0){
			return -1;
		}
		Collections.sort(tasksTemp,new Comparator<Task>(){
			public int compare(Task task1, Task task2) {   
				return task1.getPriority().compareTo(task2.getPriority());
			}   
		});
		return tasksTemp.get(tasksTemp.size()-1).getPriority();
	}
	
	/**
	 * 获得taskX的优先级的预测值列表
	 * @return
	 */
	public List<Integer> getTaskXPriorityForcast(){
		List<Integer> taskXPriorityForcast = new ArrayList<Integer>();
		List<Task> tasksTemp = getAllTasks();
		int maxPriority = sortTasksByPriority(tasksTemp);
		List<Integer> prioritys = new ArrayList<Integer>();
		for(Task task : tasksTemp){
			prioritys.add(task.getPriority());
		}
		
		for(int i=0;i<=maxPriority+1;i++){
			int index = Collections.binarySearch(prioritys, i);
			if(index < 0){
				taskXPriorityForcast.add(i);
			}
		}
		return taskXPriorityForcast;
	}
	
	private List<Task> getAllTasks(){
		List<Task> tasksOfInput = this.tasks;
		List<Task> allTasks = new ArrayList<Task>();
		for(Task tmp : tasksOfInput){
			Task newTask = new Task(tmp);
			allTasks.add(newTask);
		}
		return allTasks;
	}
	
}

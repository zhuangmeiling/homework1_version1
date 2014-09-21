package cn.edu.nju.software.entity;

public class Task {
	
	private int arriveTime;				//the time when the task came
	private int spareTime;				//si is the task's volume (in pages) 
	private Integer priority;			//the task's priority,-1:表示这个任务的优先未知,The priorities of all tasks are distinct.
	private int remainingTime;			//剩余时间
	private int finishTime;				//打印机打印出任务的最后一页的时间点
	
	public Task(){}
	
	public Task(Task task){
		this.arriveTime = task.getArriveTime();
		this.spareTime = task.getSpareTime();
		this.priority = task.getPriority();
		this.remainingTime = task.getRemainingTime();
		this.finishTime = task.finishTime;
	}
	
	public Task(int arriveTime,int spareTime,int priority,int remainingTime){
		this.arriveTime = arriveTime;
		this.spareTime = spareTime;
		this.priority = priority;
		this.remainingTime = remainingTime;
	}
	
	public int getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(int arriveTime) {
		this.arriveTime = arriveTime;
	}

	public int getSpareTime() {
		return spareTime;
	}

	public void setSpareTime(int spareTime) {
		this.spareTime = spareTime;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	
	public boolean equal(Task task){
		if(task==null){
			return false;
		}
		if(this.arriveTime==task.getArriveTime() && this.spareTime==task.getSpareTime() && this.priority==task.getPriority()){
			return true;
		}
		return false;
	}
	
	public String toString(){
		String result = "(arriveTime,spareTime,priority,remainingTime,finishTime):(" + this.arriveTime + "," + this.spareTime + "," + this.priority + "," + remainingTime + "," + finishTime + ")";
		return result;
	}
	
	
}

package jobscheduler.queue;
import java.util.*;
import jobscheduler.job.Job;

public class SchedulerQueue {
    private ArrayList<Job> jobQueue;
    private int currentIndex;
    private int timeAllowedToRun;
    public SchedulerQueue(int timeAllowedToRun){
        this.jobQueue = new ArrayList<>();
        currentIndex = -1;
        this.timeAllowedToRun = timeAllowedToRun;
    }

    public void addNewJob(Job newJob){
        this.jobQueue.add(newJob);
        currentIndex++;
    }

    private void removeJobById(int jobId){
        for(Job j: jobQueue){
            if(j.getJobId()==jobId){
                jobQueue.remove(currentIndex);
                currentIndex--;
                return;
            }
        }
    }

    public void removeJob(Job job){
        this.removeJobById(job.getJobId());
    }

    public void runNextJob() throws InterruptedException{
        if(currentIndex>=0 && currentIndex<this.jobQueue.size()){
            this.jobQueue.get(currentIndex).runJob(timeAllowedToRun);
        }
        if(this.jobQueue.get(currentIndex).isJobCompleted()) {
        	this.removeJob(this.jobQueue.get(currentIndex));
        }
        if(this.jobQueue.size()>0) {        	
        	this.currentIndex = (this.currentIndex + 1)%this.jobQueue.size();
        }
        printQueue();
    }

    private void printQueue() {
    	for(Job j : jobQueue) {
    		System.out.print(j.getJobId()+" ");
    	}
    	System.out.println();
    }
    public boolean isEmpty(){
        if(jobQueue.size()==0){
            return true;
        }
        return false;
    }

    public void changeTimeAllowedToRun(int newTimeAllowedToRun){
        this.timeAllowedToRun = newTimeAllowedToRun;
    }
}

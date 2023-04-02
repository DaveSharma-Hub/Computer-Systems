package jobscheduler.job;

public class Job {
    private int timeRemainingTillCompletion; //ms
    private int jobId;
    private boolean jobCompleted = false;

    public Job(int jobTime, int id){
        this.timeRemainingTillCompletion = jobTime;
        this.jobId = id;
    }
    public void runJob(int timeAllowedToRun) throws InterruptedException{
    	int sleepTime = timeRemainingTillCompletion>timeAllowedToRun ? timeAllowedToRun :timeRemainingTillCompletion;
    	System.out.println("Running job, id:"+jobId+" Time remaining:"+timeRemainingTillCompletion);
        Thread.sleep(sleepTime);
        if( this.timeRemainingTillCompletion - timeAllowedToRun<=0) {
        	this.timeRemainingTillCompletion = 0;
        	this.jobCompleted = true;
        }
        else {        	
        	this.timeRemainingTillCompletion = this.timeRemainingTillCompletion - timeAllowedToRun;
        }
    }

    public int getJobId(){
        return this.jobId;
    }
    public boolean isJobCompleted() {
    	return this.jobCompleted;
    }
}

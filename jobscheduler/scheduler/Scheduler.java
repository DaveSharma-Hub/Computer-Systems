package jobscheduler.scheduler;
import jobscheduler.queue.SchedulerQueue;

public class Scheduler {
    private SchedulerQueue queue;
    public Scheduler(SchedulerQueue queue){
        this.queue = queue; // reference to queue
    }
    public void runScheduler() throws InterruptedException{
        while(!this.queue.isEmpty()){
            this.queue.runNextJob();
        }
    }
}

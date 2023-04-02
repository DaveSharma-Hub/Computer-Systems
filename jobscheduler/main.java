package jobscheduler;

import jobscheduler.job.*;
import jobscheduler.queue.*;
import jobscheduler.scheduler.*;

class Main{
    public static void main(String [] args) throws InterruptedException {
        // Create jobs
        Job j1 = new Job(1000,1);
        Job j2 = new Job(2400,2);
        Job j3 = new Job(1400,3);
        Job j4 = new Job(1800,4);
        Job j5 = new Job(3490,5);
        Job j6 = new Job(200,6);
        Job j7 = new Job(900,7);
        
        //Create queue
        SchedulerQueue queue = new SchedulerQueue(800);
        //Add jobs to queue
        queue.addNewJob(j1);
        queue.addNewJob(j2);
        queue.addNewJob(j3);
        queue.addNewJob(j4);
        queue.addNewJob(j5);
        queue.addNewJob(j6);
        queue.addNewJob(j7);

        //Create scheduler and assign queue
        Scheduler scheduler = new Scheduler(queue);
        scheduler.runScheduler();
        
        System.out.println("All Jobs completed");
    }
}
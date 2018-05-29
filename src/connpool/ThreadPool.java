package connpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    BlockingQueue queue;
    boolean poolShutDownInitiated=false;

    public ThreadPool(int nthread){
        queue = new LinkedBlockingQueue(nthread);


        //create and start threads
        for(int i=1;i<=nthread;i++)
        {
            ThreadPoolTaskRunner poolTaskRunner= new ThreadPoolTaskRunner(queue,this);
            poolTaskRunner.setName("Thread--"+i);
            System.out.println("thread--"+i+" has been created and started");
            poolTaskRunner.start();
        }
    }


    public synchronized void execute(Runnable task)throws InterruptedException, Exception{

        if(poolShutDownInitiated){
            throw new Exception("poolShutDownInitiated has been initiated");
        }

        System.out.println("Task has been added");
        queue.add(task);

    }

    public boolean isPoolShutDownInitiated(){
        return poolShutDownInitiated;
    }


    public synchronized void shutDownThreadPool(){
        poolShutDownInitiated=true;
        System.out.println("shutdown has been initiated just now");
    }
}

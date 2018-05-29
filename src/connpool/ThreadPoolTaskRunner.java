package connpool;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolTaskRunner extends Thread{


    private BlockingQueue<Runnable> queue;
    ThreadPool threadPool;

    ThreadPoolTaskRunner(BlockingQueue<Runnable> queue,ThreadPool threadPool){
        this.queue=queue;
        this.threadPool=threadPool;

    }

    public void run(){
        try{

            while (true)
            {

                System.out.println(Thread.currentThread().getName()+" is ready for execution");
                Runnable run = queue.take();

                System.out.println(Thread.currentThread().getName()+" has taken the task");
                run.run();
                System.out.println(Thread.currentThread().getName()+" execution is completed");



                if(this.threadPool.isPoolShutDownInitiated()&&queue.size()==0) {
                    this.interrupt();
                    Thread.sleep(1);
                }

            }
        }catch (InterruptedException ex)
        {
            System.out.println(Thread.currentThread().getName()+" has been stopped");
        }
    }




}

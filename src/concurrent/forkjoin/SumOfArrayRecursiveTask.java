package concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SumOfArrayRecursiveTask extends RecursiveTask<Long> {

    //Part of array on which computation will be performed.
    int start;
    int end;

    //Array on which computation will be done recursively.
    long[] numberAr;


    public SumOfArrayRecursiveTask(int start, int end, long[] numberAr) {
        this.start=start;
        this.end=end;
        this.numberAr=numberAr;
    }

    /* computation will be performed in this method
     * and method will return computed result.
     */
    @Override
    protected Long compute() {


        /* We divide array into small arrays, as small as minimumProcessingSize.
         * So that each processor could efficiently process smaller array, using this
         * approach enables work-stealing approach to comes into picture.
         */
        int minimumProcessingSize=100;

        long sum=0;

        //Array is small enough to be processed, we need not to divide array.
        if(end-start < minimumProcessingSize){
            for (int i = start; i < end; i++) {
                sum +=numberAr[i];
            }
        }
        //divide array in small arrays.
        else {
            int mid= (start+end)/2;

            SumOfArrayRecursiveTask task1 = new SumOfArrayRecursiveTask(start, mid, numberAr);
            SumOfArrayRecursiveTask task2 = new SumOfArrayRecursiveTask(mid, end, numberAr);

            //We will submit subTasks by using fork() method,
            //fork() method submits the tasks asynchronously, i.e. it
            //won't wait for tasks to finish.
            task1.fork();
            task2.fork();

            //join() method waits for subtask to return result.
            //Once task will complete it will return and result will be
            //available. Then we will sum up the result returned by two tasks.
            sum= task1.join() + task2.join();
            System.out.println("Sum of Array: "+sum);

        }

        return sum;
    }
}

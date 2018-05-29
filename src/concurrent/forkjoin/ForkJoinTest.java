package concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool=new ForkJoinPool();

        long[] numberAr=new long[100000];
        for(int i=0;i<100000;i++){
            numberAr[i]=i;
        }

        SumOfArrayRecursiveTask task=new SumOfArrayRecursiveTask(0,numberAr.length,numberAr);

        //store returned result in sum variable.
        //long sum = forkJoinPool.invoke(task);
        forkJoinPool.submit(task);
       // System.out.println("sum of 100000 elements returned by compute() method = "+sum);

        System.out.println("Level of Parallesim "+forkJoinPool.getParallelism());



    }
}

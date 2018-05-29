package concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ComputeArrayForkJoinTest {

    public static void main(String...args){

        ForkJoinPool forkJoinPool= new ForkJoinPool();

        long startNanoSec=0;
        long endNanoSec=0;

        long []number = new long[100000];
        for(int i=0;i<100000;i++){
            number[i]=i;
        }

        System.out.print("original array : ");
        for(int i=0;i<10;i++){
            System.out.print(number[i]+" ");
        }

        ArrayComputationRecursiveAction action = new ArrayComputationRecursiveAction(0,number.length,number);
        startNanoSec=System.currentTimeMillis();
        forkJoinPool.invoke(action);
        endNanoSec=System.currentTimeMillis();

        System.out.print("\narray after being processed recursively "
                + "using RecursiveAction : ");
        for(int i=0;i<20;i++){
            System.out.print(number[i]+" ");
        }
        System.out.println();
        System.out.println("Level of Parallelism > "+ forkJoinPool.getParallelism());
        System.out.print("Time taken to complete task : "+ (endNanoSec-startNanoSec)+" Millisecond");
        System.out.println();
        System.out.println("Start processing Without Fork and Join");
        computearraywithoutfork();
    }

    public  static void computearraywithoutfork(){

        long []numberAr = new long[100000];
        for(int i=0;i<100000;i++){
            numberAr[i]=i;
        }

        System.out.println();
        long statmilsec=System.currentTimeMillis();
        for (int i = 0; i < numberAr.length; i++) {
            numberAr[i]=numberAr[i]*numberAr[i];
        }
        long endmilsec=System.currentTimeMillis();

        System.out.print("Time taken to complete task : "+ (endmilsec-statmilsec)+" Millisecond");
        System.out.println();
        for(int i=0;i<20;i++){
            System.out.print(numberAr[i]+" ");
        }

    }
}

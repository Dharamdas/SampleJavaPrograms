package concurrent.forkjoin;

import java.util.concurrent.RecursiveAction;

public class ArrayComputationRecursiveAction extends RecursiveAction {

    //Part of array on which computation will be performed.
    int start;
    int end;

    //Array on which computation will be done recursively.
    long[] numberAr;


    ArrayComputationRecursiveAction(int start, int end, long[] numberAr) {
        this.start = start;
        this.end = end;
        this.numberAr = numberAr;

    }


    @Override
    protected void compute() {
        /* We divide array into small arrays, as small as minimumProcessingSize.
         * So that each processor could efficiently process smaller array, using this
         * approach enables work-stealing approach to comes into picture.
         */

        int minimumProcessingSize=100;

        //Array is small enough to be processed, we need not to divide array.
        if(end-start < minimumProcessingSize){
            for (int i = start; i < end; i++) {
                numberAr[i]=numberAr[i]*numberAr[i];
            }
        }else{

            int mid= (start+end)/2;
            invokeAll(new ArrayComputationRecursiveAction(start, mid, numberAr),
                    new ArrayComputationRecursiveAction(mid, end, numberAr));

        }

    }

}

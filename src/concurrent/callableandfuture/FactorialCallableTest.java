package concurrent.callableandfuture;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class FactorialCallableTest {

    public static void main(String...args)
    {

        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        Map<Number,Future<Integer>> resultList = new HashMap<>();

        Random random = new Random();

        for(int i=0;i<4;i++){
            Integer number = random.nextInt(10);
            FactorialCalculator factorialCalculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(factorialCalculator);
            resultList.put(number,result);
        }
        for(Number number:resultList.keySet()){
            try{
                System.out.println("For the number "+number+" Future Result is: "+ resultList.get(number).get() +" And Task is Done "+resultList.get(number).isDone());
            }catch (Exception e){e.printStackTrace();}
        }

        executor.shutdown();

    }



}

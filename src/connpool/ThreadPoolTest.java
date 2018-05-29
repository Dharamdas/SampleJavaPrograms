package connpool;

public class ThreadPoolTest {

    public static void main(String...args) throws InterruptedException,Exception
    {
        ThreadPool threadPool= new ThreadPool(2);
        Runnable t1 =new Task();
        Runnable t2 =new Task();
        threadPool.execute(t1);
        threadPool.execute(t2);

        threadPool.shutDownThreadPool();

    }
}

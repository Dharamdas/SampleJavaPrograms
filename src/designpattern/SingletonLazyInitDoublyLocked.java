package designpattern;

public class SingletonLazyInitDoublyLocked {

    private static SingletonLazyInitDoublyLocked singletonLazyInitInstance;

    private SingletonLazyInitDoublyLocked(){
        System.out.println("SingletonLazyInitDoublyLocked private constructor");
    }


    public static SingletonLazyInitDoublyLocked getSingletonInstance(){

        if(singletonLazyInitInstance==null)
        {
            synchronized (SingletonLazyInitDoublyLocked.class)
            {
                if(singletonLazyInitInstance==null)
                singletonLazyInitInstance=new SingletonLazyInitDoublyLocked();
            }
        }

        return singletonLazyInitInstance;
    }
}

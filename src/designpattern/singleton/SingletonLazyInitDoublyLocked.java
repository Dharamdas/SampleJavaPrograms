package designpattern.singleton;

public class SingletonLazyInitDoublyLocked {

    private static SingletonLazyInitDoublyLocked singletonLazyInitInstance;

    private SingletonLazyInitDoublyLocked(){
        System.out.println("SingletonLazyInitDoublyLocked private constructor");
    }


    public static SingletonLazyInitDoublyLocked getSingletonInstance(){

        //First check - To avoid more than one instance creation of Singleton class.
        if(singletonLazyInitInstance==null)
        {
            synchronized (SingletonLazyInitDoublyLocked.class)
            {
                //Second check - To avoid more than one instance creation of
                //Singleton class.
                if(singletonLazyInitInstance==null)
                singletonLazyInitInstance=new SingletonLazyInitDoublyLocked();
            }
        }

        return singletonLazyInitInstance;
    }
}

package designpattern;

public class SingletonLazyInit {

    private static SingletonLazyInit SingleInstance;


    private SingletonLazyInit(){
        System.out.println("SingletonLazyInit Private Constructor");
    }

    public static SingletonLazyInit getSingletonInstance(){


        synchronized (SingletonLazyInit.class) {
            if (SingleInstance == null) {
                SingleInstance = new SingletonLazyInit();
            }
        }
        return SingleInstance;
    }

}

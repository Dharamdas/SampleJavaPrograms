package designpattern.singleton;

public class SingletonLazyInitTest {

    public static void main(String...args){
        SingletonLazyInit obj = SingletonLazyInit.getSingletonInstance();
        SingletonLazyInit obj1 = SingletonLazyInit.getSingletonInstance();

        System.out.println("Comparing Singleton Object: "+(obj==obj1));

    }
}

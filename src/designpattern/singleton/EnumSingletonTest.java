package designpattern.singleton;

public class EnumSingletonTest {
    public static void main(String...args){
        System.out.println("Enum Singleton Class: "+(EnumSingleton.ENUM_SINGLETON==EnumSingleton.ENUM_SINGLETON));
    }
}

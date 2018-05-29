package designpattern.singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SingletonSerializable implements Serializable{

    private static final long serialVersionUID = 1L;
    private static SingletonSerializable INSTANCE = new SingletonSerializable();
    private int x;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "SingletonClass [x=" + x + "]";
    }

    private SingletonSerializable(){
        System.out.println("SingletonSerializable Private Constructor called...");
    }

    //method returns INSTANCE of Singleton class.
    public static SingletonSerializable getInstance() {
        return INSTANCE;
    }


    private void readObject(ObjectInputStream inputStream)throws IOException,ClassNotFoundException {
     inputStream.defaultReadObject();
        INSTANCE=this;   //rather than creating new instance, assign current object to INSTANCE
    }

    /**
     * Method ensures that we don't impact state of object in which it was Serialized.
     */

    private Object readResolve(){
        System.out.println("in readResolve()");
        return INSTANCE;  //return INSTANCE.
    }



}

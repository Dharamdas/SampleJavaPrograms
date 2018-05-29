package designpattern.singleton;

import java.io.*;

public class SingletonSerializableTest {
    public static void main(String...agrs)throws Exception,FileNotFoundException{
        SingletonSerializable obj = SingletonSerializable.getInstance();
        obj.setX(1222);

        OutputStream fout = new FileOutputStream("ser.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        System.out.println("Serialization process has started, serializing objects...");
        out.writeObject(SingletonSerializable.getInstance());

        System.out.println("Object state at time of Serialization : "+SingletonSerializable.getInstance());
        fout.close();
        out.close();
        System.out.println("Object Serialization completed.");


        obj.setX(3333); // modified after serialization (but it's not going to change state of object in which it was Serialized, as modification is made after serialization)
        System.out.println("Object state modified after Serialization : "+SingletonSerializable.getInstance());

        //DeSerialization process >>>>>>>.

        InputStream iput = new FileInputStream("ser.txt");
        ObjectInputStream inputStream = new ObjectInputStream(iput);

        System.out.println("\nDeSerialization process has started, displaying objects...");
        inputStream.readObject();

        System.out.println("Object state after DeSerialization : "+SingletonSerializable.getInstance());
        //It's showing value of x as 22 not 33 (i.e. state in which object was serialized), although x was changed to 33 after serialization.
        iput.close();
        inputStream.close();
        System.out.println("Object DeSerialization completed.");

    }
}

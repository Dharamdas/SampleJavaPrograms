package immutable;

import java.util.HashMap;

public class ImmutableClassTest {

    public static void main(String[] args) {


        Integer localId=new Integer(1); //local

        String localName=new String("ankit"); //local

        HashMap<Integer,String> localmap = new HashMap<>();
        localmap.put(11,"Dharam");

        ImmutableClass immutableClass = new ImmutableClass(localId,localName,localmap);

        System.out.println("Id "+immutableClass.getId());
        System.out.println("Name "+immutableClass.getName());
        System.out.println("Map Value "+immutableClass.getMap());

        System.out.println("Comparing Local with Immutable class value");

        System.out.println("Id "+(immutableClass.getId()==localId));
        System.out.println("Name "+(immutableClass.getName()==localName));
        System.out.println("Map "+(immutableClass.getMap()==localmap));
    }
}

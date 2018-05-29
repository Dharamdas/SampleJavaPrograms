package immutable;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {

    private final int  id;
    private final String name;
    private final HashMap<Integer,String> map;

    ImmutableClass(int id,String name,Map<Integer,String> map){
        this.id=id;
        this.name=name;
        this.map = new HashMap<>(map);
    }


    public int getId() {
        return id;
    }

    public Map<Integer, String> getMap() {
        return (HashMap<Integer, String>)map.clone();
    }

    public String getName() {
        return name;
    }


}

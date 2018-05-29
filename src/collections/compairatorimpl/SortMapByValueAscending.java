package collections.compairatorimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValueAscending {

	public static void main(String args[]){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 2);
        map.put(2, 1);
        map.put(3, 9);
        map.put(4, 8);
        
        Set<Entry<Integer,Integer>> set = map.entrySet();
        List<Entry<Integer,Integer>> maplist =  new ArrayList<Entry<Integer,Integer>>(set);
        
        System.out.println("Before Sorting by Value");
        for(Map.Entry<Integer, Integer> entry: maplist)
        {
        	System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
        
        System.out.println("After Sorting by Value");
        
        Collections.sort(maplist, new sortByValue());
        
        for(Map.Entry<Integer, Integer> entry: maplist)
        {
        	System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
        
	}
}

class sortByValue implements Comparator<Entry<Integer,Integer>>
{

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		return o1.getValue()-o2.getValue();
	}
	
}
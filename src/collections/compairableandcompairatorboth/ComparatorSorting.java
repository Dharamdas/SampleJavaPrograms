package collections.compairableandcompairatorboth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorSorting {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		l.add(19);
		l.add(11);
		l.add(2);
		l.add(30);
		l.add(29);
		l.add(10);
		System.out.println(l);
		Collections.sort(l, new ComparatorImpl());
		System.out.println(l);
	}

}

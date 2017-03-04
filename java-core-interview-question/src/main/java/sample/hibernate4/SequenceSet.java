package sample.hibernate4;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SequenceSet {

	public static void main(String args[]) {
		
		Set<String> set = new LinkedHashSet<String>();
		
		set.add("Apple");
		set.add("Cricket");
		set.add("Banana");
		
		Iterator<String> iterator = set.iterator();

		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}


}


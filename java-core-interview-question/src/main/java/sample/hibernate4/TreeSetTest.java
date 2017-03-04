package sample.hibernate4;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {

		Set set = new TreeSet();
		set.add("2");
		set.add(3);
		set.add("1");

		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}

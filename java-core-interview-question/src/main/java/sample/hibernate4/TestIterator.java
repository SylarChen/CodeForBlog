package sample.hibernate4;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {

	public static void main(String args[]) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<String> iterator = list.iterator();

		String firtElement;
		
		firtElement = list.get(1);
//		firtElement = list[1];
//		firtElement = iterator.get(1);
//		firtElement = iterator[1];
		firtElement = iterator.next();
		
	}


}

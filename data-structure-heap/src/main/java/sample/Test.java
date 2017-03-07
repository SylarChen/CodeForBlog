package sample;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
	int[] data = new int[20];
	for (int i = 0; i < data.length; i++) {
		data[i] = (int) (Math.random() * 100);
	}
	System.out.println(Arrays.toString(data));
	MaxHeap heap = new MaxHeap(data);
	heap.print();
	
	heap.remove().print();
	heap.insert((int) (Math.random() * 100)).print();
	heap.insert(6).print();
	heap.remove().print();
}
	
}

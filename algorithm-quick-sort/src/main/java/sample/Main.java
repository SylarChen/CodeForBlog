package sample;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
    	
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		
    	System.out.println(Arrays.toString(arr));
    	
    	QuickSort.sort(arr);
    	System.out.println(Arrays.toString(arr));
    	Arrays.sort(arr2);
    	System.out.println(Arrays.toString(arr2));
    }
}

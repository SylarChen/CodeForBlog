package sample;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
    	
		int[] arr1 = new int[20];
		for (int i = 0; i < arr1.length; i++) {
//			arr1[i] = (int) (Math.random() * 100);
			arr1[i] = 22225;
		}
		
		int[] arr2 = new int[20];
		for (int i = 0; i < arr2.length; i++) {
//			arr2[i] = (int) (Math.random() * 100);
			arr2[i] = 22225;
		}
		
		Integer[] result = FindIntersection.find1(arr1, arr2);
		System.out.println(Arrays.toString(result));
		
    }
}

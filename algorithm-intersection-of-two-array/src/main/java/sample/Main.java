package sample;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
    	
		int[] arr1 = new int[100];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * 100);
		}
		
		int[] arr2 = new int[100];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = (int) (Math.random() * 100);
		}
		
		Integer[] result1 = FindIntersection.find1(Arrays.copyOf(arr1, arr1.length), Arrays.copyOf(arr2, arr2.length));
		System.out.println(Arrays.toString(result1));
		
		Integer[] result2 = FindIntersection.find2(Arrays.copyOf(arr1, arr1.length), Arrays.copyOf(arr2, arr2.length));
		System.out.println(Arrays.toString(result2));
		
		Integer[] result3 = FindIntersection.find3(Arrays.copyOf(arr1, arr1.length), Arrays.copyOf(arr2, arr2.length));
		System.out.println(Arrays.toString(result3));
    }
}

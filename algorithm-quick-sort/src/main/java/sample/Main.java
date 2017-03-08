package sample;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
    	
    	int[] arr = new int[]{123,313,43,134,43,6456,32,367,0,12,424,54,32,453,46,31,435,6570,12,332};
    	System.out.println(Arrays.toString(arr));
    	QuickSort.sort(arr);
    	System.out.println(Arrays.toString(arr));
    	
    	int[] arr2 = new int[]{123,313,43,134,43,6456,32,367,0,12,424,54,32,453,46,31,435,6570,12,332};
    	Arrays.sort(arr2);
    	System.out.println(Arrays.toString(arr2));
    }
}

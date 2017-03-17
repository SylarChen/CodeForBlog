package sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindIntersection {

	// 给定两个数组，找出他们的交集
	public static Integer[] find1(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		Set<Integer> resultSet = new HashSet<Integer>();

		int indexOfArr1 = 0;
		int indexOfArr2 = 0;
		while (indexOfArr1 < arr1.length && indexOfArr2 < arr2.length) {
			int benchMarkInArr1 = arr1[indexOfArr1];
			for ( ; indexOfArr2 < arr2.length; indexOfArr2++) {
				if(benchMarkInArr1 == arr2[indexOfArr2]){
					resultSet.add(benchMarkInArr1);
				}else if(benchMarkInArr1 < arr2[indexOfArr2]){
					break;
				}
			}
			//数组1坐标后移
			indexOfArr1 = indexOfArr1 + 1;
			if(indexOfArr1 >= arr1.length || indexOfArr2 >= arr2.length){
				//有数组已经遍历到头，那不再可能有更多的交集元素
				break;
			}
			int benchMarkInArr2 = arr2[indexOfArr2];
			for ( ; indexOfArr1 < arr1.length; indexOfArr1++) {
				if(benchMarkInArr2 == arr1[indexOfArr1]){
					resultSet.add(benchMarkInArr2);
				}else if(benchMarkInArr2 < arr1[indexOfArr1]){
					break;
				}
			}
		}

		return resultSet.toArray(new Integer[resultSet.size()]);
	}

	public static Integer[] find2(int[] arr1, int[] arr2) {
		
		Set<Integer> set1 = new HashSet<Integer>();
		
		

		return null;
	}
}

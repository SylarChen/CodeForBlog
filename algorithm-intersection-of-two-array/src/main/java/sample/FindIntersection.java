package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定两个数组，找出他们的交集
public class FindIntersection {
	
	//对两个数组排序，然后交叉查找
	public static Integer[] find1(int[] arr1, int[] arr2) {
		//排序
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		Set<Integer> resultSet = new HashSet<Integer>();

		int indexOfArr1 = 0;
		int indexOfArr2 = 0;
		while (indexOfArr1 < arr1.length && indexOfArr2 < arr2.length) {
			//从数组1中取出一个元素，逐一和数组2的元素比较，直到数组2的元素大于这个取出的元素
			int benchMarkInArr1 = arr1[indexOfArr1];
			for ( ; indexOfArr2 < arr2.length; indexOfArr2++) {
				if(benchMarkInArr1 == arr2[indexOfArr2]){
					resultSet.add(benchMarkInArr1);
				}else if(benchMarkInArr1 < arr2[indexOfArr2]){
					break;
				}
			}
			//数组1坐标后移一位
			indexOfArr1 = indexOfArr1 + 1;
			if(indexOfArr1 >= arr1.length || indexOfArr2 >= arr2.length){
				//任意数组已经遍历到头，那不再可能有更多的交集元素
				break;
			}
			//从数组2中取出一个元素，逐一和数组1的元素比较，直到数组1的元素大于这个取出的元素
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

	//使用HashSet
	public static Integer[] find2(int[] arr1, int[] arr2) {
		Set<Integer> resultSet = new HashSet<Integer>();
		
		//HashSet存取的时间复杂度都为O(1) 
		Set<Integer> set = new HashSet<Integer>();
		for(int num : arr1){
			set.add(num);
		}
		for(int num : arr2){
			if(set.contains(num)){
				resultSet.add(num);
			}
		}
		
		return resultSet.toArray(new Integer[resultSet.size()]);
	}
	
	//合并成一个数组，排序后遍历，相邻相同即为交集元素
	public static Integer[] find3(int[] arr1, int[] arr2) {
		Set<Integer> resultSet = new HashSet<Integer>();
		
		//给两个数组去重，合并
		Set<Integer> set1 = new HashSet<Integer>();
		for(int num : arr1){
			set1.add(num);
		}
		Set<Integer> set2 = new HashSet<Integer>();
		for(int num : arr2){
			set2.add(num);
		}
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(set1);
		list.addAll(set2);
		Integer[] newArr = list.toArray(new Integer[list.size()]);
		
		//排序
		Arrays.sort(newArr);
		
		//遍历一遍,相邻相同即是交集
		Integer previous = null;
		for(Integer current : newArr){
			if(previous == current){
				resultSet.add(previous);
			}
			previous = current;
		}
		
		return resultSet.toArray(new Integer[resultSet.size()]);
	}
}

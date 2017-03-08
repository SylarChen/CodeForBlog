package sample;

public class QuickSort {

	public static void sort(int[] arr){
		
		int start = 0;
		int end = arr.length - 1;
		sortPart(start, end, arr);
		
	}
	
	//负责对 数组arr中， 下标start到end的区间进行排序
	private static void sortPart(int start, int end, int[] arr){
		//需排序的区间只有一个元素时，那么这个区间已有序,这就是递归出口
		if(start >= end){
			return;
		}
		
		//基准数
		int benchMark = arr[start];
		//区间头尾下标
		int i = start;
		int j = end;
		
		//挖坑填数
		while(j!=i){
			//后往前找比benchMark小的数
			while(j!=i){
				if(arr[j]<benchMark){
					arr[i] = arr[j];
					break;
				}else{
					j--;
				}
			}
			//前往后找比benchMark大的数
			while(j!=i){
				if(arr[i]>benchMark){
					arr[j] = arr[i];
					break;
				}else{
					i++;
				}
			}	
		}
		//此处i已等于j,把benchMark填入即可
		arr[i]=benchMark;
		
		//递归 对左右区间排序
		sortPart(start, i-1, arr);
		sortPart(i+1, end, arr);
	}
	
}

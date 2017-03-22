package sample.hibernate4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
	
    public static void main(String[] args) throws CloneNotSupportedException {

//		sequenceAdd();
    	
//    	randomAdd();
    	
//    	get();
    	
//    	remove();
    	
    	removeSpecific();
    	
    }

	private static void sequenceAdd() {
		
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
    	
		Long start = System.currentTimeMillis();
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	for(int temp : arr){
    		arrayList.add(temp);
    	}
    	System.out.println("ArrayList: " + (System.currentTimeMillis() - start)/1000.0 + "s");
    	
		Long start2 = System.currentTimeMillis();
    	LinkedList<Integer> LinkedList = new LinkedList<Integer>();
    	for(int temp : arr){
    		LinkedList.add(temp);
    	}
    	System.out.println("LinkedList: " + (System.currentTimeMillis() - start2)/1000.0 + "s");
    	
	}
	
	private static void randomAdd() {
		
		//准备数据
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	for(int temp : arr){
    		arrayList.add(temp);
    	}
    	LinkedList<Integer> LinkedList = new LinkedList<Integer>();
    	for(int temp : arr){
    		LinkedList.add(temp);
    	}
    	
    	Random random =new Random();
    	//ArrayList随机add
    	Long start = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		arrayList.add(random.nextInt(999999), 999);
    	}
    	System.out.println("ArrayList: " + (System.currentTimeMillis() - start)/1000.0 + "s");
    	
    	//LinkedList随机add
    	Long start2 = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		LinkedList.add(random.nextInt(999999), 999);
    	}
    	System.out.println("LinkedList: " + (System.currentTimeMillis() - start2)/1000.0 + "s");
    	
	}
	
	private static void get() {
		
		//准备数据
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	for(int temp : arr){
    		arrayList.add(temp);
    	}
    	LinkedList<Integer> LinkedList = new LinkedList<Integer>();
    	for(int temp : arr){
    		LinkedList.add(temp);
    	}
    	
    	Random random =new Random();
    	//ArrayList随机get
    	Long start = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		arrayList.get(random.nextInt(999999));
    	}
    	System.out.println("ArrayList: " + (System.currentTimeMillis() - start)/1000.0 + "s");
    	
    	//LinkedList随机get
    	Long start2 = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		LinkedList.get(random.nextInt(999999));
    	}
    	System.out.println("LinkedList: " + (System.currentTimeMillis() - start2)/1000.0 + "s");
    	
	}
	
	private static void remove() {
		
		//准备数据
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	for(int temp : arr){
    		arrayList.add(temp);
    	}
    	LinkedList<Integer> LinkedList = new LinkedList<Integer>();
    	for(int temp : arr){
    		LinkedList.add(temp);
    	}
    	
    	Random random =new Random();
    	//ArrayList随机get
    	Long start = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		arrayList.remove(random.nextInt(999999));
    	}
    	System.out.println("ArrayList: " + (System.currentTimeMillis() - start)/1000.0 + "s");
    	
    	//LinkedList随机get
    	Long start2 = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		LinkedList.remove(random.nextInt(999999));
    	}
    	System.out.println("LinkedList: " + (System.currentTimeMillis() - start2)/1000.0 + "s");
    	
	}
    
	private static void removeSpecific() {
		
		//准备数据
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	for(int temp : arr){
    		arrayList.add(temp);
    	}
    	LinkedList<Integer> LinkedList = new LinkedList<Integer>();
    	for(int temp : arr){
    		LinkedList.add(temp);
    	}
    	
    	//ArrayList随机get
    	Long start = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		arrayList.remove(new Integer((int) (Math.random() * 100)));
    	}
    	System.out.println("ArrayList: " + (System.currentTimeMillis() - start)/1000.0 + "s");
    	
    	//LinkedList随机get
    	Long start2 = System.currentTimeMillis();
    	for(int i=0; i<100; i++){
    		LinkedList.remove(new Integer((int) (Math.random() * 100)));
    	}
    	System.out.println("LinkedList: " + (System.currentTimeMillis() - start2)/1000.0 + "s");
    	
	}
}


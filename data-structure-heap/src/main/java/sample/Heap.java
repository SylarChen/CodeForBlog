package sample;

import java.util.Arrays;

public abstract class Heap {

	protected int[] data;
	protected int length = 0;

	public Heap(int[] data) {
		this.data = data;
		this.length = data.length;
	}

	/**
	 * 构建堆
	 */
	public abstract Heap buildHeap();

	/**
	 * 删除一个节点，只能删除根节点
	 * 
	 * @return
	 */
	public abstract Heap remove();

	/**
	 * 插入一个节点，只能插入到最后
	 * 
	 * @param value
	 * @return
	 */
	public abstract Heap insert(int value);

	/**
	 * 从node开始自上而下调整堆
	 * 
	 * @param node
	 */
	public abstract void adjustDownHeap(int node);

	/**
	 * 从node开始自下而上调整堆
	 * 
	 * @param node
	 */
	public abstract void adjustUpHeap(int node);

	/**
	 * 交换元素
	 * 
	 * @param n1
	 * @param n2
	 */
	public void swap(int n1, int n2) {
		int temp = data[n1];
		data[n1] = data[n2];
		data[n2] = temp;
	}

	/**
	 * 获取node的父节点的索引
	 * 
	 * @param node
	 * @return
	 */
	protected int getParentIndex(int node) {
		return (node - 1) >> 1;
	}

	/**
	 * 获取node的右孩子索引
	 * 
	 * @param node
	 * @return
	 */
	protected int getRightChildIndex(int node) {
		return (node << 1) + 1;
	}

	/**
	 * 获取node的左孩子索引
	 * 
	 * @param node
	 * @return
	 */
	protected int getLeftChildIndex(int node) {
		return (node << 1) + 2;
	}

	/**
	 * 打印堆
	 */
	protected void print() {
		System.out.println(Arrays.toString(data));
	}
	
	protected void print(int max, int right, int left){
		System.out.print("[");
		for(int i=0; i<length; i++){
			if(i == max || i == right || i == left){
				System.out.print("(" + data[i] + ")");
			}else{
				System.out.print(data[i]);
			}
			System.out.print(i==length-1?"":", ");
		}
		System.out.print("]\n");
	}
	
}

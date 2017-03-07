package sample;

import java.util.Arrays;

/**
 * <p>
 * 最大堆
 * </p>
 *
 * @author Vicky
 * @email vicky01200059@163.com
 * @2015年11月18日
 *
 */
public class MaxHeap {
	protected int[] data;
	protected int length = 0;

	public MaxHeap(int[] data) {
		this.data = data;
		this.length = data.length;
		// 从最后一个节点的父节点开始构建堆
		int start = getParentIndex(length - 1);
		for (; start >= 0; start--) {
			adjustDown(start);
		}
	}



	/**
	 * {@inheritDoc}
	 */
	public MaxHeap remove() {
		// 将最后一个节点与头结点交换
		swap(0, length - 1);
		// 重新复制一个数组
		int[] newData = new int[length - 1];
		System.arraycopy(data, 0, newData, 0, length - 1);
		this.data = newData;
		this.length = length - 1;
		// 从头开始调整堆
		adjustDown(0);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public MaxHeap insert(int value) {
		// 插入到数组最后
		int[] newData = new int[length + 1];
		System.arraycopy(data, 0, newData, 0, length);
		newData[length] = value;
		this.data = newData;
		this.length = length + 1;
		// 从最后一个节点开始自下而上调整堆
		adjustUpHeap(this.length - 1);
		return this;
	}

	//向下调整
	public void adjustDown(int current) {
		int right = getRightChildIndex(current);// 右孩子
		int left = getLeftChildIndex(current);// 左孩子
		int max = findMax(current, right, left);// 三个节点，值最大的index
		if (max != current) {
			// 需要调整
			swap(current, max);
			// 递归调整与根节点进行交换的节点，保证下层也是堆
			adjustDown(max);
		}
	}
	// 三者最大的节点的索引
	private int findMax(int node, int right, int left) {
		int max = node;
		if (right < length && data[right] > data[max]) {
			max = right;
		}
		if (left < length && data[left] > data[max]) {
			max = left;
		}
		return max;
	}
	//交换数据
	public void swap(int n1, int n2) {
		int temp = data[n1];
		data[n1] = data[n2];
		data[n2] = temp;
	}

	/**
	 * {@inheritDoc}
	 */
	public void adjustUpHeap(int node) {
		int parent = getParentIndex(node);// 父节点
		if (parent >= 0 && data[parent] < data[node]) {
			swap(node, parent);
			adjustUpHeap(parent);// 递归调整与根节点进行交换的节点，保证上层也是堆
		}
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
	
}

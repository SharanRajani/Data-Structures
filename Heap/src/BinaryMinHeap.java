import java.util.*;

class BMH {
	int[] heap;
	int capacity;
	int heapSize;
	static Scanner scan = new Scanner(System.in);

	BMH(int capacity) {
		heap = new int[capacity];
		this.capacity = capacity;
		heapSize = 0;
	}

	static int parent(int i) {
		return (i - 1) / 2;
	}

	static int leftchild(int i) {
		return (i * 2) + 1;
	}

	static int rightchild(int i) {
		return (i * 2) + 2;
	}

	void insert() {
		System.out.println("\nEnter the new value to be added:");
		int key = scan.nextInt();
		if (heapSize == 0) {
			heap[heapSize++] = key;
		} else {
			int i = heapSize++;
			heap[i] = key;
			while (i > 0 && heap[i] < heap[parent(i)]) {
				int temp = heap[i];
				heap[i] = heap[parent(i)];
				heap[parent(i)] = temp;
				i = parent(i);
			}
		}
	}

	void decreaseKey(int index, int value) {
		heap[index] = value;
		while (index > 0 && heap[index] < heap[parent(index)]) {
			int temp = heap[index];
			heap[index] = heap[parent(index)];
			heap[parent(index)] = temp;
			index = parent(index);
		}
	}

	int getMin() {
		if (heapSize == 0)
			return -1;
		return heap[0];
	}

	int extractMin() {
		int min;
		if (heapSize == 0) {
			return -1;
		} else if (heapSize == 1) {
			min = heap[--heapSize];
		} else {
			min = heap[0];
			heap[0] = heap[--heapSize];
			this.MinHeapify(0);
		}
		return min;
	}

	void MinHeapify(int i) {
		int left = leftchild(i);
		int right = rightchild(i);
		int min = i;
		if (left < heapSize && heap[left] < heap[i])
			min = left;
		if (right < heapSize && heap[right] < heap[min])
			min = right;
		if (min != i) {
			int temp = heap[i];
			heap[i] = heap[min];
			heap[min] = temp;
			this.MinHeapify(min);
		}
	}

	void delete() {
		System.out.println("\nEnter the Index of the element to be deleted:");
		int index = scan.nextInt();
		decreaseKey(index, Integer.MIN_VALUE);
		extractMin();
	}

	void display() {
		System.out.print("\nThe elements in the heap are:");
		for (int i = 0; i < heapSize; i++) {
			System.out.print("\t" + heap[i]);
		}
		System.out.println();
	}

}

public class BinaryMinHeap {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the Size of the heap to be created:");
		int size = scan.nextInt();
		int min;
		BMH h1 = new BMH(size);
		do {
		System.out.println("\n1.Insert\n2.Delete\n3.Decrease Key\n4.Get Min\n5.Extract Min\n6.Display\nEnter your choice:");
			int ch = scan.nextInt();
			switch (ch) {
			case 1:
				h1.insert();
				break;
			case 2:
				h1.delete();
				break;
			case 3:
				System.out.println("Enter the index of the element whose value is to be decreased:");
				int index = scan.nextInt();
				System.out.println("Enter the decreased value:");
				int value = scan.nextInt();
				h1.decreaseKey(index, value);
				break;
			case 4:
				min = h1.getMin();
				System.out.println("The Minimum value is:" + min);
				break;
			case 5:
				min = h1.extractMin();
				System.out.println("The Extracted Minimum value is:" + min);
				break;
			case 6:
				h1.display();
			}
		} while (true);
	}

}

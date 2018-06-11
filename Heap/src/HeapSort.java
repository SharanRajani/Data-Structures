import java.util.*;

public class HeapSort {

	static Scanner scan = new Scanner(System.in);

	static int parent(int i) {
		return (i - 1) / 2;
	}

	static int leftChild(int i) {
		return (i * 2) + 1;
	}

	static int rightChild(int i) {
		return (i * 2) + 2;
	}

	static int insert(int[] heap, int pointer) {
		int val = scan.nextInt();
		if (pointer == 0)
			heap[pointer++] = val;
		else {
			int i = pointer++;
			heap[i] = val;
			while (i > 0 && heap[i] < heap[parent(i)]) {
				int temp = heap[i];
				heap[i] = heap[parent(i)];
				heap[parent(i)] = temp;
				i = parent(i);
			}
		}
		return pointer;
	}

	static void heapify(int i, int[] heap, int pointer) {
		int left = leftChild(i);
		int right = rightChild(i);
		int min = i;
		if (left < pointer && heap[left] < heap[i])
			min = left;
		if (right < pointer && heap[right] < heap[min])
			min = right;
		if (min != i) {
			int temp = heap[i];
			heap[i] = heap[min];
			heap[min] = temp;
			heapify(min, heap, pointer);
		}
	}

	static int extractMin(int[] heap, int pointer) {
		if (pointer == 1) {
			System.out.print("\t" + heap[--pointer]);
			return pointer;
		} else {
			int min = heap[0];
			System.out.print("\t" + min);
			heap[0] = heap[--pointer];
			heapify(0, heap, pointer);
			return pointer;
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of elements in the array to be sorted:");
		int count = scan.nextInt();
		int[] heap = new int[count];
		int pointer = 0;
		System.out.println("\nEnter the values of the elements:");
		for (int i = 0; i < count; i++) {
			pointer = insert(heap, pointer);
		}
		System.out.print("\nThe Sorted list of elements using Heap Sort is:");
		for (int i = 0; i < count; i++) {
			pointer = extractMin(heap, pointer);
		}
	}
}

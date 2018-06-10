import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node() {
		data = 0;
		next = null;
	}

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class SLL {

	Node head;

	static Scanner scan = new Scanner(System.in);

	SLL() {
		head = null;
	}

	void create() {
		int count;
		System.out.println("Enter the number of Nodes to be created:");
		count = scan.nextInt();
		Node nev, temp = null;
		int data;
		for (int i = 0; i < count; i++) {
			System.out.println("Enter the data for node " + (i + 1) + ":");
			data = scan.nextInt();
			if (i == 0) {
				head = new Node(data);
				temp = head;
			} else {
				nev = new Node(data);
				temp.next = nev;
				temp = temp.next;
			}
		}
	}

	void display() {
		System.out.print("The contents of the Linked-List are as follows:");
		Node temp = head;
		while (temp != null) {
			System.out.print("\t" + temp.data);
			temp = temp.next;
		}
	}

	Node insert() {
		System.out.println("Enter the position at which the node is to be inserted:");
		int pos = scan.nextInt();
		System.out.println("Enter the data of the new node:");
		int data = scan.nextInt();
		Node nev = new Node(data);
		if (pos == 1) {
			nev.next = head;
			return nev;
		}
		Node temp, prev;
		prev = head;
		temp = head.next;
		int p = 2;
		while (temp != null && p != pos) {
			p++;
			prev = temp;
			temp = temp.next;
		}
		if (p == pos) {
			prev.next = nev;
			nev.next = temp;
		} else {
			prev.next = nev;
		}
		return head;
	}

	void delete() {
		System.out.println("Enter the data to be deleted:");
		int data = scan.nextInt();
		if (head.data == data) {
			Node temp = head;
			head = head.next;
			temp = null;
		}
		Node prev = head;
		Node temp = head.next;
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}
		if (temp != null) {
			prev.next = temp.next;
			temp = null;
		} else {
			System.out.println("Data to be deleted is not present in the Linked List.");
		}
	}

	void dreverse(Node temp) {
		if (temp.next != null)
			dreverse(temp.next);
		System.out.print("\t" + temp.data);
	}

	static int findSize(Node head) {
		int count = 0;
		if (head == null)
			return count;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	void rotate() {
		int size = findSize(head);
		System.out.println("Enter the count of rotation:");
		int count = scan.nextInt();
		count = count % size;
		Node prev = null, temp = head;
		if (count != 0) {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = head;
			for (int i = 0; i < count; i++) {
				prev = head;
				head = head.next;
			}
			prev.next = null;
		}
	}

	void reverse() {
		if (head.next != null) {
			Node prev, next, curr;
			curr = head;
			prev = next = null;
			while (curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			head = prev;
		}
	}

}

public class List {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		SLL l1 = new SLL();
		l1.create();
		while (true) {
	System.out.println("1.Insert\n2.Display\n3.Delete\n4.Display Reverse\n5.Rotate\n6.Reverse the SLL\nEnter your choice:");
			int ch = scan.nextInt();
			switch (ch) {
			case 2:
				l1.display();
				break;
			case 1:
				l1.head = l1.insert();
				break;
			case 3:
				l1.delete();
				break;
			case 4:
				System.out.print("The contents of the Linked List in reverse order are as follows:");
				l1.dreverse(l1.head);
				break;
			case 5:
				l1.rotate();
				break;
			case 6:
				l1.reverse();
				break;
			}
			System.out.println("\nDo you want to continue(1 for Yes/2 for No):");
			int choice = scan.nextInt();
			if (choice != 1)
				break;
		}
	}
}

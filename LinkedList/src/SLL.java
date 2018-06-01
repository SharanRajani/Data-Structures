import java.util.*;

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

public class SLL {

	static Scanner scan = new Scanner(System.in);

	static Node create() {
		int count;
		System.out.println("Enter the number of Nodes to be created:");
		count = scan.nextInt();
		Node head = null, nev, temp = null;
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
		return head;
	}

	static void display(Node temp) {
		System.out.print("The contents of the Linked-List are as follows:");
		while (temp != null) {
			System.out.print("\t" + temp.data);
			temp = temp.next;
		}
	}

	static Node insert(Node head) {
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

	static Node delete(Node head) {
		System.out.println("Enter the data to be deleted:");
		int data = scan.nextInt();
		if (head.data == data) {
			Node temp = head.next;
			head = null;
			return temp;
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
		return head;
	}

	static void dreverse(Node temp) {
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

	static Node rotate(Node head) {
		int size = findSize(head);
		System.out.println("Enter the count of rotation:");
		int count = scan.nextInt();
		count = count % size;
		Node prev = null, temp = head;
		if (count == 0)
			return head;
		else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = head;
		}
		for (int i = 0; i < count; i++) {
			prev = head;
			head = head.next;
		}
		prev.next = null;
		return head;
	}

	static Node reverse(Node head) {
		if (head.next == null)
			return head;
		Node prev, next, curr;
		curr = head;
		prev = next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		Node head;
		head = create();
		while (true) {
			System.out.println(
					"1.Insert\n2.Display\n3.Delete\n4.Display Reverse\n5.Rotate\n6.Reverse the SLL\nEnter your choice:");
			int ch = scan.nextInt();
			switch (ch) {
			case 2:
				display(head);
				break;
			case 1:
				head = insert(head);
				break;
			case 3:
				head = delete(head);
				break;
			case 4:
				System.out.print("The contents of the Linked List in reverse order are as follows:");
				dreverse(head);
				break;
			case 5:
				head = rotate(head);
				break;
			case 6:
				head = reverse(head);
				break;
			}
			System.out.println("\nDo you want to continue(1 for Yes/2 for No):");
			int choice = scan.nextInt();
			if (choice != 1)
				break;
		}
	}
}

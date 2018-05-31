import java.util.*;

class Node {
	int data;
	Node left, right;

	Node() {
		data = 0;
		left = null;
		right = null;
	}

	Node(int data) {
		this.data = data;
		right = null;
		left = null;
	}

	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class BST {

	static Scanner scan = new Scanner(System.in);

	static Node insert(Node temp, int data) {
		if (temp == null) {
			Node nev = new Node(data);
			return nev;
		} else {
			if (data > temp.data) {
				temp.right = insert(temp.right, data);
			} else {
				temp.left = insert(temp.left, data);
			}
			return temp;
		}
	}

	static void preorderDisplay(Node temp) {
		if (temp != null) {
			System.out.print("\t" + temp.data);
			preorderDisplay(temp.left);
			preorderDisplay(temp.right);
		}
	}

	static void inorderDisplay(Node temp) {
		if (temp != null) {
			inorderDisplay(temp.left);
			System.out.print("\t" + temp.data);
			inorderDisplay(temp.right);
		}
	}

	static void postorderDisplay(Node temp) {
		if (temp != null) {
			postorderDisplay(temp.left);
			postorderDisplay(temp.right);
			System.out.print("\t" + temp.data);
		}
	}

	static Node create() {
		System.out.println("Enter the number of elements to be inserted:");
		int count = scan.nextInt();
		Node root = null;
		System.out.println("Enter the values of the nodes:");
		for (int i = 0; i < count; i++) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		return root;
	}

	static void search(Node temp, int data) {
		if (temp == null)
			System.out.println("Value not found.");
		else if (temp.data == data)
			System.out.println("Value found.");
		else if (data > temp.data) {
			search(temp.right, data);
		} else if (data < temp.data) {
			search(temp.left, data);
		}
	}

	static int findInorderSuccessor(Node temp) {
		Node tempRoot = temp;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.data;
	}

	static Node delete(Node temp, int data) {
		if (temp == null) {
			System.out.println("Value to be deleted not present.");
			return temp;
		} else if (temp.data == data) {
			if (temp.left == null && temp.right == null) {
				return null;
			} else if (temp.left == null) {
				return temp.right;
			} else if (temp.right == null) {
				return temp.left;
			} else {
				temp.data = findInorderSuccessor(temp.right);
				temp.right = delete(temp.right, temp.data);
				return temp;
			}
		} else if (data > temp.data) {
			temp.right = delete(temp.right, data);
		} else if (data < temp.data) {
			temp.left = delete(temp.left, data);
		}
		return temp;
	}

	public static void main(String[] args) {
		Node root = create();
		int data;
		while (true) {
			System.out.println(
					"1.Insert\n2.Preorder Display\n3.Inorder Display\n4.Postorder Display\n5.Search\n6.Delete\nEnter your choice:");
			int ch = scan.nextInt();
			switch (ch) {
			case 1:
				System.out.println("\nEnter the value of the element:");
				data = scan.nextInt();
				insert(root, data);
				break;
			case 2:
				System.out.print("The PreOrder Traversal is as follows:");
				preorderDisplay(root);
				break;
			case 3:
				System.out.print("The InOrder Traversal is as follows:");
				inorderDisplay(root);
				break;
			case 4:
				System.out.print("The PostOrder Traversal is as follows:");
				postorderDisplay(root);
				break;
			case 5:
				System.out.println("Enter the data to be searched:");
				data = scan.nextInt();
				search(root, data);
				break;
			case 6:
				System.out.println("Enter the data to be deleted:");
				data = scan.nextInt();
				root = delete(root, data);
			}
			System.out.println("\nDo you want to continue(1 for Yes/2 for No):");
			int choice = scan.nextInt();
			if (choice != 1)
				break;
		}
	}

}

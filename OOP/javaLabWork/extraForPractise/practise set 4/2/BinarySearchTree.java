import java.util.Scanner;
class BinarySearchTree {
	class Node { 
		int info; 
		Node left, right; 
		Node(int data) { 
			info = data; 
			left = right = null; 
		} 
	} 
	Node root;
	static int count = 0;
	BinarySearchTree() {  
		root = null;  
	} 
	void insert(int data) { 
		root = insertRec(root, data); 
	} 
	Node insertRec(Node root, int data) { 
		if (root == null) { 	//if tree is empty -> making a new node and returning
			root = new Node(data); 
			return root; 
		} 
		else{
			//recursion
			if (data < root.info) 
				root.left = insertRec(root.left, data); 
			else if (data > root.info) 
				root.right = insertRec(root.right, data); 
				/* return the (unchanged) node pointer */
			return root;
		} 
	} 	
	public Node search(Node root, int data) 
	{ 
		// Base Cases: root is null or key is present at root 
		if (root==null || root.info==data) 
			return root; 
	  
		// val is greater than root's key 
		if (root.info > data) 
			return search(root.left, data); 
	  
		// val is less than root's key 
		return search(root.right, data); 
	}
	
	//finding minimum Value
//	int minValue(Node node){
	int minValue(){
		Node current = root;
		while(current.left != null)
		current = current.left;
		return current.info;
	}
	//finding maximum Value
//	int maxValue(Node node){
	int maxValue(){
		Node current = root;
		while(current.right != null)
		current = current.right;
		return current.info;
	}
	
	// This method mainly calls InorderRec() //TRAVERSAL [for DISPLAY FUNCTION]
	void inorder(){ 
		inorderRec(root); 
	} 
	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root){ 
		if (root != null){ 
			inorderRec(root.left); 
			System.out.println(root.info); 
			inorderRec(root.right); 
		} 
	}  
	int totalNodes(){
		return totalNodesCounter(root);
	}
	int totalNodesCounter(Node root){
		if(root == null)
		return 0;
		else
		return (1 + totalNodesCounter(root.left) + totalNodesCounter(root.right));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree(); 
//		tree.insert(40); 
//		tree.insert(25); 
//		tree.insert(78); 
//		tree.insert(10); 
//		tree.insert(3); 
//		tree.insert(17); 
//		tree.insert(32); 
//		tree.insert(30); 
//		tree.insert(38); 
//		tree.insert(78); 
//		tree.insert(50); 
//		tree.insert(93); 
//		// print inorder traversal of the BST 
//		tree.inorder();		
		int choice = 0;
		int data;
		while(choice!=6){
			System.out.println("Menu");
			System.out.println("[1.]Insert (press 1)");
			System.out.println("[2.]Display (press 2)");
			System.out.println("[3.]Find Minimum (press 3)");
			System.out.println("[4.]Find Maximum (press 4)");
			System.out.println("[5.]Total number of nodes (press 5)");
			System.out.println("[6.]Exit (press 6)");
			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter Data : ");
					data = sc.nextInt();
					tree.insert(data);
					break;
				case 2:
					tree.inorder();
					break;
				case 3:
					System.out.println("Minimum : " + tree.minValue());
					break;
				case 4:
					System.out.println("Maximum : " + tree.maxValue());
					break;
				case 5:
					System.out.println("total number of nodes : " + tree.totalNodes());
					break;
				case 6:
					System.out.println("* * THANK YOU * *");
					break;
				default:
					System.out.println("Invalid Choice :(");
					break;
			}
		}
	}
}

//	// This method mainly calls deleteRec() 
//	void deleteKey(int data) 
//	{ 
//		root = deleteRec(root, data); 
//	} 
//  
//	//A recursive method to delete a node in BST 
//	Node deleteRec(Node root, int data) 
//	{ 
//		/* Base Case: If the tree is empty */
//		if (root == null)  	//if tree is empty
//		return root;	 
//		if (data < root.info)		//if data is less then root 	
//			root.left = deleteRec(root.left, data); 
//		else if (data > root.info) 	//if data is greater than root
//			root.right = deleteRec(root.right, data); 
//  
//		// if key is same as root's key, then This is the node 
//		// to be deleted 
//		else
//		{ 
//			// node with only one child or no child 
//			if (root.left == null) 
//				return root.right; 
//			else if (root.right == null) 
//				return root.left; 
//  
//			// node with two children: Get the inorder successor (smallest 
//			// in the right subtree) 
//			root.key = minValue(root.right); 
//  
//			// Delete the inorder successor 
//			root.right = deleteRec(root.right, root.key); 
//		} 
//  
//		return root; 
//	} 
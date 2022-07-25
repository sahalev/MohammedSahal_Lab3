package com.greatlearning.lab3.question2;

public class BinarySearchTreeDemo {
	
	Node root;
	
	public BinarySearchTreeDemo() {
		super();
		root=null;
	}

	class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			super();
			this.data = data;
		}
	}

	public static void main(String[] args) {
	
		
		BinarySearchTreeDemo bst = new BinarySearchTreeDemo();
		bst.insert(40);
		bst.insert(20);
		bst.insert(60);
		bst.insert(10);
		bst.insert(30);
		bst.insert(50);
		bst.insert(70);
		
		System.out.println("In order traversal");
		bst.inorder();

	}

	 void inorder() {
	
		inOrderTraversal(root);
		
	}

	 void inOrderTraversal(Node root) {
		
		if(root!=null)
		{
			inOrderTraversal(root.left);
			System.out.print(root.data + "-->");
			inOrderTraversal(root.right); 
		}
		
	}

	 void insert(int key) {
		
		root= insertKey(root,key);
		
	}

	private Node insertKey(Node root, int key) {

		if(root==null) {
			root= new Node(key);
			return root;
		}
		if(key<root.data)
		{
			root.left=insertKey(root.left,key);
		}
		else if(key>root.data)
		{
			root.right=insertKey(root.right,key);
		}
		return root;
	}

}

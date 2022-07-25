package com.greatlearning.lab3.question2;

import java.util.HashSet;
import java.util.Set;



public class FindPairOfSum {
	

	Node root;
	
	public FindPairOfSum() {
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
		
		FindPairOfSum tree = new FindPairOfSum();
		tree.insert(40);
		tree.insert(20);
		tree.insert(60);
		tree.insert(10);
		tree.insert(30);
		tree.insert(50);
		tree.insert(70);
		tree.inorder();
		int sum=60;
		tree.findPairWithGivenSum(tree.root, sum);
	}
	
	void findPairWithGivenSum(Node root, int sum)
	{
		Set<Integer> set = new HashSet<>();
		if(!findPairUtil(root,sum,set))
		{
			System.out.print("Pairs do not exist");
		}
		
	}
	
	 private boolean findPairUtil(Node root, int sum, Set<Integer> set) {
		
		 if(root==null)
			 return false;
		 if(findPairUtil(root.left,sum,set))
			 return true;
		 
		 if(set.contains(sum-root.data))
		 {
			 System.out.println("\n Pair is found ( "+ (sum-root.data) +", " + root.data + " )");
			 return true;
		 }
		 else
		 {
			 set.add(root.data);
		 }
		 
		 
		return findPairUtil(root.right,sum,set);
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

package com.datastructure.tree.binarytree;

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinarySearchTree {
	public static  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	
	
	/*
	 * Inorder Traversal
	 * 
	 * In this traversal the left sub tree of the given node is visited first,
	 * then the value at the given node is printed and then the right sub tree
	 * of the given node is visited. This process is applied recursively all the
	 * node in the tree until either the left sub tree is empty or the right sub
	 * tree is empty.
	 */
	public void displayInOrder(Node root){
		if(root!=null){
			displayInOrder(root.left);
			System.out.print(" " + root.data);
			displayInOrder(root.right);
		}
	}
	
	/*
	 * Preorder Traversal
	 * 
	 * In this traversal the value at the given node is printed first and then
	 * the left sub tree of the given node is visited and then the right sub
	 * tree of the given node is visited. This process is applied recursively
	 * all the node in the tree until either the left sub tree is empty or the
	 * right sub tree is empty.
	 */
	private void displayPreOrder(Node root) {
		  if (root == null) {
		    return;
		  }
		  System.out.print(root.data + ", ");
		  displayPreOrder(root.left);
		  displayPreOrder(root.right);
		}
	
	/*
	 * Postorder Traversal
	 * 
	 * In this traversal the left sub tree of the given node is traversed first,
	 * then the right sub tree of the given node is traversed and then the value
	 * at the given node is printed. This process is applied recursively all the
	 * node in the tree until either the left sub tree is empty or the right sub
	 * tree is empty.
	 */
	private void displayPostOrder(Node root) {
		  if (root == null) {
		    return;
		  }
		  displayPostOrder(root.left);
		  displayPostOrder(root.right);
		  System.out.print(root.data + ", ");

		}
	
    /*
	start from the root and compare root.data with n
	if root.data is greater than n that means we need to go to the left of the root.
	if root.data is smaller than n that means we need to go to the right of the root.
	if any point of time root.data is equal to the n then we have found the node, return true.
	if we reach to the leaves (end of the tree) return false, we didn’t find the element
	*/
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	/*	Very much similar to find() operation.
	To insert a node our first task is to find the place to insert the node.
	Take current = root .
	start from the current and compare root.data with n
	if current.data is greater than n that means we need to go to the left of the root.
	if current.data is smaller than n that means we need to go to the right of the root.
	if any point of time current is null that means we have reached to the leaf node, insert your node here with the help of parent node. (See code)
	*/
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		
		
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		
		
		//Case 2 : if node to be deleted has only one child
		
/*if a node to be deleted(deleteNode) has only one child then just traverse to that node, 
 * keep track of parent node and the side in which the node exist(left or right).
 * check which side child is null (since it has only one child).
 * Say node to be deleted has child on its left side . 
 * Then take the entire sub tree from the left side and add it to the parent and the side on which deleteNode exist.
 */
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}
		
		//Case 3 : if node to be deleted has two children
		
/*Find The Successor:
 * Successor is the node which will replace the deleted node. 
 * Successor is the smaller node in the right sub tree of the node to be deleted.
*/
		
		else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

	/**
	 * Create Mirror of a given tree
	 */
	Node mirror(Node node) {
		if (node == null)
			return node;

		/* do the subtrees */
		Node left = mirror(node.left);
		Node right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	/**
	 * Check if two trees are mirror
	 */
	boolean isMirror(Node a, Node b) {
		/* Base case : Both empty */
		if (a == null && b == null)
			return true;

		// If only one is empty
		if (a == null || b == null)
			return false;

		/*
		 * Both non-empty, compare them recursively Note that in recursive
		 * calls, we pass left of one tree and right of other tree
		 */
		return a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
	}

	/**
	 * Checks if a tree is symmetric
	 */
	boolean isSymmetric(Node node) {
		// check if tree is mirror of itself
		return isMirror(root, root);
	}

	/**
	 * Height of binary tree
	 */
	int findHeight(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(findHeight(node.left), findHeight(node.right));
	}

	/**
	 * Diameter of a tree
	 * 
	 */
	int getDiameter(Node root) {
		if (root == null)
			return 0;
		int rootDiameter = findHeight(root.left) + findHeight(root.right) + 1;
		int leftDiameter = getDiameter(root.left);
		int rightDiameter = getDiameter(root.right);
		return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.displayInOrder(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.displayInOrder(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.displayInOrder(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.displayInOrder(root);
	}
}


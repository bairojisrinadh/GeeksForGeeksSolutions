package org.datastructures.binarytrees;

import org.utilities.StopWatch;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		StopWatch.startTimer();
		tree.inorder();
 
		tree.deleteKey(50);
		StopWatch.endTimer();

		System.out.println();
		// print inorder traversal of the BST
		tree.inorder();

	}

	private void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	private Node deleteRec(Node root, int key) {
		if (root == null)
			return root;

		if (key < root.key) {
			root.left = deleteRec(root.left, key);
		} else if (key > root.key) {
			root.right = deleteRec(root.right, key);

			// if key is same as root's key, then This is the node
			// to be deleted
		} else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	private int minValue(Node root) {
		int minV = root.key;
		while (root.left != null) {
			minV = root.left.key;
			root = root.left;
		}
		return minV;
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	// This method mainly calls InorderRec()
	void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}
}

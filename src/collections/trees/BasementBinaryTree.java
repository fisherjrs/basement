package collections.trees;

interface BasementBinaryTree<T extends Comparable<T>> {
	
	Boolean insert(ImplBinaryTreeNode<T> node);
	Boolean insert(ImplBinaryTreeNode<T> node, ImplBinaryTreeNode<T> target);
	Boolean delete(ImplBinaryTreeNode<T> node);
	void display(ImplBinaryTreeNode<T> node);
	ImplBinaryTreeNode<T> getRootNode();
	ImplBinaryTreeNode<T> find(T data);
	
}
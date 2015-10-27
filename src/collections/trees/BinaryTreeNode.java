package collections.trees;

interface BinaryTreeNode<T extends Comparable<T>> {
	BinaryTreeNode<T> getLeft();
	BinaryTreeNode<T> getRight();
	Comparable<T> getData();
	
	void setLeft(BinaryTreeNode<T> node);
	void setRight(BinaryTreeNode<T> node);
	void setData(Comparable<T> data);
	
}
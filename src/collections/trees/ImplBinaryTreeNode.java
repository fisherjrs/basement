package collections.trees;

public class ImplBinaryTreeNode<T extends Comparable<T>> {

	private Comparable<T> data;
	private ImplBinaryTreeNode<T> left;
	private ImplBinaryTreeNode<T> right;
	
	public ImplBinaryTreeNode() {
		
	}
	
	public static <T extends Comparable<T>> ImplBinaryTreeNode<T> getBinaryTreeNode(Comparable<T> mydata) {
		ImplBinaryTreeNode<T> btn = new ImplBinaryTreeNode<T>();
		btn.setData(mydata);
		return btn;			
	}
	
	public static <T extends Comparable<T>> ImplBinaryTreeNode<T> getBinaryTreeNode(
			Comparable<T> mydata, 
			ImplBinaryTreeNode<T> leftNode, 
			ImplBinaryTreeNode<T> rightNode
		) {
		ImplBinaryTreeNode<T> btn = new ImplBinaryTreeNode<T>();
		btn.setData(mydata);
		btn.setLeft(leftNode);
		btn.setRight(rightNode);
		return btn;			
	}
	
	
	public ImplBinaryTreeNode<T> getLeft() {
		return left;
	}

	
	public ImplBinaryTreeNode<T> getRight() {
		return right;
	}

	
	public Comparable<T> getData() {
		return data;
	}

	
	public void setLeft(ImplBinaryTreeNode<T> node) {
		this.left = node;		
	}

	
	public void setRight(ImplBinaryTreeNode<T> node) {
		this.right = node;		
	}

	
	public void setData(Comparable<T> data) {
		this.data = data;		
	}
	
}
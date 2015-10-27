package collections.trees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImplBasementBinaryTree<T extends Comparable<T>>  {
	
	private static Logger LOG = LoggerFactory.getLogger(ImplBasementBinaryTree.class);
	
	private ImplBinaryTreeNode<T> root; 
		
	public ImplBasementBinaryTree() {
		root = null;
	}
	
	public static <T extends Comparable<T>> ImplBasementBinaryTree<T> getBasementBinaryTree() {
		ImplBasementBinaryTree<T> bt = new ImplBasementBinaryTree<T>();
		bt.root = null;
		return bt;
	}
	

	public Boolean insert(ImplBinaryTreeNode<T> node) {
		Boolean result = Boolean.FALSE;
		if(node != null){
			if(root == null) {
				root = node;
				result = Boolean.TRUE;
			} else {
				result = insert(node, root);
			}
		}
		return result;
	}
	
	private Boolean insert(ImplBinaryTreeNode<T> node, ImplBinaryTreeNode<T> target) {
		Boolean result = Boolean.FALSE;
		
		if(node != null && target != null) {		
			try {				
				if(target.getData().compareTo((T) node.getData()) >= 0) {
					if(target.getLeft() == null) {
						target.setLeft(node);
					} else {
						insert(node, target.getLeft());
					}
				} else {
					if(target.getRight() == null) {
						target.setRight(node);
					} else {
						insert(node, target.getRight());
					}
				}
				result = Boolean.TRUE;
			}catch(Exception error) {
				LOG.debug("Unable to insert node :: []", error.getMessage());
				result = Boolean.FALSE;
			}				
		}
		return result;	
	}

	
	public Boolean delete(ImplBinaryTreeNode<T> node) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ImplBinaryTreeNode<T> find(T data) {
		ImplBinaryTreeNode<T> node;		
		node = recursiveSearch(data, root);
		return node;
	}
	
	public void display(ImplBinaryTreeNode<T> node) {
		if(node != null) {
			display(node.getLeft());
			System.out.println(node.getData());
			display(node.getRight());
		}
	}
	
	
	public ImplBinaryTreeNode<T> getRootNode() {
		return this.root;
	}
	
	private ImplBinaryTreeNode<T> recursiveSearch(T data, ImplBinaryTreeNode<T> target) {
		ImplBinaryTreeNode<T> node = null;
		if( data != null && target != null) {
			
			if(data.equals(target.getData())){
				node = target;
			} else {
				node = recursiveSearch(data, target.getLeft());
				if(node == null) {
					node = recursiveSearch(data, target.getRight());
				}
			}
		}
		return node;
	}
	
}
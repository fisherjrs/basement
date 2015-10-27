package collections.trees;

import org.junit.Assert;
import org.junit.Test;

public class BasementBinarySearchTreeTest {
	
	public BasementBinarySearchTreeTest() {
		
	}
	
	@Test
	public void insertFirstNodeTest() {
		ImplBinaryTreeNode<Integer> btn1 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(99));
		ImplBasementBinaryTree<Integer> bbt1 = ImplBasementBinaryTree.<Integer>getBasementBinaryTree();
		Assert.assertEquals(Boolean.TRUE, bbt1.insert(btn1));
	}
	
	@Test
	public void insertSecondNodeTest() {
		ImplBinaryTreeNode<Integer> btn1 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(99));
		ImplBinaryTreeNode<Integer> btn2 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(45));
		ImplBasementBinaryTree<Integer> bbt1 = ImplBasementBinaryTree.<Integer>getBasementBinaryTree();
		bbt1.insert(btn1);
		Assert.assertEquals(Boolean.TRUE, bbt1.insert(btn2));
	}
	
	@Test
	public void findTest() {
		ImplBinaryTreeNode<Integer> btn1 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(99));
		ImplBasementBinaryTree<Integer> bbt1 = ImplBasementBinaryTree.<Integer>getBasementBinaryTree();
		bbt1.insert(btn1);
		Assert.assertEquals(99, bbt1.find(99).getData());
	}
	
	@Test
	public void findTestComplex() {
		ImplBinaryTreeNode<Integer> btn1 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(99));
		ImplBinaryTreeNode<Integer> btn2 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(45));
		ImplBinaryTreeNode<Integer> btn3 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(100));
		ImplBinaryTreeNode<Integer> btn4 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(23));
		ImplBinaryTreeNode<Integer> btn5 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(56));
		ImplBinaryTreeNode<Integer> btn6 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(12));
		ImplBinaryTreeNode<Integer> btn7 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(765));
		ImplBinaryTreeNode<Integer> btn8 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(34));
		ImplBasementBinaryTree<Integer> bbt1 = ImplBasementBinaryTree.<Integer>getBasementBinaryTree();
		bbt1.insert(btn1);
		bbt1.insert(btn2);
		bbt1.insert(btn3);
		bbt1.insert(btn4);
		bbt1.insert(btn5);
		bbt1.insert(btn6);
		bbt1.insert(btn7);
		bbt1.insert(btn8);
		Assert.assertEquals(765, bbt1.find(765).getData());
	}
	
	@Test
	public void findTestNotFound() {
		ImplBinaryTreeNode<Integer> btn1 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(99));
		ImplBinaryTreeNode<Integer> btn2 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(45));
		ImplBinaryTreeNode<Integer> btn3 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(100));
		ImplBinaryTreeNode<Integer> btn4 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(23));
		ImplBinaryTreeNode<Integer> btn5 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(56));
		ImplBinaryTreeNode<Integer> btn6 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(12));
		ImplBinaryTreeNode<Integer> btn7 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(765));
		ImplBinaryTreeNode<Integer> btn8 = ImplBinaryTreeNode.getBinaryTreeNode(Integer.valueOf(34));
		ImplBasementBinaryTree<Integer> bbt1 = ImplBasementBinaryTree.<Integer>getBasementBinaryTree();
		bbt1.insert(btn1);
		bbt1.insert(btn2);
		bbt1.insert(btn3);
		bbt1.insert(btn4);
		bbt1.insert(btn5);
		bbt1.insert(btn6);
		bbt1.insert(btn7);
		bbt1.insert(btn8);
		Assert.assertEquals(null, bbt1.find(1111));
	}
}


package collections.trees;

import java.util.TreeSet;

public class TreeSetExample {
	
	public static void main(String[] args) {

//		TreeSet<BinaryTreeNode> binaryTree = new TreeSet<BinaryTreeNode>();
//		
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
		bbt1.display(bbt1.getRootNode());
		
		
		ImplBinaryTreeNode<String> btnAlpha1 = ImplBinaryTreeNode.getBinaryTreeNode("pve");
		ImplBinaryTreeNode<String> btnAlpha2 = ImplBinaryTreeNode.getBinaryTreeNode("sjr");
		ImplBinaryTreeNode<String> btnAlpha3 = ImplBinaryTreeNode.getBinaryTreeNode("udc");
		ImplBinaryTreeNode<String> btnAlpha4 = ImplBinaryTreeNode.getBinaryTreeNode("mds");
		ImplBinaryTreeNode<String> btnAlpha5 = ImplBinaryTreeNode.getBinaryTreeNode("oyt");
		ImplBinaryTreeNode<String> btnAlpha6 = ImplBinaryTreeNode.getBinaryTreeNode("bce");
		ImplBinaryTreeNode<String> btnAlpha7 = ImplBinaryTreeNode.getBinaryTreeNode("axc");
		ImplBinaryTreeNode<String> btnAlpha8 = ImplBinaryTreeNode.getBinaryTreeNode("dio");
		
		ImplBasementBinaryTree<String> bbt2 = ImplBasementBinaryTree.<String>getBasementBinaryTree();
		bbt2.insert(btnAlpha1);
		bbt2.insert(btnAlpha2);
		bbt2.insert(btnAlpha3);
		bbt2.insert(btnAlpha4);
		bbt2.insert(btnAlpha5);
		bbt2.insert(btnAlpha6);
		bbt2.insert(btnAlpha7);
		bbt2.insert(btnAlpha8);
		bbt2.display(bbt2.getRootNode());
	}
	
	public TreeSetExample() {
		
	}

	
		
	public static boolean are_identical (
			BinaryTreeNode<Integer> root1,
			BinaryTreeNode<Integer> root2
		) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 != null && root2 != null) {
			boolean identical = ((root1.getData() == root2.getData()) && 
					are_identical(root1.getLeft(), root2.getLeft()) &&
					are_identical(root1.getRight(), root2.getRight())
					);
			return identical;
		}
		
		return false;
	}

}
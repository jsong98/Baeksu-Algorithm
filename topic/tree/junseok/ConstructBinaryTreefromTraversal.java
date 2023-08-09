package topic.tree;

import java.util.HashMap;

public class ConstructBinaryTreefromTraversal {

	public static void main(String[] args) {
		int[] preorder = {3, 9, 20, 15, 7};	
		int[] inorder = {9, 3, 15, 20, 7};
		
		buildTree(preorder, inorder);
	}
	
	// preorder의 element로 기준을 잡고 leftTree와 rightTree로 나눠 재귀.
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
			
		}
		
		return recur(map, preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	public static TreeNode recur(HashMap<Integer, Integer> map, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		
		if(preStart>preEnd || inStart >inEnd) return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int bd = map.get(preorder[preStart]);
		int leftBd = bd - inStart;
		
		root.left = recur(map, preorder, preStart+1, preStart+leftBd, inorder, inStart, bd-1);
		root.right = recur(map, preorder, preStart+leftBd+1, preEnd, inorder, bd+1, inEnd);
		
		return root;
	}
		
	
	
}

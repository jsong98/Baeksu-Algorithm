package topic.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        rightPriorSearch(list, root, 0);

        return list;
    }
	
	// 오른쪽에서 봤을 때의 결과값을 구하면 되기 때문에 오른쪽 우선 탐색, 값이 있으면 res에 add.
    public void rightPriorSearch(List<Integer> res, TreeNode curr, int currDepth) {
        if(curr == null) return;

        if(res.size() == currDepth) {
            res.add(curr.val);
        }

        rightPriorSearch(res, curr.right, currDepth+1);
        rightPriorSearch(res, curr.left, currDepth+1);
        
    }
}

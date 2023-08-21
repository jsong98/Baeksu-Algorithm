# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# need explain
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(cur_node, left_range, right_range):
            if cur_node == None:
                return True
            if not (cur_node.val > left_range and cur_node.val < right_range):
                return False
            return dfs(cur_node.left, left_range, cur_node.val) and dfs(cur_node.right, cur_node.val, right_range)

        return dfs(root, float('-inf'), float('inf'))

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# help neetCode
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        node_index = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:node_index + 1], inorder[:node_index])
        root.right = self.buildTree(preorder[node_index + 1:], inorder[node_index + 1:])

        return root
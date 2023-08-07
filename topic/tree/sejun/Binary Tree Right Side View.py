from collections import deque


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = deque()
        node = root
        result = [-101] * 100
        total_result = []
        if node:
            q.append((node, 0))
        while q:
            cur_node, cur_level = q.popleft()
            if cur_node.left != None:
                q.append((cur_node.left, cur_level + 1))
            if cur_node.right != None:
                q.append((cur_node.right, cur_level + 1))

            result[cur_level] = cur_node.val
        for number in result:
            if number != -101:
                total_result.append(number)
            else:
                break
        return total_result



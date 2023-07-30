# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        success_flag = False
        one_step_node, two_step_node = head, head
        start_node = head
        while one_step_node != None and one_step_node.next != None:
            one_step_node = one_step_node.next
            two_step_node = two_step_node.next.next
            if one_step_node == two_step_node:
                success_flag = True
                break
        if not success_flag:
            return None
        while start_node != one_step_node:
            start_node = start_node.next
            one_step_node = one_step_node.next
        return start_node



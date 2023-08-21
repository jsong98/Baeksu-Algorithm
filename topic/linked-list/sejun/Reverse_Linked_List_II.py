# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        start_node = ListNode(0, head)
        left_left_node = start_node
        left_node = head
        non_step_node = None

        for _ in range(left - 1):
            left_left_node = left_node
            left_node = left_node.next

        for _ in range(right - left + 1):
            temp_node = left_node
            left_node = left_node.next
            temp_node.next = non_step_node
            non_step_node = temp_node

        left_left_node.next.next = left_node
        left_left_node.next = non_step_node

        return start_node.next

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result_head = ListNode
        result_tail = result_head
        left_operation = l1
        right_operation = l2
        carry_number = 0
        while l1 or l2:
            if l1 and l2:
                target_number = l1.val + l2.val + carry_number
            elif l1:
                target_number = l1.val + carry_number
            elif l2:
                target_number = l2.val + carry_number

            if target_number < 10:
                temp = ListNode(target_number)
                carry_number = 0
            else:
                temp = ListNode(target_number % 10)
                carry_number = 1

            result_tail.next = temp
            result_tail = temp
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

        if carry_number == 1:
            temp = ListNode(1)
            result_tail.next = temp
            result_tail = temp

        return result_head.next

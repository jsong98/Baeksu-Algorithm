import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        max_heap = []
        for index, number in enumerate(nums):
            heapq.heappush(max_heap, (-number, number))

        for _ in range(k):
            number = heapq.heappop(max_heap)[1]

        return number


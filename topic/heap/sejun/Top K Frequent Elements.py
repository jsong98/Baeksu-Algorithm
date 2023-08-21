import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = 0
        numsSet = set(nums)
        result = []
        minHeap = []
        for i in numsSet:
            number_count = nums.count(i)
            minHeap.append((-number_count, i))

        heapq.heapify(minHeap)

        while minHeap:
            if count == k:
                break
            else:
                target_number = heapq.heappop(minHeap)
                result.append(target_number[1])
                count += 1

        return result
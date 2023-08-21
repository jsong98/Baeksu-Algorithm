import heapq


class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        result = []
        N1 = len(nums1)
        N2 = len(nums2)
        heap = []
        result_count = k
        heapq.heappush(heap, (nums1[0] + nums2[0], 0, 0))
        visited = set()
        visited.add((0, 0))

        while len(heap) > 0 and result_count > 0:
            _, nums1_index, nums2_index = heapq.heappop(heap)

            if nums1_index + 1 < N1 and (nums1_index + 1, nums2_index) not in visited:
                heapq.heappush(heap, (nums1[nums1_index + 1] + nums2[nums2_index], nums1_index + 1, nums2_index))
                visited.add((nums1_index + 1, nums2_index))

            if nums2_index + 1 < N2 and (nums1_index, nums2_index + 1) not in visited:
                heapq.heappush(heap, (nums1[nums1_index] + nums2[nums2_index + 1], nums1_index, nums2_index + 1))
                visited.add((nums1_index, nums2_index + 1))

            result.append((nums1[nums1_index], nums2[nums2_index]))
            result_count -= 1
        return result




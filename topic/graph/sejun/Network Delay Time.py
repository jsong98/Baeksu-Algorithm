from collections import defaultdict
import heapq


# dijjkstra
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        heap = []
        network_dict = defaultdict(list)
        costs = {i: float('inf') for i in range(1, n + 1)}
        for start, end, value in times:
            network_dict[start].append((value, end))
        visited = set()
        heapq.heappush(heap, (0, k))
        costs[k] = 0

        while heap:
            cur_cost, cur_node = heapq.heappop(heap)
            if cur_node not in visited:
                visited.add(cur_node)
                for next_cost, next_node in network_dict[cur_node]:
                    if cur_cost + next_cost < costs[next_node]:
                        costs[next_node] = cur_cost + next_cost
                        heapq.heappush(heap, (cur_cost + next_cost, next_node))

        return max(costs.values()) if len(visited) == n else -1

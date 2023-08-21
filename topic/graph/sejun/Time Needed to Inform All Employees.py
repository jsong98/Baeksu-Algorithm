from collections import deque, defaultdict


# Point Logic
# Each employee has one direct manager given in the manager
class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        q = deque()
        relation_dic = defaultdict(list)
        total_time = 0
        for emp in range(len(manager)):
            relation_dic[manager[emp]].append(emp)
        q.append((headID, informTime[headID]))

        while q:
            manager_ID, calculated_time = q.popleft()
            for emp_idx in relation_dic[manager_ID]:
                q.append((emp_idx, calculated_time + informTime[emp_idx]))
            total_time = max(total_time, calculated_time)

        return total_time




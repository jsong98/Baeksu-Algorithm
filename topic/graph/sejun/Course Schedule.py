from collections import deque, defaultdict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course_dict = defaultdict(list)

        for first, second in prerequisites:
            course_dict[first].append(second)

        visited = set()

        def dfs(start):
            if start in visited:
                return False

            visited.add(start)
            for element in course_dict[start]:
                if not dfs(element):
                    return False
            visited.remove(start)
            course_dict[start] = []
            return True

        for idx in range(numCourses):
            if not dfs(idx):
                return False
        return True

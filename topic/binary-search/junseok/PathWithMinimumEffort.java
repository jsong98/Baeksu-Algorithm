package topic.binarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
	
	private static final int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) {
		int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
		
		System.out.println(minimumEffortPath(heights));
	}
	
	public static int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];						// minimum effort를 저장할 배열
        
        for(int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // 다익스트라를 위한 우선순위 큐, row좌표, column좌표, 해당 좌표로 가기 위한 effort를 저장. effort를 기준으로 minHeap.
        pq.add(new int[] {0, 0, 0});	
        
        // 다익스트라
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0], j = p[1];
            if(i == m - 1 && j == n - 1) break;				// 맨 마지막 좌표에 도달하면 break;
            for(int[] d: dir) {								// 델타 배열을 이용하여 이동할 수 있는 모든 좌표 탐색.
                int x = i + d[0], y = j + d[1];
                if(x < 0 || x >= m || y < 0 || y >= n) continue;	// index를 넘어가는 경우는 skip
                int alt = Math.max(p[2], Math.abs(heights[i][j] - heights[x][y]));
                if(alt < dist[x][y]) {
                    pq.add(new int[] {x, y, dist[x][y] = alt});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
	
}

package topic.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 다익스트라 알고리즘, 그래프 내 weight를 최소로 하는 거리 구하기

public class NetworkDelayTime {

	public static void main(String[] args) {
		int[][] arr = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
		int n = 4;
		int k = 2;
		
		networkDelayTime(arr, n, k);
	}
	
	public static int networkDelayTime(int[][] times, int n, int k) {
        
        //Step 1
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int[] time : times) {
            int start = time[0];	// 출발 정점
            int end = time[1];		// 도착 정점
            int weight = time[2];	// 가중치
            
            map.putIfAbsent(start, new HashMap<>());
            map.get(start).put(end, weight);
        }
        
         // Step 2
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);	// 각 정점까지의 거리를 최대값으로 초기화
        dis[k] = 0;								// 출발정점까지의 거리는 0
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k,0});				// 출발정점
        
        // Step 3
        while(!queue.isEmpty()) {				// queue가 완전히 비어있을 때까지 반복.
            int[] cur = queue.poll();			
            int curNode = cur[0];				// start 
            int curWeight = cur[1];				// 현재까지의 weight
            System.out.println(map.getOrDefault(curNode, new HashMap<>()));
            for(int next : map.getOrDefault(curNode, new HashMap<>()).keySet()) {	// curNode를 key로 한 map의 element들의 keySet
                int nextweight = map.get(curNode).get(next);						// 다음 정점으로 이동할 때의 weight
                System.out.println(nextweight);	
                if(curWeight + nextweight < dis[next]) {							
                    dis[next] = curWeight + nextweight;
                    queue.add(new int[]{next, dis[next]});
                }
            }
        }
        
        // Step 4
        int res = 0;
        for(int i=1; i<=n; i++) {
            if(dis[i] > res) {
                res = Math.max(res, dis[i]);
            } 
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

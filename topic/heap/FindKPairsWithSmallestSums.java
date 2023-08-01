package topic.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_FindKPairsWithSmallestSums {
	
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
		// 우선순위 큐 선언
		List<List<Integer>> res = new ArrayList<>();
		// 결과를 저장할 List 선언
		
		for(int i = 0; i < Math.min(nums1.length, k); i++) {
			for(int j = 0; j < Math.min(nums2.length, k); j++) {	// 입력 배열의 모든 원소를 순차적으로 탐색
				int[] cur = new int[] {nums1[i], nums2[j]};			// 현재 위치한 loop에 해당하는 크기 2의 int 배열 선언
				if(pq.size()==k) {									// pq가 k만큼 차 있는 경우
					int[] comp = pq.peek();							// pq의 head를 꺼내서
					if((comp[0]+comp[1])>cur[0]+cur[1]) {			// cur와 비교. cur이 더 작으면 head를 꺼내고 cur를 삽입
						pq.poll();
						pq.offer(cur);
					} else {
						continue;
					}
				} else {											// pq가 k만큼 차 있지 않다면 바로 add
					pq.offer(cur);
				}
				
			}
		}
		
		while(!pq.isEmpty()) {					// 결과 저장.
			int[] input = pq.poll();
			res.add(Arrays.asList(input[0], input[1]));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 7, 11};
		int[] nums2 = new int[] {2, 4, 6};
		int k = 3;
		
		System.out.println(kSmallestPairs(nums1, nums2, k));
	}

}

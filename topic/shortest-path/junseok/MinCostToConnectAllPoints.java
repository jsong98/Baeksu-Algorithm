package topic.shortestPath;

import java.util.ArrayList;
import java.util.List;

// 최소신장트리 : Kruskal's algo && Prim's algo

public class MinCostToConnectAllPoints {
	
	public static void main(String[] args) {
		int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
		
		System.out.println(minCostConnectPoints(points));
	}
	
	// Prim's algo
	public static int minCostConnectPoints(int[][] points) {
		List<int[]> root = new ArrayList<>();
		List<int[]> res = new ArrayList<>();
		for(int[] arr : points) {
			root.add(arr);
		}
		res.add(root.get(0));
		root.remove(0);
		int shiftIdx = 0;
		
		int sum = 0;
		while(!root.isEmpty()) {
			int min = Integer.MAX_VALUE;
			// res 배열과, root 배열 둘다를 모두 탐색하면서 root -> res가 최소가 되는 값을 찾음
			// 해당 값을 sum에 더하고, 해당 root를 res 배열로 옮김
			for(int j = 0; j < res.size(); j++) {
				for(int k = 0; k < root.size(); k++) {
					int dis = getDis(res.get(j), root.get(k));
					if(dis < min) {
						min = dis;
						shiftIdx = k;
					}
				}
			}
			sum+= min;
			res.add(root.get(shiftIdx));
			root.remove(shiftIdx);
		}
		
		return sum;
	}
	
	public static int getDis(int[] a, int[] b) {
		return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]); 
	}
}

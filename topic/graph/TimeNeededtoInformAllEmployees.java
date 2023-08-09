package topic.graph;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededtoInformAllEmployees {

	public static void main(String[] args) {
		int n = 13;
		int headID = 3;
		int[] manager = {1,2,3,-1,2,6,3,8,9,10,3,10,3};
		int[] informTime = {1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		System.out.println(numOfMinutes(n, headID, manager, informTime));
	}
	
	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		
		List<List<Integer>> tree = new ArrayList<>();	// 연결된 자손 node들을 나타낼 list
		for(int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());				// 초기화
		}
		
		for(int i = 0; i < n; i++) {
			if(manager[i] != -1) {
				tree.get(manager[i]).add(i);			// tree의 각 index에 자손 node들을 대입
			}
		}
//		System.out.println(tree.get(headID));
		return dfs(tree, headID, informTime);
	}
	
	public static int dfs(List<List<Integer>> tree, int manager, int[] informTime) {
		int maxTime = 0;
		for(int sub : tree.get(manager)) {
//			System.out.println(sub);
			int t = dfs(tree, sub, informTime);		
			maxTime = Math.max(maxTime, t);	
		}
		// 말단 노드 부터 각 manager들의 informTime 중 최대값을 저장
		return maxTime + informTime[manager];
	}

}

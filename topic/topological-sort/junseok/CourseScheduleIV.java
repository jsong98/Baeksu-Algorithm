package topic.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIV {

	public static void main(String[] args) {
		int numCourses = 3;
		int[][] prerequisites = {{1,2},{1,0},{2,0}};
		int[][] queries = {{1,0},{1,2}};
		
		checkIfPrerequisite(numCourses, prerequisites, queries);
	}

	public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Boolean> res = new ArrayList<>();
		
		for(int i = 0; i < numCourses; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int[] arr : prerequisites) {
			list.get(arr[1]).add(arr[0]);
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i = 0; i < list.size(); i++) {
			List<Integer> temp1 = list.get(i);
			if(!temp1.isEmpty()) {
				for(int t : temp1) {
					que.offer(t);
				}
				while(!que.isEmpty()) {
					int a = que.poll();
					List<Integer> temp2 = list.get(a);
					if(!temp2.isEmpty()) {
						for(int k : temp2) {
							if(!list.get(i).contains(k)) {
								que.offer(k);
								list.get(i).add(k);
							}
						}
					}
				}
			}
		}
		
//		for(List<Integer> tmp : list) {
//			System.out.println(tmp.toString());
//		}
		
		for(int[] tmp : queries) {
			if(list.get(tmp[1]).contains(tmp[0])) {
				res.add(true);
			} else {
				res.add(false);
			}
		}
		
//		System.out.println(res.toString());
		
		return res;
	}
}
